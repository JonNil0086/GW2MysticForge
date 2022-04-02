package requests.items;

import java.util.ArrayList;
import requests.Request;

/* ItemsRequest
 * -----------------------------------------------------------------------------
 * Items reuqest from the GW2 API.
 * "This resource returns information about items that were discovered by 
 * players in the game."
 * -----------------------------------------------------------------------------
 * Notes:       See https://wiki.guildwars2.com/wiki/API:2/items for more info.
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class ItemsRequest implements Request {

    private final String endURL = "/v2/items";
    private int itemID;
    private boolean manyItems = false;
    private ArrayList<String> itemIDS = null;
    
    // Constructor for single items
    public ItemsRequest(int itemID) {
        this.itemID = itemID;
    }
    // Constructor for many items
    public ItemsRequest(ArrayList<String> itemIDS) {
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