package com.relicum.simplesubs;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.StringUtil;

import java.util.*;

/**
 * SimpleSubs
 * First Created 31/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public class DebugManager implements TabExecutor {

    public Plugin plugin;
    public List<String> tab = new ArrayList<>(2);

    public DebugManager(Plugin plugin) {
        this.plugin = plugin;
        tab.add("subcmd");
        tab.add("perms");
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
        String op = "subcmd perms";
        if (args.length == 0) {
            plugin.getLogger().info("You need to chose an option valid options are " + op);
            return true;
        }
        if (sender instanceof Player) {
            sender.sendMessage(ChatColor.RED + "This can only be run from the console");
            return true;
        }

        if (args[0].equalsIgnoreCase("subcmd")) {

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
                    if (ad == null) {
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

        if (args[0].equalsIgnoreCase("perms")) {
            Set<Permission> per = plugin.getServer().getPluginManager().getPermissions();
            for (Permission p : per) {
                if (p.getName().contains("chuck")) {
                    System.out.println(p.getName() + ": " + p.getDefault().toString());
                }
            }

        }


        return true;
    }

    /**
     * Requests a list of possible completions for a command argument.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param alias   The alias used
     * @param args    The arguments passed to the command, including final
     *                partial argument to be completed and command label
     * @return A List of possible completions for the final argument, or null
     * to default to the command executor
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (!(sender instanceof Player)) {
            if (args.length == 1) {
                return StringUtil.copyPartialMatches(args[0], tab, new ArrayList<String>(tab.size()));
            }
        }
        return Arrays.asList("");
    }
}
