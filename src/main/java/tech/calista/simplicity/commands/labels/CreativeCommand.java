package tech.calista.simplicity.commands.labels;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tech.calista.simplicity.commands.LabeledCommand;
import tech.calista.simplicity.utils.messages.Message;

import java.util.Arrays;
import java.util.List;

public class CreativeCommand implements LabeledCommand {

    @Override
    public String getLabel() {
        return "creative";
    }

    @Override
    public boolean isPlayerOnly() {
        return true;
    }

    @Override
    public String getPermission() {
        return "simplicity.gmc";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("gmc");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        Player player = (Player) commandSender;
        player.setGameMode(GameMode.CREATIVE);
        Message.CREATIVE_MODE.sendMessage(player);
    }
}
