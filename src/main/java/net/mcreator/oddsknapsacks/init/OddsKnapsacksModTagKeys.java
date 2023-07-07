package net.mcreator.oddsknapsacks.init;

import net.mcreator.oddsknapsacks.OddsKnapsacksMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class OddsKnapsacksModTagKeys {
    private static final String MODID = OddsKnapsacksMod.MODID;
    public static final TagKey<Item> KNAPSACK_ADVENTURE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, "knapsack_adventure"));
    public static final TagKey<Item> KNAPSACK_MINER = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, "knapsack_miner"));
    public static final TagKey<Item> KNAPSACK_HERBALIST = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, "knapsack_herbalist"));
    public static final TagKey<Item> KNAPSACK_ARBORIST = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, "knapsack_arborist"));
    public static final TagKey<Item> KNAPSACK_BUILDER = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, "knapsack_builder"));
    public static final TagKey<Item> KNAPSACK_POTIONEER = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, "knapsack_potioneer"));
}
