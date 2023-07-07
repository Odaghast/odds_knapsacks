package net.mcreator.oddsknapsacks.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.mcreator.oddsknapsacks.OddsKnapsacksMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class OddsKnapsacksModItemGroups {
    public static final CreativeModeTab KNAPSACKS = FabricItemGroupBuilder.build(new ResourceLocation(OddsKnapsacksMod.MODID, "knapsacks"),
            () -> new ItemStack(OddsKnapsacksModItems.KNAPSACK));
}
