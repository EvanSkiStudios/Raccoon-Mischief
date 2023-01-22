package me.evanskistudios.rm.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;
public class Recipe_dirt_to_seeds {
    public static NamespacedKey Item_Key;

    public static void DirtSeeds(Plugin namespace) {
        ItemStack WheatSeeds = new ItemStack(Material.WHEAT_SEEDS, 1);

        NamespacedKey key = new NamespacedKey(namespace, "DirtSeeds");

        ShapelessRecipe DirtSeeds_Recipe = new ShapelessRecipe(key, WheatSeeds);
        DirtSeeds_Recipe.addIngredient(4, Material.DIRT);

        Bukkit.addRecipe(DirtSeeds_Recipe);

        Item_Key = key;
    }

    public static NamespacedKey getItemKey() {
        return Item_Key;
    }
}
