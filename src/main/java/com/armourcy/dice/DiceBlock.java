package com.armourcy.dice;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.Explosion;
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
        return random.nextInt(3) + 2;
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return drop;
    }

    public void setItemDropped(Item item) {
        drop = item;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float dx, float dy, float dz) {
        if (world.getBlock(x, y+3, z) == Blocks.air) {
            EntitySheep sheep = new EntitySheep(world);
            sheep.setLocationAndAngles(x, y+3, z, 0, 0);
            world.spawnEntityInWorld(sheep);
        }
        return false;
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        Block block = world.getBlock(x, y-1, z);
        world.setBlock(x, y, z, block);
        //EntityLightningBolt lightningBolt = new EntityLightningBolt(world, x, y, z);
        //world.addWeatherEffect(lightningBolt);
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion) {
        EntitySnowball snowball = new EntitySnowball(world, x + 0.5, y + 1.5, z + 0.5);
        snowball.motionY = 0.1;
        world.spawnEntityInWorld(snowball);
    }

    @Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
        if (entity instanceof EntitySheep) {
            entity.setFire(500);
        }
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
