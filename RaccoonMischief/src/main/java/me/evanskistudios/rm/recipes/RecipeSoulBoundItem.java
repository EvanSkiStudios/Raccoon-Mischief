package me.evanskistudios.rm.Recipes;

import me.evanskistudios.rm.Items.ItemUpgradeShard;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class RecipeSoulBoundItem {

    public static void SoulBound(Plugin namespace){

        //Create SoulBound item
        ItemStack SoulBoundItem = new ItemStack(Material.BAKED_POTATO, 1);

        ItemMeta SoulBoundItemMeta = SoulBoundItem.getItemMeta();
        NamespacedKey SoulBoundKey = new NamespacedKey(namespace, "SoulBound");
        SoulBoundItemMeta.getPersistentDataContainer().set(SoulBoundKey, PersistentDataType.DOUBLE, 1.0);


        //Recipe
        ShapelessRecipe SoulBoundItemRecipe = new ShapelessRecipe(new NamespacedKey(namespace, "SoulBoundItem"), SoulBoundItem);

        RecipeChoice UpgradeShard = new RecipeChoice.MaterialChoice.ExactChoice(ItemUpgradeShard.UpgradeShard());
        SoulBoundItemRecipe.addIngredient(UpgradeShard);


        SoulBoundItemRecipe.addIngredient(1, Material.TOTEM_OF_UNDYING);


        Bukkit.addRecipe(SoulBoundItemRecipe);

    }
}
