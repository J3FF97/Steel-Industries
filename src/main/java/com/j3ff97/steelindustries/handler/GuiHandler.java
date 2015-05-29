package com.j3ff97.steelindustries.handler;

import com.j3ff97.steelindustries.client.gui.inventory.GuiHighOven;
import com.j3ff97.steelindustries.inventory.ContainerHighOven;
import com.j3ff97.steelindustries.reference.GUI;
import com.j3ff97.steelindustries.tileentity.TileEntityHighOven;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == GUI.HIGHOVEN.ordinal() && world.getTileEntity(x,y,z) instanceof TileEntityHighOven)
        {
            TileEntityHighOven entityHighOven = (TileEntityHighOven) world.getTileEntity(x,y,z);
            return new ContainerHighOven(player.inventory, entityHighOven);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == GUI.HIGHOVEN.ordinal() && world.getTileEntity(x,y,z) instanceof TileEntityHighOven)
        {
            TileEntityHighOven entityHighOven = (TileEntityHighOven) world.getTileEntity(x,y,z);
            return new GuiHighOven(player.inventory, entityHighOven);
        }

        return null;
    }
}
