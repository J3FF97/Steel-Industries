package com.j3ff97.steelindustries;

import com.j3ff97.steelindustries.handler.ConfigurationHandler;
import com.j3ff97.steelindustries.handler.FuelHandler;
import com.j3ff97.steelindustries.handler.LootHandler;
import com.j3ff97.steelindustries.handler.ResearchHandler;
import com.j3ff97.steelindustries.init.ModBlocks;
import com.j3ff97.steelindustries.init.ModItems;
import com.j3ff97.steelindustries.init.OreDict;
import com.j3ff97.steelindustries.init.Recipes;
import com.j3ff97.steelindustries.proxy.IProxy;
import com.j3ff97.steelindustries.reference.Reference;
import com.j3ff97.steelindustries.utility.LogHelper;
import com.j3ff97.steelindustries.utility.RecipeRemover;
import com.j3ff97.steelindustries.worldgen.OreGen;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION, guiFactory = Reference.GUIFACTORY, dependencies = Reference.DEPENDENCIES)
public class SteelIndustries
{
    @Mod.Instance(Reference.ID)
    public static SteelIndustries instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.info("Booting up SteelIndustries!");
        LogHelper.info("Made by: " + Reference.AUTHOR);

        LogHelper.info("SteelIndustries: Starting PreInit");

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        LogHelper.info("SteelIndustries: Initialized ConfigurationHandler");

        ModItems.init();
        LogHelper.info("SteelIndustries: Initialized Items");

        ModBlocks.init();
        LogHelper.info("SteelIndustries: Initialized Blocks");
        LogHelper.info("SteelIndustries: PreInit Complete");
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event)
    {
        LogHelper.info("SteelIndustries: Starting Init");

        if(ConfigurationHandler.flintAndSteel)
        {
            RecipeRemover.removeRecipes(Items.flint_and_steel);
            LogHelper.info("SteelIndustries: Removed Recipes");
        }

        OreDict.init();
        LogHelper.info("SteelIndustries: Initialized Oredictionary Compatibility");

        Recipes.initCrafting();
        LogHelper.info("SteelIndustries: Initialized Crafting");

        GameRegistry.registerWorldGenerator(new OreGen(), 1);
        LogHelper.info("SteelIndustries: Initialized WorldGen");

        GameRegistry.registerFuelHandler(new FuelHandler());
        LogHelper.info("SteelIndustries: Initialized FuelHandler");

        LootHandler.init();
        LogHelper.info("SteelIndustries: Initialized Chest Loot");

        LogHelper.info("SteelIndustries: Init Complete");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("SteelIndustries: Starting PostInit");

        if(Loader.isModLoaded("Thaumcraft"))
        {
            ResearchHandler.init();
            LogHelper.info("SteelIndustries: Initialized ResearchHandler");
        }

        LogHelper.info("SteelIndustries: PostInit Complete");
        LogHelper.info("SteelIndustries: Ready to rock!");
    }
}
