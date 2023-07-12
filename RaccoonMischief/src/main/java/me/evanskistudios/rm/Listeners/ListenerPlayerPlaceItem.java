package me.evanskistudios.rm.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ListenerPlayerPlaceItem implements Listener {
    @EventHandler
    public void onPlace(PlayerInteractEvent event) {
        if (event.isCancelled()) return;

        ItemStack HeldItem = event.getItem();
        if (HeldItem == null) return;

        Material HeldItemType = HeldItem.getType();
        if (HeldItemType != Material.SWEET_BERRIES) return;

        ItemMeta SweetBerryMeta = HeldItem.getItemMeta();
        if (SweetBerryMeta != null) {
            if (SweetBerryMeta.hasCustomModelData()) {
                int is_cake = SweetBerryMeta.getCustomModelData();

                if (is_cake == 1) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
