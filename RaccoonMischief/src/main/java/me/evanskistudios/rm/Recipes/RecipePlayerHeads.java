package me.evanskistudios.rm.Recipes;

import me.evanskistudios.rm.FoodManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;

public class RecipePlayerHeads {
    private static final ItemStack Strange_Meat = FoodManager.CookedStrangeMeat;

    public static void PlayerHeadCooking(Plugin namespace) {
        float xp = 1.0f;
        //Cooking time is in ticks not seconds
        int Campfire_Time = 600;
        int Furnace_time = 206;
        int Smoker_time = 100;

        FurnaceRecipe PlayerHeadFurnaceRecipe = new FurnaceRecipe(
                new NamespacedKey(namespace,"FurnaceCookingPlayerHead"),
                Strange_Meat, Material.PLAYER_HEAD, xp, Furnace_time
        );
        Bukkit.addRecipe(PlayerHeadFurnaceRecipe);

        CampfireRecipe PlayerHead_campfire_recipe = new CampfireRecipe(
                new NamespacedKey(namespace,"CampCookingPlayerHead"),
                Strange_Meat, Material.PLAYER_HEAD, xp,
                Campfire_Time
        );
        Bukkit.addRecipe(PlayerHead_campfire_recipe);

        SmokingRecipe PlayerHead_Smoker_recipe = new SmokingRecipe(
                new NamespacedKey(namespace,"SmokeCookingPlayerHead"),
                Strange_Meat, Material.PLAYER_HEAD, xp,
                Smoker_time
        );
        Bukkit.addRecipe(PlayerHead_Smoker_recipe);
    }
}
