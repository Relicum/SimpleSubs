package com.relicum.simplesubs;

import java.io.IOException;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

/**
 * SimpleSubs First Created 31/12/13
 * 
 * @author Relicum
 * @version 0.1
 */
public abstract class AbstractBase extends ISubBase {

    public PermissionDefault permissionDefault = PermissionDefault.OP;
    public List<String> tb;

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
     * Get a String List to use for tab complete at first level of the command
     * 
     * @return the tab
     */
    public abstract List<List<String>> getTab();

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

}
