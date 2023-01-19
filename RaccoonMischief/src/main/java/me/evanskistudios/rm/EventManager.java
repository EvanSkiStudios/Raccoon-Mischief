package me.evanskistudios.rm;
import me.evanskistudios.rm.events.*;

import org.bukkit.plugin.Plugin;

public class EventManager {
    public static void Events() {
        Plugin namespace = RaccoonMischief.getPlugin();

        //PLayer Join
        ListenerPlayerConnect PlayerConnectEvent = new ListenerPlayerConnect();
        namespace.getServer().getPluginManager().registerEvents(PlayerConnectEvent, namespace);

        //Player Death Event
        ListenerPlayerDeath PlayerDeathEvent = new ListenerPlayerDeath();
        namespace.getServer().getPluginManager().registerEvents(PlayerDeathEvent, namespace);

        //Milk potion
        ListenerMilkPotion PotionSplashEvent = new ListenerMilkPotion();
        namespace.getServer().getPluginManager().registerEvents(PotionSplashEvent, namespace);

        //Milk player
        ListerPlayerMilk PlayerMilkEvent = new ListerPlayerMilk();
        namespace.getServer().getPluginManager().registerEvents(PlayerMilkEvent, namespace);

        //Crafting
        ListenerPlayerCraft PlayerCraftEvent = new ListenerPlayerCraft();
        namespace.getServer().getPluginManager().registerEvents(PlayerCraftEvent, namespace);
    }
}
