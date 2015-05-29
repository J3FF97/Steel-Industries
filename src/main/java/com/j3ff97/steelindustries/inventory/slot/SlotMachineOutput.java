package com.j3ff97.steelindustries.inventory.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMachineOutput extends Slot
{
    public SlotMachineOutput(IInventory inventory, int index, int x, int y)
    {
        super(inventory, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return false;
    }
}