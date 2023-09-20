
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oddsknapsacks.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mcreator.oddsknapsacks.core.KnapsackType;
import net.mcreator.oddsknapsacks.item.KnapsackEnderItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.oddsknapsacks.item.KnapsackItem;
import net.mcreator.oddsknapsacks.OddsKnapsacksMod;

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
	public static Item NEEDLE_THREAD;


	private static ResourceKey<CreativeModeTab> TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB,
			new ResourceLocation(OddsKnapsacksMod.MODID, "knapsacks"));

	public static CreativeModeTab TAB;

	public static void load() {
		TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(OddsKnapsacksMod.MODID, "knapsacks"), FabricItemGroup.builder()
				.icon(() -> new ItemStack(KNAPSACK))
				.title(Component.translatable("itemGroup.odds_knapsacks.knapsacks"))
				.noScrollBar()
				.build());

		KNAPSACK = registerKnapsack("knapsack", new KnapsackItem(KnapsackType.SMALL, knapsackProperties()));
		KNAPSACK_IRON = registerKnapsack("knapsack_iron", new KnapsackItem(KnapsackType.MEDIUM, knapsackProperties()));
		KNAPSACK_GOLD = registerKnapsack("knapsack_gold", new KnapsackItem(KnapsackType.BIG, knapsackProperties()));
		KNAPSACK_DIAMOND = registerKnapsack("knapsack_diamond", new KnapsackItem(KnapsackType.LARGE, knapsackProperties()));
		KNAPSACK_NETHERITE = registerKnapsack("knapsack_netherite", new KnapsackItem(KnapsackType.GRAND, knapsackProperties().fireResistant()));

		KNAPSACK_ENDER = registerKnapsack("knapsack_ender", new KnapsackEnderItem(KnapsackType.ENDER, knapsackProperties()));
		KNAPSACK_CACTUS = registerKnapsack("knapsack_cactus", new KnapsackItem(KnapsackType.CACTUS, knapsackProperties()) {
			@Override
			public String getHoverTranslatable() {
				return "cactus";
			}
		});

		KNAPSACK_ADVENTURE = registerKnapsack("knapsack_adventure", new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
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
		KNAPSACK_MINER = registerKnapsack("knapsack_miner", new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(ItemStack stack) {
				return stack.is(OddsKnapsacksModTagKeys.KNAPSACK_MINER);
			}

			@Override
			public String getHoverTranslatable() {
				return "miner";
			}
		});
		KNAPSACK_HERBALIST = registerKnapsack("knapsack_herbalist", new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(ItemStack stack) {
				return stack.is(OddsKnapsacksModTagKeys.KNAPSACK_HERBALIST);
			}

			@Override
			public String getHoverTranslatable() {
				return "herbalist";
			}
		});
		KNAPSACK_ARBORIST = registerKnapsack("knapsack_arborist", new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(ItemStack stack) {
				return stack.is(OddsKnapsacksModTagKeys.KNAPSACK_ARBORIST);
			}

			@Override
			public String getHoverTranslatable() {
				return "arborist";
			}
		});
		KNAPSACK_BUILDER = registerKnapsack("knapsack_builder", new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(ItemStack stack) {
				return TAB.contains(stack) || stack.is(OddsKnapsacksModTagKeys.KNAPSACK_BUILDER);
			}

			@Override
			public String getHoverTranslatable() {
				return "builder";
			}
		});
		KNAPSACK_POTIONEER = registerKnapsack("knapsack_potioneer", new KnapsackItem(KnapsackType.BIG, knapsackProperties()) {
			@Override
			public boolean canItemInsert(ItemStack stack) {
				return stack.is(OddsKnapsacksModTagKeys.KNAPSACK_POTIONEER);
			}

			@Override
			public String getHoverTranslatable() {
				return "potioneer";
			}
		});

		WRAP_LEATHER = registerItem("wrap_leather", new Item(defaultProperties()));
		WRAP_IRON = registerItem("wrap_iron", new Item(defaultProperties()));
		WRAP_GOLD = registerItem("wrap_gold", new Item(defaultProperties()));
		WRAP_DIAMOND = registerItem("wrap_diamond", new Item(defaultProperties()));
		WRAP_NETHERITE = registerItem("wrap_netherite", new Item(defaultProperties().fireResistant()));

		WRAP_ADVENTURE = registerItem("wrap_adventure", new Item(defaultProperties()));
		WRAP_MINER = registerItem("wrap_miner", new Item(defaultProperties()));
		WRAP_HERBALIST = registerItem("wrap_herbalist", new Item(defaultProperties()));
		WRAP_ARBORIST = registerItem("wrap_arborist", new Item(defaultProperties()));
		WRAP_BUILDER = registerItem("wrap_builder", new Item(defaultProperties()));
		WRAP_POTIONEER = registerItem("wrap_potioneer", new Item(defaultProperties()));

		LINING = registerItem("lining", new Item(defaultProperties()));
		NEEDLE_THREAD = registerItem("needle_thread", new Item(defaultProperties()));
	}

	private static Item registerItem(String name, Item item) {
		Item _return = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(OddsKnapsacksMod.MODID, name), item);

		ItemGroupEvents.modifyEntriesEvent(TAB_KEY).register(content -> {
			content.accept(_return);
		});

		return _return;
	}

	private static KnapsackItem registerKnapsack(String name, Item item) {
		return (KnapsackItem) registerItem(name, item);
	}

	private static Item.Properties defaultProperties() {
		return new Item.Properties().rarity(Rarity.COMMON);
	}

	private static Item.Properties knapsackProperties() {
		return defaultProperties().stacksTo(1);
	}
}
