package com.armourcy.dice;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent;

/**
 * Created by armour on 10/30/15.
 */

public class DiceBreakMessage {
    @SubscribeEvent
    public void breakMessage(BlockEvent.BreakEvent event) {
        if (event.block != Block.getBlockFromName(DiceMod.MODID + ":diceblock")) {
            return;
        }
        event.getPlayer().addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "You broke it! OH NO!!!"));
    }
}
