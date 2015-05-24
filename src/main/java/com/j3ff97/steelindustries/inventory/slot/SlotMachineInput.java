package com.j3ff97.steelindustries.inventory.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMachineInput extends Slot
{

    IInventory iinventory;

    public SlotMachineInput(IInventory inventory, int slotNum, int x, int y)
    {
        super(inventory, slotNum, x, y);
        iinventory = inventory;
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return inventory.isItemValidForSlot(this.getSlotIndex(), stack);
    }
}
