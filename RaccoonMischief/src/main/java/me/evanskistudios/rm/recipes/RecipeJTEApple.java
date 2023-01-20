package me.evanskistudios.rm.recipes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class RecipeJTEApple {

    public static ItemStack Item;
    public static void JTEApple(Plugin namespace) {
        ItemStack EnchantedGoldenApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
        ItemMeta JTEAppleMeta = EnchantedGoldenApple.getItemMeta();
        JTEAppleMeta.setDisplayName(ChatColor.RESET+""+ChatColor.LIGHT_PURPLE+"JTE Apple");
        JTEAppleMeta.setLore(List.of(
                ChatColor.RESET+""+ChatColor.BLUE+"JTE was a user who invented this apple, and multiplayer in MC",
                ChatColor.RESET+""+ChatColor.BLUE+"https://youtu.be/5e9rpsJPWTM"));
        EnchantedGoldenApple.setItemMeta(JTEAppleMeta);

        NamespacedKey key = new NamespacedKey(namespace, "JTEApple");
        ShapedRecipe JTEApple_Recipe = new ShapedRecipe(key, EnchantedGoldenApple);
        JTEApple_Recipe.shape(
                "GGG",
                "GAG",
                "GGG");
        JTEApple_Recipe.setIngredient('A', Material.APPLE);
        JTEApple_Recipe.setIngredient('G', Material.GOLD_BLOCK);

        Bukkit.addRecipe(JTEApple_Recipe);

        Item = EnchantedGoldenApple;
    }
    public static ItemStack getItem() {
        return Item;
    }
}
