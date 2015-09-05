/**
 * Created by armour on 9/5/15.
 */

package com.armourcy.dice;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class DiceBlock extends Block {

    private Item drop;

    protected DiceBlock(Material material) {
        super(material);
    }

    @Override
    public boolean isOpaqueCube() {
        return true;
    }

    /*
    @SideOnly(Side.CLIENT)
    public EumWorldBlockLayer getBlockLayer() {
        return EumWorldBlcokLayer.SOLID;
    }
    */

    /*
    @Override
    public boolean isFullCube() {
        return true;
    }
    */

    @Override
    public int getRenderType() {
        return 3;
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
                ( x, y, z //block's coordinates.
                        //file: resources\assets\<MODID>\sounds\diceDestory.ogg
                        , DiceMod.MODID+":diceDestory"
                        , 0.5F //half volume.
                        , 1.0F //normal pitch.
                        , true //default
                );
    }
}
