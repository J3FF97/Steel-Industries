package com.j3ff97.steelindustries.init;

import com.j3ff97.steelindustries.block.*;
import com.j3ff97.steelindustries.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks
{
    public static BlockSIMulti blockSteel;
    public static BlockSIMulti blockTitanium;
    public static OreGraphite oreGraphite;
    public static BlockSI      oreRutile;
    public static BarsSteel   steelBars;
    public static BlockFalling oreSilicon;

    public static void init()
    {
        blockSteel = new BlockSIMulti(Names.Blocks.blockSteelName, Material.iron, "pickaxe", 2, 5F, 30F, Block.soundTypeMetal);
        blockTitanium = new BlockSIMulti(Names.Blocks.blockTitaniumName, Material.iron, "pickaxe", 2, 5F, 30F, Block.soundTypeMetal);
        oreGraphite = new OreGraphite(Names.Blocks.oreGraphiteName, Material.rock, "pickaxe", 1, 3F, 15F, Block.soundTypeStone);
        oreRutile = new BlockSI(Names.Blocks.oreRutileName, Material.rock, "pickaxe", 2, 3F, 15F, Block.soundTypeStone);
        oreSilicon = new OreSilicon(Names.Blocks.oreSiliconName, Material.sand, "shovel", 0, 1F, 5F, Block.soundTypeSand);
        steelBars = new BarsSteel(Names.Blocks.barSteelName, "steelIndustries:steel_bars", "steelIndustries:steel_bars", Material.iron, true, "pickaxe", 2, 5F, 30F, Block.soundTypeMetal);

        registerBlocks();
        registerOreDict();
    }

    public static void registerBlocks()
    {
        GameRegistry.registerBlock(blockSteel, Names.Blocks.blockSteelName);
        GameRegistry.registerBlock(blockTitanium, Names.Blocks.blockTitaniumName);
        GameRegistry.registerBlock(oreGraphite, Names.Blocks.oreGraphiteName);
        GameRegistry.registerBlock(oreRutile, Names.Blocks.oreRutileName);
        GameRegistry.registerBlock(oreSilicon, Names.Blocks.oreSiliconName);
        GameRegistry.registerBlock(steelBars, Names.Blocks.barSteelName);
    }

    public static void registerOreDict()
    {
        OreDictionary.registerOre("blockSteel", blockSteel);
        OreDictionary.registerOre("blockTitanium", blockTitanium);
        OreDictionary.registerOre("oreGraphite", oreGraphite);
        OreDictionary.registerOre("oreRutile", oreRutile);
        OreDictionary.registerOre("oreSilicon", oreSilicon);
    }
}
