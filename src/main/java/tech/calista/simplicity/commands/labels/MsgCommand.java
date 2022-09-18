package tech.calista.simplicity.commands.labels;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tech.calista.simplicity.commands.LabeledCommand;
import tech.calista.simplicity.utils.bukkit.chat.PlaceHolder;
import tech.calista.simplicity.utils.messages.Messages;

import java.util.List;

public class MsgCommand extends LabeledCommand {
    public MsgCommand(String label, boolean isPlayerOnly, List<String> aliases) {
        super(label, isPlayerOnly, aliases);
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (args.length < 2) {
            Messages.NOT_ENOUGH_ARGS.sendMessage(commandSender);
            return;
        }

        String targetName = args[0];
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(targetName);

        if (!offlinePlayer.isOnline()) {
            Messages.PLAYER_NOT_FOUND.sendMessage(commandSender);
            return;
        }

        Player target = offlinePlayer.getPlayer();

        if (target == null) {
            Messages.PLAYER_NOT_FOUND.sendMessage(commandSender);
            return;
        }

        StringBuilder stringBuilder = new StringBuilder(" ");

        for (int i = 1; i < args.length; i++) {
            stringBuilder.append(args[i]);
        }

        String message = stringBuilder.toString();

        Messages.MSG_SENT.sendMessage(commandSender, new PlaceHolder("player", target.getName()), new PlaceHolder("message", message));
        Messages.MSG_RECEIVED.sendMessage(target, new PlaceHolder("player", commandSender.getName()), new PlaceHolder("message", message));
    }
}
