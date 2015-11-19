package com.armourcy.dice;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Items;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by armour on 11/18/15.
 */

public class BlockFiller {
    static List<Integer> pos1 = new ArrayList<Integer>();
    static List<Integer> pos2 = new ArrayList<Integer>();

    @SubscribeEvent
    public void choosePosition(PlayerInteractEvent event) {
        if (event.entityPlayer.getHeldItem() == null ||
                event.entityPlayer.getHeldItem().getItem() != Items.wooden_axe ||
                event.entityPlayer.getHeldItem().getItem() != Items.stone_axe ||
                event.entityPlayer.getHeldItem().getItem() != Items.iron_axe ||
                event.entityPlayer.getHeldItem().getItem() != Items.golden_axe ||
                event.entityPlayer.getHeldItem().getItem() != Items.diamond_axe ||
                !event.entityPlayer.capabilities.isCreativeMode) {
            return;
        }

        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            pos1.clear();
            pos1.add(event.x);
            pos1.add(event.y);
            pos1.add(event.z);
            event.entityPlayer.addChatComponentMessage(new ChatComponentText(
                    EnumChatFormatting.GREEN
                    + "Position 1 set to " + event.x
                    + ", " + event.y
                    + ", " + event.z
                    + ". "));
            event.setCanceled(true);
        } else if (event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK) {
            pos2.clear();
            pos2.add(event.x);
            pos2.add(event.y);
            pos2.add(event.z);
            event.entityPlayer.addChatComponentMessage(new ChatComponentText(
                    EnumChatFormatting.GREEN
                            + "Position 2 set to " + event.x
                            + ", " + event.y
                            + ", " + event.z
                            + ". "));
            event.setCanceled(true);
        }
    }
}
