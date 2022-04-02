package requests.tradingpost;

import java.util.ArrayList;
import requests.Request;

/* CommerceListingsRequest
 * -----------------------------------------------------------------------------
 * Request from GW2 API.
 * "This resource returns current buy and sell listings from the trading post."
 * -----------------------------------------------------------------------------
 * Notes:       See https://wiki.guildwars2.com/wiki/API:2/commerce/listings
 *              for more info.
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class CommerceListingsRequest implements Request {
    
    private final String endURL = "/v2/commerce/listings";
    private int itemID;
    private boolean manyItems = false;
    private ArrayList<String> itemIDS = null;
    
    // Constructor for single items
    public CommerceListingsRequest(int itemID) {
        this.itemID = itemID;
    }
    // Constructor for many items
    public CommerceListingsRequest(ArrayList<String> itemIDS) {
        manyItems = true;
        this.itemIDS = itemIDS;
    }
    
    @Override
    public String getEndURL() {
        if(manyItems == true) {
            String items = "?ids=";
            for(int i = 0; i < itemIDS.size(); i++) {
                if(i == itemIDS.size() - 1) {
                    items = items + itemIDS.get(i);
                } else {
                    items = items + itemIDS.get(i) + ",";
                }
            }
            return endURL + items;
        }
        
        return endURL + "/" + Integer.toString(itemID);
    }
}