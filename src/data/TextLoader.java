package data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* TextLoader
 * -----------------------------------------------------------------------------
 * Loads data from 4 text files containing different rune and sigil names
 * together with their IDS.
 * -----------------------------------------------------------------------------
 * Notes:       Dependent on 4 text files:
 *                  1. src/res/majorSigils.txt
 *                  2. src/res/majorRunes.txt
 *                  3. src/res/superiorSigils.txt
 *                  4. src/res/superiorRunes.txt
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class TextLoader implements IDataLoader {
    // File names containing base data, like IDs and Names of items
    private final String majorSigilDataFileName     
            = "src/res/majorSigils.txt";
    private final String majorRunesDataFileName     
            = "src/res/majorRunes.txt";
    private final String superiorSigilDataFileName  
            = "src/res/superiorSigils.txt";
    private final String superiorRunesDataFileName  
            = "src/res/superiorRunes.txt";
    
    // Sigil related variables for access to IDS and names
    private ArrayList<String> majorSigilIDS;
    private ArrayList<String> superiorSigilIDS;
    private Map<String, String> sigilNamesFromID;
    private Map<String, String> sigilIdFromNames;
    // Rune related variables for access to IDS and names
    private ArrayList<String> majorRuneIDS;
    private ArrayList<String> superiorRuneIDS;
    private Map<String, String> runeNamesFromID;
    private Map<String, String> runeIdFromNames;
    
    /* loadData
     * --------------------------------------------------
     * Loads the data from text files and creates the
     * context.
     * --------------------------------------------------
     * Input:   None
     * Output:  A data context object containing all
     *          data needed for the software to work.
     * --------------------------------------------------
     */
    @Override
    public DataContext loadData() {
        sigilNamesFromID = new HashMap<>();
        sigilIdFromNames = new HashMap<>();
        runeNamesFromID = new HashMap<>();
        runeIdFromNames = new HashMap<>();
        readMajorSigils();
        readMajorRunes();
        readSuperiorSigils();
        readSuperiorRunes();       
        return new DataContext(
            // Sigils
            majorSigilIDS,
            superiorSigilIDS,
            sigilNamesFromID,
            sigilIdFromNames,
            // Runes
            majorRuneIDS,
            superiorRuneIDS,
            runeNamesFromID,
            runeIdFromNames
        );
    } 
    
    /* readMajorSigils
     * --------------------------------------------------
     * Open and read the text file containing major sigil
     * information.
     * --------------------------------------------------
     * Input:   None
     * Output:  None
     * --------------------------------------------------
     */
    private void readMajorSigils() {
        majorSigilIDS = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(majorSigilDataFileName), "Cp1252"));         
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitStr = line.split(":");
                sigilNamesFromID.put(splitStr[1], splitStr[0]);
                sigilIdFromNames.put(splitStr[0], splitStr[1]);
                majorSigilIDS.add(splitStr[1]);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error: Could not load critical data from file: " 
                    + majorSigilDataFileName);
            System.exit(-1);
        }
    }
    
    /* readMajorRunes (not used currently / implemented)
     * --------------------------------------------------
     * Open and read the text file containing major rune
     * information.
     * --------------------------------------------------
     * Input:   None
     * Output:  None
     * --------------------------------------------------
     */
    private void readMajorRunes() {
        majorRuneIDS = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(majorRunesDataFileName), "Cp1252"));         
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitStr = line.split(":");
                runeNamesFromID.put(splitStr[1], splitStr[0]);
                runeIdFromNames.put(splitStr[0], splitStr[1]);
                majorRuneIDS.add(splitStr[1]);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error: Could not load critical data from file: " 
                    + majorRunesDataFileName);
            System.exit(-1);
        }
    }

    /* readSuperiorSigils
     * --------------------------------------------------
     * Open and read the text file containing superior
     * sigil information.
     * --------------------------------------------------
     * Input:   None
     * Output:  None
     * --------------------------------------------------
     */
    private void readSuperiorSigils() {
        superiorSigilIDS = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(superiorSigilDataFileName), "Cp1252"));         
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitStr = line.split(":");
                sigilNamesFromID.put(splitStr[1], splitStr[0]);
                sigilIdFromNames.put(splitStr[0], splitStr[1]);
                superiorSigilIDS.add(splitStr[1]);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error: Could not load critical data from file: " 
                    + superiorSigilDataFileName);
            System.exit(-1);
        }
    }
    
    /* readSuperiorRunes
     * --------------------------------------------------
     * Open and read the text file containing superior
     * rune information.
     * --------------------------------------------------
     * Input:   None
     * Output:  None
     * --------------------------------------------------
     */
    private void readSuperiorRunes() {
        superiorRuneIDS = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(superiorRunesDataFileName), "Cp1252"));         
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitStr = line.split(":");
                runeNamesFromID.put(splitStr[1], splitStr[0]);
                runeIdFromNames.put(splitStr[0], splitStr[1]);
                superiorRuneIDS.add(splitStr[1]);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error: Could not load critical data from file: " 
                    + superiorRunesDataFileName);
            System.exit(-1);
        }
    } 
}