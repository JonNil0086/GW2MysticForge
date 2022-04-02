package utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/* CopperToGSC
 * -----------------------------------------------------------------------------
 * Convertion class that converts copper to formatted strings in gold, silver
 * and copper.
 * Also contains an average profit calculation.
 * -----------------------------------------------------------------------------
 * Notes:       None
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class CopperToGSC {
    
    /* CopperToGSC
     * --------------------------------------------------
     * Converts the copper to a formatted string 
     * displaying gold, silver and copper.
     * --------------------------------------------------
     * Input:   (copper): The number of copper to
     *              convert as a string
     * Output:  The formatted string
     * --------------------------------------------------
     */
    public static String CopperToGSC(String copper) {
        int totalCopper = Integer.parseInt(copper);
        int newBuyGold = (int) Math.floor(totalCopper / (100*100));
        int newBuySilver = (int) Math.floor((totalCopper - newBuyGold * 100 * 100)/100);
        int newBuyCopper = (int) totalCopper%100;
        String returnString = Integer.toString(newBuyGold) + "g "
                + Integer.toString(newBuySilver) + "s "
                + Integer.toString(newBuyCopper) + "c";
        return returnString;
    }
    
    /* CopperToGSC
     * --------------------------------------------------
     * Converts the copper to a formatted string 
     * displaying gold, silver and copper.
     * --------------------------------------------------
     * Input:   (copper): The number of copper to
     *              convert
     * Output:  The formatted string
     * --------------------------------------------------
     */
    public static String CopperToGSC(int copper) {
        int totalCopper = copper;
        int newBuyGold = (int) Math.floor(totalCopper / (100*100));
        int newBuySilver = (int) Math.floor((totalCopper - newBuyGold * 100 * 100)/100);
        int newBuyCopper = (int) totalCopper%100;
        String returnString = Integer.toString(newBuyGold) + "g "
                + Integer.toString(newBuySilver) + "s "
                + Integer.toString(newBuyCopper) + "c";
        return returnString;
    }
    
    /* averageProfitPercent
     * --------------------------------------------------
     * Calculates the average profit percentage and
     * returns it as a formatted string.
     * --------------------------------------------------
     * Input:   (copper): The copper as a string
     *          (totalProfitCopper): The total profit in
     *              copper.
     * Output:  The average profit in %.
     * --------------------------------------------------
     */
    public static String averageProfitPercent(String copper, int totalProfitCopper) {
        double totalCopper = Double.parseDouble(copper);
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format((totalCopper / totalProfitCopper)*100);
    }
}