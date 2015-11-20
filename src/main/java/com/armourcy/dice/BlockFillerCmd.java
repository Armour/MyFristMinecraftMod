package com.armourcy.dice;

import net.minecraft.block.Block;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by armour on 11/9/15.
 */

public class BlockFillerCmd implements ICommand {
    private List aliases = new ArrayList();
    private Block block;

    public BlockFillerCmd() {
        aliases.add("fillblocks");
        aliases.add("fb");
    }

    public void sendErrorMessage(ICommandSender sender, String message) {
        sender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + message));
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/fillblocks <block ID>";
    }

    @Override
    public String getCommandName() {
        return null;
    }

    @Override
    public List getCommandAliases() {
        return aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length != 1) {
            sendErrorMessage(sender, "Invalid number of arguments");
            return;
        }

        try {
            block = Block.getBlockById(Integer.parseInt(args[0]));
            if (block == Blocks.air && Integer.parseInt(args[0]) != 0) {
                sendErrorMessage(sender, "The argument \"" + args[0] + "\" is not a valid block ID!");
                return;
            }
        } catch (NumberFormatException e) {
            if (Block.getBlockFromName(args[0]) == null) {
                sendErrorMessage(sender, "The argument \"" + args[0] + "\" is not a valid block name!");
                return;
            } else {
                block = Block.getBlockFromName(args[0]);
            }
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return sender instanceof EntityPlayer;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] args) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

}