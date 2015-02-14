package com.j3ff97.steelindustries.init;


import com.j3ff97.steelindustries.block.BlockSI;
import com.j3ff97.steelindustries.block.BlockSteel;
import com.j3ff97.steelindustries.block.BlockTitanium;
import com.j3ff97.steelindustries.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;

public class ModBlocks
{
    public static BlockSI blockSteel;
    public static BlockSI blockTitanium;

    public static void init()
    {
        blockSteel = new BlockSteel(Names.Blocks.blockSteelName, Material.iron, 2);
        blockTitanium = new BlockTitanium(Names.Blocks.blockTitaniumName, Material.iron, 2);

        GameRegistry.registerBlock(blockSteel, Names.Blocks.blockSteelName);
        GameRegistry.registerBlock(blockTitanium, Names.Blocks.blockTitaniumName);
    }
}
