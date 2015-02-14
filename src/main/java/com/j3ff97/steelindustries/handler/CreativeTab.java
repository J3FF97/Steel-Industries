package com.j3ff97.steelindustries.handler;

import com.j3ff97.steelindustries.init.ModItems;
import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab
{
    public static final CreativeTabs SI_TAB = new CreativeTabs(Reference.ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.ingotSteel;
        }
    };
}
