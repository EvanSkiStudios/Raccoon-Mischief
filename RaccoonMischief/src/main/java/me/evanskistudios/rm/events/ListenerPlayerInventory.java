package me.evanskistudios.rm.events;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

enum InvSlot{
    Hotbar0, Hotbar1, Hotbar2, Hotbar3, Hotbar4, Hotbar5, Hotbar6, Hotbar7, Hotbar8,
    Inv9,Inv10,Inv11,Inv12,Inv13,Inv14,Inv15,Inv16,Inv17,Inv18,Inv19,Inv20,Inv21,Inv22,Inv23,Inv24,Inv25,Inv26,Inv27,Inv28,Inv29,Inv30,Inv31,Inv32,Inv33,Inv34,Inv35,
    ArmorBoots, ArmorLeggings, ArmorChest, ArmorHelmet, Sheild
}


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
