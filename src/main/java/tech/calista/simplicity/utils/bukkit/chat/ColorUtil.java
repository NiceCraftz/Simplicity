package tech.calista.simplicity.utils.bukkit.chat;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

@UtilityClass
public class ColorUtil {
    public String color(String toColor) {
        return ChatColor.translateAlternateColorCodes('&', toColor);
    }
}
