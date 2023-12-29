package me.evanskistudios.rm.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ListenerEntityDeath implements Listener {
    private DeathType ParrotDeathCause = DeathType.Normal;

    public void ModifyDropChance(LivingEntity entity){
        if (entity instanceof Player){
            return;
        }

        if (!(entity instanceof Monster)){
            return;
        }

        EntityEquipment EntityEquip = entity.getEquipment();
        if (EntityEquip != null) {
            if (EntityEquip.getItemInMainHand().getType() != Material.AIR){
                EntityEquip.setItemInMainHandDropChance(1.0f);
            }
            if (EntityEquip.getItemInOffHand().getType() != Material.AIR){
                EntityEquip.setItemInOffHandDropChance(1.0f);
            }

            if (EntityEquip.getHelmet() != null){
                EntityEquip.setHelmetDropChance(1.0f);
            }
            if (EntityEquip.getChestplate() != null){
                EntityEquip.setChestplateDropChance(1.0f);
            }
            if (EntityEquip.getLeggings() != null){
                EntityEquip.setLeggingsDropChance(1.0f);
            }
            if (EntityEquip.getBoots() != null){
                EntityEquip.setBootsDropChance(1.0f);
            }
        }
    }

    public void ParrotChicken(LivingEntity entity, List<ItemStack> drops){
        if (entity instanceof  Parrot parrot){
            if (ParrotDeathCause == DeathType.Fire){
                drops.add( new ItemStack(Material.COOKED_CHICKEN, 1) );
            }else{
                drops.add( new ItemStack(Material.CHICKEN, 1) );
            }
        }
        ParrotDeathCause = DeathType.Normal;
    }

    @EventHandler
    public void onHurt(EntityDamageEvent event) {
        //Fire Drowning Freezing
        if (event.isCancelled()) return;

        Entity entity = event.getEntity();
        if (entity instanceof Parrot parrot) {
            if (event.getFinalDamage() >= parrot.getHealth()) {
                EntityDamageEvent.DamageCause killer = event.getCause();

                switch(killer){
                    case FIRE, FIRE_TICK -> ParrotDeathCause = DeathType.Fire;
                }

            }
        }
    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent event) {
        LivingEntity Entity = event.getEntity();

        ParrotChicken(Entity, event.getDrops());

        ModifyDropChance(Entity);
    }
}
