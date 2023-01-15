package me.evanskistudios.rm.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

public class unmetadata_cookies {

    public static void NoMDCookies(Plugin namespace) {
        ItemStack Cookie = new ItemStack(Material.COOKIE, 1);

        NamespacedKey key = new NamespacedKey(namespace, "NoMetaDataCookie");

        ShapedRecipe NMD_Cookie_Recipe = new ShapedRecipe(key, Cookie);
        NMD_Cookie_Recipe.shape(
                "CC",
                "CC");
        NMD_Cookie_Recipe.setIngredient('C', Material.COOKIE);

        Bukkit.addRecipe(NMD_Cookie_Recipe);
    }
}
