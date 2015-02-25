package com.j3ff97.steelindustries.handler;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialHandler
{
    /**
     * EnumHelper.addToolMaterial:
     *
     * @param String name
     * @param int harvestLevel
     * @param int maxUses
     * @param float efficiency
     * @param float damage
     * @param int enchantability
     * <p/>
     * EnumHelper.addArmorMaterial:
     * @param String name
     * @param int durability
     * @param int[] reductionAmounts
     * @param int enchantability
     */

    public static ToolMaterial SteelTool    = EnumHelper.addToolMaterial("SteelTool", 2, 750, 7.0F, 3.0F, 5);
    public static ToolMaterial TitaniumTool = EnumHelper.addToolMaterial("TitaniumTool", 3, 2048, 10F, 4F, 7);

    public static ArmorMaterial SteelArmor    = EnumHelper.addArmorMaterial("SteelArmor", 25, new int[]{3, 6, 6, 2}, 5);
    public static ArmorMaterial TitaniumArmor = EnumHelper.addArmorMaterial("TitaniumArmor", 40, new int[]{4, 7, 6, 4}, 7);

}
