package me.evanskistudios.rm.recipes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class RecipeCakeFromSlices {
    public static void CakeFromSlice(Plugin namespace) {
        ItemStack CakeSlice = new ItemStack(Material.SWEET_BERRIES, 7);
        ItemMeta CakeSliceMeta = CakeSlice.getItemMeta();
        CakeSliceMeta.setDisplayName(ChatColor.RESET + "Cake Slice");
        CakeSliceMeta.setCustomModelData(1);
        CakeSlice.setItemMeta(CakeSliceMeta);
        RecipeChoice RCCakeSlice = new RecipeChoice.MaterialChoice.ExactChoice(CakeSlice);

        NamespacedKey key = new NamespacedKey(namespace, "CakeFromSlice");
        ShapelessRecipe CakeSlice_Recipe = new ShapelessRecipe(key, new ItemStack(Material.CAKE));
        for (int i = 0; i < 7; ++i) {
            CakeSlice_Recipe.addIngredient(RCCakeSlice);
        }

        Bukkit.addRecipe(CakeSlice_Recipe);
    }
}
