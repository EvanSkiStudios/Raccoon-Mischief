package me.evanskistudios.rm;
import me.evanskistudios.rm.Commands.ComRMShowCraft;
import me.evanskistudios.rm.EnchantListeners.*;
import me.evanskistudios.rm.Listeners.*;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;


public class ListenerManager {
    public static void registerEvent(org.bukkit.event.Listener listener) {
        Plugin namespace = RaccoonMischief.getPlugin();
        PluginManager Pluginmanager = namespace.getServer().getPluginManager();

        Pluginmanager.registerEvents(listener, namespace);
    }

    public static void Events() {
        registerEvent(new ComRMShowCraft()); //CraftingRecipeInventoryListener
        registerEvent(new EnchantListenerTelekinesis()); //Telekinesis Enchant
        registerEvent(new EnchantListenerBow()); //bow rm-enchantments stuff

        registerEvent(new ListenerPlayerDeath(RaccoonMischief.getPlugin())); //Player Death Event
        registerEvent(new ListenerMobSpawn(RaccoonMischief.getPlugin()));  //Mob Spawning

        registerEvent(new ListenerEntityDamage()); //Entity fire
        registerEvent(new ListenerEntityDeath()); //Entity Death
        registerEvent(new ListenerEntityItemPickup()); //Pickup item
        registerEvent(new ListenerEntitySpawn()); //Entity spawn
        registerEvent(new ListenerGoatHorn()); //GoatHorn
        registerEvent(new ListenerItemDespawn()); //Item despawn
        registerEvent(new ListenerLightning()); //Lightning
        registerEvent(new ListenerMilkPotion()); //Milk potion
        //Mob spawn
        registerEvent(new ListenerPlayerBreakBlock()); //Cake
        registerEvent(new ListenerPlayerCakeSlicesPlaceBlocker()); //Placing
        registerEvent(new ListenerPlayerConnect()); //PLayer Join
        registerEvent(new ListenerPlayerCustomItemCraft()); //Crafting
        //Player Death
        registerEvent(new ListenerPlayerEnterBed()); //bed event
        registerEvent(new ListenerPlayerEnterVoid()); //teleport void
        registerEvent(new ListenerPlayerInteractBlock()); //Right click block
        registerEvent(new ListenerPlayerInteractEntity()); //Player Right click
        registerEvent(new ListenerPlayerInventory()); //Player Inventory
        //Item consume
        registerEvent(new ListenerPlayerMove()); //Player move
        registerEvent(new ListenerPlayerRespawn()); //PlayerRespawnPotionEffects
        registerEvent(new ListenerPlayerSneak()); //player sneak
        registerEvent(new ListenerSnowballBrickProjectileLand()); //Projectile Land
        registerEvent(new ListenerXPCrystal()); //Xp Crystal

    }
}