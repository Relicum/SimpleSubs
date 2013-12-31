package com.relicum.simplesubs;

import org.bukkit.entity.Player;

import java.io.IOException;

/**
 * SimpleSubs
 * First Created 30/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public abstract class FixedSub extends ISubBase implements IFixedArgs {

    public int numArgs;
    public String name;

    public FixedSub() {
        this.numArgs = setNumArgs();
        this.description = setDescription();
        this.permission = setPermission();
        this.label = setLabel();
        this.usage = setUsage();
        this.cmdString = setCmdString();
        setName();


    }

    /**
     * On command.
     *
     * @param player the player
     * @param args   the args
     * @return the boolean
     * @throws IOException            the iO exception
     * @throws ClassNotFoundException the class not found exception
     */
    public abstract boolean onCommand(Player player, String[] args) throws IOException, ClassNotFoundException;


    /**
     * Get num args.
     *
     * @return the int
     */
    final public int getNumArgs() {
        return this.numArgs;
    }

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
     * Set this to the number of arguments the command has
     *
     * @return the num args
     */
    public abstract int setNumArgs();

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
     * Set name.
     */
    public void setName() {
        this.name = this.getClass().getSimpleName();
    }

    /**
     * Get name.
     *
     * @return the string
     */
    public String getName() {
        return this.name;
    }


}
