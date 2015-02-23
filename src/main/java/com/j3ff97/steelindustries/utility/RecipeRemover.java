package com.j3ff97.steelindustries.utility;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.Iterator;
import java.util.List;

public class RecipeRemover
{
    public static void removeRecipes(Item itemToRemove)
    {
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

        Iterator<IRecipe> remover = recipes.iterator();

        while(remover.hasNext())
        {
            ItemStack itemStack = remover.next().getRecipeOutput();
            if(itemStack != null && itemStack.getItem() == itemToRemove)
            {
                remover.remove();
            }
        }

    }
}
