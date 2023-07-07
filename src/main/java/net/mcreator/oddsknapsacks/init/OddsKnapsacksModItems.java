
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oddsknapsacks.init;

import net.mcreator.oddsknapsacks.core.KnapsackType;
import net.mcreator.oddsknapsacks.item.KnapsackEnderItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.oddsknapsacks.item.KnapsackItem;
import net.mcreator.oddsknapsacks.OddsKnapsacksMod;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class OddsKnapsacksModItems {
	public static Item KNAPSACK;
	public static Item KNAPSACK_IRON;
	public static Item KNAPSACK_GOLD;
	public static Item KNAPSACK_DIAMOND;
	public static Item KNAPSACK_NETHERITE;

	public static Item KNAPSACK_CACTUS;
	public static Item KNAPSACK_ENDER;

	public static KnapsackItem KNAPSACK_ADVENTURE;
	public static KnapsackItem KNAPSACK_MINER;
	public static KnapsackItem KNAPSACK_HERBALIST;
	public static KnapsackItem KNAPSACK_ARBORIST;
	public static KnapsackItem KNAPSACK_BUILDER;
	public static KnapsackItem KNAPSACK_POTIONEER;

	public static Item WRAP_LEATHER;
	public static Item WRAP_IRON;
	public static Item WRAP_GOLD;
	public static Item WRAP_DIAMOND;
	public static Item WRAP_NETHERITE;

	public static Item WRAP_ADVENTURE;
	public static Item WRAP_MINER;
	public static Item WRAP_HERBALIST;
	public static Item WRAP_ARBORIST;
	public static Item WRAP_BUILDER;
	public static Item WRAP_POTIONEER;

	public static Item LINING;

	public static void load() {
		KNAPSACK = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsack"), new KnapsackItem(KnapsackType.SMALL, knapsackProperties()));
		KNAPSACK_IRON = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsack_iron"), new KnapsackItem(KnapsackType.MEDIUM, knapsackProperties()));
		KNAPSACK_GOLD = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsack_gold"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()));
		KNAPSACK_DIAMOND = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsack_diamond"), new KnapsackItem(KnapsackType.LARGE, knapsackProperties()));
		KNAPSACK_NETHERITE = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsack_netherite"), new KnapsackItem(KnapsackType.GRAND, knapsackProperties().fireResistant()));

		KNAPSACK_ENDER = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsack_ender"), new KnapsackEnderItem(KnapsackType.ENDER, knapsackProperties()));
		KNAPSACK_CACTUS = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsack_cactus"), new KnapsackItem(KnapsackType.CACTUS, knapsackProperties()) {
			@Override
			public String getHoverTranslatable() {
				return "cactus";
			}
		});

		KNAPSACK_ADVENTURE = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsack_adventure"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(ItemStack stack) {
				Item item = stack.getItem();
				return item.isEdible() || item.canBeDepleted() || stack.is(OddsKnapsacksModTagKeys.KNAPSACK_ADVENTURE);
			}

			@Override
			public String getHoverTranslatable() {
				return "adventure";
			}
		});
		KNAPSACK_MINER = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsack_miner"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(ItemStack stack) {
				return stack.is(OddsKnapsacksModTagKeys.KNAPSACK_MINER);
			}

			@Override
			public String getHoverTranslatable() {
				return "miner";
			}
		});
		KNAPSACK_HERBALIST = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsack_herbalist"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(ItemStack stack) {
				return stack.is(OddsKnapsacksModTagKeys.KNAPSACK_HERBALIST);
			}

			@Override
			public String getHoverTranslatable() {
				return "herbalist";
			}
		});
		KNAPSACK_ARBORIST = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsack_arborist"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(ItemStack stack) {
				return stack.is(OddsKnapsacksModTagKeys.KNAPSACK_ARBORIST);
			}

			@Override
			public String getHoverTranslatable() {
				return "arborist";
			}
		});
		KNAPSACK_BUILDER = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsack_builder"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(ItemStack stack) {
				return stack.getItem().getItemCategory() == CreativeModeTab.TAB_BUILDING_BLOCKS || stack.is(OddsKnapsacksModTagKeys.KNAPSACK_BUILDER);
			}

			@Override
			public String getHoverTranslatable() {
				return "builder";
			}
		});
		KNAPSACK_POTIONEER = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsack_potioneer"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(ItemStack stack) {
				return stack.is(OddsKnapsacksModTagKeys.KNAPSACK_POTIONEER);
			}

			@Override
			public String getHoverTranslatable() {
				return "potioneer";
			}
		});

		WRAP_LEATHER = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "wrap_leather"), new Item(defaultProperties()));
		WRAP_IRON = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "wrap_iron"), new Item(defaultProperties()));
		WRAP_GOLD = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "wrap_gold"), new Item(defaultProperties()));
		WRAP_DIAMOND = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "wrap_diamond"), new Item(defaultProperties()));
		WRAP_NETHERITE = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "wrap_netherite"), new Item(defaultProperties().fireResistant()));

		WRAP_ADVENTURE = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "wrap_adventure"), new Item(defaultProperties()));
		WRAP_MINER = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "wrap_miner"), new Item(defaultProperties()));
		WRAP_HERBALIST = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "wrap_herbalist"), new Item(defaultProperties()));
		WRAP_ARBORIST = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "wrap_arborist"), new Item(defaultProperties()));
		WRAP_BUILDER = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "wrap_builder"), new Item(defaultProperties()));
		WRAP_POTIONEER = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "wrap_potioneer"), new Item(defaultProperties()));

		LINING = Registry.register(Registry.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, "lining"), new Item(defaultProperties()));
	}

	private static Item.Properties defaultProperties() {
		return new Item.Properties().tab(OddsKnapsacksModItemGroups.KNAPSACKS).rarity(Rarity.COMMON);
	}

	private static Item.Properties knapsackProperties() {
		return defaultProperties().stacksTo(1);
	}
}
