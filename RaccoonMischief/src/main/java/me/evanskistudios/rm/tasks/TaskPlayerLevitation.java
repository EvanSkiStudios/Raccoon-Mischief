package me.evanskistudios.rm.tasks;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.UUID;

public class TaskPlayerLevitation extends BukkitRunnable {
    RaccoonMischief plugin;

    HashMap<String, Player> affected_players = new HashMap<String, Player>();

    public TaskPlayerLevitation(RaccoonMischief plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for(Player player : plugin.getServer().getOnlinePlayers()) {
            String player_name = player.getDisplayName();

            Object player_in_map = affected_players.get(player_name);

            boolean effect = player.hasPotionEffect(PotionEffectType.LEVITATION);
            if (effect && player_in_map == null) {
                // Player has levitation
                Random rand = new Random();
                float volume = rand.nextFloat();
                player.playSound(player.getLocation(), "custom.player.levitating", volume, 1.0f);

                //add player to map, so they don't get the sound played again
                affected_players.put(player_name, player);
            }else{
                if (!effect){
                    //Remove player from map, so they can get the sound played again
                    affected_players.remove(player_name);
                }
            }
        }
    }
}
