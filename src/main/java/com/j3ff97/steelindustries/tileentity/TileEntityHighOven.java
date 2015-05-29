package com.j3ff97.steelindustries.tileentity;

import com.j3ff97.steelindustries.block.BlockHighOven;
import com.j3ff97.steelindustries.recipe.HighOvenRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityHighOven extends TileEntity implements ISidedInventory
{
    public int dualPower;
    public int dualCookTime;

    public static final int maxPower  = 25001;
    public static final int cookSpeed = 300;

    private static final int[] slots_top    = new int[]{0, 1};
    private static final int[] slots_bottom = new int[]{2, 3};
    private static final int[] slots_side   = new int[]{0, 1, 2};


    private ItemStack slots[];

    private String ovenCustomName;


    public TileEntityHighOven()
    {
        slots = new ItemStack[4];
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        NBTTagList list = compound.getTagList("Items", 10);
        slots = new ItemStack[getSizeInventory()];

        for(int i = 0; i < list.tagCount(); i++)
        {
            NBTTagCompound compound1 = list.getCompoundTagAt(i);
            byte b0 = compound1.getByte("Slot");

            if(b0 >= 0 && b0 < slots.length)
            {
                slots[b0] = ItemStack.loadItemStackFromNBT(compound1);
            }
        }

        dualPower = compound.getShort("PowerTime");
        dualCookTime = compound.getShort("CookTime");
    }

    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setShort("PowerTime", (short) dualPower);
        compound.setShort("CookTime", (short) dualCookTime);
        NBTTagList list = new NBTTagList();

        for(int i = 0; i < slots.length; i++)
        {
            if(slots[i] != null)
            {
                NBTTagCompound compound1 = new NBTTagCompound();
                compound1.setByte("Slot", (byte) i);
                slots[i].writeToNBT(compound1);
                list.appendTag(compound1);
            }
        }

        compound.setTag("Items", list);
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        if(side == ForgeDirection.DOWN.ordinal())
        {
            return slots_bottom;
        }
        else if(side == ForgeDirection.UP.ordinal())
        {
            return slots_top;
        }
        else
        {
            return slots_side;
        }

    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, int side)
    {
        return isItemValidForSlot(index, stack);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, int side)
    {
        return index == 3 ;
    }

    @Override
    public int getSizeInventory()
    {
        return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int index)
    {
        return slots[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        if(slots[index] != null)
        {
            if(slots[index].stackSize <= count)
            {
                ItemStack stack = slots[index];
                slots[index] = null;
                return stack;
            }

            ItemStack stack1 = slots[index].splitStack(count);

            if(slots[index].stackSize == 0)
            {
                slots[index] = null;
            }

            return stack1;
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index)
    {
        return getStackInSlot(index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        slots[index] = stack;
        if(stack != null && stack.stackSize > getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.ovenCustomName : "container.highOven";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return this.ovenCustomName != null && this.ovenCustomName.length() > 0;
    }

    public void setCustomInventoryName(String name)
    {
        this.ovenCustomName = name;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64;
    }

    @Override
    public void openInventory()
    {
//empty
    }

    @Override
    public void closeInventory()
    {
//empty
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if(index == 2)
        {
            return hasItemPower(stack);
        }
        else return index != 3;
    }

    public boolean hasItemPower(ItemStack stack)
    {
        return getItemPower(stack) > 0;
    }

    public static int getItemPower(ItemStack stack)
    {
        if(stack == null)
        {
            return 0;
        }
        else if (TileEntityFurnace.isItemFuel(stack))
        {
            return TileEntityFurnace.getItemBurnTime(stack);
        }
        else
        {
            return 0;
        }
    }

    public int getOvenProgressScaled(int i)
    {
        return (dualCookTime * i) / cookSpeed;
    }

    public int getPowerRemainingScaled(int i)
    {
        return (dualPower * i) / maxPower;
    }

    public boolean hasPower()
    {
        return dualPower > 0;
    }

    public boolean isCooking()
    {
        return this.dualCookTime > 0;
    }

    private boolean canCook()
    {
        if(slots[0] == null || slots[1] == null)
        {
            return false;
        }
        else
        {
            ItemStack stack = HighOvenRecipes.instance().getSmeltingResult(slots[0].getItem(), slots[1].getItem());
            if(stack == null) return false;
            if(slots[3] == null) return true;
            if(!slots[3].isItemEqual(stack)) return false;
            int result = slots[3].stackSize + stack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.slots[3].getMaxStackSize();
        }
    }

    private void cookItem()
    {
        if(canCook())
        {
            ItemStack stack = HighOvenRecipes.instance().getSmeltingResult(slots[0].getItem(), slots[1].getItem());

            if(slots[3] == null)
            {
                slots[3] = stack.copy();
            }
            else if(slots[3].isItemEqual(stack))
            {
                slots[3].stackSize += stack.stackSize;
            }

            for(int i = 0; i < 2; i++)
            {
                --slots[i].stackSize;

                if(slots[i].stackSize <= 0)
                {
                    slots[i] = null;
                }
            }
        }

    }

    public void updateEntity()
    {
        boolean flag = this.hasPower();
        boolean flag1 = false;

        if(hasPower() && this.isCooking())
        {
            this.dualPower--;
        }

        if(!worldObj.isRemote)
        {
            if(this.hasItemPower(this.slots[2]) && this.dualPower < (maxPower - getItemPower(this.slots[2])))
            {
                this.dualPower += getItemPower(this.slots[2]);

                if(this.slots[2] != null)
                {
                    flag1 = true;

                    --this.slots[2].stackSize;

                    if(this.slots[2].stackSize == 0)
                    {
                        this.slots[2] = this.slots[2].getItem().getContainerItem(this.slots[2]);
                    }
                }
            }

            if(hasPower() && canCook())
            {
                ++dualCookTime;

                if(this.dualCookTime == cookSpeed)
                {
                    this.dualCookTime = 0;
                    this.cookItem();
                    flag1 = true;
                }
            }

            else
            {
                this.dualCookTime = 0;
            }

            if(flag != this.hasPower())
            {
                flag1 = true;
                BlockHighOven.updateBlockState(this.isCooking(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }

            if(this.isCooking())
            {
                BlockHighOven.updateBlockState(true, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
            else
            {
                BlockHighOven.updateBlockState(false, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }

        }

        if(flag1)
        {
            this.markDirty();
        }
    }
}