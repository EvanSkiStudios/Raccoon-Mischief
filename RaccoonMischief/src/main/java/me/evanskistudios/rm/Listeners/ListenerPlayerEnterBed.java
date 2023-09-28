package me.evanskistudios.rm.Listeners;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class ListenerPlayerEnterBed implements Listener {
    @EventHandler
    public void onEnterBed(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();

        boolean PlayerIsInEnd = (player.getWorld().getEnvironment() == World.Environment.THE_END);
        boolean PlayerIsInNeather = (player.getWorld().getEnvironment() == World.Environment.NETHER);

        if ( !PlayerIsInEnd && !PlayerIsInNeather ) {
            return;
        }

        //override the bed event
        event.setCancelled(true);
        switch (event.getBedEnterResult()){
            case NOT_POSSIBLE_HERE -> {
                event.setUseBed(Event.Result.ALLOW);
            }

            case NOT_POSSIBLE_NOW, NOT_SAFE, TOO_FAR_AWAY, OTHER_PROBLEM -> {
                event.setUseBed(Event.Result.DENY);
            }
        }
    }
}
