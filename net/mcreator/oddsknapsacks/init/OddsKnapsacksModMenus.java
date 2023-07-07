
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oddsknapsacks.init;

import net.mcreator.oddsknapsacks.world.inventory.KnapsackMenu;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3917;
import net.mcreator.oddsknapsacks.OddsKnapsacksMod;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;

public class OddsKnapsacksModMenus {
	public static class_3917<KnapsackMenu> SMALL;
	public static class_3917<KnapsackMenu> MEDIUM;
	public static class_3917<KnapsackMenu> BIG;
	public static class_3917<KnapsackMenu> LARGE;
	public static class_3917<KnapsackMenu> GRAND;

	public static class_3917<KnapsackMenu> CACTUS;

	public static void load() {
		SMALL = class_2378.method_10230(class_2378.field_17429, new class_2960(OddsKnapsacksMod.MODID, "small"), new ExtendedScreenHandlerType<>(KnapsackMenu::small));
		MEDIUM = class_2378.method_10230(class_2378.field_17429, new class_2960(OddsKnapsacksMod.MODID, "medium"), new ExtendedScreenHandlerType<>(KnapsackMenu::medium));
		BIG = class_2378.method_10230(class_2378.field_17429, new class_2960(OddsKnapsacksMod.MODID, "big"), new ExtendedScreenHandlerType<>(KnapsackMenu::big));
		LARGE = class_2378.method_10230(class_2378.field_17429, new class_2960(OddsKnapsacksMod.MODID, "large"), new ExtendedScreenHandlerType<>(KnapsackMenu::large));
		GRAND = class_2378.method_10230(class_2378.field_17429, new class_2960(OddsKnapsacksMod.MODID, "grand"), new ExtendedScreenHandlerType<>(KnapsackMenu::grand));

		CACTUS = class_2378.method_10230(class_2378.field_17429, new class_2960(OddsKnapsacksMod.MODID, "cactus"), new ExtendedScreenHandlerType<>(KnapsackMenu::cactus));
	}
}
