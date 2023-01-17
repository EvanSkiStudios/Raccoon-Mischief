package me.evanskistudios.rm.events;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;

public class ListenerMilkPotion implements Listener{
    @EventHandler
    public void PotionSplash(PotionSplashEvent event){
        if (event.isCancelled()) return;

        ThrownPotion potion = event.getPotion();

        ItemStack item = potion.getItem();
        ItemMeta meta = item.getItemMeta();

        PersistentDataContainer Data = meta.getPersistentDataContainer();

        Plugin namespace = RaccoonMischief.getPlugin();
        NamespacedKey NameSpaceKey = new NamespacedKey(namespace, "milk_potion");
        if (Data.has(NameSpaceKey,PersistentDataType.DOUBLE)){
            //Remove effects
            for(LivingEntity entity : event.getAffectedEntities()){
                for (PotionEffect effect : entity.getActivePotionEffects()) {
                    entity.removePotionEffect(effect.getType());
                }
            }
        }
    }
}

