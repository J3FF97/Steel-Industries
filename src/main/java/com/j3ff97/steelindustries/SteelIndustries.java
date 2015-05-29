package com.j3ff97.steelindustries;

import com.j3ff97.steelindustries.proxy.CommonProxy;
import com.j3ff97.steelindustries.recipe.HighOvenRecipes;
import com.j3ff97.steelindustries.reference.Reference;
import com.j3ff97.steelindustries.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION, guiFactory = Reference.GUIFACTORY, dependencies = Reference.DEPENDENCIES)
public class SteelIndustries
{
    @Mod.Instance(Reference.ID) public static SteelIndustries instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY) public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.info("Booting up SteelIndustries!");
        LogHelper.info("Made by: " + Reference.AUTHOR);

        LogHelper.info("SteelIndustries: Starting PreInit");

        proxy.preInit(event);

        LogHelper.info("SteelIndustries: PreInit Complete");
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event)
    {
        LogHelper.info("SteelIndustries: Starting Init");

        proxy.init(event);

        FMLInterModComms.sendMessage("Waila", "register", "com.j3ff97.steelindustries.compat.waila.WailaDataProvider.callBackRegister");
        LogHelper.info("SteelIndustries: Registered Waila Addon");

        LogHelper.info("SteelIndustries: Init Complete");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("SteelIndustries: Starting PostInit");

        proxy.postInit(event);

        LogHelper.info("SteelIndustries: PostInit Complete");
        LogHelper.info("SteelIndustries: Ready to rock!");
    }

}
