package com.j3ff97.steelindustries.init;

import net.minecraftforge.oredict.OreDictionary;

public class OreDict
{
    public static void init()
    {
        //Blocks
        OreDictionary.registerOre("blockSteel", ModBlocks.blockSteel);
        OreDictionary.registerOre("blockTitanium", ModBlocks.blockTitanium);

        //Items
        OreDictionary.registerOre("ingotSteel", ModItems.ingotSteel);
        OreDictionary.registerOre("nuggetSteel", ModItems.nuggetSteel);

        OreDictionary.registerOre("ingotTitanium", ModItems.ingotTitanium);
        OreDictionary.registerOre("nuggetTitanium", ModItems.nuggetTitanium);

        OreDictionary.registerOre("itemSilicon", ModItems.refinedSilicon);
        OreDictionary.registerOre("itemRubber", ModItems.refinedSilicon);

        OreDictionary.registerOre("barGraphite", ModItems.chunkGraphite);
        OreDictionary.registerOre("ingotGraphite", ModItems.chunkGraphite);
        OreDictionary.registerOre("chunkGraphite", ModItems.chunkGraphite);

        //Ores
        OreDictionary.registerOre("oreGraphite", ModBlocks.oreGraphite);
        OreDictionary.registerOre("oreRutile", ModBlocks.oreRutile);
        OreDictionary.registerOre("oreSilicon", ModBlocks.oreSilicon);
    }
}
