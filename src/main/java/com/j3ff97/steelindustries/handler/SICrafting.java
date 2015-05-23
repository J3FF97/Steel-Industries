package com.j3ff97.steelindustries.handler;

import com.j3ff97.steelindustries.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class SICrafting
{

   public static class HighOven
    {
        private static final HighOven smeltingBase = new HighOven();

        private Map smeltingList = new HashMap();
        private Map experienceList = new HashMap();

        public static HighOven instance()
        {
            return smeltingBase;
        }

        private HighOven()
        {
            this.addSmelting(ModItems.itemIronCompound, new ItemStack(ModItems.ingotSteel), 0.8F);
        }

        public void addSmeltingRecipeForBlock(Block input, ItemStack stack, float exp)
        {
            this.addSmelting(Item.getItemFromBlock(input), stack, exp);
        }

        public void addSmelting(Item input, ItemStack output, float exp)
        {
            this.addSmeltingRecipe(new ItemStack(input, 1, 32767), output, exp);
        }

        public void addSmeltingRecipe(ItemStack input, ItemStack stack, float exp)
        {
            this.smeltingList.put(input, stack);
            this.experienceList.put(stack, exp);
        }


        public ItemStack getSmeltingResult(ItemStack stack)
        {
            Iterator iterator = this.smeltingList.entrySet().iterator();

            Entry entry;

            do
            {
                if(!iterator.hasNext())
                {
                    return null;
                }
                entry = (Entry) iterator.next();


            }
            while (!this.compareItemStacks(stack, (ItemStack) entry.getKey()));
            return (ItemStack) entry.getValue();
        }

        private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
        {
            return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
        }

        public Map getSmeltingList()
        {
            return this.smeltingList;
        }



        public float getSmeltingExperience(ItemStack stack)
        {
            Iterator iterator = this.experienceList.entrySet().iterator();
            Entry entry;
            do
            {
                if(!iterator.hasNext())
                {
                    return 0F;
                }
                entry = (Entry) iterator.next();
            }
            while (!this.compareItemStacks(stack, (ItemStack) entry.getKey()));

            return (Float) entry.getValue();
        }


    }
}
