
package net.mcreator.oddsknapsacks.client.gui;

import net.mcreator.oddsknapsacks.OddsKnapsacksMod;
import net.mcreator.oddsknapsacks.core.KnapsackType;
import net.mcreator.oddsknapsacks.world.inventory.KnapsackMenu;
import net.minecraft.class_1661;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_465;
import com.mojang.blaze3d.systems.RenderSystem;

public class KnapsackScreen extends class_465<KnapsackMenu> {

	public static KnapsackScreen small(KnapsackMenu container, class_1661 inventory, class_2561 text) {
		return new KnapsackScreen(KnapsackType.SMALL, container, inventory, text);
	}

	public static KnapsackScreen medium(KnapsackMenu container, class_1661 inventory, class_2561 text) {
		return new KnapsackScreen(KnapsackType.MEDIUM, container, inventory, text);
	}
	public static KnapsackScreen big(KnapsackMenu container, class_1661 inventory, class_2561 text) {
		return new KnapsackScreen(KnapsackType.BIG, container, inventory, text);
	}
	public static KnapsackScreen large(KnapsackMenu container, class_1661 inventory, class_2561 text) {
		return new KnapsackScreen(KnapsackType.LARGE, container, inventory, text);
	}
	public static KnapsackScreen grand(KnapsackMenu container, class_1661 inventory, class_2561 text) {
		return new KnapsackScreen(KnapsackType.GRAND, container, inventory, text);
	}
	public static KnapsackScreen cactus(KnapsackMenu container, class_1661 inventory, class_2561 text) {
		return new KnapsackScreen(KnapsackType.CACTUS, container, inventory, text);
	}

	private final class_2960 texture;

	public KnapsackScreen(KnapsackType type, KnapsackMenu container, class_1661 inventory, class_2561 text) {
		super(container, inventory, text);
		//this.world = container.world;
		//this.entity = container.entity;
		this.field_2792 = type.textureWidth;
		this.field_2779 = type.textureHeight;
		this.texture = new class_2960(OddsKnapsacksMod.MODID+":textures/screens/"+type.textureID+".png");
	}



	@Override
	public void method_25394(class_4587 ms, int mouseX, int mouseY, float partialTicks) {
		this.method_25420(ms);
		super.method_25394(ms, mouseX, mouseY, partialTicks);
		this.method_2380(ms, mouseX, mouseY);
	}

	@Override
	protected void method_2389(class_4587 ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.method_25290(ms, this.field_2776, this.field_2800, 0, 0, this.field_2792, this.field_2779, this.field_2792, this.field_2779);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean method_25404(int key, int b, int c) {
		if (key == 256) {
			this.field_22787.field_1724.method_7346();
			return true;
		}
		return super.method_25404(key, b, c);
	}

	@Override
	public void method_37432() {
		super.method_37432();
	}

	@Override
	protected void method_2388(class_4587 poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void method_25419() {
		super.method_25419();
		class_310.method_1551().field_1774.method_1462(false);
	}

	@Override
	public void method_25426() {
		super.method_25426();
		this.field_22787.field_1774.method_1462(true);
	}
}
