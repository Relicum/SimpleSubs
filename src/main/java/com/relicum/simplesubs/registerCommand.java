package com.relicum.simplesubs;

import java.util.HashMap;
import java.util.Map;

/**
 * AbilitiesApi
 * First Created 30/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public class registerCommand {
    private Map<String,FixedSub> store = new HashMap<>();

    public void add(FixedSub sub){
        this.store.put(sub.getName(), sub);
    }

    public Map<String,FixedSub> getStore(){
        return this.store;
    }

    public registerCommand(){

    }
}
