package mysticForgeProfiter;

/* Suggestion
 * -----------------------------------------------------------------------------
 * Used for storing a representation of a suggestion regarding an item.
 * This suggestion is then presented in the GUI to the user.
 * -----------------------------------------------------------------------------
 * Notes:       None
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class Suggestion {
    
    private String suggestedName = null;
    private String suggestedActions = null;
    private String suggestedProfit = null;

    public String getSuggestedName() {
        return suggestedName;
    }

    public void setSuggestedName(String suggestedName) {
        this.suggestedName = suggestedName;
    }

    public String getSuggestedActions() {
        return suggestedActions;
    }

    public void setSuggestedActions(String suggestedActions) {
        this.suggestedActions = suggestedActions;
    }

    public String getSuggestedProfit() {
        return suggestedProfit;
    }

    public void setSuggestedProfit(String suggestedProfit) {
        this.suggestedProfit = suggestedProfit;
    }
}