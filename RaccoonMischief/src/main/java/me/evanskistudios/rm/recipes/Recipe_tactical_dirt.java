package me.evanskistudios.rm.recipes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
//import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

//import java.util.List;

public class Recipe_tactical_dirt {

    public static void TactDirt(Plugin namespace) {
            ItemStack TaticalDirt = new ItemStack(Material.BAKED_POTATO, 1);
            ItemMeta TaticalDirtMeta = TaticalDirt.getItemMeta();
            TaticalDirtMeta.setDisplayName(ChatColor.RESET + "Tactical Dirt");
            TaticalDirtMeta.setCustomModelData(1);
            NamespacedKey key = new NamespacedKey(namespace, "ndirt_eat");
            TaticalDirtMeta.getPersistentDataContainer().set(key, PersistentDataType.DOUBLE, 1.0);
            TaticalDirt.setItemMeta(TaticalDirtMeta);
            ShapelessRecipe TaticalDirtRecipe = new ShapelessRecipe(new NamespacedKey(namespace, "TacticalDirt"), TaticalDirt);
            TaticalDirtRecipe.addIngredient(1, Material.DIRT);
            TaticalDirtRecipe.addIngredient(1, Material.WHEAT_SEEDS);

            Bukkit.addRecipe(TaticalDirtRecipe);
    }
}