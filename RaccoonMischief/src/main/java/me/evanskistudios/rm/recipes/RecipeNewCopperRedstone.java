package me.evanskistudios.rm.Recipes;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

//Material.LIGHT_WEIGHTED_PRESSURE_PLATE
public class RecipeNewCopperRedstone {
    public static void NewCopperRedstoneItems(Plugin namespace) {

        Material Copper = Material.COPPER_INGOT;
        Material Redstone = Material.REDSTONE;

        //clock
        ItemStack CopperClock = new ItemStack(Material.CLOCK, 1);
        NamespacedKey CopperClock_key = new NamespacedKey(namespace, "copper_clock");
        ShapedRecipe CopperClock_Recipe = new ShapedRecipe(CopperClock_key, CopperClock );
        CopperClock_Recipe.shape(
                " C ",
                "CRC",
                " C ");
        CopperClock_Recipe.setIngredient('C', Copper);
        CopperClock_Recipe.setIngredient('R', Redstone);

        Bukkit.addRecipe(CopperClock_Recipe);

        //powered rail
        ItemStack CopperRail = new ItemStack(Material.POWERED_RAIL, 6);
        NamespacedKey CopperRail_key = new NamespacedKey(namespace, "copper_rail");
        ShapedRecipe CopperRail_Recipe = new ShapedRecipe(CopperRail_key, CopperRail  );
        CopperRail_Recipe.shape(
                "C C",
                "CSC",
                "CRC");
        CopperRail_Recipe.setIngredient('C', Copper);
        CopperRail_Recipe.setIngredient('R', Redstone);
        CopperRail_Recipe.setIngredient('S', Material.STICK);

        Bukkit.addRecipe(CopperRail_Recipe);

        //LIGHT_WEIGHTED_PRESSURE_PLATE
        ItemStack CopperPlate = new ItemStack(Material.LIGHT_WEIGHTED_PRESSURE_PLATE, 6);
        NamespacedKey CopperPlate_key = new NamespacedKey(namespace, "copper_plate");
        ShapedRecipe CopperPlate_Recipe = new ShapedRecipe(CopperPlate_key, CopperPlate  );
        CopperPlate_Recipe.shape("CC");
        CopperPlate_Recipe.setIngredient('C', Copper);

        Bukkit.addRecipe(CopperPlate_Recipe);
    }
}
