package com.j3ff97.steelindustries.compat.thaumcraft;

import com.j3ff97.steelindustries.init.ModBlocks;
import com.j3ff97.steelindustries.init.ModItems;
import com.j3ff97.steelindustries.reference.Names;
import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.api.wands.WandCap;

import java.util.HashMap;

public class ResearchHandler
{
    public static HashMap<String, Object> recipe = new HashMap();

    public static WandCap WAND_CAP_STEEL;
    public static WandCap WAND_CAP_TITANIUM;

    public static void init()
    {
        initTCItems();
        initCategories();
        initResearch();
        addAspectToItem();
    }

    public static void initTCItems()
    {
        WAND_CAP_STEEL = new WandCap(Names.Addons.steelTag, 1.0F, new ItemStack(ModItems.wandCapSteel), 2);
        WAND_CAP_TITANIUM = new WandCap(Names.Addons.titaniumTag, 0.95F, new ItemStack(ModItems.wandCapTitanium), 3);
    }

    public static void initCategories()
    {
        ResearchCategories.registerCategory(Reference.RESEARCH_KEY, new ResourceLocation("steelindustries", "textures/items/wandCapSteel.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png"));
    }

    public static void initResearch()
    {
        new ResearchItem("CAP_steel", Reference.RESEARCH_KEY, new AspectList().add(Aspect.METAL, 3).add(Aspect.ARMOR, 5).add(Aspect.TOOL, 3), 1, 1, 1, new ResourceLocation(Reference.ID + ":textures/items/wandCapSteel.png")).setPages(new ResearchPage(Names.Text.CAP_steel), new ResearchPage((IArcaneRecipe) recipe.get("CAP_steel"))).setParents("BASICTHAUMATURGY").registerResearchItem();

        new ResearchItem("CAP_titanium", Reference.RESEARCH_KEY, new AspectList().add(Aspect.METAL, 3).add(Aspect.ARMOR, 5).add(Aspect.TOOL, 3), 1, 2, 1, new ResourceLocation(Reference.ID + ":textures/items/wandCapTitanium.png")).setPages(new ResearchPage(Names.Text.CAP_titanium), new ResearchPage((IArcaneRecipe) recipe.get("CAP_titanium"))).setParents("BASICTHAUMATURGY").registerResearchItem();

        new ResearchItem("steel_transmutation", Reference.RESEARCH_KEY, new AspectList().add(Aspect.METAL, 4).add(Aspect.ARMOR, 1), 3, 0, 1, new ResourceLocation(Reference.ID + ":textures/items/nuggetSteel.png")).setPages(new ResearchPage(Names.Text.steel_transmutation), new ResearchPage((CrucibleRecipe) recipe.get("steel_transmutation"))).setConcealed().setParents("CAP_steel").registerResearchItem();

        new ResearchItem("titanium_transmutation", Reference.RESEARCH_KEY, new AspectList().add(Aspect.METAL, 4).add(Aspect.ARMOR, 1), 3, 3, 1, new ResourceLocation(Reference.ID + ":textures/items/nuggetTitanium.png")).setPages(new ResearchPage(Names.Text.titanium_transmutation), new ResearchPage((CrucibleRecipe) recipe.get("titanium_transmutation"))).setConcealed().setParents("CAP_titanium").registerResearchItem();

    }

    public static void addAspectToItem()
    {
        ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.ingotSteel), (new AspectList()).add(Aspect.METAL, 5).add(Aspect.ARMOR, 2));
        ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.ingotTitanium), (new AspectList()).add(Aspect.METAL, 7).add(Aspect.ARMOR, 3));
        ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.nuggetSteel), (new AspectList()).add(Aspect.METAL, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.nuggetTitanium), (new AspectList()).add(Aspect.METAL, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.steelBars), (new AspectList()).add(Aspect.METAL, 2).add(Aspect.ARMOR, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.oreGraphite), (new AspectList()).add(Aspect.FIRE, 1).add(Aspect.EARTH, 1).add(Aspect.ENERGY, 4));
        ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.oreRutile), (new AspectList()).add(Aspect.METAL, 4).add(Aspect.EARTH, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.oreSilicon), (new AspectList()).add(Aspect.ENTROPY, 1).add(Aspect.EARTH, 1));
        ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.chunkGraphite), (new AspectList()).add(Aspect.FIRE, 4).add(Aspect.ENERGY, 4));
        ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.rawSilicon), (new AspectList()).add(Aspect.EARTH, 2).add(Aspect.SLIME, 1));


    }
}
