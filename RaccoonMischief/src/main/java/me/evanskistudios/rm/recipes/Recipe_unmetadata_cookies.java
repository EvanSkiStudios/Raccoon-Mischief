package me.evanskistudios.rm.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;

public class Recipe_unmetadata_cookies {
    public static void NoMDCookies(Plugin namespace) {
        ItemStack Cookie = new ItemStack(Material.COOKIE, 1);

        NamespacedKey key = new NamespacedKey(namespace, "NoMetaDataCookie");

        ShapelessRecipe NMD_Cookie_Recipe = new ShapelessRecipe(key, Cookie);
        NMD_Cookie_Recipe.addIngredient(1, Material.COOKIE);

        Bukkit.addRecipe(NMD_Cookie_Recipe);
    }
}
