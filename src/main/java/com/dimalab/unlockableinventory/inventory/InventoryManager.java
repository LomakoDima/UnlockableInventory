package com.dimalab.unlockableinventory.inventory;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

public final class InventoryManager {

    private InventoryManager() {
    }

    public static int findFirstUnlockedSlot(Inventory inventory, ItemStack stack) {

        // Сначала ищем место только в хотбаре
        for (int i = 0; i < 9; i++) {
            if (inventory.getItem(i).isEmpty()) {
                return i;
            }
        }

        return -1;
    }
}