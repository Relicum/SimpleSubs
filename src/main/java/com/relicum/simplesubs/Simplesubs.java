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
     * Get command manager.
     *
     * @param pl   the pl
     * @param rg   the rg
     * @param subM the sub m
     * @return the command manager
     */
    public CommandManager getCommandManager(Plugin pl, registerCommand rg, SimpleMessages subM) {
        return new CommandManager(pl, rg, subM);
    }

    /**
     * Get debug manager.
     *
     * @param pl the pl
     * @return the debug manager
     */
    public DebugManager getDebugManager(Plugin pl) {
        return new DebugManager(pl);
    }

    /**
     * Get command register. Used to register commands
     *
     * @return the register command
     */
    public registerCommand getCommandRegister() {
        return new registerCommand();
    }

    /**
     * Get messages.
     *
     * @return the simple messages
     */
    public SimpleMessages getSimpleMessages() {
        return new SimpleMessages();
    }


    @Override
    public void onDisable() {

    }
}
