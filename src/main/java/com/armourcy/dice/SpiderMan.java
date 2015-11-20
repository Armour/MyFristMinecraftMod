package com.armourcy.dice;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;

/**
 * Created by armour on 11/9/15.
 */

public class SpiderMan {
    @SubscribeEvent
    public void spiderMan(LivingEvent.LivingUpdateEvent event) {
        if (!(event.entity instanceof EntityPlayer)) {
            return;
        }
        if (!(event.entity.isCollidedHorizontally)) {
            return;
        }
        event.entity.motionY += 0.1;
    }
}
