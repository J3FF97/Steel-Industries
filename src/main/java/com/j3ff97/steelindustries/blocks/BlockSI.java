package com.j3ff97.steelindustries.blocks;

import com.j3ff97.steelindustries.handler.CreativeTab;
import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSI extends Block
{
    public BlockSI(String name, Material material, float hardness, float resistance, SoundType stepSound,  String toolClass, int harvestLevel)
    {
        super(material);
        this.setUnlocalizedName(name);
        this.setHarvestLevel(toolClass, harvestLevel);
        this.setCreativeTab(CreativeTab.tabSIBlocks);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setStepSound(stepSound);
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
