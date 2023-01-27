package me.evanskistudios.rm.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

public class RecipeNewCake {
    public static ItemStack Item;
    public static void Cake(Plugin namespace) {
        ItemStack Cake = new ItemStack(Material.CAKE, 1);

        NamespacedKey key = new NamespacedKey(namespace, "NewCake");
        ShapedRecipe Cake_Recipe = new ShapedRecipe(key, Cake);
        Cake_Recipe.shape(
                "MBM",
                "SES",
                "WWW");
        Cake_Recipe.setIngredient('M', Material.MILK_BUCKET);
        Cake_Recipe.setIngredient('B', Material.SWEET_BERRIES);
        Cake_Recipe.setIngredient('S', Material.SUGAR);
        Cake_Recipe.setIngredient('E', Material.EGG);
        Cake_Recipe.setIngredient('W', Material.WHEAT);

        Bukkit.addRecipe(Cake_Recipe);

        Item = Cake;
    }
    public static ItemStack getItem() {
        return Item;
    }
}
