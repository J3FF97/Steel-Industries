package com.j3ff97.steelindustries.item;

import com.google.common.collect.Sets;
import com.j3ff97.steelindustries.handler.CreativeTab;
import com.j3ff97.steelindustries.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

import java.util.Set;

public class SickleSI extends ItemTool
{
    @SuppressWarnings("rawtypes") private static final Set toolBlocks = Sets.newHashSet(Blocks.leaves, Blocks.leaves2, Blocks.wheat, Blocks.potatoes, Blocks.carrots, Blocks.nether_wart, Blocks.red_mushroom, Blocks.brown_mushroom, Blocks.reeds, Blocks.tallgrass, Blocks.vine, Blocks.waterlily, Blocks.red_flower, Blocks.yellow_flower);
    public                                             int cropRadius = 2;
    public                                             int leafRadius = 1;

    public SickleSI(ToolMaterial material, String name)
    {
        super(1.0F, material, toolBlocks);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTab.tabSIItems);

    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("Item.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        return String.format("item.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @SuppressWarnings("static-access")
    public float func_150893_a(ItemStack itemStack, Block block)
    {

        if((block.getMaterial() == Material.leaves) || (block.getMaterial() == Material.plants) || (block.getMaterial() == Material.grass) || this.toolBlocks.contains(block))
        {

            return this.efficiencyOnProperMaterial;
        }
        return 1.0F;
    }

    public boolean hitEntity(ItemStack itemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {

        itemStack.damageItem(2, par3EntityLivingBase);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLiving)
    {

        boolean used = false;

        if(!(entityLiving instanceof EntityPlayer)) return false;
        EntityPlayer player = (EntityPlayer) entityLiving;

        if((block != null) && (block.isLeaves(world, x, y, z)))
        {
            for(int i = -this.leafRadius; i <= this.leafRadius; i++)
            {
                for(int j = -this.leafRadius; j <= this.leafRadius; j++)
                {
                    for(int k = -this.leafRadius; k <= this.leafRadius; k++)
                    {
                        Block blockToCheck = world.getBlock(x + i, y + j, z + k);
                        int meta = world.getBlockMetadata(x + i, y + j, z + k);
                        if((blockToCheck != null) && (blockToCheck.isLeaves(world, x + i, y + j, z + k)))
                        {
                            if(blockToCheck.canHarvestBlock(player, meta))
                            {
                                blockToCheck.harvestBlock(world, player, x + i, y + j, z + k, meta);
                            }
                            world.setBlock(x + i, y + j, z + k, Blocks.air);
                            used = true;
                        }
                    }
                }
            }
            if(used)
            {
                itemStack.damageItem(1, entityLiving);
            }
            return used;
        }

        for(int i = -this.cropRadius; i <= this.cropRadius; i++)
            for(int j = -this.cropRadius; j <= this.cropRadius; j++)
            {
                Block blockToCheck = world.getBlock(x + i, y, z + j);
                int meta = world.getBlockMetadata(x + i, y, z + j);
                if(blockToCheck != null)
                {
                    if(blockToCheck instanceof BlockBush)
                    {
                        if(blockToCheck.canHarvestBlock(player, meta))
                        {
                            blockToCheck.harvestBlock(world, player, x + i, y, z + j, meta);
                        }
                        world.setBlock(x + i, y, z + j, Blocks.air);
                        used = true;
                    }
                }
            }
        if(used)
        {
            itemStack.damageItem(1, entityLiving);
        }
        return used;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }


}
