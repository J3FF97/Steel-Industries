package com.j3ff97.steelindustries.compat.waila;

import com.j3ff97.steelindustries.reference.Names;
import com.j3ff97.steelindustries.tileentity.TileEntityHighOven;
import mcp.mobius.waila.api.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class WailaDataProvider implements IWailaDataProvider
{

    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
       return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        if(accessor.getTileEntity() instanceof TileEntityHighOven)
        {
            currenttip.set(0, String.format("%s%s", SpecialChars.WHITE, StatCollector.translateToLocal(Names.TileEntities.blockHighOvenName)));
        }
        return currenttip;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return currenttip;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return currenttip;
    }

    @Override
    public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z)
    {
        return null;
    }

    public static void callBackRegister(IWailaRegistrar registrar)
    {
        registrar.registerHeadProvider(new WailaDataProvider(), TileEntityHighOven.class);
    }
}
