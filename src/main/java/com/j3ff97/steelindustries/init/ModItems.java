package com.j3ff97.steelindustries.init;

import com.j3ff97.steelindustries.item.IngotSteel;
import com.j3ff97.steelindustries.item.ItemSI;
import com.j3ff97.steelindustries.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
    public static ItemSI ingotSteel;

    public static void init()
    {
        ingotSteel = new IngotSteel();

        GameRegistry.registerItem(ingotSteel, Names.Items.ingotSteelName);
    }
}
