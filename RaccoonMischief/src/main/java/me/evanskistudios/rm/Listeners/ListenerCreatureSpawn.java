package me.evanskistudios.rm.Listeners;

import me.evanskistudios.rm.EnchantManager;
import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListenerCreatureSpawn implements Listener {

    public static ItemStack CraftExplosiveBow(ItemStack OldBow){
        Plugin plugin = RaccoonMischief.getPlugin(RaccoonMischief.class);

        ItemStack NewBowBecauseItWontDuckingAddItTOTheSpawnedOne = new ItemStack(Material.BOW, 1);
        NewBowBecauseItWontDuckingAddItTOTheSpawnedOne.addUnsafeEnchantment(EnchantManager.EXPLOSIVE, 1);
        ItemMeta BowMeta = NewBowBecauseItWontDuckingAddItTOTheSpawnedOne.getItemMeta();

        // NBT
        NamespacedKey key = new NamespacedKey(plugin, "Explosive_Bow");
        BowMeta.getPersistentDataContainer().set(key, PersistentDataType.DOUBLE, 1.0);

        // Create lore
        List<String> Lore = new ArrayList<String>();
        Lore.add(ChatColor.GRAY + "" + "Explosive" + " ");

        // get old lore
        if ( (OldBow.getItemMeta() != null) && (OldBow.getItemMeta().hasLore()) ) {
            List<String> itemLore = OldBow.getItemMeta().getLore();
            if (itemLore != null) {
                Lore.addAll(itemLore);
            }
        }
        // Add lore
        BowMeta.setLore(Lore);
        NewBowBecauseItWontDuckingAddItTOTheSpawnedOne.setItemMeta(BowMeta);

        // Give new bow
        return NewBowBecauseItWontDuckingAddItTOTheSpawnedOne;
    }

    public void RPGEquipmentLoot(LivingEntity entity){
        Random random = new Random();
        //25% chance
        if (random.nextInt(11) >= 5) return;

        EntityEquipment EntityEquip = entity.getEquipment();
        if (EntityEquip != null) {
            ItemStack MainHandItem = EntityEquip.getItemInMainHand();
            ItemStack OffHandItem = EntityEquip.getItemInOffHand();

            if (MainHandItem.getType() != Material.AIR){
                if (MainHandItem.getType() == Material.BOW){
                    if (random.nextInt(100) == 1) {
                        ItemStack newBow = CraftExplosiveBow(MainHandItem);
                        EntityEquip.setItemInMainHand(newBow);
                    }
                }
            }
            if (OffHandItem.getType() != Material.AIR){
                if (random.nextInt(100) == 1) {
                    ItemStack newBow = CraftExplosiveBow(OffHandItem);
                    EntityEquip.setItemInOffHand(newBow);
                }
            }

            if (EntityEquip.getHelmet() != null){

            }
            if (EntityEquip.getChestplate() != null){

            }
            if (EntityEquip.getLeggings() != null){

            }
            if (EntityEquip.getBoots() != null){

            }
        }
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event){
        LivingEntity SpawnedEntity = event.getEntity();

        RPGEquipmentLoot(SpawnedEntity);
    }
}
