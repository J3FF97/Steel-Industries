package com.j3ff97.steelindustries.blocks;

import codechicken.lib.math.MathHelper;
import com.j3ff97.steelindustries.handler.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.Random;

public class BlockHighOven extends BlockContainerSI
{
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    private       Random  rand;
    private final boolean isActive;
    private static boolean keepInventory = false;

    public BlockHighOven(boolean state, String name, Material material, float hardness, float resistance, SoundType stepSound, String toolClass, int harvestLevel)
    {
        super(name, material, hardness, resistance, stepSound, toolClass, harvestLevel);
        this.isActive = state;
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        rand = new Random();

        if(!isActive)
        {
            this.setCreativeTab(CreativeTab.tabSIBlocks);
        }
    }

    @Override
    public int getRenderType()
    {
        return 3;
    }

    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(world, pos, state);
        this.setDefaultFacing(world, pos, state);
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            Block block = worldIn.getBlockState(pos.offsetNorth()).getBlock();
            Block block1 = worldIn.getBlockState(pos.offsetSouth()).getBlock();
            Block block2 = worldIn.getBlockState(pos.offsetWest()).getBlock();
            Block block3 = worldIn.getBlockState(pos.offsetEast()).getBlock();
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (block.isFullBlock() && !block1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (block1.isFullBlock() && !block.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (block2.isFullBlock() && !block3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (block3.isFullBlock() && !block2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }

    public void onBlockPlacedBy(World world, BlockPos pos,IBlockState state, EntityLivingBase player, ItemStack stack)
    {
        world.setBlockState(pos, state.withProperty(FACING, player.func_174811_aO().getOpposite()), 2);

        if (stack.hasDisplayName())
        {
            TileEntity tileentity = world.getTileEntity(pos);

            if (tileentity instanceof TileEntityFurnace)
            {
                ((TileEntityFurnace)tileentity).setCustomInventoryName(stack.getDisplayName());
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return null;
    }
}
