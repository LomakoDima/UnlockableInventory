package com.dimalab.unlockableinventory.mixin;

import com.dimalab.unlockableinventory.inventory.InventoryLocks;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractContainerScreen.class)
public abstract class AbstractContainerScreenMixin {

    @Inject(
            method = "slotClicked",
            at = @At("HEAD"),
            cancellable = true
    )
    private void unlockableinventory$slotClicked(
            Slot slot,
            int slotId,
            int button,
            ClickType clickType,
            CallbackInfo ci
    ) {
        if (slot != null && InventoryLocks.isLocked(slot)) {
            ci.cancel();
        }
    }
}