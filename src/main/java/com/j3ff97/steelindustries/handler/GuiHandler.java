package com.j3ff97.steelindustries.handler;

import com.j3ff97.steelindustries.client.gui.inventory.GuiHighOven;
import com.j3ff97.steelindustries.inventory.ContainerHighOven;
import com.j3ff97.steelindustries.reference.GuiIDs;
import com.j3ff97.steelindustries.tileentity.TileEntityHighOven;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{


    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);


        if(ID == GuiIDs.HIGHOVEN.ordinal() && world.getTileEntity(pos) instanceof TileEntityHighOven)
        {
            TileEntityHighOven entityHighOven = (TileEntityHighOven) world.getTileEntity(pos);
            return new ContainerHighOven(player.inventory, entityHighOven);
        }

        return null;

    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
        if(ID == GuiIDs.HIGHOVEN.ordinal() && world.getTileEntity(pos) instanceof TileEntityHighOven)
        {
            TileEntityHighOven entityHighOven = (TileEntityHighOven) world.getTileEntity(pos);
            return new GuiHighOven(player.inventory, entityHighOven);
        }

        return null;
    }
}
