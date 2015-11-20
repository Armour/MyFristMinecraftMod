package com.armourcy.dice;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by armour on 9/5/15.
 */

public class DiceItem extends Item {
    public DiceItem() {
        super();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        player.addExperience(10);
        if (!player.capabilities.isCreativeMode) {
            stack.stackSize--;
        }
        return stack;
    }
}
