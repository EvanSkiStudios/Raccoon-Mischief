package me.evanskistudios.rm.events;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

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
                System.out.println(""+killer);
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
        if (event.isCancelled()){
            DeathCause = 0;
            return;
        }

        Player player = event.getPlayer();

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

        DeathCause = 0;
    }
}
