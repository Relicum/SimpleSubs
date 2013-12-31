package com.relicum.simplesubs;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * SimpleSubs
 * First Created 31/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public class Simplesubs extends JavaPlugin {



    @Override
    public void onEnable() {


    }

    /**
     * Get a new instance of CommandManager
     *
     * @param pl the pl the plugin instance
     * @return the command manager
     */
    public CommandManager getCommandManager(Plugin pl,registerCommand rg){
        return new CommandManager(pl,rg);
    }

    /**
     * Get debug manager.
     *
     * @param pl the pl
     * @return the debug manager
     */
    public DebugManager getDebugManager(Plugin pl){
        return new DebugManager(pl);
    }

    /**
     * Get command register. Used to register commands
     *
     * @return the register command
     */
    public registerCommand getCommandRegister(){
        return new registerCommand();
    }

    @Override
    public void onDisable() {

    }
}
