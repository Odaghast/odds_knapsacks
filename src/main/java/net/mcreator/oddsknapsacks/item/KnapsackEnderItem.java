package net.mcreator.oddsknapsacks.item;

import net.mcreator.oddsknapsacks.core.KnapsackType;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class KnapsackEnderItem extends KnapsackItem{
    public KnapsackEnderItem(KnapsackType knapsackType, Properties props) {
        super(knapsackType, props);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);

        if (world.isClientSide) return ar;

        //does NOT increase ender chests open stat (its not an ender chest so why would it)
        entity.openMenu(new SimpleMenuProvider((i, inventory, player) -> {
            return ChestMenu.threeRows(i, inventory, player.getEnderChestInventory());
        }, Component.translatable("container.enderchest")));

        return ar;
    }
}
