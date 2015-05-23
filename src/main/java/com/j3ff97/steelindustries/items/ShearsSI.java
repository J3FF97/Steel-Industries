package com.j3ff97.steelindustries.items;

import com.j3ff97.steelindustries.handler.CreativeTab;
import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;

public class ShearsSI extends ItemShears
{
    public ShearsSI(int maxDamage, String name)
    {
        super();
        this.setMaxDamage(maxDamage);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTab.tabSIItems);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("Item.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        return String.format("item.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }


    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}