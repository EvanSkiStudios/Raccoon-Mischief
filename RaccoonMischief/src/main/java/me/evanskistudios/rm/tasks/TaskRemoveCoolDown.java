package me.evanskistudios.rm.tasks;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TaskRemoveCoolDown extends BukkitRunnable {

    RaccoonMischief plugin;
    Player player;
    Material Item;

    public TaskRemoveCoolDown(RaccoonMischief plugin, Player player, Material Item) {
        this.plugin = plugin;
        this.player = player;
        this.Item = Item;
    }


    @Override
    public void run() {
        player.setCooldown(Item, 0);
    }
}

