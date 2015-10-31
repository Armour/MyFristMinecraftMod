package com.armourcy.dice;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraftforge.event.world.BlockEvent;

/**
 * Created by armour on 9/9/15.
 */

public class DiceBreakExplosion {
    @SubscribeEvent
    public void breakExplosion(BlockEvent.BreakEvent event) {
        if (event.block != Block.getBlockFromName("diceblock")) {
            return;
        }
        event.world.createExplosion(null, event.x, event.y, event.z, 3, true);
    }
}
