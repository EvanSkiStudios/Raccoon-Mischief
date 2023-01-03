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

public class test_recipe{
        public static void MethodName(Plugin namespace) {
            ItemStack SuperPotato = new ItemStack(Material.POISONOUS_POTATO, 1);
            ItemMeta SuperPotatoMeta = SuperPotato.getItemMeta();
            SuperPotatoMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Super Potato!");
            SuperPotatoMeta.setLore(List.of("This potato will ", "give you superpowers."));
            SuperPotato.setItemMeta(SuperPotatoMeta);

            ShapedRecipe SuperPotatoRecipe = new ShapedRecipe(new NamespacedKey(namespace, "potato"), SuperPotato);
            SuperPotatoRecipe.shape(
                    " X ",
                    " X ",
                    " X "
            );
            SuperPotatoRecipe.setIngredient('X', Material.POTATO);

            Bukkit.addRecipe(SuperPotatoRecipe);

        }
}