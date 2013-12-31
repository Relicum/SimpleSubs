package com.relicum.simplesubs;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.IOException;

/**
 * AbilitiesApi
 * First Created 30/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public class undress extends FixedSub {

    /**
     * @param player Player
     * @param args   String[]
     * @return boolean
     */
    @Override
    public boolean onCommand(Player player, String[] args) throws IOException, ClassNotFoundException {
        player.sendMessage(ChatColor.GREEN + "The undress command has been run");
        return true;
    }


    /**
     * Sets all the commands parameters and arguments
     * This method MUST run the following methods. Fill in the details for each
     * setDescription() This is the help message that bukkit will display color can be added with &
     * setPermission() The command permission as a String
     * setUsage() The usage String of the command
     * setLabel() The command label
     * setCmdString() The command itself as a string
     * setNumArgs() The number of arguments the command must pass to be valid
     */
    @Override
    public void setup() {

        setDescription("&bThis will remove the players inventory");
        setPermission("simplesubs.admin.undress");
        setUsage("/simple undress");
        setLabel("simple undress");
        setCmdString("simple undress");
        setNumArgs(0);

    }
}
