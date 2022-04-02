package mysticForgeProfiter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import responses.items.ItemsResponse;
import responses.tradingpost.CommerceListingsResponse;

/* ProfitCalculator
 * -----------------------------------------------------------------------------
 * Used for calculating profits.
 * -----------------------------------------------------------------------------
 * Notes:       None
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class ProfitCalculator {
 
    // Constants
    private final double superiorSigilSingleDropRate    = 0.0036;
    private final double superiorRuneSingleDropRate     = 0.0035;
    private final double averageProspectMajorSigil      = 0.3115;
    private final double averageProspectMajorRune       = 0.3115;
    private final double tradingPostFees                = 0.85;    
    // Data responses from GW2 API
    private List<CommerceListingsResponse> superiorSigilsListings = null;
    private List<CommerceListingsResponse> superiorRunesListings = null;
    private Map<String, ItemsResponse> majorSigilsItemsMap = null;
    private Map<String, ItemsResponse> majorRunesItemsMap = null;
    private Map<String, ItemsResponse> superiorSigilsItemsMap = null;
    private Map<String, ItemsResponse> superiorRunesItemsMap = null; 
    // Used to get the names of sigils or runes fast
    private Map<String, String> sigilNamesFromID = null;
    private Map<String, String> runeNamesFromID = null;
    // Array containing all suggestions for the user
    private ArrayList<Suggestion> suggestions = null;
    
    /* calculateMajorSigilMaximumValue
     * --------------------------------------------------
     * Calculate the maximum value of the major sigil.
     * Also returns that value, as well as adds to the
     * suggestions.
     * --------------------------------------------------
     * Input:   None
     * Output:  The maximum value
     * --------------------------------------------------
     */
    public int calculateMajorSigilMaximumValue() {
        double totalProfit = 0.0;
        suggestions = new ArrayList<>();
        //Average value of a prospect in the mystic forge for 4 major sigils
        for(int i = 0; i < superiorSigilsListings.size();i++) {
            CommerceListingsResponse tempSuperiorSigil = superiorSigilsListings.get(i);
            if (tempSuperiorSigil.getSells() == null) {
                System.out.println("Warning: Empty CommerceListingsResponse detected.");
                continue;
            }
            Suggestion suggestion = new Suggestion();
            suggestion.setSuggestedName(sigilNamesFromID.get(tempSuperiorSigil.getId()));
            //Get the best price for the sigil
            double biggestPossibleSell = (Double.parseDouble(tempSuperiorSigil.getSells().get(0).getUnit_price()) - 1.0);
            double vendorValue = Double.parseDouble(superiorSigilsItemsMap.get(tempSuperiorSigil.getId()).getVendor_value());
            if( (biggestPossibleSell * tradingPostFees) > vendorValue) {
                totalProfit = totalProfit + ((biggestPossibleSell * tradingPostFees));
                suggestion.setSuggestedActions("Market Place");
                suggestion.setSuggestedProfit(Double.toString(
                        averageProspectMajorSigil * superiorSigilSingleDropRate * (biggestPossibleSell * tradingPostFees)
                ));
            } else {
                totalProfit = totalProfit + vendorValue;
                suggestion.setSuggestedActions("Vendor");
                suggestion.setSuggestedProfit(Double.toString(
                        averageProspectMajorSigil * superiorSigilSingleDropRate * vendorValue
                ));
            }
            suggestions.add(suggestion);
        }
        totalProfit = totalProfit * superiorSigilSingleDropRate;
        totalProfit = totalProfit * averageProspectMajorSigil;    
        return (int)Math.round(totalProfit);
    }

    /* calculateMajorRuneMaximumValue (Not Implemented)
     * --------------------------------------------------
     * Calculate the maximum value of the major rune.
     * Also returns that value, as well as adds to the
     * suggestions.
     * --------------------------------------------------
     * Input:   None
     * Output:  The maximum value
     * --------------------------------------------------
     */
    public int calculateMajorRuneMaximumValue() {
        double totalProfit = 0.0;
        suggestions = new ArrayList<>();
        //Average value of a prospect in the mystic forge for 4 major sigils
        for(int i = 0; i < superiorRunesListings.size(); i++) {
            CommerceListingsResponse tempSuperiorRune = superiorRunesListings.get(i);
            Suggestion suggestion = new Suggestion();
            suggestion.setSuggestedName(runeNamesFromID.get(tempSuperiorRune.getId()));
            ArrayList<String> flags = superiorRunesItemsMap.get(tempSuperiorRune.getId()).getFlags();
            System.out.println(tempSuperiorRune.getId());
            if(tempSuperiorRune.getId().equals("24851")) {
                System.out.println("Should be account bound");
            }
            boolean accountBound = false;
            for(int j = 0; j < flags.size(); j++){
                System.out.println(flags.get(j));
                if(flags.get(j).equals("AccountBound")) {
                    accountBound = true;
                    break;
                }
            }
            if(accountBound) {
                System.out.println("ACCBOUND");
                double vendorValue = Double.parseDouble(superiorRunesItemsMap.get(tempSuperiorRune.getId()).getVendor_value());
                totalProfit = totalProfit + vendorValue;
                suggestion.setSuggestedActions("Vendor");
                suggestion.setSuggestedProfit(Double.toString(
                    averageProspectMajorRune * superiorRuneSingleDropRate * vendorValue
                ));
                suggestions.add(suggestion);
            } else {
                //Get the best price for the sigil
                if (tempSuperiorRune.getSells() == null) {
                    System.out.println("Warning: Empty CommerceListingsResponse detected.");
                    continue;
                }
                double biggestPossibleSell = (Double.parseDouble(tempSuperiorRune.getSells().get(0).getUnit_price()) - 1.0);
                double vendorValue = Double.parseDouble(superiorRunesItemsMap.get(tempSuperiorRune.getId()).getVendor_value());
                if( (biggestPossibleSell * tradingPostFees) > vendorValue) {
                    totalProfit = totalProfit + ((biggestPossibleSell * tradingPostFees));
                    suggestion.setSuggestedActions("Market Place");
                    suggestion.setSuggestedProfit(Double.toString(
                            averageProspectMajorRune * superiorRuneSingleDropRate * (biggestPossibleSell * tradingPostFees)
                    ));
                } else {
                    totalProfit = totalProfit + vendorValue;
                    suggestion.setSuggestedActions("Vendor");
                    suggestion.setSuggestedProfit(Double.toString(
                            averageProspectMajorRune * superiorRuneSingleDropRate * vendorValue
                    ));
                }
                suggestions.add(suggestion);    
            }
        }
        totalProfit = totalProfit * superiorRuneSingleDropRate;
        totalProfit = totalProfit * averageProspectMajorRune;
        return (int)Math.round(totalProfit);
    }
    
    /*
     * Getters & setters below
     */
    public void setSuperiorRuneListings(List<CommerceListingsResponse> superiorRuneListings) {
        this.superiorRunesListings = superiorRuneListings;
    }

    public void setSuperiorSigilsListings(List<CommerceListingsResponse> superiorSigilsListings) {
        this.superiorSigilsListings = superiorSigilsListings;
    }

    public void setSigilNamesFromID(Map<String, String> sigilNamesFromID) {
        this.sigilNamesFromID = sigilNamesFromID;
    }

    public void setRuneNamesFromID(Map<String, String> runeNamesFromID) {
        this.runeNamesFromID = runeNamesFromID;
    }
    
    public void setMajorSigilsItems(List<ItemsResponse> majorSigilsItems) {
        majorSigilsItemsMap = new HashMap<>();
        for(int i = 0; i < majorSigilsItems.size(); i++) {
            majorSigilsItemsMap.put(majorSigilsItems.get(i).getId(), majorSigilsItems.get(i));
        }
    }
    
    public void setMajorRunesItems(List<ItemsResponse> majorRunesItems) {
        majorRunesItemsMap = new HashMap<>();
        for(int i = 0; i < majorRunesItems.size(); i++) {
            majorRunesItemsMap.put(majorRunesItems.get(i).getId(), majorRunesItems.get(i));
        }
    }
    
    public void setSuperiorSigilsItems(List<ItemsResponse> superiorSigilsItems) {
        superiorSigilsItemsMap = new HashMap<>();
        for(int i = 0; i < superiorSigilsItems.size(); i++) {
            superiorSigilsItemsMap.put(superiorSigilsItems.get(i).getId(), superiorSigilsItems.get(i));
        }
    }
    
    public void setSuperiorRunesItems(List<ItemsResponse> superiorRunesItems) {
        superiorRunesItemsMap = new HashMap<>();        
        for(int i = 0; i < superiorRunesItems.size(); i++) {
            superiorRunesItemsMap.put(superiorRunesItems.get(i).getId(), superiorRunesItems.get(i));
        }
    }
    
    public ArrayList<Suggestion> getSuggestions() {
        return suggestions;
    }
}