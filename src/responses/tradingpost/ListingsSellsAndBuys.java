package responses.tradingpost;

import com.google.gson.annotations.SerializedName;

/* ListingsSellsAndBuys
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
public class ListingsSellsAndBuys {
    
    @SerializedName("listings")
    private String listings= null;
    
    @SerializedName("unit_price")
    private String unit_price= null;
    
    @SerializedName("quantity")
    private String quantity= null;
    
    public String getListings() {
        return listings;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public String getQuantity() {
        return quantity;
    }
}