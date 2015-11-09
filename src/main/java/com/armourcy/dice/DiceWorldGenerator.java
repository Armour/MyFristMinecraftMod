package com.armourcy.dice;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenTrees;

import java.util.Random;

/**
 * Created by armour on 9/5/15.
 */

public class DiceWorldGenerator implements IWorldGenerator {

    public final Block genBlock;
    public final int frequency;
    public final int abundance;


    public DiceWorldGenerator(Block block, int frequency, int abundance) {
        genBlock = block;
        this.frequency = frequency;
        this.abundance = abundance;
    }

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case -1:
                generateInNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 0:
                generateInOverworld(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                generateInEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
        }
    }

    private void generateInNether(World world, Random random, int chunkX , int chunkZ) {
        //do nothing.
    }

    private void generateInEnd(World world, Random random, int chunkX , int chunkZ) {
        //do nothing.
    }

    private void generateInOverworld(World world, Random random, int chunkX , int chunkZ) {
        for (int i = 0; i < frequency; i++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(64); //max height.
            int z = chunkZ + random.nextInt(16);
            WorldGenMinable worldGenMine = new WorldGenMinable(genBlock, abundance);
            worldGenMine.generate(world, random, x, y, z);
            WorldGenTrees worldGenTree = new WorldGenTrees(true);
            worldGenTree.generate(world, random, x, y, z);
        }
    }
}
