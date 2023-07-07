package net.mcreator.oddsknapsacks.core;

import net.mcreator.oddsknapsacks.init.OddsKnapsacksModMenus;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.inventory.MenuType;

public class KnapsackType {

    public final String typeID;
    public final int slotCollumns;
    public final int slotRows;
    public final int inventoryXOff;
    public final int inventoryYOff;
    public final String textureID;
    public final int textureWidth;
    public final int textureHeight;

    public KnapsackType(String typeID, int slotCollumns, int slotRows, int inventoryXOff, int inventoryYOff, String textureID, int textureWidth, int textureHeight) {
        this.typeID = typeID;

        this.slotCollumns = slotCollumns;
        this.slotRows = slotRows;

        //Player inventory offset, mainly used for netherite/grand knapsack
        this.inventoryXOff = inventoryXOff;
        this.inventoryYOff = inventoryYOff;

        this.textureID = textureID;
        this.textureHeight = textureHeight;
        this.textureWidth = textureWidth;
    }

    public KnapsackType(String typeID, int slotCollumns, int slotRows, String textureID, int textureWidth, int textureHeight) {
        this(typeID, slotCollumns, slotRows, 0, 0, textureID, textureWidth, textureHeight);
    }

    public MenuType<?> getMenuType() {
        //return based on ID
        switch (this.typeID) {
            case "MEDIUM" -> {
                return OddsKnapsacksModMenus.MEDIUM;
            }
            case "BIG" -> {
                return OddsKnapsacksModMenus.BIG;
            }
            case "LARGE" -> {
                return OddsKnapsacksModMenus.LARGE;
            }
            case "GRAND" -> {
                return OddsKnapsacksModMenus.GRAND;
            }
            case "CACTUS" -> {
                return OddsKnapsacksModMenus.CACTUS;
            }
            default -> {
                return OddsKnapsacksModMenus.SMALL;
            }
        }
    }

    public SoundEvent getSound(boolean open) {

        switch (this.typeID) {
            case "ENDER" -> {
                if (open) {
                    return SoundEvents.ENDER_CHEST_OPEN;
                } else {
                    return SoundEvents.ENDER_CHEST_CLOSE;
                }
            }
            default -> {
                if (open) {
                    return SoundEvents.BUNDLE_DROP_CONTENTS;
                } else {
                    return SoundEvents.BUNDLE_REMOVE_ONE;
                }
            }
        }
    }

    public static KnapsackType SMALL = new KnapsackType("SMALL", 3, 3, "knapsack_small", 176, 166);
    public static KnapsackType MEDIUM = new KnapsackType("MEDIUM", 5, 3, "knapsack_medium", 176, 166);
    public static KnapsackType BIG = new KnapsackType("BIG", 7, 3, "knapsack_big", 176, 166);
    public static KnapsackType LARGE = new KnapsackType("LARGE", 9, 3, "knapsack_large", 176, 166);
    public static KnapsackType GRAND = new KnapsackType("GRAND", 9, 4, 0, 9, "knapsack_grand", 176, 175);

    public static KnapsackType CACTUS = new KnapsackType("CACTUS", 3, 3, "knapsack_cactus", 176, 166);
    public static KnapsackType ENDER = new KnapsackType("ENDER", 1, 1, "knapsack_small", 176, 166);

}
