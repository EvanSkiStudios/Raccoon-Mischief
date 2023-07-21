package me.evanskistudios.rm.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;

public class RecipeNetherWart {
    public static void NetherWart(Plugin namespace) {
        ItemStack NetherWart = new ItemStack(Material.NETHER_WART, 9);
        ShapelessRecipe NetherWartRecipe = new ShapelessRecipe(new NamespacedKey(namespace, "NetherWart"), NetherWart);
        NetherWartRecipe.addIngredient(1, Material.NETHER_WART_BLOCK);

        Bukkit.addRecipe(NetherWartRecipe);
    }
}
