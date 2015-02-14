package com.j3ff97.steelindustries.block;


import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.block.material.Material;

public class BlockSteel extends BlockSIMulti
{
    public BlockSteel(String name, Material material, int harvestLevel)
    {
        super(material);
        this.setBlockName(name);
        this.setBlockTextureName(Reference.ID + ":" + name);
        this.setHardness(5F);
        this.setResistance(30F);
        this.setStepSound(BlockSI.soundTypeMetal);
        this.setHarvestLevel("pickaxe", harvestLevel);

    }
}
