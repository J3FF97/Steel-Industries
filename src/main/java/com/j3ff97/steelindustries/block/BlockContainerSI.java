package com.j3ff97.steelindustries.block;

import com.j3ff97.steelindustries.creativetab.CreativeTab;
import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public abstract class BlockContainerSI extends Block implements ITileEntityProvider
{
    private IIcon[] icons = new IIcon[3];

    public BlockContainerSI(String name, Material material, float hardness, float resistance, SoundType stepSound, String toolClass, int harvestLevel)
    {
        super(material);
        this.setBlockName(name);
        this.setBlockTextureName(Reference.ID + ":" + name);
        this.setHarvestLevel(toolClass, harvestLevel);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setStepSound(stepSound);
        this.setCreativeTab(CreativeTab.tabSIBlocks);
        this.isBlockContainer = true;
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        super.breakBlock(world, x, y, z, block, meta);
        world.removeTileEntity(x,y,z);
    }

    public boolean onBlockEventReceived(World world, int x, int y, int z, int id, int param)
    {
        super.onBlockEventReceived(world,x,y,z,id,param);
        TileEntity entity = world.getTileEntity(x,y,z);
        return entity != null && entity.receiveClientEvent(id,param);
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
