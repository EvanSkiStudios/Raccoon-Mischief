package me.evanskistudios.rm.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ListenerPlayerConnect implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        String Player_name = player.getName();

        event.setJoinMessage(ChatColor.YELLOW + "Welcome to HELL, " + Player_name + "!");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        String Player_name = player.getName();

        event.setQuitMessage(ChatColor.YELLOW + "" + Player_name + " Escaped!");
    }

}
