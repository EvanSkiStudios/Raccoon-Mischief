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

public class ListenerEntityFire implements Listener {
    private static final List<EntityType> FlameableEntities = Arrays.asList(PHANTOM, CREEPER, SKELETON);

    @EventHandler
    public void onFire(EntityCombustEvent event){
        if (event.isCancelled()) return;

        Entity BurningEntity = event.getEntity();

        if (FlameableEntities.contains(BurningEntity.getType())){
       // if ( (BurningEntity instanceof Phantom) || (BurningEntity instanceof Creeper)  || (BurningEntity instanceof Skeleton) ){
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
    }
}
