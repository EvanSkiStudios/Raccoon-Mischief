package me.evanskistudios.rm.recipes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class RecipeCakeSlices {
    public static ItemStack Item;
    public static void CakeSlice(Plugin namespace) {
        ItemStack CakeSlice = new ItemStack(Material.SWEET_BERRIES, 7);
        ItemMeta CakeSliceMeta = CakeSlice.getItemMeta();
        CakeSliceMeta.setDisplayName(ChatColor.RESET + "Cake Slice");
        CakeSliceMeta.setCustomModelData(1);
        CakeSlice.setItemMeta(CakeSliceMeta);

        NamespacedKey key = new NamespacedKey(namespace, "CakeSlice");
        ShapelessRecipe CakeSlice_Recipe = new ShapelessRecipe(key, CakeSlice);
        CakeSlice_Recipe.addIngredient(1, Material.CAKE);

        Bukkit.addRecipe(CakeSlice_Recipe);

        Item = CakeSlice;
    }
    public static ItemStack getItem() {
        return Item;
    }
}