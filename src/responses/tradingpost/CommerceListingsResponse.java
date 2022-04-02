package responses.tradingpost;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* CommerceListingsResponse
 * -----------------------------------------------------------------------------
 * Response from GW2 API.
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
public class CommerceListingsResponse {
    
    @SerializedName("id")
    private String id = null;
    
    @SerializedName("buys")
    private ArrayList<ListingsSellsAndBuys> buys = null;
    
    @SerializedName("sells")
    private ArrayList<ListingsSellsAndBuys> sells = null;

    public String getId() {
        return id;
    }

    public ArrayList<ListingsSellsAndBuys> getBuys() {
        return buys;
    }

    public ArrayList<ListingsSellsAndBuys> getSells() {
        return sells;
    }
}