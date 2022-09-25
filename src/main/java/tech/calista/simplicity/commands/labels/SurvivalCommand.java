package tech.calista.simplicity.commands.labels;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tech.calista.simplicity.commands.LabeledCommand;
import tech.calista.simplicity.utils.messages.Message;

import java.util.Arrays;
import java.util.List;

public class SurvivalCommand implements LabeledCommand {

    @Override
    public boolean isPlayerOnly() {
        return true;
    }


    @Override
    public String getLabel() {
        return "gms";
    }

    @Override
    public String getPermission() {
        return "simplicity.gms";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("survival");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        Player player = (Player) commandSender;
        player.setGameMode(GameMode.SURVIVAL);
        Message.SURVIVAL_MODE.sendMessage(player);
    }
}
