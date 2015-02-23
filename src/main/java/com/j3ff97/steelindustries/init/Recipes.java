package com.j3ff97.steelindustries.init;


import com.j3ff97.steelindustries.handler.ConfigurationHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes
{
    public static void initCrafting()
    {
        initCraftingRecipes();
        initShapelessRecipes();
        initSmeltingRecipes();
    }

    public static void initCraftingRecipes()
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.saddle), "XXX", "Y Y", "Z Z", 'X', Items.leather, 'Y', Items.string, 'Z', "ingotIron"));

        GameRegistry.addRecipe(new ItemStack(Items.chainmail_boots), "X X", "X X", 'X', ModItems.itemSteelMesh);

        GameRegistry.addRecipe(new ItemStack(Items.chainmail_chestplate), "X X", "XXX", "XXX", 'X', ModItems.itemSteelMesh);

        GameRegistry.addRecipe(new ItemStack(Items.chainmail_helmet), "XXX", "X X", 'X', ModItems.itemSteelMesh);

        GameRegistry.addRecipe(new ItemStack(Items.chainmail_leggings), "XXX", "X X", "X X", 'X', ModItems.itemSteelMesh);

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockSteel, 1), "XXX", "XXX", "XXX", 'X', "ingotSteel"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.ingotSteel), "XXX", "XXX", "XXX", 'X', "nuggetSteel"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.ingotTitanium), "XXX", "XXX", "XXX", 'X', "nuggetTitanium"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockTitanium, 1), "XXX", "XXX", "XXX", 'X', "ingotTitanium"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemSteelMesh, 4), " Y ", "YXY", " Y ", 'X', "ingotSteel", 'Y', ModBlocks.steelBars));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.steelBars, 16), "XXX", "XXX", 'X', "ingotSteel"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.torch, 6), " X ", " Y ", 'X', ModItems.chunkGraphite, 'Y', "stickWood"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemIronCompound), "XXX", "XYX", "XXX", 'X', Items.coal, 'Y', "ingotIron"));

    }

    public static void initShapelessRecipes()
    {
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.nuggetSteel, 9), "ingotSteel"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.ingotSteel, 9), "blockSteel"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.nuggetTitanium, 9), "ingotTitanium"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.ingotTitanium, 9), "blockTitanium"));

        if(ConfigurationHandler.flintAndSteel)
        {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.flint_and_steel), "ingotSteel", new ItemStack(Items.flint)));
        }
    }

    public static void initSmeltingRecipes()
    {
        GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather), 0.2F);
        GameRegistry.addSmelting(ModItems.rawSilicon, new ItemStack(ModItems.refinedSilicon), 0.5F);
        GameRegistry.addSmelting(ModBlocks.oreRutile, new ItemStack(ModItems.ingotTitanium), 1.0F);
        GameRegistry.addSmelting(ModBlocks.oreGraphite, new ItemStack(ModItems.chunkGraphite), 0.5F);
        GameRegistry.addSmelting(ModItems.itemIronCompound, new ItemStack(ModItems.ingotSteel), 0.8F);
        GameRegistry.addSmelting(ModBlocks.oreSilicon, new ItemStack(ModItems.rawSilicon), 0.5F);
    }
}
