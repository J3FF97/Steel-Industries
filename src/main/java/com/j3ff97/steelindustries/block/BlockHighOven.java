package com.j3ff97.steelindustries.block;


import codechicken.lib.math.MathHelper;
import com.j3ff97.steelindustries.SteelIndustries;
import com.j3ff97.steelindustries.init.ModBlocks;
import com.j3ff97.steelindustries.reference.GUI;
import com.j3ff97.steelindustries.reference.Reference;
import com.j3ff97.steelindustries.tileentity.TileEntityHighOven;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockHighOven extends BlockContainerSI
{
    private       Random  rand;
    private final boolean isActive;
    private static boolean keepInventory = false;

    @SideOnly(Side.CLIENT)
    private IIcon iconFront;


    public BlockHighOven(boolean state, String name, Material material, float hardness, float resistance, SoundType stepSound, String toolClass, int harvestLevel)
    {
        super(name, material, hardness, resistance, stepSound, toolClass, harvestLevel);
        this.isActive = state;
        rand = new Random();
        if(isActive)
        {
            this.setCreativeTab(null);
            this.setLightLevel(1F);
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon(Reference.ID.toLowerCase() + ":" + "highOven_side");
        this.iconFront = register.registerIcon(Reference.ID.toLowerCase() + ":" + (this.isActive ? "highOven_front_on" : "highOven_front_off"));
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
       return meta == 0 && side == 3 ? this.iconFront : (side == meta ? this.iconFront : this.blockIcon);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        if (!keepInventory)
        {
            TileEntityHighOven entityHighOven = (TileEntityHighOven)world.getTileEntity(x, y, z);

            if (entityHighOven != null)
            {
                for (int i1 = 0; i1 < entityHighOven.getSizeInventory(); ++i1)
                {
                    ItemStack itemstack = entityHighOven.getStackInSlot(i1);

                    if (itemstack != null)
                    {
                        float f = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int j1 = this.rand.nextInt(21) + 10;

                            if (j1 > itemstack.stackSize)
                            {
                                j1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j1;
                            EntityItem entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                world.func_147453_f(x, y, z, block);
            }
        }

        super.breakBlock(world, x, y, z, block, meta);
    }

    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x,y,z);
        this.setDefaultFacing(world, x, y, z);
    }

    private void setDefaultFacing(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
        int i = MathHelper.floor_double((double) (entity.rotationYaw * 4.0f / 360f) + 0.5D) & 3;

        if (i == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (i == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (i == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (i == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (stack.hasDisplayName())
        {
            ((TileEntityHighOven)world.getTileEntity(x, y, z)).setCustomInventoryName(stack.getDisplayName());
        }
    }

    public static void updateBlockState(boolean isCooking, World world, int x, int y, int z)
    {
        int i = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        keepInventory = true;

        if (isCooking)
        {
            world.setBlock(x, y, z, ModBlocks.highOven_lit);
        }
        else
        {
            world.setBlock(x, y, z, ModBlocks.highOven);
        }

        keepInventory = false;
        world.setBlockMetadataWithNotify(x, y, z, i, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz)
    {
        if(player.isSneaking())
        {
            return false;
        }
        else
        {
            if(!world.isRemote)
            {
                if(world.getTileEntity(x,y,z) instanceof TileEntityHighOven)
                {
                    player.openGui(SteelIndustries.instance, GUI.HIGHOVEN.ordinal(), world, x, y, z);
                }
            }
            return true;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityHighOven();
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (this.isActive)
        {
            int l = world.getBlockMetadata(x, y, z);
            float f = (float)x + 0.5F;
            float f1 = (float)y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)z + 0.5F;
            float f3 = 0.52F;
            float f4 = random.nextFloat() * 0.6F - 0.3F;

            if (l == 4)
            {
                world.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 5)
            {
                world.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 2)
            {
                world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 3)
            {
                world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }


}
