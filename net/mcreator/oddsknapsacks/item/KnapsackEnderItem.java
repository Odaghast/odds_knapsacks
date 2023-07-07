package net.mcreator.oddsknapsacks.item;

import net.mcreator.oddsknapsacks.core.KnapsackType;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1657;
import net.minecraft.class_1707;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2561;
import net.minecraft.class_747;

public class KnapsackEnderItem extends KnapsackItem{
    public KnapsackEnderItem(KnapsackType knapsackType, class_1793 props) {
        super(knapsackType, props);
    }

    @Override
    public class_1271<class_1799> method_7836(class_1937 world, class_1657 entity, class_1268 hand) {
        class_1271<class_1799> ar = super.method_7836(world, entity, hand);

        //does NOT increase ender chests open stat (its not an ender chest so why would it)
        entity.method_17355(new class_747((i, inventory, player) -> {
            return class_1707.method_19245(i, inventory, player.method_7274());
        }, class_2561.method_43471("container.enderchest")));

        return ar;
    }
}
