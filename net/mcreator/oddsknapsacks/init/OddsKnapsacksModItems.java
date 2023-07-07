
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oddsknapsacks.init;

import net.mcreator.oddsknapsacks.core.KnapsackType;
import net.mcreator.oddsknapsacks.item.KnapsackEnderItem;
import net.mcreator.oddsknapsacks.item.KnapsackItem;
import net.minecraft.class_1761;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1814;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.mcreator.oddsknapsacks.OddsKnapsacksMod;

public class OddsKnapsacksModItems {
	public static class_1792 KNAPSACK;
	public static class_1792 KNAPSACK_IRON;
	public static class_1792 KNAPSACK_GOLD;
	public static class_1792 KNAPSACK_DIAMOND;
	public static class_1792 KNAPSACK_NETHERITE;

	public static class_1792 KNAPSACK_CACTUS;
	public static class_1792 KNAPSACK_ENDER;

	public static KnapsackItem KNAPSACK_ADVENTURE;
	public static KnapsackItem KNAPSACK_MINER;
	public static KnapsackItem KNAPSACK_HERBALIST;
	public static KnapsackItem KNAPSACK_ARBORIST;
	public static KnapsackItem KNAPSACK_BUILDER;
	public static KnapsackItem KNAPSACK_POTIONEER;

	public static class_1792 WRAP_LEATHER;
	public static class_1792 WRAP_IRON;
	public static class_1792 WRAP_GOLD;
	public static class_1792 WRAP_DIAMOND;
	public static class_1792 WRAP_NETHERITE;

	public static class_1792 WRAP_ADVENTURE;
	public static class_1792 WRAP_MINER;
	public static class_1792 WRAP_HERBALIST;
	public static class_1792 WRAP_ARBORIST;
	public static class_1792 WRAP_BUILDER;
	public static class_1792 WRAP_POTIONEER;

	public static class_1792 LINING;

	public static void load() {
		KNAPSACK = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "knapsack"), new KnapsackItem(KnapsackType.SMALL, knapsackProperties()));
		KNAPSACK_IRON = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "knapsack_iron"), new KnapsackItem(KnapsackType.MEDIUM, knapsackProperties()));
		KNAPSACK_GOLD = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "knapsack_gold"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()));
		KNAPSACK_DIAMOND = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "knapsack_diamond"), new KnapsackItem(KnapsackType.LARGE, knapsackProperties()));
		KNAPSACK_NETHERITE = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "knapsack_netherite"), new KnapsackItem(KnapsackType.GRAND, knapsackProperties().method_24359()));

		KNAPSACK_ENDER = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "knapsack_ender"), new KnapsackEnderItem(KnapsackType.ENDER, knapsackProperties()));
		KNAPSACK_CACTUS = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "knapsack_cactus"), new KnapsackItem(KnapsackType.CACTUS, knapsackProperties()) {
			@Override
			public String getHoverTranslatable() {
				return "cactus";
			}
		});

		KNAPSACK_ADVENTURE = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "knapsack_adventure"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(class_1799 stack) {
				class_1792 item = stack.method_7909();
				return item.method_19263() || item.method_7846() || stack.method_31573(OddsKnapsacksModTagKeys.KNAPSACK_ADVENTURE);
			}

			@Override
			public String getHoverTranslatable() {
				return "adventure";
			}
		});
		KNAPSACK_MINER = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "knapsack_miner"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(class_1799 stack) {
				return stack.method_31573(OddsKnapsacksModTagKeys.KNAPSACK_MINER);
			}

			@Override
			public String getHoverTranslatable() {
				return "miner";
			}
		});
		KNAPSACK_HERBALIST = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "knapsack_herbalist"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(class_1799 stack) {
				return stack.method_31573(OddsKnapsacksModTagKeys.KNAPSACK_HERBALIST);
			}

			@Override
			public String getHoverTranslatable() {
				return "herbalist";
			}
		});
		KNAPSACK_ARBORIST = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "knapsack_arborist"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(class_1799 stack) {
				return stack.method_31573(OddsKnapsacksModTagKeys.KNAPSACK_ARBORIST);
			}

			@Override
			public String getHoverTranslatable() {
				return "arborist";
			}
		});
		KNAPSACK_BUILDER = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "knapsack_builder"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(class_1799 stack) {
				return stack.method_7909().method_7859() == class_1761.field_7931 || stack.method_31573(OddsKnapsacksModTagKeys.KNAPSACK_BUILDER);
			}

			@Override
			public String getHoverTranslatable() {
				return "builder";
			}
		});
		KNAPSACK_POTIONEER = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "knapsack_potioneer"), new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(class_1799 stack) {
				return stack.method_31573(OddsKnapsacksModTagKeys.KNAPSACK_POTIONEER);
			}

			@Override
			public String getHoverTranslatable() {
				return "potioneer";
			}
		});

		WRAP_LEATHER = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "wrap_leather"), new class_1792(defaultProperties()));
		WRAP_IRON = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "wrap_iron"), new class_1792(defaultProperties()));
		WRAP_GOLD = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "wrap_gold"), new class_1792(defaultProperties()));
		WRAP_DIAMOND = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "wrap_diamond"), new class_1792(defaultProperties()));
		WRAP_NETHERITE = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "wrap_netherite"), new class_1792(defaultProperties().method_24359()));

		WRAP_ADVENTURE = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "wrap_adventure"), new class_1792(defaultProperties()));
		WRAP_MINER = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "wrap_miner"), new class_1792(defaultProperties()));
		WRAP_HERBALIST = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "wrap_herbalist"), new class_1792(defaultProperties()));
		WRAP_ARBORIST = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "wrap_arborist"), new class_1792(defaultProperties()));
		WRAP_BUILDER = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "wrap_builder"), new class_1792(defaultProperties()));
		WRAP_POTIONEER = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "wrap_potioneer"), new class_1792(defaultProperties()));

		LINING = class_2378.method_10230(class_2378.field_11142, new class_2960(OddsKnapsacksMod.MODID, "lining"), new class_1792(defaultProperties()));
	}

	private static class_1792.class_1793 defaultProperties() {
		return new class_1792.class_1793().method_7892(OddsKnapsacksModItemGroups.KNAPSACKS).method_7894(class_1814.field_8906);
	}

	private static class_1792.class_1793 knapsackProperties() {
		return defaultProperties().method_7889(1);
	}
}
