
package net.mcreator.oddsknapsacks.world.inventory;

import net.mcreator.oddsknapsacks.core.KnapsackType;
import net.mcreator.oddsknapsacks.item.KnapsackItem;
import net.mcreator.oddsknapsacks.item.inventory.KnapsackInventory;
import net.minecraft.class_128;
import net.minecraft.class_129;
import net.minecraft.class_148;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_2540;
import net.minecraft.class_3222;
import org.jetbrains.annotations.Nullable;

public class KnapsackMenu extends class_1703 {
	private final KnapsackInventory inventory;

	private int size;
	public class_1799 knapStack;
	private final KnapsackType knapsackType;

	public static KnapsackMenu small(int id, class_1661 inv, @Nullable class_2540 extraData) {
		return new KnapsackMenu(KnapsackType.SMALL, id, inv, class_1799.field_8037);
	}
	public static KnapsackMenu medium(int id, class_1661 inv, @Nullable class_2540 extraData) {
		return new KnapsackMenu(KnapsackType.MEDIUM, id, inv, class_1799.field_8037);
	}

	public static KnapsackMenu big(int id, class_1661 inv, @Nullable class_2540 extraData) {
		return new KnapsackMenu(KnapsackType.BIG, id, inv, class_1799.field_8037);
	}

	public static KnapsackMenu large(int id, class_1661 inv, @Nullable class_2540 extraData) {
		return new KnapsackMenu(KnapsackType.LARGE, id, inv, class_1799.field_8037);
	}

	public static KnapsackMenu grand(int id, class_1661 inv, @Nullable class_2540 extraData) {
		return new KnapsackMenu(KnapsackType.GRAND, id, inv, class_1799.field_8037);
	}

	public static KnapsackMenu cactus(int id, class_1661 inv, @Nullable class_2540 extraData) {
		return new KnapsackMenu(KnapsackType.CACTUS, id, inv, class_1799.field_8037);
	}

	public KnapsackMenu(KnapsackType knapsackType, int id, class_1661 inv, class_1799 stack) {
		super(knapsackType.getMenuType(), id);

		this.knapsackType = knapsackType;
		this.size = knapsackType.slotCollumns * knapsackType.slotRows;
		this.inventory = new KnapsackInventory(stack, this.size);
		this.knapStack = stack;

		setCustomSlots(knapsackType.slotCollumns, knapsackType.slotRows);

		//vanilla inventory
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.method_7621(new class_1735(inv, sj + (si + 1) * 9, knapsackType.inventoryXOff + 8 + sj * 18, knapsackType.inventoryYOff + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.method_7621(new class_1735(inv, si, knapsackType.inventoryXOff + 8 + si * 18, knapsackType.inventoryYOff + 142));
	}

	private void setCustomSlots(int width, int height) {
		int _sSize = 18;
		int _xStart = 89 - (width * _sSize/2);
		int _yStart = 45 - (height * _sSize/2);

		int index = 0;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				this.method_7621(new class_1735(inventory, index, _xStart + x*_sSize, _yStart + y*_sSize));
				index++;
			}
		}
	}

	@Override
	public boolean method_7597(class_1657 player) {
		return this.inventory.method_5443(player);
	}

	@Override
	public class_1799 method_7601(class_1657 player, int index) {
		class_1799 itemstack = class_1799.field_8037;
		class_1735 slot = this.field_7761.get(index);

		if (slot != null && slot.method_7681()) {
			class_1799 itemstack1 = slot.method_7677();
			itemstack = itemstack1.method_7972();

			if (!itemIsValid(itemstack)) {return class_1799.field_8037;}

			if (index < size) {
				//move from sack to inventory
				if (!this.method_7616(itemstack1, size, this.field_7761.size(), true)) {
					return class_1799.field_8037;
				}
			} else if (!this.method_7616(itemstack1, 0, size, false)) {
				//move from inventory to sack
				return class_1799.field_8037;
			}

			if (itemstack1.method_7960()) {
				slot.method_7673(class_1799.field_8037);
			} else {
				slot.method_7668();
			}
		}

		return itemstack;
	}

	@Override
	public void method_7595(class_1657 playerIn) {
		//cactus trash event
		if (this.knapsackType.typeID.equals("CACTUS")) {
			this.inventory.voidContent();
		}
		playerIn.method_5783(this.knapsackType.getSound(false), 1.0F, 0.8F + playerIn.method_37908().method_8409().method_43057() * 0.4F);
		super.method_7595(playerIn);
	}

	@Override
	public void method_7593(int slotID, int button, class_1713 flag, class_1657 player) {
		try {
			this.method_30010(slotID, button, flag, player);
		} catch (Exception exception) {
			class_128 crashreport = class_128.method_560(exception, "Container click");
			class_129 crashreportcategory = crashreport.method_562("Click info");
			crashreportcategory.method_578("Menu Type", "BasicKnapsackMenu : Potentially a sub menu!");
			crashreportcategory.method_577("Menu Class", () -> {
				return this.getClass().getCanonicalName();
			});
			crashreportcategory.method_578("Slot Count", this.field_7761.size());
			crashreportcategory.method_578("Slot", slotID);
			crashreportcategory.method_578("Button", button);
			crashreportcategory.method_578("Type", flag);
			throw new class_148(crashreport);
		}
	}

	private void method_30010(int slotID, int button, class_1713 flag, class_1657 player) {
		if (!(player instanceof class_3222) || slotID < 0) return;
		//clicktype
		if (flag == class_1713.field_7790 || flag == class_1713.field_7794 || flag == class_1713.field_7795 || flag == class_1713.field_7791) {
			//stop movement of open sack
			if (this.field_7761.get(slotID).method_7677() != this.knapStack) {

				if (slotID >= this.size || itemIsValid(this.method_34255())) {
					super.method_7593(slotID, button, flag, player);
				}
			}
		} else {
			super.method_7593(slotID, button, flag, player);
		}
	}

	private boolean itemIsValid(class_1799 stack) {
		return stack.method_7960() || ((KnapsackItem) this.knapStack.method_7909()).canItemInsert(stack);
	}
}
