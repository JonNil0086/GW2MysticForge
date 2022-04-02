package responses.items;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* ItemsResponse
 * -----------------------------------------------------------------------------
 * Items response from the GW2 server.
 * "This resource returns information about items that were discovered by 
 * players in the game."
 * -----------------------------------------------------------------------------
 * Notes:       See https://wiki.guildwars2.com/wiki/API:2/items for more info.
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public class ItemsResponse {
    
    @SerializedName("id")
    private String id = null;
    
    @SerializedName("chat_link")
    private String chat_link = null;
    
    @SerializedName("name")
    private String name = null;
    
    @SerializedName("icon")
    private String icon = null;
    
    @SerializedName("description")
    private String description = null;
    
    @SerializedName("type")
    private String type = null;
    
    @SerializedName("rarity")
    private String rarity = null;
    
    @SerializedName("level")
    private String level = null;
    
    @SerializedName("vendor_value")
    private String vendor_value = null;
    
    @SerializedName("default_skin")
    private String default_skin = null;
    
    @SerializedName("flags")
    private ArrayList<String> flags = null;
    
    @SerializedName("game_types")
    private ArrayList<String> game_types = null;
    
    @SerializedName("restrictions")
    private ArrayList<String> restrictions = null;
    
    public String getId() {
        return id;
    }

    public String getChat_link() {
        return chat_link;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getRarity() {
        return rarity;
    }

    public String getLevel() {
        return level;
    }

    public String getVendor_value() {
        return vendor_value;
    }

    public String getDefault_skin() {
        return default_skin;
    }

    public ArrayList<String> getFlags() {
        return flags;
    }

    public ArrayList<String> getGame_types() {
        return game_types;
    }

    public ArrayList<String> getRestrictions() {
        return restrictions;
    }
}