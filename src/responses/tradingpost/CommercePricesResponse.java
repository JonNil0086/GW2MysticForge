package responses.tradingpost;

import com.google.gson.annotations.SerializedName;

/* CommercePricesResponse
 * -----------------------------------------------------------------------------
 * Response from GW2 API.
 * "This resource returns current aggregated buy and sell listing 
 * information from the trading post."
 * -----------------------------------------------------------------------------
 * Notes:       See https://wiki.guildwars2.com/wiki/API:2/commerce/prices
 *              for more info.
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class CommercePricesResponse {
    
    @SerializedName("id")
    private String id;
    
    @SerializedName("whitelisted")
    private boolean whitelisted;
    
    @SerializedName("buys")
    private SellsAndBuys buys;
    
    @SerializedName("sells")
    private SellsAndBuys sells;
    
    public String getId() {
        return id;
    }

    public boolean isWhitelisted() {
        return whitelisted;
    }

    public SellsAndBuys getBuys() {
        return buys;
    }

    public SellsAndBuys getSells() {
        return sells;
    }
}