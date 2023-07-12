package me.evanskistudios.rm.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.entity.EntityType.*;


enum RC_EVENT{
    Normal,
    Milk,
    Snow
}

public class ListenerPlayerInteractEntity implements Listener {

    public static EntityType[] MilkableEntity = {PLAYER, LLAMA};

    @EventHandler
    public void onUseEntity(PlayerInteractEntityEvent event) {
        if (event.isCancelled()) return;

        //Event fires for both hands
        if (! (event.getHand().equals(EquipmentSlot.HAND)) ) return;


        Player player = event.getPlayer();
        Entity RightClickedEntity = event.getRightClicked();

        RC_EVENT ENTITY_EVENT = RC_EVENT.Normal;
        boolean CheckEvent = false;


        //Check entity
        if (!(CheckEvent)) {
            for (EntityType MilkEntity : MilkableEntity) {
                if (RightClickedEntity.getType() == MilkEntity) {
                    ENTITY_EVENT = RC_EVENT.Milk;
                    CheckEvent = true;
                    break;
                }
            }
        }

        if (!(CheckEvent)) {
            if (RightClickedEntity instanceof Snowman) {
                ENTITY_EVENT = RC_EVENT.Snow;
                CheckEvent = true;
            }
        }

        if (CheckEvent) {
            event.setCancelled(true); //stop normal event and do our own thing

            switch (ENTITY_EVENT) {

                default:
                case Normal: //IDK why we would ever do this, but it's good to have edge cases
                    break;

                case Milk: {
                    //if milk-able entity
                    ItemStack HeldItem = player.getInventory().getItemInMainHand();
                    Material HeldItemType = HeldItem.getType();
                    if (HeldItemType == Material.BUCKET) {

                        ItemStack MilkBucket = new ItemStack(Material.MILK_BUCKET);

                        int HeldItemAmount = HeldItem.getAmount();
                        if (HeldItemAmount != 1) {
                            player.getInventory().addItem(MilkBucket);
                            player.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET, HeldItemAmount - 1));
                        } else {
                            //replaces the bucket if its just 1
                            player.getInventory().setItemInMainHand(MilkBucket);
                        }
                        player.playSound(player.getLocation(), "minecraft:entity.cow.milk", 1.0f, 1.0f);
                        //If in creative, you will only get 1 milk-bucket, and after it won't give you a new one, this is not a bug, it's a feature of vanilla minecraft
                    }
                }
                break;

                case Snow: {
                    //if Snow
                    ItemStack HeldItem = player.getInventory().getItemInMainHand();
                    Material HeldItemType = HeldItem.getType();
                    if (HeldItemType == Material.BUCKET) {
                        ItemStack SnowBucket = new ItemStack(Material.POWDER_SNOW_BUCKET);

                        int HeldItemAmount = HeldItem.getAmount();
                        if (HeldItemAmount != 1) {
                            player.getInventory().addItem(SnowBucket);
                            player.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET, HeldItemAmount - 1));
                        } else {
                            //replaces the bucket if its just 1
                            player.getInventory().setItemInMainHand(SnowBucket);
                        }

                        player.playSound(player.getLocation(), "minecraft:item.bucket.fill_powder_snow", 1.0f, 1.0f);
                    }
                }
                break;

            }
        }
    }
}
