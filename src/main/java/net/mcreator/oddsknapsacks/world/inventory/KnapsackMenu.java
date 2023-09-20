
package net.mcreator.oddsknapsacks.world.inventory;

import net.mcreator.oddsknapsacks.core.KnapsackType;
import net.mcreator.oddsknapsacks.item.KnapsackItem;
import net.mcreator.oddsknapsacks.item.inventory.KnapsackInventory;

import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.Nullable;

public class KnapsackMenu extends AbstractContainerMenu {
	private final KnapsackInventory inventory;

	private int size;
	public ItemStack knapStack;
	private final KnapsackType knapsackType;

	public static KnapsackMenu small(int id, Inventory inv, @Nullable FriendlyByteBuf extraData) {
		return new KnapsackMenu(KnapsackType.SMALL, id, inv, ItemStack.EMPTY);
	}
	public static KnapsackMenu medium(int id, Inventory inv, @Nullable FriendlyByteBuf extraData) {
		return new KnapsackMenu(KnapsackType.MEDIUM, id, inv, ItemStack.EMPTY);
	}

	public static KnapsackMenu big(int id, Inventory inv, @Nullable FriendlyByteBuf extraData) {
		return new KnapsackMenu(KnapsackType.BIG, id, inv, ItemStack.EMPTY);
	}

	public static KnapsackMenu large(int id, Inventory inv, @Nullable FriendlyByteBuf extraData) {
		return new KnapsackMenu(KnapsackType.LARGE, id, inv, ItemStack.EMPTY);
	}

	public static KnapsackMenu grand(int id, Inventory inv, @Nullable FriendlyByteBuf extraData) {
		return new KnapsackMenu(KnapsackType.GRAND, id, inv, ItemStack.EMPTY);
	}

	public static KnapsackMenu cactus(int id, Inventory inv, @Nullable FriendlyByteBuf extraData) {
		return new KnapsackMenu(KnapsackType.CACTUS, id, inv, ItemStack.EMPTY);
	}

	public KnapsackMenu(KnapsackType knapsackType, int id, Inventory inv, ItemStack stack) {
		super(knapsackType.getMenuType(), id);

		this.knapsackType = knapsackType;
		this.size = knapsackType.slotCollumns * knapsackType.slotRows;
		this.inventory = new KnapsackInventory(stack, this.size);
		this.knapStack = stack;

		setCustomSlots(knapsackType.slotCollumns, knapsackType.slotRows);

		//vanilla inventory
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, knapsackType.inventoryXOff + 8 + sj * 18, knapsackType.inventoryYOff + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, knapsackType.inventoryXOff + 8 + si * 18, knapsackType.inventoryYOff + 142));
	}

	private void setCustomSlots(int width, int height) {
		int _sSize = 18;
		int _xStart = 89 - (width * _sSize/2);
		int _yStart = 45 - (height * _sSize/2);

		int index = 0;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				this.addSlot(new Slot(inventory, index, _xStart + x*_sSize, _yStart + y*_sSize));
				index++;
			}
		}
	}

	@Override
	public boolean stillValid(Player player) {
		return this.inventory.stillValid(player);
	}

	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);

		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();

			if (!itemIsValid(itemstack)) {return ItemStack.EMPTY;}

			if (index < size) {
				//move from sack to inventory
				if (!this.moveItemStackTo(itemstack1, size, this.slots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(itemstack1, 0, size, false)) {
				//move from inventory to sack
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
		}

		return itemstack;
	}

	@Override
	public void removed(Player playerIn) {
		//cactus trash event
		if (this.knapsackType.typeID.equals("CACTUS")) {
			this.inventory.voidContent();
		}
		playerIn.playSound(this.knapsackType.getSound(false), 1.0F, 0.8F + playerIn.getRandom().nextFloat() * 0.4F);
		super.removed(playerIn);
	}

	@Override
	public void clicked(int slotID, int button, ClickType flag, Player player) {
		try {
			this.doClick(slotID, button, flag, player);
		} catch (Exception exception) {
			CrashReport crashreport = CrashReport.forThrowable(exception, "Container click");
			CrashReportCategory crashreportcategory = crashreport.addCategory("Click info");
			crashreportcategory.setDetail("Menu Type", "BasicKnapsackMenu : Potentially a sub menu!");
			crashreportcategory.setDetail("Menu Class", () -> {
				return this.getClass().getCanonicalName();
			});
			crashreportcategory.setDetail("Slot Count", this.slots.size());
			crashreportcategory.setDetail("Slot", slotID);
			crashreportcategory.setDetail("Button", button);
			crashreportcategory.setDetail("Type", flag);
			throw new ReportedException(crashreport);
		}
	}

	private void doClick(int slotID, int button, ClickType flag, Player player) {
		if (!(player instanceof ServerPlayer) || slotID < 0) return;
		//clicktype
		if (flag == ClickType.PICKUP || flag == ClickType.QUICK_MOVE || flag == ClickType.THROW || flag == ClickType.SWAP) {
			//stop movement of open sack
			if (this.slots.get(slotID).getItem() != this.knapStack) {

				if (slotID >= this.size || itemIsValid(this.getCarried())) {
					super.clicked(slotID, button, flag, player);
				}
			}
		} else {
			super.clicked(slotID, button, flag, player);
		}
	}

	private boolean itemIsValid(ItemStack stack) {
		return stack.isEmpty() || ((KnapsackItem) this.knapStack.getItem()).canItemInsert(stack);
	}
}
