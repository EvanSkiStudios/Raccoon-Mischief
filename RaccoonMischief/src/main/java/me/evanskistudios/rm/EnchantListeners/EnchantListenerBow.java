package me.evanskistudios.rm.EnchantListeners;

import me.evanskistudios.rm.EnchantManager;
import me.evanskistudios.rm.RaccoonMischief;
import me.evanskistudios.rm.Utilis.MyMetadata;
import org.bukkit.World;
import org.bukkit.block.Block;
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
import org.bukkit.plugin.Plugin;

public class EnchantListenerBow implements Listener {

    private final Plugin plugin = RaccoonMischief.getPlugin();

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
                Projectile.setMetadata("Explosive_Arrow", new MyMetadata(plugin, "Explosive_Arrow"));
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event){
        Entity Projectile = event.getEntity();
        if (Projectile instanceof Arrow) {
            if (Projectile.hasMetadata("Explosive_Arrow")){
                Block HitBlock = event.getHitBlock();
                if (HitBlock != null){
                    World w = Projectile.getWorld();
                    TNTPrimed tnt = (TNTPrimed) w.spawnEntity(HitBlock.getLocation(), EntityType.PRIMED_TNT);
                    tnt.setFuseTicks(1);
                }
            }
        }
    }
}
