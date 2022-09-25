package tech.calista.simplicity;

import org.bukkit.plugin.java.JavaPlugin;
import tech.calista.simplicity.commands.SimplicityCommand;

public final class Simplicity extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        SimplicityCommand simplicityCommand = new SimplicityCommand(this);
        getServer().getCommandMap().register("simplicity", simplicityCommand);
    }

}
