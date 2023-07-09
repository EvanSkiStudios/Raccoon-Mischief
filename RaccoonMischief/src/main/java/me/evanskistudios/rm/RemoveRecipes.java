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
                Material RecipeResult = recipe.getResult().getType();

                switch (RecipeResult) {
                    default -> {/*Default don't do anything*/}
                    case IRON_HELMET, IRON_CHESTPLATE, IRON_LEGGINGS, IRON_BOOTS,
                    GOLDEN_HELMET, GOLDEN_CHESTPLATE, GOLDEN_LEGGINGS, GOLDEN_BOOTS,
                    DIAMOND_HELMET, DIAMOND_CHESTPLATE, DIAMOND_LEGGINGS, DIAMOND_BOOTS,
                    LIGHT_WEIGHTED_PRESSURE_PLATE, CLOCK, POWERED_RAIL, CAKE
                    -> it.remove();

                }
            }
        }
    }
}