package me.evanskistudios.rm;
import me.evanskistudios.rm.commands.ComRMShowCraft;
import me.evanskistudios.rm.enchantevents.*;
import me.evanskistudios.rm.events.*;

import me.evanskistudios.rm.tasks.TaskRekkoRoomCode;
import org.bukkit.plugin.Plugin;

public class EventManager {
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
    }
}
