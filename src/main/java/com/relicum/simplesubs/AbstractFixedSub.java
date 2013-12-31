package com.relicum.simplesubs;

import org.bukkit.ChatColor;

/**
 * AbilitiesApi
 * First Created 30/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public abstract class AbstractFixedSub implements ISub {

    private String description;
    private String permission;
    private String usage;
    private String label;
    private String cmdString;
    private String noPermMessage = ChatColor.RED + "You do not have permission to run this command";

    /**
     * Sets description.
     *
     * @param description the description
     */
    @Override
    final public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get description.
     *
     * @return the string
     */
     public String getDescription(){
        return this.description;
    }

    /**
     * Sets permission.
     *
     * @param permission the permission
     */
    @Override
    public void setPermission(String permission) {
       this.permission = permission;
    }

    /**
     * Get permission.
     *
     * @return the string permission for this command
     */
    final public String getPermission(){
        return this.permission;
    }

    /**
     * Sets usage.
     *
     * @param usage the usage
     */
    @Override
    public void setUsage(String usage) {
      this.usage = usage;
    }

    /**
     * Get usage.
     *
     * @return the string
     */
    final public String getUsage(){
        return this.usage;
    }

    /**
     * Sets label.
     *
     * @param label the label
     */
    @Override
    public void setLabel(String label) {
       this.label = label;
    }

    /**
     * Get label.
     *
     * @return the string
     */
    final public String getLabel(){
        return this.label;
    }

    /**
     * Sets cmdString.
     *
     * @param cmdString the cmdString
     */
    @Override
    public void setCmdString(String cmdString) {
       this.cmdString = cmdString;
    }

    /**
     * Sets no perm message.
     *
     * @param mess the mess
     */
    @Override
    public void setNoPermMessage(String mess) {
        this.noPermMessage = mess;
    }

    final public String getNoPermMessage()
    {
        return this.noPermMessage;
    }

    /**
     * Get cmd string.
     *
     * @return the string
     */
    final public String getCmdString(){
        return this.cmdString;
    }

    /**
     * Get name of the command this is the name of the class the command is in
     *
     * @return the string
     */
    final public String getName(){
        return this.getClass().getSimpleName();
    }
}
