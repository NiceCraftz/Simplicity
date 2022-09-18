package tech.calista.simplicity.commands;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.bukkit.command.CommandSender;

import java.util.List;

@Getter
public abstract class LabeledCommand {
    private final String label;
    private final String permission;
    private final boolean isPlayerOnly;
    private final List<String> aliases;

    public LabeledCommand(String label, boolean isPlayerOnly, List<String> aliases) {
        this.label = label.toLowerCase();
        this.permission = "simplicity." + label.toLowerCase();
        this.isPlayerOnly = isPlayerOnly;

        this.aliases = Lists.newArrayList();
        this.aliases.add(label.toLowerCase());

        if (aliases != null) {
            this.aliases.addAll(aliases);
        }
    }

    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(permission);
    }

    public abstract void execute(CommandSender commandSender, String[] args);
}

