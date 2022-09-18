package tech.calista.simplicity;

import org.bukkit.plugin.java.JavaPlugin;
import tech.calista.simplicity.commands.SimplicityCommand;

public final class Simplicity extends JavaPlugin {
    private static Simplicity instance;

    public static Simplicity getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        SimplicityCommand simplicityCommand = new SimplicityCommand();
        getServer().getCommandMap().register("simplicity", simplicityCommand);
    }

}
