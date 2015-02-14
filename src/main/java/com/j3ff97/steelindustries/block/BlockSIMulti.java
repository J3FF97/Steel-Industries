package com.j3ff97.steelindustries.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockSIMulti extends BlockSI
{
    private IIcon[] icons = new IIcon[3];

    public BlockSIMulti(Material material)
    {
        super(material);
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
}
