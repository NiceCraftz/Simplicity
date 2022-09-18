package tech.calista.simplicity.commands.labels;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tech.calista.simplicity.commands.LabeledCommand;
import tech.calista.simplicity.utils.messages.Messages;

import java.util.List;

public class CreativeCommand extends LabeledCommand {

    public CreativeCommand(String label, boolean isPlayerOnly, List<String> aliases) {
        super(label, isPlayerOnly, aliases);
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        Player player = (Player) commandSender;
        player.setGameMode(GameMode.CREATIVE);
        Messages.CREATIVE.sendMessage(player);
    }
}
