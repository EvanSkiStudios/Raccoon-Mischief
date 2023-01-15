package me.evanskistudios.rm.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class ListenerPlayerDeath implements Listener{
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getPlayer();
        player.playSound( player.getLocation(), "custom.player.no", 1.0f, 1.0f);
    }
}
