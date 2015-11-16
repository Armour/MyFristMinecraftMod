package com.armourcy.dice;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import java.util.Random;

/**
 * Created by armour on 9/5/15.
 */

public class DiceBlock extends Block {

    private Item drop;

    protected DiceBlock(Material material) {
        super(material);
    }

    @Override
    public boolean isOpaqueCube() {
        return true;
    }

    @Override
    public int quantityDropped(Random random) {
        return super.quantityDropped(random);
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return drop;
    }

    public void setItemDropped(Item item) {
        drop = item;
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata) {
        world.playSound
                ( x, y, z,                          //block's coordinates.
                  DiceMod.MODID+":diceDestory",     //file: resources\assets\<MODID>\sounds\diceDestory.ogg
                  0.5F,                             //half volume.
                  1.0F,                             //normal pitch.
                  true                              //default
                );
    }
}
