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
            if (recipe != null){
                //check what it makes, not what it uses, then remove it
                if (recipe.getResult().getType() == Material.BREAD) it.remove();
            }
        }
    }
}
