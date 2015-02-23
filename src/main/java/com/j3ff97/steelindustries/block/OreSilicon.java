package com.j3ff97.steelindustries.block;

import com.j3ff97.steelindustries.block.base.BlockSIFalling;
import com.j3ff97.steelindustries.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class OreSilicon extends BlockSIFalling
{
    public OreSilicon(String name, Material material, String toolClass, int harvestLevel)
    {
        super(name, material, toolClass, harvestLevel);
        this.setStepSound(Block.soundTypeSand);
        this.setHardness(1F);
        this.setResistance(5F);
    }

    @Override
    public Item getItemDropped(int par1, Random random, int par2)
    {
        return ModItems.rawSilicon;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(3);
    }
}
