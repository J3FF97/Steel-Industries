package com.j3ff97.steelindustries.init;

import com.j3ff97.steelindustries.blocks.*;
import com.j3ff97.steelindustries.reference.Names;
import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public final class ModBlocks
{
    public static BlockSI     blockSteel;
    public static BlockSI     blockTitanium;
    public static BlockSI     oreRutile;
    public static OreGraphite oreGraphite;
    public static OreSilicon  oreSilicon;
    public static BarsSteel   barsSteel;

    public static Block       highOven;
    public static Block       highOven_lit;

public static void init()
{
    blockSteel = new BlockSI(Names.Blocks.blockSteelName, Material.iron, 5F, 30F, BlockSI.soundTypeMetal, "pickaxe", 2);
    blockTitanium = new BlockSI(Names.Blocks.blockTitaniumName, Material.iron, 5F, 30F, BlockSI.soundTypeMetal, "pickaxe", 2);
    oreRutile = new BlockSI(Names.Blocks.oreRutileName, Material.rock, 3F, 15F, BlockSI.soundTypeStone, "pickaxe", 2);
    oreGraphite = new OreGraphite(Names.Blocks.oreGraphiteName, Material.rock, 3F, 15F, BlockSI.soundTypeStone, "pickaxe", 1);
    oreSilicon = new OreSilicon(Names.Blocks.oreSiliconName, Material.sand, 1F, 5F, BlockSI.soundTypeSand, "shovel", 0);
    barsSteel = new BarsSteel(Names.Blocks.barSteelName, Material.iron, true, 5F, 30F, BlockSI.soundTypeMetal, "pickaxe", 2);

    highOven = new BlockHighOven(false, Names.TileEntities.blockHighOvenName, Material.iron, 5F, 30F, Block.soundTypeMetal, "pickaxe", 2);
    highOven_lit = new BlockHighOven(true, Names.TileEntities.blockHighOvenName, Material.iron, 5F, 30F, Block.soundTypeMetal, "pickaxe", 2);

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
    GameRegistry.registerBlock(barsSteel, Names.Blocks.barSteelName);

    GameRegistry.registerBlock(highOven, Names.TileEntities.blockHighOvenName);
    GameRegistry.registerBlock(highOven_lit, Names.TileEntities.lit_blockHighOvenName);


}

public static void registerOreDict()
{
    OreDictionary.registerOre("blockSteel", ModBlocks.blockSteel);
    OreDictionary.registerOre("blockTitanium", ModBlocks.blockTitanium);
    OreDictionary.registerOre("oreGraphite", ModBlocks.oreGraphite);
    OreDictionary.registerOre("oreRutile", ModBlocks.oreRutile);
    OreDictionary.registerOre("oreTitanium", ModBlocks.oreRutile);
    OreDictionary.registerOre("oreSilicon", ModBlocks.oreSilicon);
}

public static void registerBlockRenderer()
{
    registerModel(blockSteel, Names.Blocks.blockSteelName);
    registerModel(blockTitanium, Names.Blocks.blockTitaniumName);
    registerModel(oreGraphite, Names.Blocks.oreGraphiteName);
    registerModel(oreRutile, Names.Blocks.oreRutileName);
    registerModel(oreSilicon, Names.Blocks.oreSiliconName);
    registerModel(barsSteel, Names.Blocks.barSteelName);
    registerModel(highOven, Names.TileEntities.blockHighOvenName);
    registerModel(highOven_lit, Names.TileEntities.lit_blockHighOvenName);
}

public static void registerModel(Block block, String blockName)
{
    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
            .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.ID + ":" + blockName, "inventory"));
}
}
