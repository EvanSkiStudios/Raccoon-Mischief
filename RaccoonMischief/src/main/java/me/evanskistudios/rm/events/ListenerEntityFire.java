package me.evanskistudios.rm.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Phantom;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;

public class ListenerEntityFire implements Listener {
    @EventHandler
    public void onFire(EntityCombustEvent event){
        if (event.isCancelled()) return;

        Entity BurningEntity = event.getEntity();

        if (BurningEntity instanceof Phantom){
            event.setCancelled(true);
            BurningEntity.setFireTicks(0);
        }
    }
}