package me.evanskistudios.rm.events;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class ListenerPlayerConnect implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Plugin plugin = RaccoonMischief.getPlugin(RaccoonMischief.class);
        String CustomMessage = "" + plugin.getConfig().get("B_CustomPlayerJoinLeaveMessages");
        if (CustomMessage.equalsIgnoreCase("True")) {

            Player player = event.getPlayer();

            String Player_name = player.getName();

            event.setJoinMessage(ChatColor.YELLOW + "Welcome to HELL, " + Player_name + "!");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Plugin plugin = RaccoonMischief.getPlugin(RaccoonMischief.class);
        String CustomMessage = "" + plugin.getConfig().get("B_CustomPlayerJoinLeaveMessages");
        if (CustomMessage.equalsIgnoreCase("True")) {

            Player player = event.getPlayer();

            String Player_name = player.getName();

            event.setQuitMessage(ChatColor.YELLOW + "" + Player_name + " Escaped!");

        }
    }

}
