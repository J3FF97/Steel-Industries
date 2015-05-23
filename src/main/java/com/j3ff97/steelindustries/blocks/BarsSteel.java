package com.j3ff97.steelindustries.blocks;

import com.j3ff97.steelindustries.handler.CreativeTab;
import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

public class BarsSteel extends BlockPane
{

    public BarsSteel(String name, Material material, boolean canDrop, float hardness, float resistance, SoundType stepSound,  String toolClass, int harvestLevel)
    {
        super(material, canDrop);
        this.setUnlocalizedName(name);
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
