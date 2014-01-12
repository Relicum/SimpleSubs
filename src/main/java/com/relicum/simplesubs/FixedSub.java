package com.relicum.simplesubs;

/**
 * SimpleSubs
 * First Created 31/12/13
 *
 * @author Relicum
 * @version 0.1
 */
public abstract class FixedSub extends AbstractBase implements IFixedArgs {

    public int numArgs;

    /**
     * <p>Constructor for FixedSub.</p>
     */
    public FixedSub() {
        this.numArgs = setNumArgs();
        this.description = setDescription();
        this.permission = setPermission();
        this.label = setLabel();
        this.usage = setUsage();
        this.cmdString = setCmdString();
        this.permissionDefault = setPermissionDefault();

    }

    /**
     * Set this to the number of arguments the command has
     *
     * @return the num args
     */
    public abstract int setNumArgs();


    /**
     * {@inheritDoc}
     */
    @Override
    public int getNumArgs() {
        return this.numArgs;
    }


}
