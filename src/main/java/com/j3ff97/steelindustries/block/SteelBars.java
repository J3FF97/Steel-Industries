package com.j3ff97.steelindustries.block;

import com.j3ff97.steelindustries.block.base.BlockSIPane;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SteelBars extends BlockSIPane
{
    public SteelBars(String name, String texture, String icon, Material material, boolean par4bool, String toolClass, int harvestLevel)
    {
        super(name, texture, icon, material, par4bool, toolClass, harvestLevel);
        this.setStepSound(Block.soundTypeMetal);
        this.setHardness(5F);
        this.setResistance(30F);
    }
}
