package me.evanskistudios.rm.Listeners;

import me.evanskistudios.rm.FoodManager;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

import static org.bukkit.entity.EntityType.*;


enum RC_EVENT{
    NORMAL,
    MILK,
    BOTTLE_MILK,
    SADDLE,
    SNOW
}

public class ListenerPlayerInteractEntity implements Listener {

    private static final List<EntityType> DontOverRideEntityEvent = Arrays.asList(COW, GOAT);
    private static final List<EntityType> MilkableEntity = Arrays.asList(COW, GOAT, PLAYER, LLAMA, SQUID);
    private static final List<EntityType> RideableEntity = Arrays.asList(PIG, STRIDER);

    @EventHandler
    public void onUseEntity(PlayerInteractEntityEvent event) {
        if (event.isCancelled()) return;

        EntityType interactedEntity = null;

        //Event fires for both hands
        if (! (event.getHand().equals(EquipmentSlot.HAND)) ) return;

        Player player = event.getPlayer();
        Entity RightClickedEntity = event.getRightClicked();
        EntityType RightClickedEntityType = RightClickedEntity.getType();

        RC_EVENT ENTITY_EVENT = RC_EVENT.NORMAL;

        if (RightClickedEntity instanceof Snowman) {
            ENTITY_EVENT = RC_EVENT.SNOW;
        }

        if (MilkableEntity.contains(RightClickedEntityType)){

            ItemStack HeldItem = player.getInventory().getItemInMainHand();
            Material HeldItemType = HeldItem.getType();

            if (HeldItemType == Material.BUCKET) {
                if (DontOverRideEntityEvent.contains(RightClickedEntityType)){ return; }
                ENTITY_EVENT = RC_EVENT.MILK;
            }
            if (HeldItemType == Material.GLASS_BOTTLE) {
                ENTITY_EVENT = RC_EVENT.BOTTLE_MILK;
            }
        }

//SNEAKING
        Pig interactedEntityPig = null;
        Strider interactedEntityStrider = null;
        if (player.isSneaking()) {
            if (RideableEntity.contains(RightClickedEntityType)) {
                if (RightClickedEntity instanceof Pig RightClickedEntityCast) {
                    if (RightClickedEntityCast.hasSaddle()) {
                        interactedEntityPig = RightClickedEntityCast;
                        ENTITY_EVENT = RC_EVENT.SADDLE;
                    }
                }

                if (RightClickedEntity instanceof Strider RightClickedEntityCast) {
                    if (RightClickedEntityCast.hasSaddle()) {
                        interactedEntityStrider = RightClickedEntityCast;
                        ENTITY_EVENT = RC_EVENT.SADDLE;
                    }
                }
            }

        }
//END
        if (ENTITY_EVENT == RC_EVENT.NORMAL) {
            //basically at this point we arent doing anything so just exit and let MC deal with it
            return;
        }

        event.setCancelled(true); //stop normal event and do our own thing

        switch (ENTITY_EVENT) {
            default -> {} //IDK why we would ever do this, but it's good to have edge cases

            case MILK -> {
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

            case BOTTLE_MILK -> {
                ItemStack MainHandItem = player.getInventory().getItemInMainHand();
                if (MainHandItem.getAmount() > 1){
                    MainHandItem.setAmount(MainHandItem.getAmount() - 1);
                    player.getInventory().addItem(FoodManager.BottleOMilk);
                }else{
                    player.getInventory().setItemInMainHand(FoodManager.BottleOMilk);
                }
                player.playSound(player.getLocation(), "item.bottle.fill", 1.0f, 1.0f);
            }

            case SADDLE -> {
                ItemStack HeldItem = player.getInventory().getItemInMainHand();
                Material HeldItemType = HeldItem.getType();

                if (HeldItemType == Material.AIR) {
                    if (interactedEntityPig != null){
                        interactedEntityPig.setSaddle(false);
                        player.playSound(player.getLocation(), "minecraft:entity.pig.saddle", 1.0f, 1.0f);
                    }
                    if (interactedEntityStrider != null){
                        interactedEntityStrider.setSaddle(false);
                        player.playSound(player.getLocation(), "minecraft:entity.strider.saddle", 1.0f, 1.0f);
                    }
                }
                ItemStack Saddle = new ItemStack(Material.SADDLE, 1);
                player.getInventory().setItemInMainHand(Saddle);
            }

            case SNOW -> {
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

        }
    }
}
