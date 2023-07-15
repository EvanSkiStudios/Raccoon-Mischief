package me.evanskistudios.rm;
import me.evanskistudios.rm.Commands.ComRMShowCraft;
import me.evanskistudios.rm.EnchantListeners.*;
import me.evanskistudios.rm.Listeners.*;

import me.evanskistudios.rm.Tasks.TaskRekkoRoomCode;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerManager {
    public static void registerEvent(org.bukkit.event.Listener listener) {
        Plugin namespace = RaccoonMischief.getPlugin();
        PluginManager Pluginmanager = namespace.getServer().getPluginManager();

        Pluginmanager.registerEvents(listener, namespace);
    }

    public static void Events() {
        registerEvent( new TaskRekkoRoomCode(RaccoonMischief.getPlugin()) ); //Rekko
        registerEvent( new ListenerPlayerDeath(RaccoonMischief.getPlugin())  ); //Player Death Event
        registerEvent( new ListenerMobSpawn(RaccoonMischief.getPlugin()) );  //Mob Spawning

        registerEvent( new ComRMShowCraft() ); //CraftingRecipeInventoryListener
        registerEvent( new ListenerLightning() ); //Lightning
        registerEvent( new ListenerPlayerConnect() ); //PLayer Join
        registerEvent( new ListenerMilkPotion()  ); //Milk potion
        registerEvent( new ListenerPlayerInteractEntity()  ); //Player Right click
        registerEvent( new ListenerPlayerCraft() ); //Crafting
        registerEvent( new ListenerXPCrystal() ); //Xp Crystal
        registerEvent( new ListenerPlayerEnterVoid() ); //teleport void
        registerEvent( new ListenerEntityFire() ); //Entity fire
        registerEvent( new ListenerPlayerInventory() ); //Player Inventory
        registerEvent( new ListenerProjectileLand() ); //Projectile Land
        registerEvent( new EnchantListenerTelekinesis() ); //Telekinesis Enchant
        registerEvent( new ListenerGoatHorn() ); //GoatHorn
        registerEvent( new ListenerPlayerInteractBlock() ); //Right click block
        registerEvent( new ListenerItemDespawn() ); //Item despawn
        registerEvent( new ListenerPlayerPlaceItem() ); //Placing
        registerEvent( new ListenerPlayerBreakBlock() ); //Cake
        registerEvent( new ListenerPlayerRespawn() ); //PlayerRespawnPotionEffects
        registerEvent( new ListenerEntitySpawn() ); //Entity spawn
    }
}