package empiretell.utils;

import org.bukkit.ChatColor;

public class Utils {
    public static String colorString(String string) {

        if (string == null)
            return null;

        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
