package com.relicum.simplesubs;

import org.bukkit.ChatColor;

/**
 * SimpleSubs
 * First Created 31/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public abstract class ISubBase implements ISub {

    public String name = this.getClass().getSimpleName();
    public String description;
    public String permission;
    public String usage;
    public String label;
    public String cmdString;
    public String numArgsInValid = ChatColor.RED + "Error incorrect number of arguments command exited";


    /**
     * {@inheritDoc}
     * <p/>
     * Gets command description.
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * {@inheritDoc}
     * <p/>
     * Gets command permission.
     */
    @Override
    public String getPermission() {
        return this.permission;
    }

    /**
     * {@inheritDoc}
     * <p/>
     * Gets command usage.
     */
    @Override
    public String getUsage() {
        return this.usage;
    }

    /**
     * {@inheritDoc}
     * <p/>
     * Gets command label.
     */
    @Override
    public String getLabel() {
        return this.label;
    }

    /**
     * {@inheritDoc}
     * <p/>
     * Gets cmd string.
     */
    @Override
    public String getCmdString() {
        return this.cmdString;
    }

    /**
     * {@inheritDoc}
     * <p/>
     * Gets num args in valid.
     */
    @Override
    public String getNumArgsInValid() {
        return this.numArgsInValid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }
}
