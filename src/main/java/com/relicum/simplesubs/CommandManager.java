package com.relicum.simplesubs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

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
public class CommandManager implements CommandExecutor {

    public Map<String, FixedSub> clist = new HashMap<>();
    public Plugin plugin;
    public SimpleMessages MM;


    public boolean setupCommands() {

        return true;
    }


    public CommandManager(Plugin pl, registerCommand rg,SimpleMessages subMM) {
        this.plugin = (JavaPlugin) pl;

        clist = rg.getStore();
        MM = subMM;
        for (Map.Entry<String, FixedSub> entry : clist.entrySet()) {

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
        FixedSub subCom = clist.get(sub);
        // Check if the sub command is valid
        if (!clist.containsKey(sub)) {
            player.sendMessage(MM.getUnKnownCmd());
            return true;
        }


        //Check they have the perm
        if (!player.isOp() && (!player.hasPermission(subCom.getPermission()))) {
            player.sendMessage(subCom.getNoPermMessage());
            return true;
        }

        try {
            clist.get(sub).onCommand(player, strings);
        } catch (IOException | ClassNotFoundException e) {
            player.sendMessage(MM.getInternalError());
            e.printStackTrace();
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
    public boolean registerCommand(String name, FixedSub sb) {

        String[] ps = sb.getPermission().split("\\.");
        String ubPerm = ps[0] + "." + ps[1];


        //String des = mm.getStringConfig(sb.getDescription());
        String des = ChatColor.translateAlternateColorCodes('&', sb.getDescription());

        Permission per = new Permission(ubPerm + "." + name);

        per.setDefault(PermissionDefault.OP);
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


    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
