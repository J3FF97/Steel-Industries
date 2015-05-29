package com.j3ff97.steelindustries.compat.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import com.j3ff97.steelindustries.init.ModBlocks;
import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.item.ItemStack;

public class NEIConfig implements IConfigureNEI
{
    @Override
    public void loadConfig()
    {
        API.registerRecipeHandler(new NEICokeOvenHandler());
        API.registerUsageHandler(new NEICokeOvenHandler());

        API.hideItem(new ItemStack(ModBlocks.highOven_lit));
    }

    @Override
    public String getName()
    {
        return Reference.NAME;
    }

    @Override
    public String getVersion()
    {
        return Reference.VERSION;
    }
}
