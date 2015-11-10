package com.armourcy.dice;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;

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

    @SubscribeEvent
    public void parachute(TickEvent.PlayerTickEvent event) {
        if (!event.player.isAirBorne || !event.player.isSneaking()) {
            return;
        }
        event.player.motionY = -0.05;
    }

    @SubscribeEvent
    public void noFallDamage(LivingFallEvent event) {
        if (!(event.entity instanceof EntityPlayer)) {
            return;
        }
        if (!event.entity.isSneaking()) {
            return;
        }
        event.setCanceled(true);
    }
}
