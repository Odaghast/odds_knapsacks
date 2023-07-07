
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oddsknapsacks.init;

import net.mcreator.oddsknapsacks.client.gui.KnapsackScreen;
import net.minecraft.client.gui.screens.MenuScreens;

public class OddsKnapsacksModScreens {
	public static void load() {
		MenuScreens.register(OddsKnapsacksModMenus.SMALL, KnapsackScreen::small);
		MenuScreens.register(OddsKnapsacksModMenus.MEDIUM, KnapsackScreen::medium);
		MenuScreens.register(OddsKnapsacksModMenus.BIG, KnapsackScreen::big);
		MenuScreens.register(OddsKnapsacksModMenus.LARGE, KnapsackScreen::large);
		MenuScreens.register(OddsKnapsacksModMenus.GRAND, KnapsackScreen::grand);

		MenuScreens.register(OddsKnapsacksModMenus.CACTUS, KnapsackScreen::cactus);
	}
}
