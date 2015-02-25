package com.j3ff97.steelindustries.init;

import com.j3ff97.steelindustries.handler.MaterialHandler;
import com.j3ff97.steelindustries.item.*;
import com.j3ff97.steelindustries.reference.Names;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
    public static ItemSI    ingotSteel;
    public static ItemSI    ingotTitanium;
    public static ItemSI    nuggetSteel;
    public static ItemSI    nuggetTitanium;
    public static ItemSI    itemIronCompound;
    public static ItemSI    itemSteelMesh;
    public static ItemSI    rawSilicon;
    public static ItemSI    refinedSilicon;
    public static ItemSI    chunkGraphite;
    public static ItemSI    wandCapSteel;
    public static ItemSI    wandCapTitanium;
    public static AxeSI     axeSteel;
    public static AxeSI     axeTitanium;
    public static HoeSI     hoeSteel;
    public static HoeSI     hoeTitanium;
    public static PickaxeSI pickaxeSteel;
    public static PickaxeSI pickaxeTitanium;
    public static ShearsSI  shearsSteel;
    public static ShearsSI  shearsTitanium;
    public static ShovelSI  shovelSteel;
    public static ShovelSI  shovelTitanium;
    public static SickleSI  sickleSteel;
    public static SickleSI  sickleTitanium;
    public static SwordSI   swordSteel;
    public static SwordSI   swordTitanium;

    public static SteelArmorSI    steelBoots;
    public static SteelArmorSI    steelLeggings;
    public static SteelArmorSI    steelChestplate;
    public static SteelArmorSI    steelHelmet;
    public static TitaniumArmorSI titaniumBoots;
    public static TitaniumArmorSI titaniumLeggings;
    public static TitaniumArmorSI titaniumChestplate;
    public static TitaniumArmorSI titaniumHelmet;

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
        wandCapSteel = new ItemSI(Names.Addons.wandCapSteelName);
        wandCapTitanium = new ItemSI(Names.Addons.wandCapTitaniumName);

        axeSteel = new AxeSI(MaterialHandler.SteelTool, Names.Tools.axeSteelName);
        axeTitanium = new AxeSI(MaterialHandler.TitaniumTool, Names.Tools.axeTitaniumName);
        hoeSteel = new HoeSI(MaterialHandler.SteelTool, Names.Tools.hoeSteelName);
        hoeTitanium = new HoeSI(MaterialHandler.TitaniumTool, Names.Tools.hoeTitaniumName);
        pickaxeSteel = new PickaxeSI(MaterialHandler.SteelTool, Names.Tools.pickaxeSteelName);
        pickaxeTitanium = new PickaxeSI(MaterialHandler.TitaniumTool, Names.Tools.pickaxeTitaniumName);
        shovelSteel = new ShovelSI(MaterialHandler.SteelTool, Names.Tools.shovelSteelName);
        shovelTitanium = new ShovelSI(MaterialHandler.TitaniumTool, Names.Tools.shovelTitaniumName);
        sickleSteel = new SickleSI(MaterialHandler.SteelTool, Names.Tools.sickleSteelName);
        sickleTitanium = new SickleSI(MaterialHandler.TitaniumTool, Names.Tools.sickleTitaniumName);
        swordSteel = new SwordSI(MaterialHandler.SteelTool, Names.Tools.swordSteelName);
        swordTitanium = new SwordSI(MaterialHandler.TitaniumTool, Names.Tools.swordTitaniumName);
        shearsSteel = new ShearsSI(2048, Names.Tools.shearsSteelName);
        shearsTitanium = new ShearsSI(750, Names.Tools.shearsTitaniumName);

        steelBoots = new SteelArmorSI(Names.Armor.bootsSteelName, MaterialHandler.SteelArmor, "steel", 3);
        steelLeggings = new SteelArmorSI(Names.Armor.legsSteelName, MaterialHandler.SteelArmor, "steel", 2);
        steelChestplate = new SteelArmorSI(Names.Armor.chestplateSteelName, MaterialHandler.SteelArmor, "steel", 1);
        steelHelmet = new SteelArmorSI(Names.Armor.helmetSteelName, MaterialHandler.SteelArmor, "steel", 0);
        titaniumBoots = new TitaniumArmorSI(Names.Armor.bootsTitaniumName, MaterialHandler.TitaniumArmor, "titanium", 3);
        titaniumLeggings = new TitaniumArmorSI(Names.Armor.legsTitaniumName, MaterialHandler.TitaniumArmor, "titanium", 2);
        titaniumChestplate = new TitaniumArmorSI(Names.Armor.chestplateTitaniumName, MaterialHandler.TitaniumArmor, "titanium", 1);
        titaniumHelmet = new TitaniumArmorSI(Names.Armor.helmetTitaniumName, MaterialHandler.TitaniumArmor, "titanium", 0);

        GameRegistry.registerItem(ingotSteel, Names.Items.ingotSteelName);
        GameRegistry.registerItem(nuggetSteel, Names.Items.nuggetSteelName);
        GameRegistry.registerItem(axeSteel, Names.Tools.axeSteelName);
        GameRegistry.registerItem(hoeSteel, Names.Tools.hoeSteelName);
        GameRegistry.registerItem(pickaxeSteel, Names.Tools.pickaxeSteelName);
        GameRegistry.registerItem(shearsSteel, Names.Tools.shearsSteelName);
        GameRegistry.registerItem(shovelSteel, Names.Tools.shovelSteelName);
        GameRegistry.registerItem(sickleSteel, Names.Tools.sickleSteelName);
        GameRegistry.registerItem(swordSteel, Names.Tools.swordSteelName);
        GameRegistry.registerItem(steelBoots, Names.Armor.bootsSteelName);
        GameRegistry.registerItem(steelLeggings, Names.Armor.legsSteelName);
        GameRegistry.registerItem(steelChestplate, Names.Armor.chestplateSteelName);
        GameRegistry.registerItem(steelHelmet, Names.Armor.helmetSteelName);
        GameRegistry.registerItem(ingotTitanium, Names.Items.ingotTitaniumName);
        GameRegistry.registerItem(nuggetTitanium, Names.Items.nuggetTitaniumName);
        GameRegistry.registerItem(axeTitanium, Names.Tools.axeTitaniumName);
        GameRegistry.registerItem(hoeTitanium, Names.Tools.hoeTitaniumName);
        GameRegistry.registerItem(pickaxeTitanium, Names.Tools.pickaxeTitaniumName);
        GameRegistry.registerItem(shearsTitanium, Names.Tools.shearsTitaniumName);
        GameRegistry.registerItem(shovelTitanium, Names.Tools.shovelTitaniumName);
        GameRegistry.registerItem(sickleTitanium, Names.Tools.sickleTitaniumName);
        GameRegistry.registerItem(swordTitanium, Names.Tools.swordTitaniumName);
        GameRegistry.registerItem(titaniumBoots, Names.Armor.bootsTitaniumName);
        GameRegistry.registerItem(titaniumLeggings, Names.Armor.legsTitaniumName);
        GameRegistry.registerItem(titaniumChestplate, Names.Armor.chestplateTitaniumName);
        GameRegistry.registerItem(titaniumHelmet, Names.Armor.helmetTitaniumName);
        GameRegistry.registerItem(itemIronCompound, Names.Items.itemIronCompoundName);
        GameRegistry.registerItem(itemSteelMesh, Names.Items.itemSteelMeshName);
        GameRegistry.registerItem(rawSilicon, Names.Items.rawSiliconName);
        GameRegistry.registerItem(refinedSilicon, Names.Items.refinedSiliconName);
        GameRegistry.registerItem(chunkGraphite, Names.Items.chunkGraphiteName);

        if(Loader.isModLoaded("Thaumcraft"))
        {
            GameRegistry.registerItem(wandCapSteel, Names.Addons.wandCapSteelName);
            GameRegistry.registerItem(wandCapTitanium, Names.Addons.wandCapTitaniumName);
        }
    }
}
