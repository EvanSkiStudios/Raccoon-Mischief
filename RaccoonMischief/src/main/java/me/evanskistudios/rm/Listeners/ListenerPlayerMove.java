package me.evanskistudios.rm.Listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

import static java.lang.Math.floor;

public class ListenerPlayerMove implements Listener{
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        /*
        Player player = event.getPlayer();

        Location loc = player.getLocation();
        int PLocX = (int) floor(loc.getX());
        int PLocY = (int) floor(loc.getY());
        int PLocZ = (int) floor(loc.getZ());

        Material BlockAtPlayer = player.getWorld().getBlockAt(PLocX, PLocY, PLocZ).getType();
        Material BlockUnderPlayer = player.getWorld().getBlockAt(PLocX, PLocY - 1, PLocZ).getType();

        if ( (BlockAtPlayer != Material.ANVIL) && (BlockUnderPlayer == Material.ANVIL) ){
            Random random = new Random();
            int randomNumber = random.nextInt(20);

            if (randomNumber == 0) {
                int[] offsets = {-1, 0, 1};
                for (int xOffset : offsets) {
                    for (int yOffset : offsets) {
                        for (int zOffset : offsets) {
                            Block TargetBLock = player.getWorld().getBlockAt(PLocX + xOffset, PLocY + yOffset, PLocZ + zOffset);
                            if (TargetBLock.getType() == Material.AIR) {
                                TargetBLock.setType(Material.ANVIL);
                            }
                        }
                    }
                }
            }
        }

         */
    }
}
