package com.j3ff97.steelindustries.client.gui.inventory;

import com.j3ff97.steelindustries.inventory.ContainerHighOven;
import com.j3ff97.steelindustries.reference.Textures;
import com.j3ff97.steelindustries.tileentity.TileEntityHighOven;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import org.lwjgl.opengl.GL11;

public class GuiHighOven extends GuiContainer
{

    private TileEntityHighOven highOven;

    public GuiHighOven(InventoryPlayer player, TileEntityHighOven tile)
    {
        super(new ContainerHighOven(player, tile));
        highOven = tile;

        this.xSize = 176;
        this.ySize = 166;
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String name = this.highOven.hasCustomInventoryName() ? this.highOven.getInventoryName() : I18n.format(this.highOven.getInventoryName());

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 5, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(Textures.GUI.HIGHOVEN);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        if(highOven.hasPower())
        {
            int i1 = highOven.getPowerRemainingScaled(45);
            drawTexturedModalRect(guiLeft + 8, guiTop + 51 - i1, 176, 71 - i1, 27, i1);
        }
            int j1 = highOven.getOvenProgressScaled(15);
            drawTexturedModalRect(guiLeft + 84, guiTop + 29, 176, 0, j1 + 1, 26);
    }
}
