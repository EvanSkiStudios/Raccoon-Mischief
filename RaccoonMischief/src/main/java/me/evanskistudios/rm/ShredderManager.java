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

import static org.bukkit.Bukkit.getServer;

public class ShredderManager {

    public static void ShredderEnable() {
        Plugin plugin = RaccoonMischief.getPlugin(RaccoonMischief.class);

        //if plugin isnt installed just disable these things
        if (getServer().getPluginManager().getPlugin("ATurtlesTroll") == null){
            return;
        }

        String Enabled = "" + plugin.getConfig().get("E_TurtlesTrollFeatures");
        if (Enabled.equalsIgnoreCase("Disabled")){
            return;
        }
        //Is enabled, continue
        ShredderManager.Events();
    }

    //Removes entities
    public static class ListenerUnMercerEntities implements Listener {
        @EventHandler
        public void onMobSpawn(CreatureSpawnEvent event) {
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
