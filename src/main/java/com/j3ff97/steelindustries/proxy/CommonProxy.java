package com.j3ff97.steelindustries.proxy;


import com.j3ff97.steelindustries.SteelIndustries;
import com.j3ff97.steelindustries.compat.thaumcraft.ResearchHandler;
import com.j3ff97.steelindustries.handler.*;
import com.j3ff97.steelindustries.init.ModBlocks;
import com.j3ff97.steelindustries.init.ModItems;
import com.j3ff97.steelindustries.init.Recipes;
import com.j3ff97.steelindustries.init.TileEntities;
import com.j3ff97.steelindustries.utility.LogHelper;
import com.j3ff97.steelindustries.utility.RecipeRemover;
import com.j3ff97.steelindustries.worldgen.OreGen;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        ConfigurationHandler.init(e.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        LogHelper.info("SteelIndustries: Initialized ConfigurationHandler");

        ModItems.init();
        LogHelper.info("SteelIndustries: Initialized Items");

        ModBlocks.init();
        LogHelper.info("SteelIndustries: Initialized Blocks");
    }

    public void init(FMLInitializationEvent e)
    {
        TileEntities.init();
        LogHelper.info("SteelIndustries: Initialized Tile Entities");

        if(ConfigurationHandler.flintAndSteel)
        {
            RecipeRemover.removeRecipes(Items.flint_and_steel);
            LogHelper.info("SteelIndustries: Removed Recipes");
        }

        NetworkRegistry.INSTANCE.registerGuiHandler(SteelIndustries.instance, new GuiHandler());

        Recipes.init();
        LogHelper.info("SteelIndustries: Initialized Crafting");

        GameRegistry.registerFuelHandler(new FuelHandler());
        LogHelper.info("SteelIndustries: Initialized FuelHandler");

        LootHandler.init();
        LogHelper.info("SteelIndustries: Initialized Chest Loot");

        GameRegistry.registerWorldGenerator(new OreGen(), 2);
        LogHelper.info("SteelIndustries: Initialized OreGen");

    }

    public void postInit(FMLPostInitializationEvent e)
    {

        if(Loader.isModLoaded("Thaumcraft"))
        {
            ResearchHandler.init();
            LogHelper.info("SteelIndustries: Initialized ResearchHandler");
        }

    }
}
