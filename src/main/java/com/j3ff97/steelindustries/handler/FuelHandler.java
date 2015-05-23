package com.j3ff97.steelindustries.handler;

import com.j3ff97.steelindustries.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if(fuel.getItem() == ModItems.chunkGraphite)
        {
            return ConfigurationHandler.graphiteBurnTime;
        }
        return 0;
    }
}
