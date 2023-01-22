package me.evanskistudios.rm.events;

import me.evanskistudios.rm.RaccoonMischief;
import me.evanskistudios.rm.tasks.TaskPlayerLevitation;
import me.evanskistudios.rm.tasks.TaskRemoveCoolDown;
import me.evanskistudios.rm.utilis.UtilityMethods;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;


public class ListenerXPCrystal implements Listener {

    public static final String[] adjectives = {"Savory", "Sweet", "Sour", "Bitter", "Salty", "Uma-mi", "Rich", "Creamy", "Crunchy", "Chewy", "Tender", "Juicy", "Spicy", "Tangy", "Smoky", "Buttery", "Aromatic", "Earthy", "Nutty", "Herby", "Fruity", "Pungent", "Peppery", "Mild", "Robust", "Complex", "Smooth", "Fresh", "Charred", "Roasted", "Grilled", "Fried", "Marinated", "Brined", "Pickled", "Glazed", "Crispy", "Soft", "Tasty", "Delicate", "Distinct", "Zesty", "Strong", "Mild", "Rich", "Light", "Hearty", "Bold", "Piquant", "Savory-sweet", "Fragrant", "Textured", "Sweet-sour", "Sour-sweet", "Spicy-sweet", "Smoky-sweet", "Aromatic-spicy", "Earthy-nutty", "Herby-spicy", "Fruity-tangy", "Pungent-spicy", "Peppery-spicy", "Mild-spicy", "Robust-smoky", "Complex-spicy", "Smooth-creamy", "Fresh-herby", "Charred-smoky", "Roasted-nutty", "Grilled-smoky", "Fried-crispy", "Marinated-herby", "Brined-salty", "Pickled-sour", "Glazed-sweet", "Crispy-crunchy", "Soft-tender", "Tasty-savory", "Delicate-mild", "Distinct-flavorful", "Zesty-tangy", "Strong-bold", "Mild-subtle", "Rich-decadent", "Light-refreshing", "Hearty-satisfying", "Bold-intense", "Piquant-spicy", "Savory-uma-mi", "Fragrant-aromatic", "Textured-chewy", "Sweet-tart", "Sour-tangy", "Spicy-hot", "Smoky-earthy", "Aromatic-herby", "Earthy-mushroom-y", "Nutty-buttery", "Herby-aromatic", "Fruity-juicy"};

    public boolean is_xpcrystal = false;
    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
        if (event.isCancelled()){
            is_xpcrystal = false;
            return;
        }
        is_xpcrystal = false;

        Player player = event.getPlayer();

        ItemStack ate_item = event.getItem();
        //player.sendMessage(""+ate_item);

        if (ate_item.getType() == Material.CHORUS_FRUIT) {

            ItemMeta ate_item_meta = ate_item.getItemMeta();

            PersistentDataContainer Data = ate_item_meta.getPersistentDataContainer();
            Plugin namespace = RaccoonMischief.getPlugin();
            NamespacedKey tag = new NamespacedKey(namespace, "exp_crystal");

            if (Data.has(tag, PersistentDataType.DOUBLE)) {
                //is special
                is_xpcrystal = true;
            }
        }

        if (is_xpcrystal){
            float xp = player.getExp();

            player.giveExpLevels(1);

            player.setExp(xp);

            player.playSound(player.getLocation(),"minecraft:entity.player.levelup", 1.0f, 1.0f);

            //set exp is in progress not amount - give xp is for amount, xp crystal will always give 1 level

            Object adjective = UtilityMethods.Choose(List.of(adjectives));
            String string = "Tastes "+adjective;

            player.sendMessage(ChatColor.ITALIC+""+ChatColor.BLUE+""+string);

            RaccoonMischief namespace = RaccoonMischief.getPlugin();
            BukkitTask TaskRemoveCoolDown = (BukkitTask) new TaskRemoveCoolDown(namespace, player, Material.CHORUS_FRUIT).runTask(namespace);
        }

    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event) {
        if (event.isCancelled()){
            is_xpcrystal = false;
            return;
        }

        //turn off the teleport if it's a xp crystal
        if (event.getCause() == PlayerTeleportEvent.TeleportCause.CHORUS_FRUIT){
            if (is_xpcrystal) {
                event.setCancelled(true);
            }
        }

        is_xpcrystal = false;
    }

}
