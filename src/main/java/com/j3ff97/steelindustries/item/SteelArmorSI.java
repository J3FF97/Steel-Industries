package com.j3ff97.steelindustries.item;

import com.j3ff97.steelindustries.creativetab.CreativeTab;
import com.j3ff97.steelindustries.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class SteelArmorSI extends ItemArmor
{
    public String textureName;

    public SteelArmorSI(String name, ArmorMaterial material, String textureName, int type)
    {
        super(material, 0, type);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTab.tabSIItems);
        this.textureName = textureName;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return Reference.ID + ":textures/models/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
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

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
