package com.relicum.simplesubs;

import org.bukkit.ChatColor;

/**
 * SimpleSubs
 * First Created 31/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public class SimpleMessages {

    private String playerOnly = "Command can not be run from console";
    private String unKnownCmd = ChatColor.RED + "Error: Unknown Command";
    private String internalError = ChatColor.RED + "Internal Error has occurred please let a member of staff know";

    /**
     * <p>Constructor for SimpleMessages.</p>
     */
    public SimpleMessages() {

    }

    /**
     * <p>Getter for the field <code>playerOnly</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPlayerOnly() {
        return this.playerOnly;
    }

    /**
     * Set player only message
     *
     * @param mess the mess
     */
    public void setPlayerOnly(String mess) {
        this.playerOnly = mess;
    }

    /**
     * <p>Getter for the field <code>unKnownCmd</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUnKnownCmd() {
        return unKnownCmd;
    }

    /**
     * Sets message if command is unknown.
     *
     * @param unKnownCmd the un known cmd
     */
    public void setUnKnownCmd(String unKnownCmd) {
        this.unKnownCmd = unKnownCmd;
    }

    /**
     * <p>Getter for the field <code>internalError</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getInternalError() {
        return internalError;
    }

    /**
     * Sets message if an internal error occurs.
     *
     * @param internalError the internal error
     */
    public void setInternalError(String internalError) {
        this.internalError = internalError;
    }
}
