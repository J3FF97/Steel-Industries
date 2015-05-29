package com.j3ff97.steelindustries.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class HighOvenRecipes
{
    private static HighOvenRecipes ovenRecipes = null;

    private static ItemStack[][][] smeltList = new ItemStack[64][64][64];

    private HighOvenRecipes()
    {

    }

    public static HighOvenRecipes getInstance()
    {
        if(ovenRecipes == null)
        {
            ovenRecipes = new HighOvenRecipes();
        }

        return ovenRecipes;
    }

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

    public void addSmelting(String input, Item i1, int meta, ItemStack output)
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
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }
    }

    public void addSmelting(String input, String input2, ItemStack output)
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
                    if(smeltList[i][j][0].getItem() == i1 )
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
}

