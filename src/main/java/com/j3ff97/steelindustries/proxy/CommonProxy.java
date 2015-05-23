package com.j3ff97.steelindustries.proxy;

import com.j3ff97.steelindustries.SteelIndustries;
import com.j3ff97.steelindustries.handler.ConfigurationHandler;
import com.j3ff97.steelindustries.handler.FuelHandler;
import com.j3ff97.steelindustries.handler.GuiHandler;
import com.j3ff97.steelindustries.handler.LootHandler;
import com.j3ff97.steelindustries.init.ModBlocks;
import com.j3ff97.steelindustries.init.ModItems;
import com.j3ff97.steelindustries.init.Recipes;
import com.j3ff97.steelindustries.init.TileEntities;
import com.j3ff97.steelindustries.utility.LogHelper;
import com.j3ff97.steelindustries.utility.RecipeRemover;
import com.j3ff97.steelindustries.worldgen.OreGen;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

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

        TileEntities.init();
        LogHelper.info("SteelIndustries: Initialized TileEntities");

    }

    public void init(FMLInitializationEvent e)
    {
        if(ConfigurationHandler.flintAndSteel)
        {
            RecipeRemover.removeRecipes(Items.flint_and_steel);
            LogHelper.info("SteelIndustries: Removed Recipes");
        }

        Recipes.init();
        LogHelper.info("SteelIndustries: Initialized Crafting");

        GameRegistry.registerFuelHandler(new FuelHandler());
        LogHelper.info("SteelIndustries: Initialized FuelHandler");

        LootHandler.init();
        LogHelper.info("SteelIndustries: Initialized Chest Loot");

        GameRegistry.registerWorldGenerator(new OreGen(), 2);
        LogHelper.info("SteelIndustries: Initialized OreGen");

        NetworkRegistry.INSTANCE.registerGuiHandler(SteelIndustries.instance, new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }
}
