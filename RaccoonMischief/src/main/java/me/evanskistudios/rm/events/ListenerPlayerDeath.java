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

// import java.util.function.Supplier;
// import java.util.logging.Level;

public class ListenerPlayerDeath implements Listener{
    public int DeathCause = 0;
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) return;

        Entity entity = event.getEntity();
        if (entity instanceof Player) {
            Player player = (Player) entity;

            if (event.getFinalDamage() >= player.getHealth()){
                Entity killer = event.getDamager();

                // Plugin namespace = RaccoonMischief.getPlugin();
                // namespace.getLogger().log(Level.INFO, ""+killer);

                if (killer instanceof LlamaSpit) {
                    DeathCause = 1;
                    return;
                }else{
                    DeathCause = 0;
                    return;
                }
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (event.isCancelled()) {
            DeathCause = 0;
            return;
        }

        Player player = event.getPlayer();

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
        switch(DeathCause){
            default:{
                //regular death
                player.playSound(player.getLocation(), "custom.player.no", 1.0f, 1.0f);
            }break;

            case 1:{
                //death by llama
                player.playSound(player.getLocation(), "custom.player.llama", 1.0f, 1.0f);
            }break;
        }
        DeathCause = 0; //reset so we are not stuck with last one played
    }
}
