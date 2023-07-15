package me.evanskistudios.rm.Listeners;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
public class ListenerEntitySpawn implements Listener {

    @EventHandler
    public void onSpawn(EntitySpawnEvent event){
        Entity SpawnedEntity = event.getEntity();

    }
}
