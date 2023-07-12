package me.evanskistudios.rm.Recipes;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class RecipeThrowableBrick {

    public static ItemStack Item;
    public static void ThrowableBrick(Plugin namespace) {
        ItemStack Brick = new ItemStack(Material.SNOWBALL, 1);

        ItemMeta Brick_Meta = Brick.getItemMeta();
        Brick_Meta.setCustomModelData(1);

        //Tag
        NamespacedKey TagKey = new NamespacedKey(namespace, "brick");
        Brick_Meta.getPersistentDataContainer().set(TagKey, PersistentDataType.DOUBLE, 1.0);

        //Text
        Brick_Meta.setDisplayName(ChatColor.RESET + "Throwable Brick");

        //set Item meta
        Brick.setItemMeta(Brick_Meta);

        //Crafting
        NamespacedKey key = new NamespacedKey(namespace, "ThrowBrick");

        ShapelessRecipe Brick_Recipe = new ShapelessRecipe(key, Brick);
        Brick_Recipe.addIngredient(1, Material.BRICK);

        Bukkit.addRecipe(Brick_Recipe);


        Item = Brick;
    }
    public static ItemStack getItem() {
        return Item;
    }
}
