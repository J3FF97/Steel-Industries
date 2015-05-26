package com.j3ff97.steelindustries.creativetab;

import com.j3ff97.steelindustries.init.ModBlocks;
import com.j3ff97.steelindustries.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab
{

    public static final CreativeTabs tabSIItems = new CreativeTabs("tabSIItems")
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.ingotSteel;
        }

    };

    public static final CreativeTabs tabSIBlocks = new CreativeTabs("tabSIBlocks")
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(ModBlocks.blockSteel);
        }
    };
}
