package com.j3ff97.steelindustries.block;

import com.j3ff97.steelindustries.creativetab.CreativeTab;
import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockSIMulti extends Block
{
    private IIcon[] icons = new IIcon[3];

    public BlockSIMulti(String name, Material material, String toolClass, int harvestLevel, float hardness, float resistance, SoundType stepSound)
    {
        super(material);
        this.setBlockName(name);
        this.setBlockTextureName(Reference.ID + ":" + name);
        this.setHarvestLevel(toolClass, harvestLevel);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setStepSound(stepSound);
        this.setCreativeTab(CreativeTab.tabSIBlocks);
    }

    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        for (int i = 0; i < icons.length; i ++)
        {
            this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
        }
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        switch(side)
        {
            case 0:
                return icons[0];
            case 1:
                return icons[1];
            case 2:
                return icons[2];
            default:
                return icons[2];
        }
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
