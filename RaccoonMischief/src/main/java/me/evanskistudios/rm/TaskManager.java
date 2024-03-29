package me.evanskistudios.rm;

import me.evanskistudios.rm.Tasks.*;
import org.bukkit.scheduler.BukkitTask;

public class TaskManager {
    public static void tasks(){
        RaccoonMischief namespace = RaccoonMischief.getPlugin();

        //Use where needed BukkitTask TaskRemoveCoolDown = (BukkitTask) new TaskRemoveCoolDown(namespace, player, Material.item).runTask(namespace);

        BukkitTask taskPlayerLevitation = (BukkitTask) new TaskPlayerLevitation(namespace).runTaskTimer(namespace,20L,20L);

        BukkitTask TaskRekkoRoomCode = (BukkitTask) new TaskRekkoRoomCode(namespace).runTask(namespace);

        BukkitTask TaskMercServerFire = (BukkitTask) new TaskMercServerFire(namespace).runTask(namespace);
    }

}
