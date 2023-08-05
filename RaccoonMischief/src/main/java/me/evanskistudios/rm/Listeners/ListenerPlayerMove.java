package me.evanskistudios.rm.Listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

public class ListenerPlayerMove implements Listener{
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Location loc = player.getLocation();
        int PLocX = (int) loc.getX();
        int PLocY = (int) loc.getY();
        int PLocZ = (int) loc.getZ();

        Material BlockAtPlayer = player.getWorld().getBlockAt(PLocX, PLocY, PLocZ).getType();
        Material BlockUnderPlayer = player.getWorld().getBlockAt(PLocX, PLocY - 1, PLocZ).getType();

        if ( (BlockAtPlayer != Material.ANVIL) && (BlockUnderPlayer == Material.ANVIL) ){
            Random random = new Random();
            int randomNumber = random.nextInt(20);

            if (randomNumber == 0) {
                player.getWorld().getBlockAt(PLocX, PLocY, PLocZ).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX, PLocY, PLocZ + 1).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX, PLocY, PLocZ - 1).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX + 1, PLocY, PLocZ).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX - 1, PLocY, PLocZ).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX + 1, PLocY, PLocZ + 1).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX - 1, PLocY, PLocZ - 1).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX + 1, PLocY, PLocZ - 1).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX - 1, PLocY, PLocZ + 1).setType(Material.ANVIL);

                player.getWorld().getBlockAt(PLocX, PLocY + 1, PLocZ).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX, PLocY + 1, PLocZ + 1).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX, PLocY + 1, PLocZ - 1).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX + 1, PLocY + 1, PLocZ).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX - 1, PLocY + 1, PLocZ).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX + 1, PLocY + 1, PLocZ + 1).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX - 1, PLocY + 1, PLocZ - 1).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX + 1, PLocY + 1, PLocZ - 1).setType(Material.ANVIL);
                player.getWorld().getBlockAt(PLocX - 1, PLocY + 1, PLocZ + 1).setType(Material.ANVIL);
            }
        }
    }
}
