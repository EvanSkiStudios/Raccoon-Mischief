package me.evanskistudios.rm.events;

import me.evanskistudios.rm.EnchantmentManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ListenerItemDespawn implements Listener{
    @EventHandler
    public void onDespawn(ItemDespawnEvent event){
        ItemStack Item = event.getEntity().getItemStack();

        ItemMeta ItemMeta = Item.getItemMeta();
        if (ItemMeta != null) {
            //if soulbound item is somehow lying around, prevent it from despawning
            if (ItemMeta.hasEnchant(EnchantmentManager.SOULBOUND)) {
                event.setCancelled(true);
            }
        }
    }
}
