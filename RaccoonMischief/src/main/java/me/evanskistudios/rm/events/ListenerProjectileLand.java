package me.evanskistudios.rm.events;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.projectiles.ProjectileSource;

import static me.evanskistudios.rm.utilis.UtilityMethods.MCHearts;


public class ListenerProjectileLand implements Listener {
    @EventHandler
    public void onLand(ProjectileHitEvent event) {
        if (event.isCancelled()) return;

        Entity Projectile = event.getEntity();

        if (Projectile instanceof Snowball) {
            //Get shooter
            ThrowableProjectile Snowball = (Snowball) Projectile;
            ProjectileSource Shooter = Snowball.getShooter();

            //Check if brick
            ItemStack item = Snowball.getItem();
            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer Data = meta.getPersistentDataContainer();
            Plugin namespace = RaccoonMischief.getPlugin();
            NamespacedKey NameSpaceKey = new NamespacedKey(namespace, "brick");
            //if custom brick throwable
            if (Data.has(NameSpaceKey, PersistentDataType.DOUBLE)) {

                //if we hit an entity, do damage
                Entity HitEntity = event.getHitEntity();
                if (HitEntity != null) {
                    if (HitEntity instanceof LivingEntity LiveEntity) {
                        double HP = LiveEntity.getHealth();
                        double BrickDamage = MCHearts(1.5);

                        if (HP >= BrickDamage) {
                            LiveEntity.setHealth(HP - BrickDamage);
                        } else {
                            //take rest of health away
                            LiveEntity.setHealth(HP - (BrickDamage + (HP - BrickDamage)));
                        }
                    }
                    return;
                }

                //if shooter was player
                if (Shooter instanceof Player player) {

                    //if hit a block
                    Block HitBlock = event.getHitBlock();
                    if (HitBlock != null) {
                        Material Block = HitBlock.getType();

                        Material[] GlassBlocks = {Material.TINTED_GLASS, Material.GLASS, Material.WHITE_STAINED_GLASS, Material.ORANGE_STAINED_GLASS, Material.MAGENTA_STAINED_GLASS, Material.LIGHT_BLUE_STAINED_GLASS, Material.YELLOW_STAINED_GLASS, Material.LIME_STAINED_GLASS, Material.PINK_STAINED_GLASS, Material.GRAY_STAINED_GLASS, Material.LIGHT_GRAY_STAINED_GLASS, Material.CYAN_STAINED_GLASS, Material.PURPLE_STAINED_GLASS, Material.BLUE_STAINED_GLASS, Material.BROWN_STAINED_GLASS, Material.GREEN_STAINED_GLASS, Material.RED_STAINED_GLASS, Material.BLACK_STAINED_GLASS, Material.GLASS_PANE, Material.WHITE_STAINED_GLASS_PANE, Material.ORANGE_STAINED_GLASS_PANE, Material.MAGENTA_STAINED_GLASS_PANE, Material.LIGHT_BLUE_STAINED_GLASS_PANE, Material.YELLOW_STAINED_GLASS_PANE, Material.LIME_STAINED_GLASS_PANE, Material.PINK_STAINED_GLASS_PANE, Material.GRAY_STAINED_GLASS_PANE, Material.LIGHT_GRAY_STAINED_GLASS_PANE, Material.CYAN_STAINED_GLASS_PANE, Material.PURPLE_STAINED_GLASS_PANE, Material.BLUE_STAINED_GLASS_PANE, Material.BROWN_STAINED_GLASS_PANE, Material.GREEN_STAINED_GLASS_PANE, Material.RED_STAINED_GLASS_PANE, Material.BLACK_STAINED_GLASS_PANE};

                        boolean Block_is_glass = false;

                        for (Material glassBlock : GlassBlocks) {
                            if (Block.equals(glassBlock)) {
                                Block_is_glass = true;
                                break;
                            }
                        }

                        if (Block_is_glass) {
                            Particle particle = Particle.BLOCK_DUST;
                            BlockData particleData = Block.createBlockData();

                            HitBlock.breakNaturally(new ItemStack(Material.AIR));

                            player.playSound(player.getLocation(), "minecraft:block.glass.break", 1.0f, 1.0f);

                            double coord_x = HitBlock.getLocation().getX() + 0.50;
                            double coord_y = HitBlock.getLocation().getY() + 0.50;
                            double coord_z = HitBlock.getLocation().getZ() + 0.50;

                            player.spawnParticle(particle, coord_x, coord_y, coord_z, 50, particleData);
                        }

                        //play brick impact sound
                        player.playSound(Projectile.getLocation(), "minecraft:block.stone.break", 1.0f, 1.0f);
                    }
                    //was a player
                    return;
                }
            }

            //ITs not a brick
            if (!(Shooter instanceof Player player)) {
                //if hit an entity, do damage
                Entity HitEntity = event.getHitEntity();
                if (HitEntity != null) {
                    if (HitEntity instanceof LivingEntity LiveEntity) {
                        double HP = LiveEntity.getHealth();
                        double Damage = MCHearts(1);

                        if (HP >= Damage) {
                            LiveEntity.setHealth(HP - Damage);
                        } else {
                            //take rest of health away
                            LiveEntity.setHealth(HP - (Damage + (HP - Damage)));
                        }
                    }
                }
            }


        }
        //is not a snowball
        return;
    }
}