package com.j3ff97.steelindustries.init;

import com.j3ff97.steelindustries.item.ItemSI;
import com.j3ff97.steelindustries.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
    public static ItemSI ingotSteel;
    public static ItemSI ingotTitanium;
    public static ItemSI nuggetSteel;
    public static ItemSI nuggetTitanium;
    public static ItemSI itemIronCompound;
    public static ItemSI itemSteelMesh;
    public static ItemSI rawSilicon;
    public static ItemSI refinedSilicon;
    public static ItemSI chunkGraphite;

    public static void init()
    {
        ingotSteel = new ItemSI(Names.Items.ingotSteelName);
        ingotTitanium = new ItemSI(Names.Items.ingotTitaniumName);
        nuggetSteel = new ItemSI(Names.Items.nuggetSteelName);
        nuggetTitanium = new ItemSI(Names.Items.nuggetTitaniumName);
        itemIronCompound = new ItemSI(Names.Items.itemIronCompoundName);
        itemSteelMesh = new ItemSI(Names.Items.itemSteelMeshName);
        rawSilicon = new ItemSI(Names.Items.rawSiliconName);
        refinedSilicon = new ItemSI(Names.Items.refinedSiliconName);
        chunkGraphite = new ItemSI(Names.Items.chunkGraphiteName);

        GameRegistry.registerItem(ingotSteel, Names.Items.ingotSteelName);
        GameRegistry.registerItem(ingotTitanium, Names.Items.ingotTitaniumName);
        GameRegistry.registerItem(nuggetSteel, Names.Items.nuggetSteelName);
        GameRegistry.registerItem(nuggetTitanium, Names.Items.nuggetTitaniumName);
        GameRegistry.registerItem(itemIronCompound, Names.Items.itemIronCompoundName);
        GameRegistry.registerItem(itemSteelMesh, Names.Items.itemSteelMeshName);
        GameRegistry.registerItem(rawSilicon, Names.Items.rawSiliconName);
        GameRegistry.registerItem(refinedSilicon, Names.Items.refinedSiliconName);
        GameRegistry.registerItem(chunkGraphite, Names.Items.chunkGraphiteName);
    }
}
