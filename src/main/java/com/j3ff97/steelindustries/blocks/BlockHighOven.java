package com.j3ff97.steelindustries.blocks;

import com.j3ff97.steelindustries.SteelIndustries;
import com.j3ff97.steelindustries.handler.CreativeTab;
import com.j3ff97.steelindustries.init.ModBlocks;
import com.j3ff97.steelindustries.reference.GuiIDs;
import com.j3ff97.steelindustries.tileentity.TileEntityHighOven;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
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

            if(tileentity instanceof TileEntityHighOven)
            {
                ((TileEntityHighOven) tileentity).setCustomInventoryName(stack.getDisplayName());
            }
        }
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {

        if(player.isSneaking())
        {
            return false;
        }
        else
        {
            if(!worldIn.isRemote)
            {
                if(worldIn.getTileEntity(pos) instanceof TileEntityHighOven)
                {
                    player.openGui(SteelIndustries.instance, GuiIDs.HIGHOVEN.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
                }
            }
            return true;
        }
    }

    public static void updateBlockState(boolean isCooking, World world, BlockPos pos)
    {
        IBlockState iblockstate = world.getBlockState(pos);
        TileEntity tileentity = world.getTileEntity(pos);
        keepInventory = true;

        if(isCooking)
        {
            //           world.setBlockState(pos, ModBlocks.highOven_lit.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            world.setBlockState(pos, ModBlocks.highOven_lit.getDefaultState(), 3);
        }
        else
        {
//            world.setBlockState(pos, ModBlocks.highOven.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            world.setBlockState(pos, ModBlocks.highOven.getDefaultState(), 3);
        }

        keepInventory = false;
        world.setBlockState(pos, iblockstate, 2);

        if(tileentity != null)
        {
            tileentity.validate();
            world.setTileEntity(pos, tileentity);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityHighOven();
    }

    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if(enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing) state.getValue(FACING)).getIndex();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, FACING);
    }
}
