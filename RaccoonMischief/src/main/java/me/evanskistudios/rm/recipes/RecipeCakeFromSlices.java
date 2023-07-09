package me.evanskistudios.rm.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;

public class RecipeCakeFromSlices {
    public static void CakeFromSlice(Plugin namespace) {
        ItemStack CakeSlice = RecipeCakeSlices.getItem();
        CakeSlice.setAmount(1);
        RecipeChoice RCCakeSlice = new RecipeChoice.MaterialChoice.ExactChoice(CakeSlice);

        NamespacedKey key = new NamespacedKey(namespace, "CakeFromSlice");
        ShapelessRecipe CakeSlice_Recipe = new ShapelessRecipe(key, new ItemStack(Material.CAKE));
        for (int i = 0; i < 7; ++i) {
            CakeSlice_Recipe.addIngredient(RCCakeSlice);
        }

        Bukkit.addRecipe(CakeSlice_Recipe);
    }
}
