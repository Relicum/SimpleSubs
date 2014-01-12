package com.relicum.simplesubs;

import java.util.HashMap;
import java.util.Map;

/**
 * SimpleSubs
 * First Created 30/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public class registerCommand {
    private Map<String, AbstractBase> store = new HashMap<>();
    private Map<String, MultiSub> mstore = new HashMap<>();

    /**
     * <p>add.</p>
     *
     * @param sub a {@link com.relicum.simplesubs.FixedSub} object.
     */
    public void add(FixedSub sub) {
        this.store.put(sub.getName(), sub);
    }

    /**
     * <p>add.</p>
     *
     * @param sub a {@link com.relicum.simplesubs.MultiSub} object.
     */
    public void add(MultiSub sub) {
        this.store.put(sub.getName(), sub);
    }

    /**
     * <p>Getter for the field <code>store</code>.</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<String, AbstractBase> getStore() {
        return this.store;
    }

    /**
     * <p>getMStore.</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<String, MultiSub> getMStore() {
        return this.mstore;
    }

    /**
     * <p>Constructor for registerCommand.</p>
     */
    public registerCommand() {

    }
}
