package com.relicum.simplesubs;

import java.util.HashMap;
import java.util.Map;

/**
 * registerCommand Used to register your commands with the {@link com.relicum.simplesubs.CommandManager}
 *
 * @author Relicum
 * @version 0.1
 */
public class registerCommand {
    private Map<String, AbstractBase> store = new HashMap<>();
    private Map<String, MultiSub> mstore = new HashMap<>();

    /**
     * <p>Add a new Command with a Fixed number of arguments</p>
     *
     * @param sub
     *         The new {@link com.relicum.simplesubs.FixedSub} to add.
     */
    public void add(FixedSub sub) {
        this.store.put(sub.getName(), sub);
    }

    /**
     * <p>Add a new Command with a variable number of arguments</p>
     *
     * @param sub
     *         The new {@link com.relicum.simplesubs.MultiSub} to add
     */
    public void add(MultiSub sub) {
        this.store.put(sub.getName(), sub);
    }

    /**
     * <p>Used Internally</p>
     *
     * @return a {@link java.util.Map} object.
     */
    protected Map<String, AbstractBase> getStore() {
        return this.store;
    }

    /**
     * <p>Constructor for registerCommand. <p>Needs to be created in the plugins {@link
     * org.bukkit.plugin.java.JavaPlugin} main class
     */
    public registerCommand() {

    }
}
