package com.j3ff97.steelindustries.block;

import com.j3ff97.steelindustries.block.base.BlockSI;
import com.j3ff97.steelindustries.block.base.BlockSIMulti;
import net.minecraft.block.material.Material;

public class BlockTitanium extends BlockSIMulti
{
    public BlockTitanium(String name, Material material, String toolClass, int harvestLevel)
    {
        super(name, material, toolClass, harvestLevel);
        this.setHardness(5F);
        this.setResistance(30F);
        this.setStepSound(BlockSI.soundTypeMetal);
    }
}
