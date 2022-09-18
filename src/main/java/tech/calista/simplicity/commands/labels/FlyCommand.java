package tech.calista.simplicity.commands.labels;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tech.calista.simplicity.commands.LabeledCommand;
import tech.calista.simplicity.utils.messages.Messages;

import java.util.List;

public class FlyCommand extends LabeledCommand {

    public FlyCommand(String label, boolean isPlayerOnly, List<String> aliases) {
        super(label, isPlayerOnly, aliases);
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        Player player = (Player) commandSender;

        boolean isFlying = player.getAllowFlight();
        player.setAllowFlight(!isFlying);

        if (isFlying) {
            Messages.FLY_OFF.sendMessage(player);
        } else {
           Messages.FLY_ON.sendMessage(player);
        }

    }
}
