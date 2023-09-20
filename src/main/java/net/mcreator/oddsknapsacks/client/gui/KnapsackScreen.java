
package net.mcreator.oddsknapsacks.client.gui;

import net.mcreator.oddsknapsacks.OddsKnapsacksMod;
import net.mcreator.oddsknapsacks.core.KnapsackType;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.oddsknapsacks.world.inventory.KnapsackMenu;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class KnapsackScreen extends AbstractContainerScreen<KnapsackMenu> {

	public static KnapsackScreen small(KnapsackMenu container, Inventory inventory, Component text) {
		return new KnapsackScreen(KnapsackType.SMALL, container, inventory, text);
	}

	public static KnapsackScreen medium(KnapsackMenu container, Inventory inventory, Component text) {
		return new KnapsackScreen(KnapsackType.MEDIUM, container, inventory, text);
	}
	public static KnapsackScreen big(KnapsackMenu container, Inventory inventory, Component text) {
		return new KnapsackScreen(KnapsackType.BIG, container, inventory, text);
	}
	public static KnapsackScreen large(KnapsackMenu container, Inventory inventory, Component text) {
		return new KnapsackScreen(KnapsackType.LARGE, container, inventory, text);
	}
	public static KnapsackScreen grand(KnapsackMenu container, Inventory inventory, Component text) {
		return new KnapsackScreen(KnapsackType.GRAND, container, inventory, text);
	}
	public static KnapsackScreen cactus(KnapsackMenu container, Inventory inventory, Component text) {
		return new KnapsackScreen(KnapsackType.CACTUS, container, inventory, text);
	}

	private final ResourceLocation texture;

	public KnapsackScreen(KnapsackType type, KnapsackMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.imageWidth = type.textureWidth;
		this.imageHeight = type.textureHeight;
		this.texture = new ResourceLocation(OddsKnapsacksMod.MODID+":textures/screens/"+type.textureID+".png");
	}



	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0,0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int i, int j) {

	}
}
