package me.evanskistudios.rm.FoodListeners;

import me.evanskistudios.rm.FoodManager;
import me.evanskistudios.rm.Utilis.UtilityMethods;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class FoodListenerDebugChicken implements Listener{

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        if (event.isCancelled()) return;
        Player player = event.getPlayer();

        ItemStack ConsumedItem = event.getItem();
        if (ConsumedItem.getType() == FoodManager.DebugChicken.getType()){
            ItemMeta ConsumedItem_Meta = ConsumedItem.getItemMeta();
            if (ConsumedItem_Meta == null) { return; }

            if (ConsumedItem_Meta.getPersistentDataContainer().has(FoodManager.NSKEY_DEBUG_CHICKEN, PersistentDataType.DOUBLE)){
                player.setHealth(UtilityMethods.MCHearts(0));
            }
        }
    }
}
