package com.dimalab.unlockableinventory.mixin;

import com.dimalab.unlockableinventory.inventory.InventoryLocks;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Inventory.class)
public abstract class InventoryMixin {

    /**
     * Возвращает первый свободный РАЗРЕШЁННЫЙ слот.
     */
    @Overwrite
    public int getFreeSlot() {

        Inventory inventory = (Inventory) (Object) this;

        // Сначала хотбар
        for (int i = 0; i < 9; i++) {
            if (inventory.items.get(i).isEmpty()) {
                return i;
            }
        }

        // Затем только открытые слоты основного инвентаря
        for (int i = 9; i < inventory.items.size(); i++) {

            if (!InventoryLocks.isLockedIndex(i)
                    && inventory.items.get(i).isEmpty()) {
                return i;
            }
        }

        return -1;
    }
}