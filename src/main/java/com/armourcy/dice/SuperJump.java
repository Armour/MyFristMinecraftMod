package com.armourcy.dice;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;

import java.util.Random;

/**
 * Created by armour on 11/9/15.
 */

public class SuperJump {
    @SubscribeEvent
    public void superJump(LivingEvent.LivingJumpEvent event) {
        if (!(event.entity instanceof EntityPlayer)) {
            return;
        }

        Random random = new Random();

        event.entity.motionY *= ((random.nextDouble() + 0.5f) * 2.0f);  // random from 1x to 3x
    }
}
