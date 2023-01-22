package me.evanskistudios.rm;
import me.evanskistudios.rm.events.*;

import org.bukkit.plugin.Plugin;

public class EventManager {
    public static void Events() {
        Plugin namespace = RaccoonMischief.getPlugin();

        //Lightning
        ListenerLightning LightningEvent = new ListenerLightning();
        namespace.getServer().getPluginManager().registerEvents(LightningEvent, namespace);

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

        //Xp Crystal
        ListenerXPCrystal PlayerTeleportEvent = new ListenerXPCrystal();
        namespace.getServer().getPluginManager().registerEvents(PlayerTeleportEvent, namespace);

        //teleport void
        ListenerPlayerEnterVoid PlayerVoidEvent = new ListenerPlayerEnterVoid();
        namespace.getServer().getPluginManager().registerEvents(PlayerVoidEvent, namespace);
    }
}
