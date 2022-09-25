package tech.calista.simplicity.commands.labels;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tech.calista.simplicity.commands.LabeledCommand;
import tech.calista.simplicity.utils.messages.Message;

import java.util.Arrays;
import java.util.List;

public class FlyCommand implements LabeledCommand {

    @Override
    public boolean isPlayerOnly() {
        return true;
    }

    @Override
    public String getLabel() {
        return "fly";
    }

    @Override
    public String getPermission() {
        return "simplicity.fly";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("flight", "wings");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        Player player = (Player) commandSender;

        boolean isFlying = player.getAllowFlight();
        player.setAllowFlight(!isFlying);

        if (isFlying) {
            Message.FLY_OFF.sendMessage(player);
        } else {
            Message.FLY_ON.sendMessage(player);
        }
    }
}
