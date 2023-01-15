package me.evanskistudios.rm;

import org.bukkit.Material;
import org.bukkit.inventory.Recipe;

import java.util.Iterator;

import static org.bukkit.Bukkit.getServer;

public class RemoveRecipes {
    public static void Recipes() {
        Iterator<Recipe> it = getServer().recipeIterator();

        while (it.hasNext()) {
            Recipe recipe = it.next();
            if (recipe != null) {
                //check what it makes, not what it uses, then remove it
                //Vanilla Armor
                {
                    if (recipe.getResult().getType() == Material.IRON_HELMET) it.remove();
                    if (recipe.getResult().getType() == Material.IRON_CHESTPLATE) it.remove();
                    if (recipe.getResult().getType() == Material.IRON_LEGGINGS) it.remove();
                    if (recipe.getResult().getType() == Material.IRON_BOOTS) it.remove();

                    if (recipe.getResult().getType() == Material.GOLDEN_HELMET) it.remove();
                    if (recipe.getResult().getType() == Material.GOLDEN_CHESTPLATE) it.remove();
                    if (recipe.getResult().getType() == Material.GOLDEN_LEGGINGS) it.remove();
                    if (recipe.getResult().getType() == Material.GOLDEN_BOOTS) it.remove();

                    if (recipe.getResult().getType() == Material.DIAMOND_HELMET) it.remove();
                    if (recipe.getResult().getType() == Material.DIAMOND_CHESTPLATE) it.remove();
                    if (recipe.getResult().getType() == Material.DIAMOND_LEGGINGS) it.remove();
                    if (recipe.getResult().getType() == Material.DIAMOND_BOOTS) it.remove();
                }

            }
        }
    }
}
