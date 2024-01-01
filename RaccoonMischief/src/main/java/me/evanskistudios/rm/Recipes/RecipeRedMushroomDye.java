package me.evanskistudios.rm.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class RecipeRedMushroomDye {
    public static void MushroomDye(Plugin namespace) {
        ItemStack RedMushroom = new ItemStack(Material.RED_MUSHROOM, 1);
        Material RedDye = Material.RED_DYE;
        float xp = 1.0f;
        int Furnace_time = 200;

        FurnaceRecipe MushroomDye_furnace_recipe = new FurnaceRecipe(
                new NamespacedKey(namespace,"RedMushroomDye"),
                new ItemStack(Material.RED_DYE, 1), Material.RED_MUSHROOM, xp, Furnace_time
        );
        Bukkit.addRecipe(MushroomDye_furnace_recipe);

        FurnaceRecipe DyeToMushroom_furnace_recipe = new FurnaceRecipe(
                new NamespacedKey(namespace,"DyeToMushroomRecipe"),
                RedMushroom, RedDye, xp, Furnace_time
        );
        Bukkit.addRecipe(DyeToMushroom_furnace_recipe);
    }
}
