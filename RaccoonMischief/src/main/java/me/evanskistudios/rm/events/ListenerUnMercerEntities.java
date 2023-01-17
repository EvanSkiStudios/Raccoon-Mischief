package me.evanskistudios.rm.events;

import org.bukkit.entity.Drowned;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Warden;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class ListenerUnMercerEntities implements Listener {
    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event) {
        Entity SpawnedEntity = event.getEntity();

        if (SpawnedEntity instanceof Drowned) event.setCancelled(true); //Gets rid of all the Drown that lag the game completely
        if (SpawnedEntity instanceof Warden) event.setCancelled(true); //No
    }
}
