package com.armourcy.dice;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by armour on 11/9/15.
 */

public class FlamingPigs implements ICommand {
    private List aliases = new ArrayList();
    private int numberOfPigs = 0;

    public FlamingPigs() {
        aliases.add("flamingpigs");
        aliases.add("fp");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/flamingpigs <number of pigs>";
    }

    @Override
    public List getAliases() {
        return aliases;
    }

}
