package connectivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import requests.Request;

/* Client
 * -----------------------------------------------------------------------------
 * Class that represents the client that handles the connection with the
 * Guild Wars 2 API.
 * -----------------------------------------------------------------------------
 * Notes:       None
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class Client {
  
    //GW2 URL address
    private final String baseURL = "https://api.guildwars2.com";  
    private int connectTimeout = 10000;
    private int readTimeout = 10000;
    private HttpURLConnection connection = null;
    
    /* Client
     * --------------------------------------------------
     * Constructor used for initialization.
     * --------------------------------------------------
     * Input:   ():
     * Output:  None
     * --------------------------------------------------
     */
    public Client(int connectTimeout, int readTimeout) {
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }
    
    /* sendRequest
     * --------------------------------------------------
     * Method used to get data from the GW2 API
     * --------------------------------------------------
     * Input:   (req): The request to send
     * Output:  JSON containing the information
     * --------------------------------------------------
     */
    public String sendRequest(Request req) {       
        StringBuilder sb = new StringBuilder(); 
        try {
            URL url = new URL(baseURL + req.getEndURL());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-length", "0");
            connection.setUseCaches(false);
            connection.setAllowUserInteraction(false);
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);
            connection.connect();
            int status = connection.getResponseCode();
            if (status == -1){
                System.out.println("Error: Not a valid HTTP");
                System.exit(-1);
            } else if (status == 401){
                System.out.println("Error: Not Unauthorized");
                System.exit(-1);
            }
            // Get the data from the connection (response)
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
            connection.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: Malformed URL Exception");
            System.exit(-1);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: I/O related");
            System.exit(-1);
        }      
        return sb.toString();
    }
}