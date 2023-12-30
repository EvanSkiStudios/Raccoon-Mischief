package me.evanskistudios.rm.EnchantListeners;

import me.evanskistudios.rm.EnchantManager;
import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.Map;

public class EnchantListenerBow implements Listener {

    private final Plugin plugin = RaccoonMischief.getPlugin();
    private final NamespacedKey ExplosiveArrow = new NamespacedKey(plugin, "Explosive_Arrow");
    private final NamespacedKey ExplosivePower = new NamespacedKey(plugin, "Explosive_Power");

    @EventHandler
    public void onShoot(EntityShootBowEvent event){
        if (event.isCancelled()) return;

        ItemStack Bow = event.getBow();
        if (Bow == null) return;
        ItemMeta BowMeta = Bow.getItemMeta();
        if (BowMeta == null) return;

        if (BowMeta.hasEnchant(EnchantManager.EXPLOSIVE)){
            Entity Projectile = event.getProjectile();
            if (Projectile instanceof Arrow) {
                Projectile.getPersistentDataContainer().set(ExplosiveArrow, PersistentDataType.DOUBLE, 1.0);

                int EnchantLevel = 1;
                Map<Enchantment, Integer> BowEnchantments = Bow.getEnchantments();
                for (Map.Entry<Enchantment, Integer> entry : BowEnchantments.entrySet()) {
                    if (entry.getKey() == EnchantManager.EXPLOSIVE){
                        EnchantLevel = entry.getValue();
                        break;
                    }
                }

                Projectile.getPersistentDataContainer().set(ExplosivePower, PersistentDataType.INTEGER, EnchantLevel);
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event){
        Entity arrow = event.getEntity();
        if (arrow instanceof Arrow) {
            PersistentDataContainer ArrowData = arrow.getPersistentDataContainer();
            if (!(ArrowData.has(ExplosiveArrow, PersistentDataType.DOUBLE))) { return; }

            if (ArrowData.get(ExplosiveArrow, PersistentDataType.DOUBLE) == 1.0){
                Block HitBlock = event.getHitBlock();
                if (HitBlock != null){
                    int ExplosiveMulti = 1;
                    if (ArrowData.has(ExplosivePower, PersistentDataType.INTEGER)){
                        ExplosiveMulti = ArrowData.get(ExplosivePower, PersistentDataType.INTEGER);
                    }

                    World w = arrow.getWorld();
                    TNTPrimed tnt = (TNTPrimed) w.spawnEntity(HitBlock.getLocation(), EntityType.PRIMED_TNT);
                    tnt.setFuseTicks(1);
                    ArrowData.remove(ExplosiveArrow);
                }
            }
        }
    }
}
