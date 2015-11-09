package com.armourcy.dice;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.Random;

/**
 * Created by armour on 11/8/15.
 */
public class DiceChickenDrop {
    @SubscribeEvent
    public void chickenDrop(LivingDeathEvent event) {
        if (!(event.entity instanceof EntityChicken)) {
            return;
        }

        Random random = new Random();

        if (!event.entity.worldObj.isRemote) {
            event.entity.dropItem(Items.carrot_on_a_stick, random.nextInt(3));
        }
    }
}
