package me.evanskistudios.rm.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

public class RecipeNewWorkbenches {
    private static final RecipeChoice MaterialChoiceWOOD = new RecipeChoice.MaterialChoice(Arrays.asList(Material.OAK_PLANKS, Material.BIRCH_PLANKS, Material.ACACIA_PLANKS, Material.BAMBOO_PLANKS, Material.DARK_OAK_PLANKS, Material.CHERRY_PLANKS, Material.CRIMSON_PLANKS, Material.JUNGLE_PLANKS, Material.MANGROVE_PLANKS, Material.SPRUCE_PLANKS, Material.WARPED_PLANKS));
    public static void HarderWorkBenches(Plugin namespace){
        ItemStack CraftingBench = new ItemStack(Material.CRAFTING_TABLE, 1);
        NamespacedKey CraftingTableKey = new NamespacedKey(namespace, "CraftingTable");
        ShapedRecipe CraftingTableRecipe = new ShapedRecipe(CraftingTableKey, CraftingBench);
        CraftingTableRecipe.shape(
                "CC",
                "CC");
        CraftingTableRecipe.setIngredient('C', Material.COBBLESTONE);
        Bukkit.addRecipe(CraftingTableRecipe);


        ItemStack Furnace = new ItemStack(Material.FURNACE, 1);
        NamespacedKey FurnaceKey = new NamespacedKey(namespace, "Furnace");
        ShapedRecipe FurnaceRecipe = new ShapedRecipe(FurnaceKey, Furnace);
        FurnaceRecipe.shape(
                "WW",
                "WW");
        FurnaceRecipe.setIngredient('W', MaterialChoiceWOOD);
        Bukkit.addRecipe(FurnaceRecipe);
    }
}
