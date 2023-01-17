package me.evanskistudios.rm.events;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.Random;

public class ListenerPlayerCraft  implements Listener {

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        if (event.isCancelled()) {
            return;
        }

        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();


            ItemStack CraftResult = event.getRecipe().getResult();
            if (CraftResult.getType() == Material.BAKED_POTATO) {
                //Get meta of potato to see if its tactical dirt
                ItemMeta ResultMeta = CraftResult.getItemMeta();
                PersistentDataContainer Data = ResultMeta.getPersistentDataContainer();

                Plugin namespace = RaccoonMischief.getPlugin();
                NamespacedKey NameSpaceKey = new NamespacedKey(namespace, "ndirt_eat");
                if (Data.has(NameSpaceKey, PersistentDataType.DOUBLE)) {
                    ClickType clickType = event.getClick();

                    int amount = event.getRecipe().getResult().getAmount();
//GET AMOUNT OF ITEMS CRAFTED
                    if (event.isShiftClick()) {
                        int itemsChecked = 0;
                        int possibleCreations = 1;

                        int amountCanBeMade = 0;

                        for (ItemStack item : event.getInventory().getMatrix()) {
                            if (item != null && item.getType() != Material.AIR) {
                                if (itemsChecked == 0) {
                                    possibleCreations = item.getAmount();
                                    itemsChecked++;
                                } else {
                                    possibleCreations = Math.min(possibleCreations, item.getAmount());
                                }
                            }
                        }

                        int amountOfItems = event.getRecipe().getResult().getAmount() * possibleCreations;

                        ItemStack i = event.getRecipe().getResult();

                        for (int s = 0; s <= player.getInventory().getSize(); s++) {
                            ItemStack test = player.getInventory().getItem(s);
                            if (test == null || test.getType() == Material.AIR) {
                                amountCanBeMade += i.getMaxStackSize();
                                continue;
                            }
                            if (test.isSimilar(i)) {
                                amountCanBeMade += i.getMaxStackSize() - test.getAmount();
                            }
                        }
                        amount = amountOfItems > amountCanBeMade ? amountCanBeMade : amountOfItems;
                    } else {
                        amount = event.getRecipe().getResult().getAmount();
                    }
//GET AMOUNT OF ITEMS CRAFTED
                    // create Random object
                    Random random = new Random();
                    // generate random number from 0 to (bound - 1)
                    int number = random.nextInt(2);

                    for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                        for (int i = 0; i < amount; ++i) {
                            player.getInventory().removeItem(CraftResult); //remove players copy, they are going to get it again below
                            all.getInventory().addItem(CraftResult);
                        }

                        //Sound
                        if (number == 0) {
                            all.playSound(player.getLocation(), "custom.crafting.tacticaldirt_evan", 1.0f, 1.0f);
                        } else {
                            all.playSound(player.getLocation(), "custom.crafting.tacticaldirt_merc", 1.0f, 1.0f);
                        }
                    }
                }
            }
        }
    }
}