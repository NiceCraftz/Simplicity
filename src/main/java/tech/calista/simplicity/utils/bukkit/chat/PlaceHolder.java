package tech.calista.simplicity.utils.bukkit.chat;

import lombok.Getter;

@Getter
public class PlaceHolder {
    private final String key;
    private final String value;

    public PlaceHolder(String key, String value) {
        this.key = "%" + key + "%";
        this.value = value;
    }
}
