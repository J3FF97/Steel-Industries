package com.j3ff97.steelindustries.init;

import com.j3ff97.steelindustries.reference.Names;
import com.j3ff97.steelindustries.tileentity.TileEntityHighOven;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntities
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileEntityHighOven.class, Names.TileEntities.blockHighOvenName);
    }
}
