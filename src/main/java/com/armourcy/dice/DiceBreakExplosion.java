package com.armourcy.dice;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
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
        //if (event.getPlayer().getItemInUse().getItem() != Item.getItemById(278)) {
        event.world.createExplosion(null, event.x, event.y, event.z, 3, true);
        //}
    }
}
