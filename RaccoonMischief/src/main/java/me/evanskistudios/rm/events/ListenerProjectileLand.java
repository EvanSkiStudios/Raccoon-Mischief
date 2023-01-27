package me.evanskistudios.rm.events;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.ThrowableProjectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.projectiles.ProjectileSource;

public class ListenerProjectileLand implements Listener {
    @EventHandler
    public void onLand(ProjectileHitEvent event){
        if (event.isCancelled()) return;

        Entity entity = event.getEntity();

        if (entity instanceof Snowball){

            ThrowableProjectile Snowball = (Snowball) entity;
            ItemStack item = Snowball.getItem();
            ItemMeta meta = item.getItemMeta();

            if (meta == null) return;

            PersistentDataContainer Data = meta.getPersistentDataContainer();

            Plugin namespace = RaccoonMischief.getPlugin();
            NamespacedKey NameSpaceKey = new NamespacedKey(namespace, "brick");
            if (Data.has(NameSpaceKey, PersistentDataType.DOUBLE)) {

                ProjectileSource Shooter = ((Snowball) entity).getShooter();
                if (Shooter instanceof Player) {
                    Player player = (Player) Shooter;

                    Block HitBlock = event.getHitBlock();

                    if (HitBlock != null) {
                        Material Block = HitBlock.getType();

                        Material Glass = Material.GLASS;

                        if (Block.equals(Glass)) {
                            HitBlock.breakNaturally(new ItemStack(Material.AIR));

                            player.playSound(player.getLocation(), "minecraft:block.glass.break", 1.0f, 1.0f);

                            Particle particle = Particle.BLOCK_DUST;
                            BlockData particleData = Material.GLASS.createBlockData();

                            double coord_x = HitBlock.getLocation().getX() + 0.50;
                            double coord_y = HitBlock.getLocation().getY() + 0.50;
                            double coord_z = HitBlock.getLocation().getZ() + 0.50;

                            player.spawnParticle(particle, coord_x,coord_y,coord_z, 50, particleData);
                        }
                    }
                }
            }
        }
    }
}
