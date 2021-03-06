package com.armourcy.dice;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraftforge.event.world.BlockEvent;

/**
 * Created by armour on 9/9/15.
 */

public class DiceBreakExplosion {
    @SubscribeEvent
    public void breakExplosion(BlockEvent.BreakEvent event) {
        if (event.block != Block.getBlockFromName(DiceMod.MODID + ":diceblock")) {
            return;
        }
        if (event.getPlayer().getHeldItem() != null &&
                (event.getPlayer().getHeldItem().getItem() == Items.wooden_pickaxe ||
                event.getPlayer().getHeldItem().getItem() == Items.stone_pickaxe ||
                event.getPlayer().getHeldItem().getItem() == Items.iron_pickaxe ||
                event.getPlayer().getHeldItem().getItem() == Items.golden_pickaxe ||
                event.getPlayer().getHeldItem().getItem() == Items.diamond_pickaxe)) {
            return;
        }
        event.world.createExplosion(null, event.x, event.y, event.z, 3, true);
    }
}
