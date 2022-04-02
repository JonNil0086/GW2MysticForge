package responses.tradingpost;

import com.google.gson.annotations.SerializedName;

/* SellsAndBuys
 * -----------------------------------------------------------------------------
 * Used as a container in, ex CommercePricesResponse.
 * -----------------------------------------------------------------------------
 * Notes:       None
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class SellsAndBuys {
    
    @SerializedName("quantity")
    private String quantity;
    
    @SerializedName("unit_price")
    private String unit_price;
    
    public String getQuantity() {
        return quantity;
    }
    
    public String getUnitPrice() {
        return unit_price;
    } 
}