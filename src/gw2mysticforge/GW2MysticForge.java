package gw2mysticforge;

import guis.GUI;
import java.awt.Dimension;

/* GW2MysticForge (main container)
 * -----------------------------------------------------------------------------
 * This program scans the GW2 API and calculates which runes / sigils to buy
 * in order to be able to convert them to profit in the mystic forge by
 * merging them together into new random runes and sigils.
 * -----------------------------------------------------------------------------
 * Notes:       None
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class GW2MysticForge {
    public static void main(String[] args) {
        GUI gui = new GUI("GW2 Mystic Forge", new Dimension(710, 750));
        gui.show();
    }
}