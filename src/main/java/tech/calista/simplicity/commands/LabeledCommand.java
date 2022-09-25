package tech.calista.simplicity.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface LabeledCommand {
    String getLabel();

    String getPermission();

    List<String> getAliases();

    default boolean isPlayerOnly() {
        return false;
    }

    void execute(CommandSender commandSender, String[] args);
}

