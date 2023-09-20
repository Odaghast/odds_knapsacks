
package net.mcreator.oddsknapsacks.item;

import net.mcreator.oddsknapsacks.OddsKnapsacksMod;
import net.mcreator.oddsknapsacks.core.KnapsackType;

import net.minecraft.ChatFormatting;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.oddsknapsacks.world.inventory.KnapsackMenu;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KnapsackItem extends Item {

	public final KnapsackType knapsackType;
	private final int slotSize;

	private static final int BAR_COLOR = Mth.color(0.4F, 0.4F, 1.0F);
	public KnapsackItem(KnapsackType knapsackType, Properties props) {
		super(props);
		this.knapsackType = knapsackType;
		this.slotSize = knapsackType.slotCollumns * knapsackType.slotRows;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		KnapsackType type = this.knapsackType;

		entity.playSound(this.knapsackType.getSound(true), 1.0F, 0.8F + entity.getRandom().nextFloat() * 0.4F);

		entity.openMenu(new ExtendedScreenHandlerFactory() {
			@Override
			public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
				return new KnapsackMenu(type, syncId, inventory, itemstack);
			}

			@Override
			public Component getDisplayName() {
				return itemstack.getDisplayName();
			}

			@Override
			public void writeScreenOpeningData(ServerPlayer player, FriendlyByteBuf buf) {
				buf.writeBlockPos(BlockPos.ZERO);
			}
		});
		return ar;
	}

	@Override
	public boolean isBarVisible(ItemStack itemStack) {
		return this.getWeight(itemStack) > 0;
	}

	@Override
	public int getBarWidth(ItemStack itemStack) {

		return (int)(getWeight(itemStack) * 13);
	}

	@Override
	public int getBarColor(ItemStack itemStack) {
		return BAR_COLOR;
	}

	private float getWeight(ItemStack stack) {
		CompoundTag tag = stack.getTagElement("Items");
		if (tag != null) {
			return getFilledSlots(tag) / this.slotSize;
		}
		return -1;
	}

	private float getFilledSlots(CompoundTag tag) {
		ListTag listTag = tag.getList("Items", 10);

		float count = 0;
		for(int i = 0; i < listTag.size(); ++i) {
			CompoundTag compoundTag2 = listTag.getCompound(i);
			int j = compoundTag2.getByte("Slot") & 255;
			if (j >= 0 && j < this.slotSize && ItemStack.of(compoundTag2) != ItemStack.EMPTY) {
				count++;
			}
		}
		return count;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
		list.add(Component.translatable("item."+ OddsKnapsacksMod.MODID + ".hover." + getHoverTranslatable()).withStyle(ChatFormatting.GRAY));
		super.appendHoverText(itemStack, level, list, tooltipFlag);
	}

	public String getHoverTranslatable() {
		return "holds_all";
	}

	public boolean canItemInsert(ItemStack stack) {
		return !(stack.getItem() instanceof KnapsackItem);
	}
}
