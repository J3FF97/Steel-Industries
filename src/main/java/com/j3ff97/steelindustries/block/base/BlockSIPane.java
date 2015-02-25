package com.j3ff97.steelindustries.block.base;

import com.j3ff97.steelindustries.handler.CreativeTab;
import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

public class BlockSIPane extends BlockPane
{
    public BlockSIPane(String name, String texture, String icon, Material material, boolean par4bool, String toolClass, int harvestLevel)
    {
        super(texture, icon, material, par4bool);
        this.setBlockName(name);
        this.setCreativeTab(CreativeTab.tabSIBlocks);
        this.setHarvestLevel(toolClass, harvestLevel);
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
