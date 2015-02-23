package com.j3ff97.steelindustries.block;

import com.j3ff97.steelindustries.block.base.BlockSI;
import com.j3ff97.steelindustries.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class OreGraphite extends BlockSI
{
    public OreGraphite(String name, Material material, String toolClass, int harvestLevel)
    {
        super(name, material, toolClass, harvestLevel);
        this.setHardness(3F);
        this.setResistance(15F);
        this.setStepSound(BlockSI.soundTypeStone);

    }

    @Override
    public Item getItemDropped(int par1, Random random, int par2)
    {
        return ModItems.chunkGraphite;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 1;
    }
}
