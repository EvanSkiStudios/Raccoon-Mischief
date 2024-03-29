package me.evanskistudios.rm.Listeners;

import org.bukkit.entity.*;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Arrays;
import java.util.List;

import static org.bukkit.entity.EntityType.*;

public class ListenerEntityDamage implements Listener {
    private static final List<EntityType> FlameableEntities = Arrays.asList(PHANTOM, CREEPER, SKELETON, ENDERMAN);
    private static final List<EntityType> MoistEntities = Arrays.asList(ENDERMAN);

    @EventHandler
    public void onFire(EntityCombustEvent event){
        if (event.isCancelled()) return;

        Entity BurningEntity = event.getEntity();

        if (FlameableEntities.contains(BurningEntity.getType())){
            event.setCancelled(true);
            BurningEntity.setFireTicks(0);
        }
    }

    @EventHandler
    public void onMobDamage(EntityDamageEvent event) {
        Entity DamagedEntity = event.getEntity();
        EntityDamageEvent.DamageCause DamageCause = event.getCause();

        if (DamageCause == EntityDamageEvent.DamageCause.FIRE) {
            if (FlameableEntities.contains(DamagedEntity.getType())){
                event.setCancelled(true);
            }
        }

        if (DamageCause == EntityDamageEvent.DamageCause.DROWNING){
            if (MoistEntities.contains(DamagedEntity.getType())){
                event.setCancelled(true);
            }
        }
    }
}
