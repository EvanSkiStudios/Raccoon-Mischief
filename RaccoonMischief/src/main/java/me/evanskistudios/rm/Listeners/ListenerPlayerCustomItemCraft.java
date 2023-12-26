package me.evanskistudios.rm.Listeners;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import static me.evanskistudios.rm.Utilis.UtilityMethods.Choose;

public class ListenerPlayerCustomItemCraft implements Listener {
    RaccoonMischief plugin;
    public int AmountCrafted(CraftItemEvent event, Player player){
        int amount;
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

        return amount;
//GET AMOUNT OF ITEMS CRAFTED
    }

    public boolean GetItemTag(ItemStack item, String namespace_key){
        ItemMeta ResultMeta = item.getItemMeta();
        PersistentDataContainer Data = ResultMeta.getPersistentDataContainer();

        Plugin namespace = RaccoonMischief.getPlugin();
        NamespacedKey NameSpaceKey = new NamespacedKey(namespace, namespace_key);
        return (Data.has(NameSpaceKey, PersistentDataType.DOUBLE));
    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        if (event.isCancelled()) {
            return;
        }

        if (event.getWhoClicked() instanceof Player player) {

            ItemStack CraftResult = event.getRecipe().getResult();

            //Tactical dirt
            if (CraftResult.getType() == Material.BAKED_POTATO) {
                //Get meta of potato to see if its tactical dirt
                ItemMeta ResultMeta = CraftResult.getItemMeta();
                PersistentDataContainer Data = ResultMeta.getPersistentDataContainer();

                Plugin namespace = RaccoonMischief.getPlugin();
                NamespacedKey NameSpaceKey = new NamespacedKey(namespace, "ndirt_eat");
                if (Data.has(NameSpaceKey, PersistentDataType.DOUBLE)) {

                    int amount = AmountCrafted(event, player);
                    for (int i = 0; i < amount; ++i) {
                        player.getInventory().removeItem(CraftResult); //remove players copy, they are going to get it again below
                    }

                    for (Player p : RaccoonMischief.getPlugin().getServer().getOnlinePlayers()) {
                        for (int i = 0; i < amount; ++i) {
                            p.getInventory().addItem(CraftResult);
                        }

                        String[] Sounds = {
                            "custom.crafting.tacticaldirt_evan",
                            "custom.crafting.tacticaldirt_merc"
                        };

                        String sound = "" + Choose(Sounds);

                        p.playSound(player.getLocation(),sound, 1.0f, 1.0f);
                    }
                }
            }

            //XP Orb
            if (CraftResult.getType() == Material.CHORUS_FRUIT) {
                if (GetItemTag(CraftResult, "exp_crystal")){
                    int amount = AmountCrafted(event, player);

                    float xp = player.getExp();
                    float xp_level = player.getLevel();

                    //set player level progress to 0
                    player.setExp(0.0f);
                    if (xp_level >= amount) {
                        for (int i = 0; i < amount; ++i) {
                            player.giveExpLevels(-1);
                            xp_level = player.getLevel();
                        }
                        player.playSound(player.getLocation(),"minecraft:entity.player.levelup", 1.0f, 1.0f);
                    }else{
                        event.setCancelled(true);
                        player.sendMessage(ChatColor.RED+"Not enough experience levels to craft!");
                    }
                    //reset player level progress
                    player.setExp(xp);
                }
            }

        }
    }
}