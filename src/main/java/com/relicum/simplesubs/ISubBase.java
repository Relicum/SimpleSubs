package com.relicum.simplesubs;

import org.bukkit.ChatColor;

/**
 * SimpleSubs
 * First Created 31/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public class ISubBase implements ISub {

    public String name = this.getClass().getSimpleName();
    public String description;
    public String permission;
    public String usage;
    public String label;
    public String cmdString;
    public String numArgsInValid = ChatColor.RED + "Error incorrect number of arguments command exited";


    /**
     * Gets command description.
     *
     * @return the description
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets command permission.
     *
     * @return the permission
     */
    @Override
    public String getPermission() {
        return this.permission;
    }

    /**
     * Gets command usage.
     *
     * @return the usage
     */
    @Override
    public String getUsage() {
        return this.usage;
    }

    /**
     * Gets command label.
     *
     * @return the label
     */
    @Override
    public String getLabel() {
        return this.label;
    }

    /**
     * Gets cmd string.
     *
     * @return the cmd string
     */
    @Override
    public String getCmdString() {
        return this.cmdString;
    }

    /**
     * Gets num args in valid.
     *
     * @return the num args in valid
     */
    @Override
    public String getNumArgsInValid() {
        return this.numArgsInValid;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
