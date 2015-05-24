package com.j3ff97.steelindustries.reference;

import com.j3ff97.steelindustries.utility.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public final class Textures
{
    public static final String RESOURCE_PREFIX = Reference.ID.toLowerCase() + ":";

    public static final class Armor
    {
        private static final String ARMOR_SHEET_LOCATION = "textures/armor/";
    }

    public static final class GUI
    {
        protected static final String           GUI_TEXTURE_LOCATION = "textures/gui/";
        public static final    ResourceLocation HIGHOVEN             = ResourceLocationHelper.getResourceLocation(GUI_TEXTURE_LOCATION + "highOven.png");
    }
}
