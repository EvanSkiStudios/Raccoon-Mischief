package me.evanskistudios.rm.Listeners;

import me.evanskistudios.rm.Enums.InvSlot;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class ListenerPlayerInventory implements Listener {

    @EventHandler
    public void onMenu(InventoryClickEvent event){
        if (event.isCancelled()) return;

        HumanEntity WhoClicked = event.getWhoClicked();
        if (WhoClicked instanceof Player player) {

            Inventory Active_Inventory = event.getClickedInventory();
            Inventory Player_inventory = player.getInventory();

            if (Active_Inventory != null &&
                Active_Inventory == Player_inventory) {

                int Player_helmet_slot = InvSlot.ArmorHelmet.ordinal();

                int Slot = event.getSlot();
                if (Slot == Player_helmet_slot) {
                    event.setCancelled(true);

                    ItemStack item_on_head = Player_inventory.getItem(Player_helmet_slot);

                    ItemStack ClickedItem = event.getCursor();
                    event.setCurrentItem(ClickedItem);

                    player.setItemOnCursor(item_on_head);
                    player.updateInventory();
                }

            }
        }
    }
}
