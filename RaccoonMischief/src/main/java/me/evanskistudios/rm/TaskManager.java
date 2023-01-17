package me.evanskistudios.rm;

import me.evanskistudios.rm.tasks.TaskPlayerLevitation;
import org.bukkit.scheduler.BukkitTask;

public class TaskManager {
    public static void tasks(){
        RaccoonMischief namespace = RaccoonMischief.getPlugin();

        BukkitTask taskPlayerLevitation = (BukkitTask) new TaskPlayerLevitation(namespace).runTaskTimer(namespace,20L,20L);
    }

}
