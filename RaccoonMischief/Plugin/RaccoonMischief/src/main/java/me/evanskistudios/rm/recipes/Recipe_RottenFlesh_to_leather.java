package me.evanskistudios.rm.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;

public class Recipe_RottenFlesh_to_leather {
    public static void RotLeather(Plugin namespace) {
        ItemStack RottenLeather = new ItemStack(Material.LEATHER, 1);
        Material Mat_RottenFlesh = Material.ROTTEN_FLESH;
        float xp = 0.35f;
        int Campfire_Time = 600; //Cooking time is in ticks not seconds
        int Furnace_time = 206;
        int Smoker_time = 100;

        //namespaces for recipes must be unique

        CampfireRecipe RottenLeather_campfire_recipe = new CampfireRecipe(
                new NamespacedKey(namespace,"RFtoLCF"),
                RottenLeather, Mat_RottenFlesh, xp,
                Campfire_Time
        );
        Bukkit.addRecipe(RottenLeather_campfire_recipe);

        FurnaceRecipe RottenLeather_furnace_recipe = new FurnaceRecipe(
                new NamespacedKey(namespace,"RFtoLF"),
                RottenLeather, Mat_RottenFlesh, xp,
                Furnace_time
        );
        Bukkit.addRecipe(RottenLeather_furnace_recipe);

        SmokingRecipe RottenLeather_Smoker_recipe = new SmokingRecipe(
                new NamespacedKey(namespace,"RFtoLS"),
                RottenLeather, Mat_RottenFlesh, xp,
                Smoker_time
        );
        Bukkit.addRecipe(RottenLeather_Smoker_recipe);
    }
}
