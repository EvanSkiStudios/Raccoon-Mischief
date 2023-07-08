package me.evanskistudios.rm.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class ListenerPlayerItemConsume implements Listener {
    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {
        if (event.isCancelled()) return;
    }
}