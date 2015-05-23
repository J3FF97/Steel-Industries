package com.j3ff97.steelindustries;

import com.j3ff97.steelindustries.proxy.CommonProxy;
import com.j3ff97.steelindustries.reference.Reference;
import com.j3ff97.steelindustries.utility.LogHelper;

import com.sun.org.apache.xml.internal.security.signature.ReferenceNotInitializedException;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod( modid = Reference.ID, name= Reference.NAME, version = Reference.VERSION, guiFactory = Reference.GUIFACTORY, dependencies = Reference.DEPENDENCIES)

public class SteelIndustries
{
    @Mod.Instance(Reference.ID)
    public static SteelIndustries instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.info("Booting up SteelIndustries!");
        LogHelper.info("Made by: " + Reference.AUTHOR);

        LogHelper.info("SteelIndustries: Starting PreInit");

        proxy.preInit(event);

        LogHelper.info("SteelIndustries: PreInit Complete");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        LogHelper.info("SteelIndustries: Starting Init");

        proxy.init(event);

        LogHelper.info("SteelIndustries: Init Complete");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("SteelIndustries: Starting PostInit");

        proxy.postInit(event);

        LogHelper.info("SteelIndustries: PostInit Complete");
        LogHelper.info("SteelIndustries: Ready to rock!");
    }
}
