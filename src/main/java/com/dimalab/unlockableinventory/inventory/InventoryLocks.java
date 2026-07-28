package com.dimalab.unlockableinventory.inventory;

import net.minecraft.world.inventory.Slot;

public final class InventoryLocks {

    private InventoryLocks() {
    }

    public static boolean isLocked(Slot slot) {
        return isLockedIndex(slot.index);
    }

    public static boolean isLockedIndex(int index) {
        return index >= 9 && index <= 35;
    }
}