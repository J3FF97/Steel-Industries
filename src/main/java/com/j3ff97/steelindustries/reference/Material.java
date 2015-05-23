package com.j3ff97.steelindustries.reference;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Material
{
    public static ToolMaterial SteelTool    = EnumHelper.addToolMaterial("SteelTool", 2, 750, 7.0F, 3.0F, 5);
    public static ToolMaterial TitaniumTool = EnumHelper.addToolMaterial("TitaniumTool", 3, 2048, 10F, 4F, 7);

    public static ArmorMaterial SteelArmor    = EnumHelper.addArmorMaterial("SteelArmor", "steelindustries:SteelArmor",25, new int[]{3, 6, 6, 2}, 5);
    public static ArmorMaterial TitaniumArmor = EnumHelper.addArmorMaterial("TitaniumArmor", "steelindustries:TitaniumArmor", 40, new int[]{4, 7, 6, 4}, 7);

}
