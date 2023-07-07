
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oddsknapsacks.init;

import net.mcreator.oddsknapsacks.client.gui.KnapsackScreen;
import net.minecraft.class_3929;

public class OddsKnapsacksModScreens {
	public static void load() {
		class_3929.method_17542(OddsKnapsacksModMenus.SMALL, KnapsackScreen::small);
		class_3929.method_17542(OddsKnapsacksModMenus.MEDIUM, KnapsackScreen::medium);
		class_3929.method_17542(OddsKnapsacksModMenus.BIG, KnapsackScreen::big);
		class_3929.method_17542(OddsKnapsacksModMenus.LARGE, KnapsackScreen::large);
		class_3929.method_17542(OddsKnapsacksModMenus.GRAND, KnapsackScreen::grand);

		class_3929.method_17542(OddsKnapsacksModMenus.CACTUS, KnapsackScreen::cactus);
	}
}
