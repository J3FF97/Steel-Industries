package com.j3ff97.steelindustries.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerSI extends Container
{
    protected void bindPlayerInventory(InventoryPlayer invPlayer)
    {

        // Render inventory
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // Render hotbar
        for(int j = 0; j < 9; j++)
        {
            addSlotToContainer(new Slot(invPlayer, j, 8 + j * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }
}
