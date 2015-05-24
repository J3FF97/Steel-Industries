package com.j3ff97.steelindustries.utility;

import com.j3ff97.steelindustries.reference.Reference;
import net.minecraft.util.ResourceLocation;

public class ResourceLocationHelper
{
    public static ResourceLocation getResourceLocation(String modId, String path)
    {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String path)
    {
        return getResourceLocation(Reference.ID.toLowerCase(), path);
    }
}
