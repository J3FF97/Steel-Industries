package com.j3ff97.steelindustries.block;

import com.j3ff97.steelindustries.creativetab.CreativeTab;
import com.j3ff97.steelindustries.init.ModItems;
import com.j3ff97.steelindustries.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import java.util.Random;

public class OreSilicon extends BlockFalling
{
    public OreSilicon(String name, Material material, String toolClass, int harvestLevel, float hardness, float resistance, SoundType stepSound)
    {
        super(material);
        this.setBlockName(name);
        this.setBlockTextureName(Reference.ID + ":" + name);
        this.setHarvestLevel(toolClass, harvestLevel);
        this.setCreativeTab(CreativeTab.tabSIBlocks);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setStepSound(stepSound);
    }

    @Override
    public Item getItemDropped(int par1, Random random, int par2)
    {
        return ModItems.rawSilicon;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(3);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
