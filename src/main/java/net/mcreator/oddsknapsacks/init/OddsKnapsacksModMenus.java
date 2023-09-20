
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oddsknapsacks.init;

import net.mcreator.oddsknapsacks.world.inventory.KnapsackMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.oddsknapsacks.OddsKnapsacksMod;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;

public class OddsKnapsacksModMenus {
	public static MenuType<KnapsackMenu> SMALL;
	public static MenuType<KnapsackMenu> MEDIUM;
	public static MenuType<KnapsackMenu> BIG;
	public static MenuType<KnapsackMenu> LARGE;
	public static MenuType<KnapsackMenu> GRAND;

	public static MenuType<KnapsackMenu> CACTUS;

	public static void load() {
		SMALL = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(OddsKnapsacksMod.MODID, "small"), new ExtendedScreenHandlerType<>(KnapsackMenu::small));
		MEDIUM = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(OddsKnapsacksMod.MODID, "medium"), new ExtendedScreenHandlerType<>(KnapsackMenu::medium));
		BIG = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(OddsKnapsacksMod.MODID, "big"), new ExtendedScreenHandlerType<>(KnapsackMenu::big));
		LARGE = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(OddsKnapsacksMod.MODID, "large"), new ExtendedScreenHandlerType<>(KnapsackMenu::large));
		GRAND = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(OddsKnapsacksMod.MODID, "grand"), new ExtendedScreenHandlerType<>(KnapsackMenu::grand));

		CACTUS = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(OddsKnapsacksMod.MODID, "cactus"), new ExtendedScreenHandlerType<>(KnapsackMenu::cactus));
	}
}
