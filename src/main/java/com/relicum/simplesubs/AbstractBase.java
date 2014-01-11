package com.relicum.simplesubs;

import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

import java.io.IOException;

/**
 * SimpleSubs
 * First Created 31/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public abstract class AbstractBase extends ISubBase {


    public PermissionDefault permissionDefault = PermissionDefault.OP;

    /**
     * On command.
     *
     * @param player the player
     * @param args   the args
     * @return the boolean
     * @throws java.io.IOException    the iO exception
     * @throws ClassNotFoundException the class not found exception
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


}
