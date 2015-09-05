/**
 * Created by armour on 9/5/15.
 */

package com.armourcy.dice;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid="DiceMod.MODID", name = "DiceMod.NAME", version="DiceMod.VERSION")
public class DiceMod {
    public static final String MODID = "dice";
    public static final String VERSION = "version";
    public static final String NAME = "Dice Blcok";

    public static final Block diceblock = new DiceBlock(Material.rock);

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        System.out.println("DiceMod.preInit()"); //output to console.
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        System.out.println("DiceMod.init()"); //output to console.
        diceblock.setBlockName("diceblock");
        diceblock.setStepSound(Block.soundTypeStone);
        diceblock.setCreativeTab(CreativeTabs.tabBlock);
        diceblock.setBlockTextureName(MODID + ":diceBlock"); //file: resources\assets\<MODID>\textures\blocks\diceBlock.png
        GameRegistry.registerBlock(diceblock, "diceblock");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        System.out.println("DiceMod.postInit()"); //output to console.
    }
}
