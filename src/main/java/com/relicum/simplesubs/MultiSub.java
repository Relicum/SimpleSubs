package com.relicum.simplesubs;

import org.bukkit.command.TabCompleter;

/**
 * SimpleSubs First Created 31/12/13
 * 
 * @author Relicum
 * @version 0.1
 */
public abstract class MultiSub extends AbstractBase implements IVariableArgs, TabCompleter {

    public int minArgs;
    public int maxArgs;

    /**
     * <p>
     * Constructor for MultiSub.
     * </p>
     */
    public MultiSub() {
        this.minArgs = setMinArgs();
        this.maxArgs = setMaxArgs();
        this.description = setDescription();
        this.permission = setPermission();
        this.label = setLabel();
        this.usage = setUsage();
        this.cmdString = setCmdString();
        this.permissionDefault = setPermissionDefault();

    }

    /**
     * Sets max args.
     * 
     * @return the max args
     */
    public abstract int setMaxArgs();

    /**
     * Sets min args.
     * 
     * @return the min args
     */
    public abstract int setMinArgs();

    /**
     * {@inheritDoc}
     * <p/>
     * Gets min args.
     */
    @Override
    public int getMinArgs() {
        return this.minArgs;
    }

    /**
     * {@inheritDoc}
     * <p/>
     * Gets max args.
     */
    @Override
    public int getMaxArgs() {
        return this.maxArgs;
    }

}
