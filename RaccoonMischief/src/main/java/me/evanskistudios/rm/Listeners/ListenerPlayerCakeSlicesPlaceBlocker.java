package me.evanskistudios.rm.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ListenerPlayerCakeSlicesPlaceBlocker implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (event.isCancelled()) return;

        if ( event.getBlockPlaced().getType() != Material.SWEET_BERRY_BUSH ){
           return;
        }

        ItemStack HeldItem = event.getItemInHand();
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
