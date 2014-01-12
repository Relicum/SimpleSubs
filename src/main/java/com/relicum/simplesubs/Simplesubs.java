package com.relicum.simplesubs;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * SimpleSubs
 * Used to handel all incoming commands.
 * <p>
 * Registers the command and it's permission correct with Bukkit.
 * Integrates by default Bukkit help facility. Implements automatically TabCompletion at the root level
 * </p>
 * <p>All incoming commands will have their permission checked automatically before being passed to your command. I default permission
 * message is displayed or you can override this using {@link com.relicum.simplesubs.SimpleMessages}
 * </p>
 *
 * @author Relicum
 * @version 0.1
 */
public class Simplesubs extends JavaPlugin {


    /**
     * {@inheritDoc}
     */
    @Override
    public void onEnable() {

        System.out.println("*******--->         Powered By SimpleSubs         <---*******");
        System.out.println("*******          Developer Guide Available At         *******");
        System.out.println("*******   https://github.com/Relicum/SimpleSubs/wiki  *******");

    }


    /**
     * Gets {@link com.relicum.simplesubs.CommandManager} that is used to register your commands against
     *
     * @param plugin the needs to be a instance of YOUR plugin
     * @param registerCommand the register command
     * @param simpleMessages the simple messages
     * @return the command manager
     */
    public CommandManager getCommandManager(Plugin plugin, registerCommand registerCommand, SimpleMessages simpleMessages) {
        return new CommandManager(plugin, registerCommand, simpleMessages);
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


    /** {@inheritDoc} */
    @Override
    public void onDisable() {

    }
}
