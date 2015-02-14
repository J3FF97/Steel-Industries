package com.j3ff97.steelindustries.handler;

import com.j3ff97.steelindustries.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;

    public static boolean testBoolean = true;

    public static void init(File configFile)
    {
        //create the configuration object from the given configuration file
        if(configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    public static void loadConfiguration()
    {
        String desc;

        desc = "TestBoolean";
        testBoolean = getBool("testBool", testBoolean, desc);

        if(configuration.hasChanged())
        {
            configuration.save();
        }
    }

    public static int getInt(String propName, int default_, String desc)
    {
        Property property = configuration.get(Configuration.CATEGORY_GENERAL, propName, default_);
        property.comment = desc;
        return property.getInt(default_);
    }

    public static boolean getBool(String propName, boolean default_, String desc)
    {
        Property property = configuration.get(Configuration.CATEGORY_GENERAL, propName, default_);
        property.comment = desc;
        return property.getBoolean(default_);
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if(event.modID.equalsIgnoreCase(Reference.ID))
        {
            loadConfiguration();
        }
    }
}
