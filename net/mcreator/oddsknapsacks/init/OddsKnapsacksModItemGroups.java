package net.mcreator.oddsknapsacks.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.mcreator.oddsknapsacks.OddsKnapsacksMod;
import net.minecraft.class_1761;
import net.minecraft.class_1799;
import net.minecraft.class_2960;

public class OddsKnapsacksModItemGroups {
    public static final class_1761 KNAPSACKS = FabricItemGroupBuilder.build(new class_2960(OddsKnapsacksMod.MODID, "knapsacks"),
            () -> new class_1799(OddsKnapsacksModItems.KNAPSACK));
}
