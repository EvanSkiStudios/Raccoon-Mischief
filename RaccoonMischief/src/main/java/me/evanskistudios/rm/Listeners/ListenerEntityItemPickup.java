package me.evanskistudios.rm.Listeners;

import me.evanskistudios.rm.Enums.InvSlot;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ListenerEntityItemPickup implements Listener {
    @EventHandler
    public void onPickup(EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        Random random = new Random();
        int randomNumber = random.nextInt(100);
        if (randomNumber != 0) return;

        Player player = (Player) event.getEntity();

        ItemStack[] InventoryContents = player.getInventory().getContents();
        for (int i = 0; i < InventoryContents.length; ++i) {
            if (InventoryContents[i] == null) {
                if ( (i > InvSlot.Hotbar8.ordinal()) && (i < InvSlot.ArmorBoots.ordinal()) ) {
                    player.getInventory().setItem(i, new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1));
                    break;
                }
            }
        }
    }
}