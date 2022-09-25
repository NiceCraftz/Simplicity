package tech.calista.simplicity.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import tech.calista.simplicity.Simplicity;
import tech.calista.simplicity.commands.labels.CreativeCommand;
import tech.calista.simplicity.commands.labels.FlyCommand;
import tech.calista.simplicity.commands.labels.MsgCommand;
import tech.calista.simplicity.commands.labels.SurvivalCommand;
import tech.calista.simplicity.utils.messages.Message;

import java.util.Optional;

public class SimplicityCommand extends LabeledCommandProvider {

    private final Simplicity simplicity;
    public SimplicityCommand(Simplicity simplicity) {
        super("simplicity");
        this.simplicity = simplicity;

        load(new CreativeCommand());
        load(new SurvivalCommand());
        load(new FlyCommand());
        load(new MsgCommand());

    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (commandLabel.equalsIgnoreCase(getName())) {
            if (args.length >= 1 && args[0].equalsIgnoreCase("reload") && sender.hasPermission("simplicity.reload")) {
                simplicity.reloadConfig();
                Message.RELOADED.sendMessage(sender);
                return true;
            }

            sender.sendMessage("§aSimplicity §7- §fA simple plugin for simple people.");
            return true;
        }

        Optional<LabeledCommand> command = getLabeledCommand(commandLabel);

        if (!command.isPresent()) {
            return true;
        }

        LabeledCommand labeledCommand = command.get();

        if (!sender.hasPermission(labeledCommand.getPermission())) {
            Message.NO_PERMISSION.sendMessage(sender);
            return true;
        }

        if (labeledCommand.isPlayerOnly() && !(sender instanceof Player)) {
            Message.PLAYER_ONLY.sendMessage(sender);
            return true;
        }

        labeledCommand.execute(sender, args);
        return true;
    }
}
