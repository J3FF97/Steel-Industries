package com.j3ff97.steelindustries.inventory.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class SlotMachineFluid extends Slot
{
    boolean empty;
    public SlotMachineFluid(IInventory inv, int x, int y, int z, boolean empty)
    {
        super(inv, x, y, z);
        this.empty = empty;
    }

    public boolean isItemValid(ItemStack stack)
    {
        if(empty)
        {
            return FluidContainerRegistry.isEmptyContainer(stack);
        }
        else
        {
            return FluidContainerRegistry.isFilledContainer(stack);
        }
    }
}
