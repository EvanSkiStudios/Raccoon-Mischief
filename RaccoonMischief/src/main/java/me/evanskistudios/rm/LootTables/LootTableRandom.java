package me.evanskistudios.rm.LootTables;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LootTableRandom implements Listener {
    private static final List<LootTables> LootTablesList = Arrays.asList(
            LootTables.ABANDONED_MINESHAFT,
            LootTables.ANCIENT_CITY,
            LootTables.ANCIENT_CITY_ICE_BOX,
            LootTables.BASTION_BRIDGE,
            LootTables.BASTION_HOGLIN_STABLE,
            LootTables.BASTION_OTHER,
            LootTables.BASTION_TREASURE,
            LootTables.BURIED_TREASURE,
            LootTables.CAT_MORNING_GIFT,
            LootTables.DESERT_PYRAMID,
            LootTables.DESERT_PYRAMID_ARCHAEOLOGY,
            LootTables.DESERT_WELL_ARCHAEOLOGY,
            LootTables.END_CITY_TREASURE,
            LootTables.FISHING,
            LootTables.FISHING_FISH,
            LootTables.FISHING_JUNK,
            LootTables.FISHING_TREASURE,
            LootTables.FLETCHER_GIFT,
            LootTables.IGLOO_CHEST,
            LootTables.JUNGLE_TEMPLE,
            LootTables.JUNGLE_TEMPLE_DISPENSER,
            LootTables.NETHER_BRIDGE,
            LootTables.OCEAN_RUIN_COLD_ARCHAEOLOGY,
            LootTables.OCEAN_RUIN_WARM_ARCHAEOLOGY,
            LootTables.PIGLIN_BARTERING,
            LootTables.PILLAGER_OUTPOST,
            LootTables.RUINED_PORTAL,
            LootTables.SHIPWRECK_SUPPLY,
            LootTables.SHIPWRECK_TREASURE,
            LootTables.SIMPLE_DUNGEON,
            LootTables.STRONGHOLD_CORRIDOR,
            LootTables.STRONGHOLD_CROSSING,
            LootTables.STRONGHOLD_LIBRARY,
            LootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON,
            LootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE,
            LootTables.UNDERWATER_RUIN_BIG,
            LootTables.UNDERWATER_RUIN_SMALL,
            LootTables.WOODLAND_MANSION
    );

    @EventHandler
    public void OnLootSpawn(LootGenerateEvent event){
        LootTable SpawnedLootTable = event.getLootTable();

        if (LootTablesList.contains(SpawnedLootTable)) {

            Random rand = new Random();
            LootTable NewLootTable = LootTablesList.get(rand.nextInt(LootTablesList.size())).getLootTable();
        }
    }
}
