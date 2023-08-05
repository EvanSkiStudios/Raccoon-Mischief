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
                "WWW",
                "WAW",
                "WWW");
        CraftingTableRecipe.setIngredient('A', Material.AIR);
        CraftingTableRecipe.setIngredient('W', MaterialChoiceWOOD);
        Bukkit.addRecipe(CraftingTableRecipe);


        ItemStack Furnace = new ItemStack(Material.FURNACE, 1);
        NamespacedKey FurnaceKey = new NamespacedKey(namespace, "Furnace");
        ShapedRecipe FurnaceRecipe = new ShapedRecipe(FurnaceKey, Furnace);
        FurnaceRecipe.shape(
                "CC",
                "CC");
        FurnaceRecipe.setIngredient('C', Material.COBBLESTONE);
        Bukkit.addRecipe(FurnaceRecipe);

        ItemStack Chest = new ItemStack(Material.CHEST, 1);
        NamespacedKey ChestKey = new NamespacedKey(namespace, "Chest");
        ShapedRecipe ChestRecipe = new ShapedRecipe(ChestKey, Chest);
        ChestRecipe.shape(
                "WW",
                "WW");
        ChestRecipe.setIngredient('W', MaterialChoiceWOOD);
        Bukkit.addRecipe(ChestRecipe);

        ItemStack TrappedChest = new ItemStack(Material.TRAPPED_CHEST, 1);
        NamespacedKey TrappedChestKey = new NamespacedKey(namespace, "TrappedChest");
        ShapedRecipe TrappedChestRecipe = new ShapedRecipe(TrappedChestKey, TrappedChest);
        TrappedChestRecipe.shape(
                "TA",
                "WW",
                "WW");
        TrappedChestRecipe.setIngredient('A', Material.AIR);
        TrappedChestRecipe.setIngredient('T', Material.TRIPWIRE_HOOK);
        TrappedChestRecipe.setIngredient('W', MaterialChoiceWOOD);
        Bukkit.addRecipe(TrappedChestRecipe);

        ItemStack TrappedChestWithChest = new ItemStack(Material.TRAPPED_CHEST, 1);
        NamespacedKey TrappedChestWithChestKey = new NamespacedKey(namespace, "TrappedChestWithChest");
        ShapelessRecipe TrappedChestWithChestRecipe = new ShapelessRecipe(TrappedChestWithChestKey, TrappedChestWithChest);
        TrappedChestWithChestRecipe.addIngredient(1, Material.TRIPWIRE_HOOK);
        TrappedChestWithChestRecipe.addIngredient(1, Material.CHEST);
        Bukkit.addRecipe(TrappedChestWithChestRecipe);
    }
}
