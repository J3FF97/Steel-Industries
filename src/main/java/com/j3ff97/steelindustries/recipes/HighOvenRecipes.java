package com.j3ff97.steelindustries.recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HighOvenRecipes
{
    private static final HighOvenRecipes ovenRecipes = new HighOvenRecipes();

    private static ItemStack[][][] smeltList = new ItemStack[64][64][64];
    private static Map             expList   = new HashMap();

    public static HighOvenRecipes instance()
    {
        return ovenRecipes;
    }

    public static void addSmelting(Item i1, Item i2, ItemStack output)
    {
        ItemStack input1 = new ItemStack(i1);
        ItemStack input2 = new ItemStack(i2);

        for(int i = 0; i < smeltList.length; i++)
        {
            if(smeltList[i][0][0] == null || smeltList[i][0][0] == output)
            {
                smeltList[i][0][0] = output;
                for(int j = 0; j < smeltList.length; j++)
                {
                    if(smeltList[i][j][0] == null)
                    {
                        smeltList[i][j][0] = input1;
                        for(int k = 0; k < smeltList.length; k++)
                        {
                            if(smeltList[i][j][k] == null)
                            {
                                smeltList[i][j][k] = input2;
                                //  expList.put(output,exp);
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }

    public void addSmelting(String input, Item i1, int meta, ItemStack output, float exp)
    {
        List<ItemStack> inputs = OreDictionary.getOres(input);
        ItemStack input2 = new ItemStack(i1, 1, meta);

        for(int i = 0; i < smeltList.length; i++)
        {
            if(smeltList[i][0][0] == null || smeltList[i][0][0] == output)
            {
                smeltList[i][0][0] = output;
                for(int j = 0; j < inputs.size(); j++)
                {
                    if(smeltList[i][j + 1][0] == null)
                    {
                        smeltList[i][j + 1][0] = inputs.get(j);
                        for(int k = 0; k < smeltList.length; k++)
                        {
                            if(smeltList[i][j + 1][k + 1] == null)
                            {
                                smeltList[i][j + 1][k + 1] = input2;
                                expList.put(output, exp);
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }
    }

    public void addSmelting(String input, String input2, ItemStack output, float exp)
    {

        List<ItemStack> inputs = OreDictionary.getOres(input);
        List<ItemStack> inputs2 = OreDictionary.getOres(input2);

        for(int i = 0; i < smeltList.length; i++)
        {
            if(smeltList[i][0][0] == null || smeltList[i][0][0] == output)
            {
                smeltList[i][0][0] = output;
                for(int j = 0; j < inputs.size(); j++)
                {
                    if(smeltList[i][j + 1][0] == null)
                    {
                        smeltList[i][j + 1][0] = inputs.get(j);
                        for(int k = 0; k < inputs2.size(); k++)
                        {
                            if(smeltList[i][j + 1][k + 1] == null)
                            {
                                smeltList[i][j + 1][k + 1] = inputs2.get(k);
                                expList.put(output, exp);
                            }
                        }
                    }
                }
                break;
            }
        }
    }

    public ItemStack getSmeltingResult(Item i1, Item i2)
    {

        for(int i = 0; i < smeltList.length; i++)
        {
            for(int j = 1; j < smeltList.length; j++)
            {
                if(smeltList[i][j][0] != null)
                {
                    if(smeltList[i][j][0].getItem() == i1)
                    {
                        for(int k = 1; k < smeltList.length; k++)
                        {
                            if(smeltList[i][j][k] != null)
                            {
                                if(smeltList[i][j][k].getItem() == i2)
                                {
                                    return smeltList[i][0][0];
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean hasSmeltingResult(Item item, int meta)
    {
        for(int i = 0; i < smeltList.length; i++)
        {
            for(int j = 0; j < smeltList.length - 1; j++)
            {
                if(smeltList[i][j + 1][0] != null)
                {

                    if(smeltList[i][j + 1][0].getItem() == item && (smeltList[i][j + 1][0].getItemDamage() == meta))
                    {
                        return true;
                    }

                    for(int k = 0; k < smeltList.length - 1; k++)
                    {
                        if(smeltList[i][j + 1][k + 1] != null)
                        {
                            if(smeltList[i][j + 1][k + 1].getItem() == item && (smeltList[i][j + 1][k + 1].getItemDamage() == meta))
                            {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public float getSmeltingExperience(ItemStack stack)
    {
        Iterator iterator = expList.entrySet().iterator();
        Map.Entry entry;
        do
        {
            if(!iterator.hasNext())
            {
                return 0F;
            }
            entry = (Map.Entry) iterator.next();
        }
        while(!this.compareItemStacks(stack, (ItemStack) entry.getKey()));

        return (Float) entry.getValue();
    }
}
