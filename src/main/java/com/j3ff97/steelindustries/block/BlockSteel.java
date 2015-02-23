package com.j3ff97.steelindustries.block;

import com.j3ff97.steelindustries.block.base.BlockSI;
import com.j3ff97.steelindustries.block.base.BlockSIMulti;
import net.minecraft.block.material.Material;

public class BlockSteel extends BlockSIMulti
{
    public BlockSteel(String name, Material material, String toolClass,  int harvestLevel)
    {
        super(name,material, toolClass, harvestLevel);
        this.setHardness(5F);
        this.setResistance(30F);
        this.setStepSound(BlockSI.soundTypeMetal);

    }
}
