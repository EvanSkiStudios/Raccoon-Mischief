package me.evanskistudios.rm.events;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;

public class ListenerPlayerEnterVoid implements Listener {
        @EventHandler
        public void onDamage(EntityDamageEvent event){
            if (event.isCancelled()) return;
            if (!(event.getEntity() instanceof Player)) return;

            Plugin plugin = RaccoonMischief.getPlugin(RaccoonMischief.class);
            String CustomMessage = "" + plugin.getConfig().get("B_ForgivingVoid");
            if (CustomMessage.equalsIgnoreCase("False")) {
                return;
            }

            Player player = (Player) event.getEntity();

            //check if player is in the end
            if (! (player.getWorld().getEnvironment() == World.Environment.THE_END) ) {
                return;
            }
            //check if player fell into the void
            if (! (player.getLocation().getY() < -60) ) {
                return;
            }

            if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {

                event.setCancelled(true);

                World OverWorld = Bukkit.getServer().getWorlds().get(0);

                double player_x = player.getLocation().getX();
                double new_y = 320.5;
                double player_z = player.getLocation().getZ();
                float player_yaw = player.getLocation().getYaw();
                float player_pitch = player.getLocation().getPitch();

                Location Teleport_Loc = new Location(OverWorld, player_x, 320.5, player_z, player_yaw , player_pitch);

                Block Load_area = Teleport_Loc.getBlock(); //preloads the area

                player.teleport(Teleport_Loc);

                player.playSound(player.getLocation(), "minecraft:block.portal.travel", 1.0f, 1.0f);
            }

        }
}
