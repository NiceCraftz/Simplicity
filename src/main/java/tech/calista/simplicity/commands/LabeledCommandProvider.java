package tech.calista.simplicity.commands;

import com.google.common.collect.Maps;
import org.bukkit.command.Command;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Optional;

public abstract class LabeledCommandProvider extends Command {
    private final Map<String, LabeledCommand> labeledCommandMap = Maps.newHashMap();

    protected LabeledCommandProvider(@NotNull String name) {
        super(name);
    }

    public void load(LabeledCommand labeledCommand) {
        labeledCommandMap.put(labeledCommand.getLabel().toLowerCase(), labeledCommand);

        for (String alias : labeledCommand.getAliases()) {
            labeledCommandMap.put(alias.toLowerCase(), labeledCommand);
        }

        getAliases().addAll(labeledCommand.getAliases());
    }

    protected Optional<LabeledCommand> getLabeledCommand(String label) {
        return Optional.ofNullable(labeledCommandMap.get(label.toLowerCase()));
    }

}
