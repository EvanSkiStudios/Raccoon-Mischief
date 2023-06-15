package me.evanskistudios.rm.events;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

enum DeathType {
    Normal,
    Llama,
    Creeper,
    Phantom
}

public class ListenerPlayerDeath implements Listener{
    RaccoonMischief plugin;
    public ListenerPlayerDeath(RaccoonMischief plugin) {this.plugin = plugin;}
    public DeathType DeathCause = DeathType.Normal;
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) return;

        Entity entity = event.getEntity();
        if (entity instanceof Player player) {

            if (event.getFinalDamage() >= player.getHealth()){
                Entity killer = event.getDamager();

                // Plugin namespace = RaccoonMischief.getPlugin();
                // namespace.getLogger().log(Level.INFO, ""+killer);

                DeathCause = DeathType.Normal;

                if (killer instanceof LlamaSpit) {
                    DeathCause = DeathType.Llama;
                    return;
                }

                if (killer instanceof Creeper) {
                    DeathCause = DeathType.Creeper;
                    return;
                }

                if (killer instanceof Phantom) {
                    DeathCause = DeathType.Phantom;
                    return;
                }
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        //players Drop Strange meat
        ItemStack Strange_meat = new ItemStack(Material.BEEF);
        ItemMeta Strange_meat_meta = Strange_meat.getItemMeta();
        Strange_meat_meta.setDisplayName(ChatColor.RESET+"Strange Meat");
        Strange_meat.setItemMeta(Strange_meat_meta);

        player.getWorld().dropItem(player.getLocation().add(0,1,0), Strange_meat);


        Plugin plugin = RaccoonMischief.getPlugin(RaccoonMischief.class);
        String DropSkulls = "" + plugin.getConfig().get("B_PlayersDropSkulls");
        if (DropSkulls.equalsIgnoreCase("True")) {
            //Player head
            ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta PlayerHead_meta = (SkullMeta) PlayerHead.getItemMeta();
            PlayerHead_meta.setOwner(player.getName());

            PlayerHead.setItemMeta(PlayerHead_meta);

            player.getWorld().dropItem(player.getLocation().add(0, 1, 0), PlayerHead);
        }

        //Custom death sounds
        switch (DeathCause) {
            default -> {
                //regular death
                player.playSound(player.getLocation(), "custom.player.no", 1.0f, 1.0f);
            }
            case Llama -> {
                //death by llama
                player.playSound(player.getLocation(), "custom.player.llama", 1.0f, 1.0f);
            }
            case Creeper -> {
                //death by creeper
                String orgDeathMessage = event.getDeathMessage();
                if (orgDeathMessage == null) return;
                orgDeathMessage = orgDeathMessage.replace("up ","");
                event.setDeathMessage(orgDeathMessage);
                //play normal no sound
                player.playSound(player.getLocation(), "custom.player.no", 1.0f, 1.0f);
            }
            case Phantom -> {
                //death by Phantom
                event.setDeathMessage(player.getName() + " got Vectored!");
                //play normal no sound
                player.playSound(player.getLocation(), "custom.hostile.vector.kill", 1.0f, 1.0f);
            }
        }
        DeathCause = DeathType.Normal; //reset so we are not stuck with last one played
    }
}
