package me.evanskistudios.rm.Listeners;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.Effect;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.util.Collection;

import static me.evanskistudios.rm.Utilis.UtilityMethods.Choose;

public class ListenerMobSpawn implements Listener {
    RaccoonMischief plugin;
    public ListenerMobSpawn(RaccoonMischief plugin) {
        this.plugin = plugin;
    }
    public static final PotionEffectType[] PotionEffects = PotionEffectType.values();

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event) {
        Entity SpawnedEntity = event.getEntity();

        if (SpawnedEntity instanceof Creeper Crep){
           // if (( Crep.getWorld().getBlockAt(Crep.getLocation()).getLightFromSky() ) >= 15) {
                PotionEffect Effect = new PotionEffect((PotionEffectType) Choose(PotionEffects), 9600, 3);
                Crep.addPotionEffect(Effect);
                Crep.setPowered(true);
                //Crep.getWorld().strikeLightning(Crep.getLocation());
            //}
        }
    }

    @EventHandler
    public void onMobDeath(EntityDamageEvent event) {
        Entity DamagedEntity = event.getEntity();

        if (DamagedEntity instanceof Creeper Crep){
            //EntityDamageEvent.DamageCause DamageCause = event.getCause();
            event.setCancelled(true);

            // accidentally had this inverted, so it only let lightning and fire damage creepers
//            if ( (DamageCause == EntityDamageEvent.DamageCause.LIGHTNING) || (DamageCause == EntityDamageEvent.DamageCause.FIRE)){
//                event.setCancelled(true);
//            }
            // Make creepers always explode
//            if (DamageCause == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION){
//                Crep.setExplosionRadius(12);
                Crep.setMaxFuseTicks(1);
                Crep.setFuseTicks(1);
                Crep.ignite();
//            }
        }
    }
}
