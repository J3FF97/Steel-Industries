package com.j3ff97.steelindustries.blocks;

import com.j3ff97.steelindustries.handler.CreativeTab;
import com.j3ff97.steelindustries.init.ModItems;
import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class OreGraphite extends Block
{
    public OreGraphite(String name, Material material, float hardness, float resistance, SoundType stepSound,  String toolClass, int harvestLevel)
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

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune)
    {
        return ModItems.chunkGraphite;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 1;
    }
}
