package com.relicum.simplesubs;

import java.io.IOException;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

/**
 * SimpleSubs First Created 31/12/13
 * 
 * @author Relicum
 * @version 0.1
 */
public abstract class AbstractBase extends ISubBase implements TabCompleter {

    public PermissionDefault permissionDefault = PermissionDefault.OP;

    /**
     * On command.
     * 
     * @param player the player
     * @param args the args
     * @return the boolean
     * @throws java.io.IOException the iO exception
     * @throws java.lang.ClassNotFoundException the class not found exception
     */
    public abstract boolean onCommand(Player player, String[] args) throws IOException, ClassNotFoundException;

    /**
     * Set this as the description of the command. Used in bukkit help
     * 
     * @return the description
     */
    public abstract String setDescription();

    /**
     * Set the command permission
     * 
     * @return the permission
     */
    public abstract String setPermission();

    /**
     * Set the commands usage
     * 
     * @return the usage
     */
    public abstract String setUsage();

    /**
     * Set this to the command label
     * 
     * @return the label
     */
    public abstract String setLabel();

    /**
     * Set this to return the command as String
     * 
     * @return the cmd string
     */
    public abstract String setCmdString();

    /**
     * Sets permission default for the command;
     * 
     * @return the permission default
     */
    public abstract PermissionDefault setPermissionDefault();

    /**
     * Get permission default.
     * 
     * @return the permission default
     */
    public PermissionDefault getPermissionDefault() {
        return this.permissionDefault;
    }

    /**
     * Requests a list of possible completions for a command argument.
     * 
     * @param sender Source of the command
     * @param command Command which was executed
     * @param alias The alias used
     * @param args The arguments passed to the command, including final partial
     *        argument to be completed and command label
     * @return A List of possible completions for the final argument, or null to
     *         default to the command executor
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
