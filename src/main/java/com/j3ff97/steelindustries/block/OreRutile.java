package com.j3ff97.steelindustries.block;

import com.j3ff97.steelindustries.block.base.BlockSI;
import net.minecraft.block.material.Material;

public class OreRutile extends BlockSI
{
    public OreRutile(String name, Material material, String toolClass, int harvestLevel)
    {
        super(name, material, toolClass, harvestLevel);
        this.setHardness(3F);
        this.setResistance(15F);
        this.setStepSound(BlockSI.soundTypeStone);
    }
}
