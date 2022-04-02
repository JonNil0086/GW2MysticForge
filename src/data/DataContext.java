package data;

import java.util.ArrayList;
import java.util.Map;

/* DataContext
 * -----------------------------------------------------------------------------
 * Contains all pre-read data needed for the software to work.
 * -----------------------------------------------------------------------------
 * Notes:       None
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class DataContext {
    // Sigil related variables for easy access to IDS and names
    private final ArrayList<String> majorSigilIDS;
    private final ArrayList<String> superiorSigilIDS;
    private final Map<String, String> sigilNamesFromID;
    private final Map<String, String> sigilIdFromNames;
    // Rune related variables for easy access to IDS and names
    private final ArrayList<String> majorRuneIDS;
    private final ArrayList<String> superiorRuneIDS;
    private final Map<String, String> runeNamesFromID;
    private final Map<String, String> runeIdFromNames;
  
    /* DataContext
     * --------------------------------------------------
     * Constructor used for initialization.
     * --------------------------------------------------
     * Input:   (majorSigilIDS): Major sigil IDS
     *          (superiorSigilIDS): Superior sigil IDS
     *          (sigilNamesFromID): ID -> Name
     *          (sigilIdFromNames): Name -> ID
     *          (majorRuneIDS): Major rune IDS
     *          (superiorRuneIDS): Superior rune IDS
     *          (runeNamesFromID): ID -> Name
     *          (runeIdFromNames): Name -> ID
     * Output:  A data context object containing all
     *          data needed for the software to work.
     * --------------------------------------------------
     */
    public DataContext(ArrayList<String> majorSigilIDS
            , ArrayList<String> superiorSigilIDS
            , Map<String, String> sigilNamesFromID
            , Map<String, String> sigilIdFromNames
            , ArrayList<String> majorRuneIDS
            , ArrayList<String> superiorRuneIDS
            , Map<String, String> runeNamesFromID
            , Map<String, String> runeIdFromNames){
        this.majorSigilIDS = majorSigilIDS;
        this.superiorSigilIDS = superiorSigilIDS;
        this.sigilNamesFromID = sigilNamesFromID;
        this.sigilIdFromNames = sigilIdFromNames;
        this.majorRuneIDS = majorRuneIDS;
        this.superiorRuneIDS = superiorRuneIDS;
        this.runeNamesFromID = runeNamesFromID;
        this.runeIdFromNames = runeIdFromNames;
    }

    /*
     * ONLY GETTERS BELOW
     */
    public ArrayList<String> getMajorSigilIDS() {
        return majorSigilIDS;
    }

    public ArrayList<String> getSuperiorSigilIDS() {
        return superiorSigilIDS;
    }

    public Map<String, String> getSigilNamesFromID() {
        return sigilNamesFromID;
    }

    public Map<String, String> getSigilIdFromNames() {
        return sigilIdFromNames;
    }

    public ArrayList<String> getMajorRuneIDS() {
        return majorRuneIDS;
    }

    public ArrayList<String> getSuperiorRuneIDS() {
        return superiorRuneIDS;
    }

    public Map<String, String> getRuneNamesFromID() {
        return runeNamesFromID;
    }

    public Map<String, String> getRuneIdFromNames() {
        return runeIdFromNames;
    }
}