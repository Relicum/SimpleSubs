package com.relicum.simplesubs;

import org.bukkit.command.TabCompleter;

/**
 * SimpleSubs
 * First Created 30/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public interface ISub extends TabCompleter {

    /**
     * Gets command description.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Gets command permission.
     *
     * @return the permission
     */
    String getPermission();

    /**
     * Gets command usage.
     *
     * @return the usage
     */
    String getUsage();

    /**
     * Gets command label.
     *
     * @return the label
     */
    String getLabel();

    /**
     * Gets cmd string.
     *
     * @return the cmd string
     */
    String getCmdString();

    /**
     * Gets num args in valid.
     *
     * @return the num args in valid
     */
    String getNumArgsInValid();

    /**
     * Gets name.
     *
     * @return the name
     */
    String getName();
}
