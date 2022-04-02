package mysticForgeProfiter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import connectivity.Client;
import data.DataContext;
import data.IDataLoader;
import java.util.ArrayList;
import java.util.List;
import requests.items.ItemsRequest;
import requests.tradingpost.CommerceListingsRequest;
import requests.tradingpost.CommercePricesRequest;
import responses.items.ItemsResponse;
import responses.tradingpost.CommerceListingsResponse;
import responses.tradingpost.CommercePricesResponse;

/* MysticForgeProfiter
 * -----------------------------------------------------------------------------
 * Scans for sigils and runes and updates the profit calculator with data.
 * -----------------------------------------------------------------------------
 * Notes:       None
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class MysticForgeProfiter { 
    // Enum used for knowing what type of item is looked up
    public enum ItemType { SIGIL, RUNE }
    
    // Client variables
    private final int connectTimeout = 50000;
    private final int readTimeout = 50000; 
    private final Client client;
    // Calculator and initial text reader
    private final ProfitCalculator profitCalculator;
    private final DataContext dataContext;
    // Sigil section
    private List<CommercePricesResponse> majorSigilsPricings = null;
    private List<CommercePricesResponse> superiorSigilsPricings = null;
    private List<CommerceListingsResponse> majorSigilsListings = null;
    private List<CommerceListingsResponse> superiorSigilsListings = null;
    private List<ItemsResponse> majorSigilsItems = null;
    private List<ItemsResponse> superiorSigilsItems = null;
    // Rune section
    private List<CommercePricesResponse> majorRunesPricings = null;
    private List<CommercePricesResponse> superiorRunesPricings = null;
    private List<CommerceListingsResponse> majorRunesListings = null;
    private List<CommerceListingsResponse> superiorRunesListings = null;
    private List<ItemsResponse> majorRunesItems = null;
    private List<ItemsResponse> superiorRunesItems = null;
    
    /* MysticForgeProfiter
     * --------------------------------------------------
     * Contstructor used for initialization.
     * --------------------------------------------------
     * Input:   (dataLoader): Used for loading and
     *              creating a data context.
     * Output:  None
     * --------------------------------------------------
     */  
    public MysticForgeProfiter(IDataLoader dataLoader) {
        this.client = new Client(connectTimeout, readTimeout);
        this.profitCalculator = new ProfitCalculator();
        this.dataContext = dataLoader.loadData();     
    }

    /* scanSigils
     * --------------------------------------------------
     * Scan all sigils at the trading post.
     * --------------------------------------------------
     * Input:   None
     * Output:  None
     * --------------------------------------------------
     */
    public void scanSigils() {
        // Get all sigil names and ID:s
        ArrayList<String> majorSigilIDS = dataContext.getMajorSigilIDS();
        ArrayList<String> superiorSigilIDS = dataContext.getSuperiorSigilIDS();      
        // Get all data from the trading post
        String majorSigilPriceData 
                = client.sendRequest(new CommercePricesRequest(majorSigilIDS));
        String superiorSigilPriceData 
                = client.sendRequest(new CommercePricesRequest(superiorSigilIDS));
        String majorSigilListingsData 
                = client.sendRequest(new CommerceListingsRequest(majorSigilIDS));
        String superiorSigilListingsData 
                = client.sendRequest(new CommerceListingsRequest(superiorSigilIDS));
        String majorSigilItemsData 
                = client.sendRequest(new ItemsRequest(majorSigilIDS));
        String superiorSigilItemsData 
                = client.sendRequest(new ItemsRequest(superiorSigilIDS));    
        // Store the read data properly
        Gson gson = new Gson();
        this.majorSigilsPricings = gson.fromJson(
                majorSigilPriceData, new TypeToken<List<CommercePricesResponse>>(){}.getType());
        this.superiorSigilsPricings = gson.fromJson(
                superiorSigilPriceData, new TypeToken<List<CommercePricesResponse>>(){}.getType());
        this.majorSigilsListings = gson.fromJson(
                majorSigilListingsData, new TypeToken<List<CommerceListingsResponse>>(){}.getType());
        this.superiorSigilsListings = gson.fromJson(
                superiorSigilListingsData, new TypeToken<List<CommerceListingsResponse>>(){}.getType());
        this.majorSigilsItems = gson.fromJson(
                majorSigilItemsData, new TypeToken<List<ItemsResponse>>(){}.getType());
        this.superiorSigilsItems = gson.fromJson(
                superiorSigilItemsData, new TypeToken<List<ItemsResponse>>(){}.getType());        
        // Pass the data to the calculator
        // (unused) profitCalculator.setMajorSigilsListings(majorSigilsListings);
        profitCalculator.setSuperiorSigilsListings(superiorSigilsListings);
        profitCalculator.setMajorSigilsItems(majorSigilsItems);
        profitCalculator.setSuperiorSigilsItems(superiorSigilsItems);
        profitCalculator.setSigilNamesFromID(dataContext.getSigilNamesFromID());
    }
    
    /* scanRunes
     * --------------------------------------------------
     * Scan all runes at the trading post.
     * --------------------------------------------------
     * Input:   None
     * Output:  None
     * --------------------------------------------------
     */
    public void scanRunes() {
        // Get all rune names and ID:s
        ArrayList<String> majorRuneIDS = dataContext.getMajorRuneIDS();
        ArrayList<String> superiorRuneIDS = dataContext.getSuperiorRuneIDS();
        // Get all data from the trading post        
        String majorRunePriceData 
                = client.sendRequest(new CommercePricesRequest(majorRuneIDS));
        String superiorRunePriceData 
                = client.sendRequest(new CommercePricesRequest(superiorRuneIDS));
        String majorRuneListingsData 
                = client.sendRequest(new CommerceListingsRequest(majorRuneIDS));
        String superiorRuneListingsData 
                = client.sendRequest(new CommerceListingsRequest(superiorRuneIDS));
        String majorRuneItemsData 
                = client.sendRequest(new ItemsRequest(majorRuneIDS));
        String superiorRuneItemsData 
                = client.sendRequest(new ItemsRequest(superiorRuneIDS));       
        // Store the read data properly
        Gson gson = new Gson();
        this.majorRunesPricings = gson.fromJson(
                majorRunePriceData, new TypeToken<List<CommercePricesResponse>>(){}.getType());
        this.superiorRunesPricings = gson.fromJson(
                superiorRunePriceData, new TypeToken<List<CommercePricesResponse>>(){}.getType());
        this.majorRunesListings = gson.fromJson(
                majorRuneListingsData, new TypeToken<List<CommerceListingsResponse>>(){}.getType());
        this.superiorRunesListings = gson.fromJson(
                superiorRuneListingsData, new TypeToken<List<CommerceListingsResponse>>(){}.getType());
        this.majorRunesItems = gson.fromJson(
                majorRuneItemsData, new TypeToken<List<ItemsResponse>>(){}.getType());
        this.superiorRunesItems = gson.fromJson(
                superiorRuneItemsData, new TypeToken<List<ItemsResponse>>(){}.getType());
        // Pass the data to the calculator
        // (unused) profitCalculator.setMajorRuneListings(majorRunesListings);
        profitCalculator.setSuperiorRuneListings(superiorRunesListings);
        profitCalculator.setMajorRunesItems(majorRunesItems);
        profitCalculator.setSuperiorRunesItems(superiorRunesItems);
        profitCalculator.setRuneNamesFromID(dataContext.getRuneNamesFromID());        
    }
    
    // Calculates expected min value of a major sigil
    public int calculateExpectedMaximumSigilValue() {
        return profitCalculator.calculateMajorSigilMaximumValue();
    }
    // Calculates expected max value of a major rune
    public int calculateExpectedMaximumRuneValue() {
        return profitCalculator.calculateMajorRuneMaximumValue();
    }
    
    // Getter Looksup by name->ID for runes and sigils
    public String lookupName(String name, ItemType type) {
        if (type == ItemType.SIGIL){
           return dataContext.getSigilIdFromNames().get(name);
        } else if (type == ItemType.RUNE) {
           return dataContext.getRuneIdFromNames().get(name);
        }
        return null;
    }
    // Geter Lookups by ID->name for runes and sigils
    public String lookupISigilD(String ID) {
        return dataContext.getSigilNamesFromID().get(ID);
    }  
    public String lookupRuneID(String ID) {
        return dataContext.getRuneNamesFromID().get(ID);
    }
    
    /*
     * Getters below
     */
    public ArrayList<Suggestion> getSuggestions() {
        return profitCalculator.getSuggestions();
    }
    
    public List<CommercePricesResponse> getMajorSigilsPricings() {
        return majorSigilsPricings;
    }

    public List<CommercePricesResponse> getSuperiorSigilsPricings() {
        return superiorSigilsPricings;
    }

    public List<CommerceListingsResponse> getMajorSigilsListings() {
        return majorSigilsListings;
    }

    public List<CommerceListingsResponse> getSuperiorSigilsListings() {
        return superiorSigilsListings;
    }

    public List<ItemsResponse> getMajorSigilsItems() {
        return majorSigilsItems;
    }

    public List<ItemsResponse> getSuperiorSigilsItems() {
        return superiorSigilsItems;
    }

    public List<CommercePricesResponse> getMajorRunesPricings() {
        return majorRunesPricings;
    }

    public List<CommercePricesResponse> getSuperiorRunesPricings() {
        return superiorRunesPricings;
    }

    public List<CommerceListingsResponse> getMajorRunesListings() {
        return majorRunesListings;
    }

    public List<CommerceListingsResponse> getSuperiorRunesListings() {
        return superiorRunesListings;
    }

    public List<ItemsResponse> getMajorRunesItems() {
        return majorRunesItems;
    }

    public List<ItemsResponse> getSuperiorRunesItems() {
        return superiorRunesItems;
    }
}