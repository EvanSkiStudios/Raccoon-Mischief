package me.evanskistudios.rm.tasks;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.Random;

public class TaskPlayerLevitation extends BukkitRunnable {
    RaccoonMischief plugin;

    public TaskPlayerLevitation(RaccoonMischief plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for(Player player : plugin.getServer().getOnlinePlayers()) {
            boolean effect = player.hasPotionEffect(PotionEffectType.LEVITATION);
            if (effect) {
                // Player has levitation
                Random rand = new Random();
                float volume = rand.nextFloat();
                player.playSound(player.getLocation(), "custom.player.levitating", volume, 1.0f);
            }
        }
    }
}
