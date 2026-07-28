package com.dimalab.unlockableinventory.client;

import com.dimalab.unlockableinventory.UnlockableInventory;
import com.dimalab.unlockableinventory.inventory.InventoryLocks;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = UnlockableInventory.MODID,
        value = Dist.CLIENT
)
public class LockOverlayRenderer {

    private static final ResourceLocation LOCK =
            new ResourceLocation(UnlockableInventory.MODID, "textures/gui/lock.png");

    @SubscribeEvent
    public static void onRender(ScreenEvent.Render.Post event) {

        if (!(event.getScreen() instanceof InventoryScreen screen)) {
            return;
        }

        GuiGraphics graphics = event.getGuiGraphics();

        int left = screen.getGuiLeft();
        int top = screen.getGuiTop();

        for (Slot slot : screen.getMenu().slots) {

            // Только основной инвентарь игрока (27 слотов)
            if (InventoryLocks.isLocked(slot)) {

                graphics.blit(
                        LOCK,
                        left + slot.x,
                        top + slot.y,
                        0,
                        0,
                        16,
                        16,
                        16,
                        16
                );
            }
        }
    }
}
