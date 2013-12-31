package com.relicum.simplesubs;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;

import java.util.Map;
import java.util.Set;

/**
 * AbilitiesApi
 * First Created 31/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public class DebugManager implements CommandExecutor {

    public Plugin plugin;

    public DebugManager(Plugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Executes the given command, returning its success
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            plugin.getLogger().severe("Error You need to set a debug command to run");
            return true;
        }
        if (sender instanceof Player) {
            sender.sendMessage(ChatColor.RED + "This can only be run from the console");
            return true;
        }

        if (args[0].equalsIgnoreCase("perms")) {

            Set<Map.Entry<String, Map<String, Object>>> cmd = plugin.getDescription().getCommands().entrySet();
            Set<Permission> per = plugin.getServer().getPluginManager().getPermissions();
            for (Map.Entry<String, Map<String, Object>> entry : cmd) {
                String cmdd = entry.getKey();
                if (!cmdd.equalsIgnoreCase("debuger")) {
                    plugin.getLogger().info("Cmd name is " + entry.getKey());
                    String p = entry.getValue().get("permission").toString();
                    plugin.getLogger().info("Permission Node: " + p);
                    plugin.getLogger().info("Has the child perms");
                    Permission ad = plugin.getServer().getPluginManager().getPermission(p);
                    if (ad.getChildren().size() == 0) {
                        plugin.getLogger().info("Has no Children");
                    } else {
                        Map<String, Boolean> adc = ad.getChildren();
                        for (String ak : adc.keySet()) {
                            plugin.getLogger().info(ak);
                        }
                    }

                }
            }

        }


        return true;
    }
}
