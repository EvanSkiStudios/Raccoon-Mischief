package me.evanskistudios.rm.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EntityEquipment;

public class ListenerEntityDeath implements Listener {

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



    @EventHandler
    public void onMobDeath(EntityDeathEvent event) {
        LivingEntity Entity = event.getEntity();

        ModifyDropChance(Entity);
    }
}
