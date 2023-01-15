package me.evanskistudios.rm.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

public class notch_apple {

    public static void NotchApple(Plugin namespace) {
        ItemStack EnchantedGoldenApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);

        NamespacedKey key = new NamespacedKey(namespace, "NotchApple");

        ShapedRecipe NotchApple_Recipe = new ShapedRecipe(key, EnchantedGoldenApple);
        NotchApple_Recipe.shape(
                "GGG",
                "GAG",
                "GGG");
        NotchApple_Recipe.setIngredient('A', Material.APPLE);
        NotchApple_Recipe.setIngredient('G', Material.GOLD_BLOCK);

        Bukkit.addRecipe(NotchApple_Recipe);
    }
}
