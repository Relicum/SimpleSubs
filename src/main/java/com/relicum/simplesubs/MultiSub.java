package com.relicum.simplesubs;

/**
 * SimpleSubs
 * First Created 31/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public abstract class MultiSub extends AbstractBase implements IVariableArgs {

    public int minArgs;
    public int maxArgs;


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
     * Gets min args.
     *
     * @return the min args
     */
    @Override
    public int getMinArgs() {
        return this.minArgs;
    }

    /**
     * Gets max args.
     *
     * @return the max args
     */
    @Override
    public int getMaxArgs() {
        return this.maxArgs;
    }

}
