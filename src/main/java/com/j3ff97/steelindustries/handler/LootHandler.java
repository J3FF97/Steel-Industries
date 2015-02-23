package com.j3ff97.steelindustries.handler;

import com.j3ff97.steelindustries.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class LootHandler
{
    public static void init()
    {
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.itemIronCompound), 1, 3, 20));
    }
}
