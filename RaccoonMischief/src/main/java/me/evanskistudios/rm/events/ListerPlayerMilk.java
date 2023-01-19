package me.evanskistudios.rm.events;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ListerPlayerMilk implements Listener {
    @EventHandler
    public void onUseEntity(PlayerInteractEntityEvent event) {
        if (event.isCancelled()) return;

        Player player = event.getPlayer();
        Entity RightClickedEntity = event.getRightClicked();

        boolean Milk_entity = false;
        //Check entity
        if (RightClickedEntity instanceof Llama) Milk_entity = true;
        if (RightClickedEntity instanceof Player) Milk_entity = true;

        //if milk-able entity
        if (Milk_entity) {
            ItemStack HeldItem = player.getInventory().getItemInMainHand();
            Material HeldItemType = HeldItem.getType();
            if (HeldItemType == Material.BUCKET) {
                event.setCancelled(true); //stop normal event and do our own thing

                ItemStack MilkBucket = new ItemStack(Material.MILK_BUCKET);

                int HeldItemAmount = HeldItem.getAmount();
                if (HeldItemAmount != 1) {
                    player.getInventory().addItem(MilkBucket);
                    player.getInventory().setItemInMainHand(new ItemStack(HeldItemType, HeldItemAmount - 1));
                }else{
                    //replaces the bucket if its just 1
                    player.getInventory().setItemInMainHand(MilkBucket);
                }

                player.playSound(player.getLocation(), "minecraft:entity.cow.milk", 1.0f, 1.0f);
                //If in creative, you will only get 1 milk-bucket, and after it won't give you a new one, this is not a bug, it's a feature of vanilla minecraft
            }
        }
    }
}
