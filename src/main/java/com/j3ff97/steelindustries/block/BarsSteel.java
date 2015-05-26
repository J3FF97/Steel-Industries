package com.j3ff97.steelindustries.block;

import com.j3ff97.steelindustries.creativetab.CreativeTab;
import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

public class BarsSteel extends BlockPane
{
    public BarsSteel(String name, String texture, String icon, Material material, boolean canDrop, String toolClass, int harvestLevel, float hardness, float resistance, SoundType stepSound)
    {
        super(texture, icon, material, canDrop);
        this.setBlockName(name);
        this.setCreativeTab(CreativeTab.tabSIBlocks);
        this.setHarvestLevel(toolClass, harvestLevel);
        this.setStepSound(stepSound);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
