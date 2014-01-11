package com.relicum.simplesubs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * SimpleSubs
 * First Created 30/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public class CommandManager implements TabExecutor {

    public Map<String, AbstractBase> clist = new HashMap<>();
    public List<String> tabs;

    public Plugin plugin;
    public SimpleMessages MM;


    public boolean setupCommands() {

        return true;
    }


    public CommandManager(Plugin pl, registerCommand rg, SimpleMessages subMM) {
        this.plugin = (JavaPlugin) pl;
        tabs = new ArrayList<>(rg.getStore().size());
        clist = rg.getStore();
        MM = subMM;
        for (Map.Entry<String, AbstractBase> entry : clist.entrySet()) {

            tabs.add(entry.getKey());
            registerCommand(entry.getKey(), entry.getValue());
        }

    }


    /**
     * Executes the given command, returning its success
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param strings Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        if (strings.length == 0) {
            return false;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(MM.getPlayerOnly());
            return true;
        }

        Player player = (Player) sender;


        String sub = strings[0];
        ArrayList<String> t = new ArrayList<String>();
        t.addAll(Arrays.asList(strings));
        t.remove(0);
        strings = t.toArray(new String[t.size()]);

        FixedSub subCom = null;
        MultiSub subcom = null;

        if (clist.get(sub) instanceof FixedSub) {
            subCom = (FixedSub) clist.get(sub);


        } else {

            subcom = (MultiSub) clist.get(sub);
        }

        // Check if the sub command is valid
        if (!clist.containsKey(sub)) {
            player.sendMessage(MM.getUnKnownCmd());
            return true;
        }

        if (subCom != null) {
            if (subCom.getNumArgs() != strings.length) {
                player.sendMessage(ChatColor.RED + "Error incorrect number of arguments");
                return true;
            }

            //Check they have the perm
            if (!player.isOp() && (!player.hasPermission(subCom.getPermission()))) {
                player.sendMessage(subCom.getNumArgsInValid());
                return true;
            }

            try {
                subCom.onCommand(player, strings);
            } catch (IOException | ClassNotFoundException e) {
                player.sendMessage(MM.getInternalError());
                e.printStackTrace();
            }

        }

        if (subcom != null) {
            if (strings.length > subcom.getMaxArgs() || strings.length < subcom.getMinArgs()) {
                player.sendMessage(ChatColor.RED + "Error incorrect number of arguments");
                return true;
            }

            //Check they have the perm
            if (!player.isOp() && (!player.hasPermission(subcom.getPermission()))) {
                player.sendMessage(subcom.getNumArgsInValid());
                return true;
            }

            try {
                subcom.onCommand(player, strings);
            } catch (IOException | ClassNotFoundException e) {
                player.sendMessage(MM.getInternalError());
                e.printStackTrace();
            }

        }
        return true;
    }

    /**
     * This function will register all the clist With Bukkit as well as setting the Description, Useage Permission and
     * label of the command
     *
     * @param name String
     * @param sb   SubBase
     */
    public boolean registerCommand(String name, AbstractBase sb) {


        String[] ps = sb.getPermission().split("\\.");
        String ubPerm = ps[0] + "." + ps[1];


        //String des = mm.getStringConfig(sb.getDescription());
        String des = ChatColor.translateAlternateColorCodes('&', sb.getDescription());

        Permission per = new Permission(ubPerm + "." + name);

        per.setDefault(sb.getPermissionDefault());
        per.addParent(ubPerm, true);
        per.setDescription(des);
        plugin.getServer().getPluginManager().addPermission(per);

        CommandMap cmp = getCommandMap();
        PluginCommand cd = getCommand(name.toLowerCase());

        cd.setDescription(des);
        cd.setUsage(sb.getUsage());
        cd.setExecutor(this);

        cd.setPermission(sb.getPermission());

        boolean display = false;
        if (plugin.getConfig().contains("simplesubsDisplay")) {
            display = plugin.getConfig().getBoolean("simplesubsDisplay");
        }
        if (cmp.register(sb.getLabel(), "mcc", (Command) cd)) {
            if (display) {
                plugin.getLogger().info("Command: /" + sb.getLabel() + " has successfully been registered");
            }

            return true;
        }

        plugin.getLogger().severe("Unknown error command: /" + sb.getLabel() + " did not register at all. Investigation needed");

        return false;


    }


    /**
     * Returns an instance of Command object setup For the command name you give it.
     *
     * @param name String
     * @return PluginCommand
     */
    public PluginCommand getCommand(String name) {


        PluginCommand command = null;
        try {
            Constructor c = PluginCommand.class.getDeclaredConstructor(new Class[]{String.class, Plugin.class});
            c.setAccessible(true);

            command = (PluginCommand) c.newInstance(new Object[]{name, plugin});
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return command;
    }


    /**
     * Returns an instance of CommandMap which Can then be used to correctly register the command and details with
     * Bukkit
     *
     * @return CommandMap
     */
    public CommandMap getCommandMap() {
        CommandMap commandMap = null;
        PluginManager pm = Bukkit.getServer().getPluginManager();

        try {
            if (pm instanceof PluginManager) {
                Field f = pm.getClass().getDeclaredField("commandMap");
                f.setAccessible(true);

                commandMap = (CommandMap) f.get(pm);
            }
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return commandMap;
    }


    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (strings.length == 1) {


                return StringUtil.copyPartialMatches(strings[0], tabs, new ArrayList<String>(tabs.size()));

            }
        }
        return Arrays.asList("");
    }


}
