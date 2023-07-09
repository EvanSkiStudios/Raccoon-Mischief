/*
                                          ,@@@@@@@@@@@@@@#
                                   ,@@@@@@@@%%%%%%%%%%%%%@@@@@@@@
                               %@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@.
                            @@@@&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@(
                         *@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@
                       (@@@%%%%%%%%%%%%%%@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%@@@
                      @@@%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%@@@
                    &@@%%%%%%%%%%%%%%&@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%@@@
                   @@@%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@&%%%%@@@@%%%%%%%%%%%%%%&@@,
                  @@@%%%%%%%%%%%%%@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&@@
                 .@@%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@
                 @@@%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%%%%%%%%%%%%%%%%%%%%@@#
                 @@@%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%@@@
                 @@&%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%@@@
                 @@@%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%%%%%%%%%%%%%@@@
                 @@@%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%@@/
                  @@%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@
                  &@@%%%%%%%%%%%%%@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@
                   @@@%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@&&&@@@@@%%%%%%%%%%%%%%@@@
                    #@@&%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@@@@@@@&%%%%%%%%%%%%%%%%@@@
                      @@@%%%%%%%%%%%%%%%@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%@@@
                       ,@@@%%%%%%%%%%%%%%@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%@@@
                         .@@@&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@
                            &@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@.
                               ,@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@
                                    @@@@@@@@&%%%%%%%%%%%@@@@@@@@%
                                           /@@@@@@@@@@@@%

Removes and or Prevents Features from A-Turtles-Troll
 */


package me.evanskistudios.rm;

import org.bukkit.entity.Entity;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.logging.Level;

import static org.bukkit.Bukkit.getServer;

public class ShredderManager {

    public static void ShredderEnable() {
        //Is enabled, continue
        ShredderManager.Events();
    }

    //Removes entities
    public static class ListenerUnMercerEntities implements Listener {
        @EventHandler
        public void onMobSpawn(CreatureSpawnEvent event) {
            Plugin plugin = RaccoonMischief.getPlugin(RaccoonMischief.class);

            Plugin[] LoadedPlugins = getServer().getPluginManager().getPlugins();
            System.out.println(Arrays.toString(LoadedPlugins));

            String ignore = "" + plugin.getConfig().get("B_IgnorePluginGetInstalledFlag");
            if (ignore.equalsIgnoreCase("False")) {
                //if plugin isn't installed just disable these things, does not check if flag above is true


                if (("ATurtlesTroll") == null) {
                    //plugin.getLogger().log(Level.INFO, "ATurtlesTroll is not installed on server");
                    return;
                }
            }

            String Enabled = "" + plugin.getConfig().get("B_TurtlesTrollFeatures");
            if (Enabled.equalsIgnoreCase("False")){
                //plugin.getLogger().log(Level.INFO, "ATurtlesTroll Features are Disabled");
                return;
            }


            Entity SpawnedEntity = event.getEntity();

            if (SpawnedEntity instanceof Bat) event.setCancelled(true); //cuts down on lag
            if (SpawnedEntity instanceof Drowned) event.setCancelled(true); //Gets rid of all the Drown that lag the game completely
            if (SpawnedEntity instanceof Warden) event.setCancelled(true); //No
        }
    }

    //Enables Events above
    public static void Events() {
        Plugin namespace = RaccoonMischief.getPlugin();

        //UnMercer
        ListenerUnMercerEntities UnMercerEntities = new ListenerUnMercerEntities();
        namespace.getServer().getPluginManager().registerEvents(UnMercerEntities, namespace);
    }

}
