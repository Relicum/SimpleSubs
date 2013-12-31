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

    public void add(FixedSub sub) {
        this.store.put(sub.getName(), sub);
    }

    public void add(MultiSub sub) {
        this.store.put(sub.getName(), sub);
    }

    public Map<String, AbstractBase> getStore() {
        return this.store;
    }

    public Map<String, MultiSub> getMStore() {
        return this.mstore;
    }

    public registerCommand() {

    }
}
