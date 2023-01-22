package me.evanskistudios.rm.events;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PufferFish;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;

public class ListenerLightning implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if (event.isCancelled()) return;

        Entity DamagedEntity = event.getEntity();

        Plugin plugin = RaccoonMischief.getPlugin(RaccoonMischief.class);
        String PufferfishConvert = "" + plugin.getConfig().get("B_PufferfishConversion");

        if ( (DamagedEntity instanceof PufferFish) && (PufferfishConvert.equalsIgnoreCase("True")) ){

            if (event.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {

                event.setCancelled(true);

                Location EntityLocation = DamagedEntity.getLocation();
                DamagedEntity.getWorld().spawnEntity(EntityLocation, EntityType.GUARDIAN);
                DamagedEntity.remove();
            }
        }
    }
}
