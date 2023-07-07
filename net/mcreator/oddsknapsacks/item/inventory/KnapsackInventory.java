
package net.mcreator.oddsknapsacks.item.inventory;

import org.jetbrains.annotations.Nullable;
import net.fabricmc.api.Environment;
import net.minecraft.class_1262;
import net.minecraft.class_1278;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_2350;
import net.minecraft.class_2371;
import net.minecraft.class_2487;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class KnapsackInventory implements class_1278 {
	private final class_1799 stack;
	private final class_2371<class_1799> items;

	public KnapsackInventory(class_1799 stack, int size) {
		this.stack = stack;
		this.items = class_2371.method_10213(size, class_1799.field_8037);
		class_2487 tag = stack.method_7941("Items");
		if (tag != null) {
			class_1262.method_5429(tag, items);
		}
	}

	public class_2371<class_1799> getItems() {
		return items;
	}

	@Override
	public int[] method_5494(class_2350 side) {
		int[] result = new int[getItems().size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = i;
		}
		return result;
	}

	@Override
	public int method_5444() {
		return 64;
	}

	@Override
	public boolean method_5492(int slot, class_1799 stack, @Nullable class_2350 dir) {
		return true;
	}

	@Override
	public boolean method_5493(int slot, class_1799 stack, class_2350 dir) {
		return true;
	}

	@Override
	public int method_5439() {
		return getItems().size();
	}

	@Override
	public boolean method_5442() {
		for (int i = 0; i < method_5439(); i++) {
			class_1799 stack = method_5438(i);
			if (!stack.method_7960()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public class_1799 method_5438(int slot) {
		return getItems().get(slot);
	}

	@Override
	public class_1799 method_5434(int slot, int amount) {
		class_1799 result = class_1262.method_5430(getItems(), slot, amount);
		if (!result.method_7960()) {
			method_5431();
		}
		return result;
	}

	@Override
	public class_1799 method_5441(int slot) {
		return class_1262.method_5428(getItems(), slot);
	}

	@Override
	public void method_5447(int slot, class_1799 stack) {
		getItems().set(slot, stack);
		if (stack.method_7947() > method_5444()) {
			stack.method_7939(method_5444());
		}
	}

	@Override
	public void method_5431() {
		class_2487 tag = stack.method_7911("Items");
		class_1262.method_5426(tag, items);
	}

	@Override
	public boolean method_5443(class_1657 player) {
		return player.method_5805();
	}

	@Override
	public void method_5448() {
		getItems().clear();
	}

	public void voidContent() {
		this.method_5448();
		method_5431();
	}
}
