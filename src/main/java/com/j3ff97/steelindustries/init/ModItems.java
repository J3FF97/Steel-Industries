package com.j3ff97.steelindustries.init;

import com.j3ff97.steelindustries.reference.Material;
import com.j3ff97.steelindustries.items.*;
import com.j3ff97.steelindustries.reference.Names;
import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public final class ModItems
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
    public static ItemSI wandCapSteel;
    public static ItemSI wandCapTitanium;
    public static ItemSI bucket_of_steel;

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
        bucket_of_steel = new ItemSI(Names.Items.bucketMoltenSteelName);

        axeSteel = new AxeSI(Material.SteelTool, Names.Tools.axeSteelName);
        axeTitanium = new AxeSI(Material.TitaniumTool, Names.Tools.axeTitaniumName);
        hoeSteel = new HoeSI(Material.SteelTool, Names.Tools.hoeSteelName);
        hoeTitanium = new HoeSI(Material.TitaniumTool, Names.Tools.hoeTitaniumName);
        pickaxeSteel = new PickaxeSI(Material.SteelTool, Names.Tools.pickaxeSteelName);
        pickaxeTitanium = new PickaxeSI(Material.TitaniumTool, Names.Tools.pickaxeTitaniumName);
        shovelSteel = new ShovelSI(Material.SteelTool, Names.Tools.shovelSteelName);
        shovelTitanium = new ShovelSI(Material.TitaniumTool, Names.Tools.shovelTitaniumName);
        swordSteel = new SwordSI(Material.SteelTool, Names.Tools.swordSteelName);
        swordTitanium = new SwordSI(Material.TitaniumTool, Names.Tools.swordTitaniumName);
        shearsSteel = new ShearsSI(2048, Names.Tools.shearsSteelName);
        shearsTitanium = new ShearsSI(750, Names.Tools.shearsTitaniumName);

        steelBoots = new SteelArmorSI(Names.Armor.bootsSteelName, Material.SteelArmor, "steel", 3);
        steelLeggings = new SteelArmorSI(Names.Armor.legsSteelName, Material.SteelArmor, "steel", 2);
        steelChestplate = new SteelArmorSI(Names.Armor.chestplateSteelName, Material.SteelArmor, "steel", 1);
        steelHelmet = new SteelArmorSI(Names.Armor.helmetSteelName, Material.SteelArmor, "steel", 0);
        titaniumBoots = new TitaniumArmorSI(Names.Armor.bootsTitaniumName, Material.TitaniumArmor, "titanium", 3);
        titaniumLeggings = new TitaniumArmorSI(Names.Armor.legsTitaniumName, Material.TitaniumArmor, "titanium", 2);
        titaniumChestplate = new TitaniumArmorSI(Names.Armor.chestplateTitaniumName, Material.TitaniumArmor, "titanium", 1);
        titaniumHelmet = new TitaniumArmorSI(Names.Armor.helmetTitaniumName, Material.TitaniumArmor, "titanium", 0);

        registerItems();

        registerOreDict();
    }

    public static void registerItems()
    {
        GameRegistry.registerItem(ingotSteel, Names.Items.ingotSteelName);
        GameRegistry.registerItem(nuggetSteel, Names.Items.nuggetSteelName);
        GameRegistry.registerItem(ingotTitanium, Names.Items.ingotTitaniumName);
        GameRegistry.registerItem(nuggetTitanium, Names.Items.nuggetTitaniumName);
        GameRegistry.registerItem(itemIronCompound, Names.Items.itemIronCompoundName);
        GameRegistry.registerItem(itemSteelMesh, Names.Items.itemSteelMeshName);
        GameRegistry.registerItem(rawSilicon, Names.Items.rawSiliconName);
        GameRegistry.registerItem(refinedSilicon, Names.Items.refinedSiliconName);
        GameRegistry.registerItem(chunkGraphite, Names.Items.chunkGraphiteName);


        GameRegistry.registerItem(axeSteel, Names.Tools.axeSteelName);
        GameRegistry.registerItem(hoeSteel, Names.Tools.hoeSteelName);
        GameRegistry.registerItem(pickaxeSteel, Names.Tools.pickaxeSteelName);
        GameRegistry.registerItem(shearsSteel, Names.Tools.shearsSteelName);
        GameRegistry.registerItem(shovelSteel, Names.Tools.shovelSteelName);
        GameRegistry.registerItem(swordSteel, Names.Tools.swordSteelName);

        GameRegistry.registerItem(axeTitanium, Names.Tools.axeTitaniumName);
        GameRegistry.registerItem(hoeTitanium, Names.Tools.hoeTitaniumName);
        GameRegistry.registerItem(pickaxeTitanium, Names.Tools.pickaxeTitaniumName);
        GameRegistry.registerItem(shearsTitanium, Names.Tools.shearsTitaniumName);
        GameRegistry.registerItem(shovelTitanium, Names.Tools.shovelTitaniumName);
        GameRegistry.registerItem(swordTitanium, Names.Tools.swordTitaniumName);

        GameRegistry.registerItem(steelBoots, Names.Armor.bootsSteelName);
        GameRegistry.registerItem(steelLeggings, Names.Armor.legsSteelName);
        GameRegistry.registerItem(steelChestplate, Names.Armor.chestplateSteelName);
        GameRegistry.registerItem(steelHelmet, Names.Armor.helmetSteelName);
        GameRegistry.registerItem(titaniumBoots, Names.Armor.bootsTitaniumName);
        GameRegistry.registerItem(titaniumLeggings, Names.Armor.legsTitaniumName);
        GameRegistry.registerItem(titaniumChestplate, Names.Armor.chestplateTitaniumName);
        GameRegistry.registerItem(titaniumHelmet, Names.Armor.helmetTitaniumName);

        if(Loader.isModLoaded("Thaumcraft"))
        {
            GameRegistry.registerItem(wandCapSteel, Names.Addons.wandCapSteelName);
            GameRegistry.registerItem(wandCapTitanium, Names.Addons.wandCapTitaniumName);
        }
    }

    public static void registerOreDict()
    {
        OreDictionary.registerOre("ingotSteel", ModItems.ingotSteel);
        OreDictionary.registerOre("nuggetSteel", ModItems.nuggetSteel);

        OreDictionary.registerOre("ingotTitanium", ModItems.ingotTitanium);
        OreDictionary.registerOre("nuggetTitanium", ModItems.nuggetTitanium);

        OreDictionary.registerOre("itemSilicon", ModItems.refinedSilicon);
        OreDictionary.registerOre("itemRubber", ModItems.refinedSilicon);

        OreDictionary.registerOre("barGraphite", ModItems.chunkGraphite);
        OreDictionary.registerOre("ingotGraphite", ModItems.chunkGraphite);
        OreDictionary.registerOre("chunkGraphite", ModItems.chunkGraphite);

    }

    public static void registerItemRenderer()
    {
        registerModel(ingotSteel, Names.Items.ingotSteelName);
        registerModel(nuggetSteel, Names.Items.nuggetSteelName);
        registerModel(ingotTitanium, Names.Items.ingotTitaniumName);
        registerModel(nuggetTitanium, Names.Items.nuggetTitaniumName);
        registerModel(itemIronCompound, Names.Items.itemIronCompoundName);
        registerModel(itemSteelMesh, Names.Items.itemSteelMeshName);
        registerModel(rawSilicon, Names.Items.rawSiliconName);
        registerModel(refinedSilicon, Names.Items.refinedSiliconName);
        registerModel(chunkGraphite, Names.Items.chunkGraphiteName);
        registerModel(wandCapSteel, Names.Addons.wandCapSteelName);
        registerModel(wandCapTitanium, Names.Addons.wandCapTitaniumName);

        registerModel(axeSteel, Names.Tools.axeSteelName);
        registerModel(hoeSteel, Names.Tools.hoeSteelName);
        registerModel(pickaxeSteel, Names.Tools.pickaxeSteelName);
        registerModel(shearsSteel, Names.Tools.shearsSteelName);
        registerModel(shovelSteel, Names.Tools.shovelSteelName);
        registerModel(swordSteel, Names.Tools.swordSteelName);

        registerModel(axeTitanium, Names.Tools.axeTitaniumName);
        registerModel(hoeTitanium, Names.Tools.hoeTitaniumName);
        registerModel(pickaxeTitanium, Names.Tools.pickaxeTitaniumName);
        registerModel(shearsTitanium, Names.Tools.shearsTitaniumName);
        registerModel(shovelTitanium, Names.Tools.shovelTitaniumName);
        registerModel(swordTitanium, Names.Tools.swordTitaniumName);

        registerModel(steelBoots, Names.Armor.bootsSteelName);
        registerModel(steelLeggings, Names.Armor.legsSteelName);
        registerModel(steelChestplate, Names.Armor.chestplateSteelName);
        registerModel(steelHelmet, Names.Armor.helmetSteelName);
        registerModel(titaniumBoots, Names.Armor.bootsTitaniumName);
        registerModel(titaniumLeggings, Names.Armor.legsTitaniumName);
        registerModel(titaniumChestplate, Names.Armor.chestplateTitaniumName);
        registerModel(titaniumHelmet, Names.Armor.helmetTitaniumName);
    }


    public static void registerModel(Item item, String itemName)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.ID + ":" + itemName, "inventory"));
    }
}

