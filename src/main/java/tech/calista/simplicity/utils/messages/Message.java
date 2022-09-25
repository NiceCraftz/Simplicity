package tech.calista.simplicity.utils.messages;

import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import tech.calista.simplicity.Simplicity;
import tech.calista.simplicity.utils.bukkit.chat.ColorUtil;
import tech.calista.simplicity.utils.bukkit.chat.Placeholder;

import java.util.Objects;

@RequiredArgsConstructor
public enum Message {
    SURVIVAL_MODE("survival"),
    CREATIVE_MODE("creative"),
    FLY_ON("fly-on"),
    FLY_OFF("fly-off"),
    MSG_SENT("msg-sent"),
    MSG_RECEIVED("msg-received"),
    NOT_ENOUGH_ARGS("not-enough-args"),
    NO_PERMISSION("no-permission"),
    PLAYER_ONLY("player-only"),
    PLAYER_NOT_FOUND("player-not-found"),
    RELOADED("reloaded"),
    ;

    private final String path;

    private FileConfiguration getConfig() {
        return JavaPlugin.getPlugin(Simplicity.class).getConfig();
    }

    public void sendMessage(CommandSender commandSender, Placeholder... placeholders) {
        String message = getConfig().getString(path);

        if (message == null || message.isEmpty()) {
            return;
        }

        for (Placeholder placeHolder : placeholders) {
            message = message.replace(placeHolder.getKey(), placeHolder.getValue());
        }

        message = message.replace("%prefix%", Objects.requireNonNull(getConfig().getString("prefix")));
        commandSender.sendMessage(ColorUtil.color(message));
    }
}
