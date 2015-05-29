package com.j3ff97.steelindustries.reference;

import com.j3ff97.steelindustries.utility.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public class Textures
{
    public static final String RESOURCE_PREFIX = Reference.ID.toLowerCase() + ":";

    public static final class Armor
    {
        private static final String ARMOR_SHEET_LOCATION = "textures/armor/";
    }

    public static final class Blocks
    {
        private static final String BLOCK_TEXTURE_LOCATION = "textures/blocks/";

    }

    public static final class GUI
    {
        public static final String           GUI_TEXTURE_LOCATION = "textures/gui/";
        public static final    ResourceLocation HIGHOVEN             = ResourceLocationHelper.getResourceLocation(GUI_TEXTURE_LOCATION + "highOven.png");
    }
}
