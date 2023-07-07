
package net.mcreator.oddsknapsacks.item;

import net.mcreator.oddsknapsacks.OddsKnapsacksMod;
import net.mcreator.oddsknapsacks.core.KnapsackType;
import net.mcreator.oddsknapsacks.world.inventory.KnapsackMenu;
import net.minecraft.class_124;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_2499;
import net.minecraft.class_2540;
import net.minecraft.class_2561;
import net.minecraft.class_3222;
import net.minecraft.class_3532;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KnapsackItem extends class_1792 {

	public final KnapsackType knapsackType;
	private final int slotSize;

	private static final int BAR_COLOR = class_3532.method_15353(0.4F, 0.4F, 1.0F);
	public KnapsackItem(KnapsackType knapsackType, class_1793 props) {
		super(props);
		this.knapsackType = knapsackType;
		this.slotSize = knapsackType.slotCollumns * knapsackType.slotRows;
	}

	@Override
	public int method_7881(class_1799 itemstack) {
		return 0;
	}

	@Override
	public class_1271<class_1799> method_7836(class_1937 world, class_1657 entity, class_1268 hand) {
		class_1271<class_1799> ar = super.method_7836(world, entity, hand);
		class_1799 itemstack = ar.method_5466();
		KnapsackType type = this.knapsackType;

		entity.method_5783(this.knapsackType.getSound(true), 1.0F, 0.8F + entity.method_37908().method_8409().method_43057() * 0.4F);

		entity.method_17355(new ExtendedScreenHandlerFactory() {
			@Override
			public class_1703 createMenu(int syncId, class_1661 inventory, class_1657 player) {
				return new KnapsackMenu(type, syncId, inventory, itemstack);
			}

			@Override
			public class_2561 method_5476() {
				return itemstack.method_7954();
			}

			@Override
			public void writeScreenOpeningData(class_3222 player, class_2540 buf) {
				buf.method_10807(class_2338.field_10980);
			}
		});
		return ar;
	}

	@Override
	public boolean method_31567(class_1799 itemStack) {
		return this.getWeight(itemStack) > 0;
	}

	@Override
	public int method_31569(class_1799 itemStack) {

		return (int)(getWeight(itemStack) * 13);
	}

	@Override
	public int method_31571(class_1799 itemStack) {
		return BAR_COLOR;
	}

	private float getWeight(class_1799 stack) {
		class_2487 tag = stack.method_7941("Items");
		if (tag != null) {
			return getFilledSlots(tag) / this.slotSize;
		}
		return -1;
	}

	private float getFilledSlots(class_2487 tag) {
		class_2499 listTag = tag.method_10554("Items", 10);

		float count = 0;
		for(int i = 0; i < listTag.size(); ++i) {
			class_2487 compoundTag2 = listTag.method_10602(i);
			int j = compoundTag2.method_10571("Slot") & 255;
			if (j >= 0 && j < this.slotSize && class_1799.method_7915(compoundTag2) != class_1799.field_8037) {
				count++;
			}
		}
		return count;
	}

	@Override
	public void method_7851(class_1799 itemStack, @Nullable class_1937 level, List<class_2561> list, class_1836 tooltipFlag) {
		list.add(class_2561.method_43471("item."+ OddsKnapsacksMod.MODID + ".hover." + getHoverTranslatable()).method_27692(class_124.field_1080));
		super.method_7851(itemStack, level, list, tooltipFlag);
	}

	public String getHoverTranslatable() {
		return "holds_all";
	}

	public boolean canItemInsert(class_1799 stack) {
		return !(stack.method_7909() instanceof KnapsackItem);
	}
}
