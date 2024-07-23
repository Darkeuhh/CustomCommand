package fr.clmt.customCommand;

import fr.clmt.customCommand.commands.CustomCommandMain;
import fr.clmt.customCommand.commands.bcSubC;
import fr.clmt.customCommand.tabCompleters.mainCompleter;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class main extends JavaPlugin {
    public Logger logger = this.getLogger();


    @Override
    public void onEnable() {
        logger.log(java.util.logging.Level.INFO, "CustomCommand is enabled");

        CustomCommandMain customCommandMain = new CustomCommandMain();
        getCommand("customcommand").setExecutor(customCommandMain);
        customCommandMain.registerCommand("bc", new bcSubC());
        TabCompleter mainTc = new mainCompleter();
        getCommand("customcommand").setTabCompleter(mainTc);


    }

    @Override
    public void onDisable() {
        logger.log(java.util.logging.Level.INFO, "CustomCommand is disabled");
    }
}
