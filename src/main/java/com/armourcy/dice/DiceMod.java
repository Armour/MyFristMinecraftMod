package com.armourcy.dice;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by armour on 9/5/15.
 */

@Mod(modid = DiceMod.MODID, name = DiceMod.NAME, version = DiceMod.VERSION)
public class DiceMod {
    public static final String MODID = "dice";
    public static final String VERSION = "1.0";
    public static final String NAME = "Dice Block";

    public static DiceBlock diceblock;
    public static DiceItem diceitem;
    public static DiceTab dicetab;
    public static DiceWorldGenerator diceWorldGen;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        System.out.println("DiceMod.preInit()"); //output to console.
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        System.out.println("DiceMod.init()"); //output to console.

        dicetab = new DiceTab("dicetab");

        diceitem = new DiceItem();
        diceitem.setUnlocalizedName("diceitem");
        diceitem.setCreativeTab(dicetab);
        diceitem.setTextureName(MODID + ":diceItem"); //file: resources\assets\<MODID>\textures\blocks\diceItem.png
        diceitem.setMaxStackSize(99);
        GameRegistry.registerItem(diceitem, "diceitem");

        diceblock = new DiceBlock(Material.rock);
        diceblock.setBlockName("diceblock");
        diceblock.setStepSound(Block.soundTypeStone);
        diceblock.setCreativeTab(dicetab);
        diceblock.setHardness(20.0F);
        diceblock.setHarvestLevel("pickaxe", 1);
        diceblock.setResistance(30.0F);
        diceblock.setBlockTextureName(MODID + ":diceBlock"); //file: resources\assets\<MODID>\textures\blocks\diceBlock.png
        diceblock.setItemDropped(diceitem);
        diceblock.setLightLevel(1.0f);
        GameRegistry.registerBlock(diceblock, "diceblock");

        dicetab.setTabItemIcon(diceitem);

        diceWorldGen = new DiceWorldGenerator(diceblock, 1000, 12);
        GameRegistry.registerWorldGenerator(diceWorldGen, 1);

        GameRegistry.addShapedRecipe(new ItemStack(diceblock), "XXX", "X X", "XXX", 'X', Item.getItemFromBlock(Block.getBlockFromName("cobblestone")));
        GameRegistry.addShapelessRecipe(new ItemStack(diceitem, 3), new ItemStack(diceblock));
        GameRegistry.addSmelting(diceblock, new ItemStack(diceitem, 3), 1.0F);

        MinecraftForge.EVENT_BUS.register(new DiceBreakExplosion());
        MinecraftForge.EVENT_BUS.register(new DiceBreakMessage());
        MinecraftForge.EVENT_BUS.register(new DiceChickenDrop());
        MinecraftForge.EVENT_BUS.register(new ArmoredZombie());
        MinecraftForge.EVENT_BUS.register(new SuperJump());
        MinecraftForge.EVENT_BUS.register(new SpiderMan());
        MinecraftForge.EVENT_BUS.register(new BlockFiller());

        FMLCommonHandler.instance().bus().register(new SuperJump());
    }

    @EventHandler
    public void registerCommands(FMLServerStartingEvent event) {
        event.registerServerCommand(new FlamingPigs());
        event.registerServerCommand(new BlockFillerCmd());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        System.out.println("DiceMod.postInit()"); //output to console.
    }
}
