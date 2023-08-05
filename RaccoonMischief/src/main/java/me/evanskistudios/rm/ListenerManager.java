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
        registerEvent( new ListenerSnowballBrickProjectileLand() ); //Projectile Land
        registerEvent( new EnchantListenerTelekinesis() ); //Telekinesis Enchant
        registerEvent( new ListenerGoatHorn() ); //GoatHorn
        registerEvent( new ListenerPlayerInteractBlock() ); //Right click block
        registerEvent( new ListenerItemDespawn() ); //Item despawn
        registerEvent( new ListenerPlayerMove() ); //Player move
        registerEvent( new ListenerPlayerPlaceSweetBerries() ); //Placing
        registerEvent( new ListenerPlayerBreakBlock() ); //Cake
        registerEvent( new ListenerPlayerRespawn() ); //PlayerRespawnPotionEffects
        registerEvent( new ListenerEntitySpawn() ); //Entity spawn
        registerEvent( new ListenerPlayerSneak() ); //player sneak
    }
}

/*
public class ListenerManager {
    public static void Events() {
        Plugin namespace = RaccoonMischief.getPlugin();

        //CraftingRecipeInventoryListener
        ComRMShowCraft InventoryListener = new ComRMShowCraft();
        namespace.getServer().getPluginManager().registerEvents(InventoryListener, namespace);

        //Lightning
        ListenerLightning LightningEvent = new ListenerLightning();
        namespace.getServer().getPluginManager().registerEvents(LightningEvent, namespace);

        //PLayer Join
        ListenerPlayerConnect PlayerConnectEvent = new ListenerPlayerConnect();
        namespace.getServer().getPluginManager().registerEvents(PlayerConnectEvent, namespace);

        //Player Death Event
        ListenerPlayerDeath PlayerDeathEvent = new ListenerPlayerDeath(RaccoonMischief.getPlugin());
        namespace.getServer().getPluginManager().registerEvents(PlayerDeathEvent, namespace);

        //Milk potion
        ListenerMilkPotion PotionSplashEvent = new ListenerMilkPotion();
        namespace.getServer().getPluginManager().registerEvents(PotionSplashEvent, namespace);

        //Player Right click
        ListenerPlayerInteractEntity PlayerRightClickEvent = new ListenerPlayerInteractEntity();
        namespace.getServer().getPluginManager().registerEvents(PlayerRightClickEvent, namespace);

        //Crafting
        ListenerPlayerCraft PlayerCraftEvent = new ListenerPlayerCraft();
        namespace.getServer().getPluginManager().registerEvents(PlayerCraftEvent, namespace);

        //Xp Crystal
        ListenerXPCrystal PlayerTeleportEvent = new ListenerXPCrystal();
        namespace.getServer().getPluginManager().registerEvents(PlayerTeleportEvent, namespace);

        //teleport void
        ListenerPlayerEnterVoid PlayerVoidEvent = new ListenerPlayerEnterVoid();
        namespace.getServer().getPluginManager().registerEvents(PlayerVoidEvent, namespace);

        //Entity fire
        ListenerEntityFire EntityFireEvent = new ListenerEntityFire();
        namespace.getServer().getPluginManager().registerEvents(EntityFireEvent, namespace);

        //Player Inventory
        ListenerPlayerInventory PlayerInventoryEvent = new ListenerPlayerInventory();
        namespace.getServer().getPluginManager().registerEvents(PlayerInventoryEvent, namespace);

        //Projectile Land
        ListenerProjectileLand ProjectileLandEvent = new ListenerProjectileLand();
        namespace.getServer().getPluginManager().registerEvents(ProjectileLandEvent, namespace);

        //Telekinesis Enchant
        EnchantListenerTelekinesis EnchantTelekinesisEvent = new EnchantListenerTelekinesis();
        namespace.getServer().getPluginManager().registerEvents(EnchantTelekinesisEvent, namespace);

        //GoatHorn
        ListenerGoatHorn PlayerGoatHornEvent = new ListenerGoatHorn();
        namespace.getServer().getPluginManager().registerEvents(PlayerGoatHornEvent, namespace);

        //Rekko
        TaskRekkoRoomCode ListenerRekkoJoin = new TaskRekkoRoomCode(RaccoonMischief.getPlugin());
        namespace.getServer().getPluginManager().registerEvents(ListenerRekkoJoin, namespace);

        //Right click block
        ListenerPlayerInteractBlock PlayerUseBlockEvent = new ListenerPlayerInteractBlock();
        namespace.getServer().getPluginManager().registerEvents(PlayerUseBlockEvent, namespace);

        //Item despawn
        ListenerItemDespawn ItemDespawnEvent = new ListenerItemDespawn();
        namespace.getServer().getPluginManager().registerEvents(ItemDespawnEvent, namespace);

        //Mob Spawning
        ListenerMobSpawn MobSpawnEvent = new ListenerMobSpawn(RaccoonMischief.getPlugin());
        namespace.getServer().getPluginManager().registerEvents(MobSpawnEvent, namespace);

        //Placing
        ListenerPlayerPlaceItem PlaceItemEvent = new ListenerPlayerPlaceItem();
        namespace.getServer().getPluginManager().registerEvents(PlaceItemEvent, namespace);

        //Cake
        ListenerPlayerBreakBlock BreakBlockEvent = new ListenerPlayerBreakBlock();
        namespace.getServer().getPluginManager().registerEvents(BreakBlockEvent, namespace);

        //PlayerRespawnPotionEffects
        ListenerPlayerRespawn PlayerRespawnEvent = new ListenerPlayerRespawn();
        namespace.getServer().getPluginManager().registerEvents(PlayerRespawnEvent, namespace);
    }
}
 */