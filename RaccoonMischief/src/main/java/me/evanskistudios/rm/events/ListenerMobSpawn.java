package me.evanskistudios.rm.events;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static me.evanskistudios.rm.utilis.UtilityMethods.Choose;

public class ListenerMobSpawn implements Listener {
    public static final PotionEffectType[] PotionEffects = PotionEffectType.values();

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event) {
        Entity SpawnedEntity = event.getEntity();

        if (SpawnedEntity instanceof Creeper Crep){
            if (( Crep.getWorld().getBlockAt(Crep.getLocation()).getLightFromSky() ) <= 15) {

                PotionEffect Effect = new PotionEffect((PotionEffectType) Choose(PotionEffects), 99999, 3);
                Crep.addPotionEffect(Effect);

                Crep.getWorld().strikeLightning(Crep.getLocation());
            }
        }
    }

    @EventHandler
    public void onMobDeath(EntityDamageEvent event) {
        Entity DamagedEntity = event.getEntity();

        if (DamagedEntity instanceof Creeper Crep){
            Crep.setMaxFuseTicks(1);
            Crep.setFuseTicks(1);
            Crep.ignite();
        }
    }
}