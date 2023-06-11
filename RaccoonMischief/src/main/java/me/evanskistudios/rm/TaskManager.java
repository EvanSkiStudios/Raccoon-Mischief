package me.evanskistudios.rm;

import me.evanskistudios.rm.tasks.*;
import org.bukkit.scheduler.BukkitTask;

public class TaskManager {
    public static void tasks(){
        RaccoonMischief namespace = RaccoonMischief.getPlugin();

        //Use where needed BukkitTask TaskRemoveCoolDown = (BukkitTask) new TaskRemoveCoolDown(namespace, player, Material.item).runTask(namespace);

        BukkitTask taskPlayerLevitation = (BukkitTask) new TaskPlayerLevitation(namespace).runTaskTimer(namespace,20L,20L);

        //BukkitTask taskFanfic = (BukkitTask) new TaskFanfic(namespace).runTaskTimer(namespace,0L,0L);
    }

}
