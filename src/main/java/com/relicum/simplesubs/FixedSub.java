package com.relicum.simplesubs;

import org.bukkit.entity.Player;

import java.io.IOException;

/**
 * AbilitiesApi
 * First Created 30/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public abstract class FixedSub extends AbstractFixedSub implements IFixedArgs {

    private int numArgs;

    /**
     * @param player Player
     * @param args   String[]
     * @return boolean
     */
    public abstract boolean onCommand(Player player, String[] args) throws IOException, ClassNotFoundException;

    public FixedSub(){
        setup();
    }

    /**
     * Sets all the commands parameters and arguments
     * This method MUST run the following methods. Fill in the details for each
     * setDescription() This is the help message that bukkit will display
     * setPermission() The command permission as a String
     * setUsage() The usage String of the command
     * setLabel() The command label
     * setCmdString() The command itself as a string
     * setNumArgs() The number of arguments the command must pass to be valid
     *
     */
    public abstract void setup();

    /**
     * Sets num args.
     *
     * @param args the args
     */
    @Override
    final public void setNumArgs(int args) {
       this.numArgs = args;
    }

    /**
     * Get num args.
     *
     * @return the int
     */
    final public int getNumArgs(){
        return this.numArgs;
    }
}
