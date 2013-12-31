package com.relicum.simplesubs;

/**
 * AbilitiesApi
 * First Created 30/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public interface ISub {

    /**
     * Sets description.
     *
     * @param description the description
     */
    void setDescription(String description);


    /**
     * Sets permission.
     *
     * @param permission the permission
     */
    void setPermission(String permission);


    /**
     * Sets usage.
     *
     * @param usage the usage
     */
    void setUsage(String usage);


    /**
     * Sets label.
     *
     * @param label the label
     */
    void setLabel(String label);


    /**
     * Sets cmd.
     *
     * @param cmd the cmd
     */
    void setCmdString(String cmd);

    /**
     * Sets no perm message.
     *
     * @param mess the mess
     */
    void setNoPermMessage(String mess);
}
