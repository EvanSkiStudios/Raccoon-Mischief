package me.evanskistudios.rm.events;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class ListenerMobSpawn implements Listener {
    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event) {

        Entity SpawnedEntity = event.getEntity();

        if (SpawnedEntity instanceof Creeper Crep){
            if (( Crep.getWorld().getBlockAt(Crep.getLocation()).getLightFromSky() ) <= 15) {
                Crep.getWorld().strikeLightning(Crep.getLocation());
            }
        }
    }
}
