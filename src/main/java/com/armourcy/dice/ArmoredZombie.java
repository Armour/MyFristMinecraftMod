package com.armourcy.dice;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import java.util.Random;

/**
 * Created by armour on 11/8/15.
 */

public class ArmoredZombie {
    @SubscribeEvent
    public void armouredZombie(EntityJoinWorldEvent event) {
        if (!(event.entity instanceof EntityZombie)) {
            return;
        }

        Random random = new Random();
        int p = random.nextInt(5);
        if (p < 1) {
            EntityZombie zombie = (EntityZombie) event.entity;
            zombie.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
            zombie.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_chestplate));
            zombie.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_leggings));
            zombie.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_boots));
            zombie.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_helmet));
        }
    }
}
