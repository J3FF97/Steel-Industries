package com.j3ff97.steelindustries.init;

import com.j3ff97.steelindustries.block.*;
import com.j3ff97.steelindustries.block.base.BlockSI;
import com.j3ff97.steelindustries.block.base.BlockSIMulti;
import com.j3ff97.steelindustries.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class ModBlocks
{
    public static BlockSIMulti blockSteel;
    public static BlockSIMulti blockTitanium;
    public static BlockSI      oreGraphite;
    public static BlockSI      oreRutile;
    public static BlockFalling oreSilicon;

    public static void init()
    {
        blockSteel = new BlockSteel(Names.Blocks.blockSteelName, Material.iron, "pickaxe", 2);
        blockTitanium = new BlockTitanium(Names.Blocks.blockTitaniumName, Material.iron, "pickaxe", 2);
        oreGraphite = new OreGraphite(Names.Blocks.oreGraphiteName, Material.rock, "pickaxe", 1);
        oreRutile = new OreRutile(Names.Blocks.oreRutileName, Material.rock, "pickaxe", 2);
        oreSilicon = new OreSilicon(Names.Blocks.oreSiliconName, Material.sand, "shovel", 0);

        GameRegistry.registerBlock(blockSteel, Names.Blocks.blockSteelName);
        GameRegistry.registerBlock(blockTitanium, Names.Blocks.blockTitaniumName);
        GameRegistry.registerBlock(oreGraphite, Names.Blocks.oreGraphiteName);
        GameRegistry.registerBlock(oreRutile, Names.Blocks.oreRutileName);
        GameRegistry.registerBlock(oreSilicon, Names.Blocks.oreSiliconName);
    }
}
