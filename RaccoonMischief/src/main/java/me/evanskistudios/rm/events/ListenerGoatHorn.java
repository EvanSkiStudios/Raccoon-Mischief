package me.evanskistudios.rm.events;

import me.evanskistudios.rm.RaccoonMischief;
import me.evanskistudios.rm.tasks.TaskRemoveCoolDown;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

public class ListenerGoatHorn implements Listener {
    @EventHandler
    public void onUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        ItemStack HeldItem = player.getInventory().getItemInMainHand();
        Material HeldItemType = HeldItem.getType();
        if (!(HeldItemType == Material.GOAT_HORN)) {
            ItemStack OffHeldItem = player.getInventory().getItemInOffHand();
            Material OffHeldItemType = OffHeldItem.getType();
            if (!(OffHeldItemType == Material.GOAT_HORN)) {
                return;
            }
        }

        RaccoonMischief namespace = RaccoonMischief.getPlugin();
        BukkitTask TaskRemoveCoolDown = (BukkitTask) new TaskRemoveCoolDown(namespace, player, Material.GOAT_HORN).runTask(namespace);
    }

}
