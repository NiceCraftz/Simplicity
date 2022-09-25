package tech.calista.simplicity.commands.labels;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tech.calista.simplicity.commands.LabeledCommand;
import tech.calista.simplicity.utils.bukkit.chat.Placeholder;
import tech.calista.simplicity.utils.messages.Message;

import java.util.Arrays;
import java.util.List;

public class MsgCommand implements LabeledCommand {
    @Override
    public String getLabel() {
        return "msg";
    }

    @Override
    public String getPermission() {
        return "simplicity.msg";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("message", "tell", "whisper", "w");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (args.length < 2) {
            Message.NOT_ENOUGH_ARGS.sendMessage(commandSender);
            return;
        }

        String targetName = args[0];
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(targetName);

        if (!offlinePlayer.isOnline()) {
            Message.PLAYER_NOT_FOUND.sendMessage(commandSender);
            return;
        }

        Player target = offlinePlayer.getPlayer();

        if (target == null) {
            Message.PLAYER_NOT_FOUND.sendMessage(commandSender);
            return;
        }

        StringBuilder stringBuilder = new StringBuilder(" ");

        for (int i = 1; i < args.length; i++) {
            stringBuilder.append(args[i]);
        }

        String message = stringBuilder.toString();

        Message.MSG_SENT.sendMessage(commandSender, new Placeholder("player", target.getName()), new Placeholder("message", message));
        Message.MSG_RECEIVED.sendMessage(target, new Placeholder("player", commandSender.getName()), new Placeholder("message", message));
    }
}
