package me.evanskistudios.rm.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;

public class Harder_Armor {
    public static void HArmor(Plugin namespace) {

        //IRON
        {
                ItemStack IH = new ItemStack(Material.IRON_HELMET, 1);
                ItemStack IC = new ItemStack(Material.IRON_CHESTPLATE, 1);
                ItemStack IL = new ItemStack(Material.IRON_LEGGINGS, 1);
                ItemStack IB = new ItemStack(Material.IRON_BOOTS, 1);

                NamespacedKey I_H_key = new NamespacedKey(namespace, "I_Helmet");
                NamespacedKey I_C_key = new NamespacedKey(namespace, "I_ChestPlate");
                NamespacedKey I_L_key = new NamespacedKey(namespace, "I_Leggings");
                NamespacedKey I_B_key = new NamespacedKey(namespace, "I_Boots");

                //Iron Helmet
                ShapedRecipe H_I_H_Recipe = new ShapedRecipe(I_H_key, IH);
                H_I_H_Recipe.shape("III", "IOI");
                H_I_H_Recipe.setIngredient('I', Material.IRON_INGOT);
                H_I_H_Recipe.setIngredient('O', Material.LEATHER_HELMET);
                Bukkit.addRecipe(H_I_H_Recipe);

                //Iron ChestPlate
                ShapedRecipe C_I_H_Recipe = new ShapedRecipe(I_C_key, IC);
                C_I_H_Recipe.shape("IOI", "III", "III");
                C_I_H_Recipe.setIngredient('I', Material.IRON_INGOT);
                C_I_H_Recipe.setIngredient('O', Material.LEATHER_CHESTPLATE);
                Bukkit.addRecipe(C_I_H_Recipe);

                //Iron Leggings
                ShapedRecipe L_I_H_Recipe = new ShapedRecipe(I_L_key, IL);
                L_I_H_Recipe.shape("III", "IOI", "I I");
                L_I_H_Recipe.setIngredient('I', Material.IRON_INGOT);
                L_I_H_Recipe.setIngredient('O', Material.LEATHER_LEGGINGS);
                Bukkit.addRecipe(L_I_H_Recipe);

                //Iron Boots
                ShapedRecipe B_I_H_Recipe = new ShapedRecipe(I_B_key, IB);
                B_I_H_Recipe.shape("IOI", "I I");
                B_I_H_Recipe.setIngredient('I', Material.IRON_INGOT);
                B_I_H_Recipe.setIngredient('O', Material.LEATHER_BOOTS);
                Bukkit.addRecipe(B_I_H_Recipe);
        }
        //GOLD
        {
                ItemStack GH = new ItemStack(Material.GOLDEN_HELMET, 1);
                ItemStack GC = new ItemStack(Material.GOLDEN_CHESTPLATE, 1);
                ItemStack GL = new ItemStack(Material.GOLDEN_LEGGINGS, 1);
                ItemStack GB = new ItemStack(Material.GOLDEN_BOOTS, 1);

                NamespacedKey G_H_key = new NamespacedKey(namespace, "G_Helmet");
                NamespacedKey G_C_key = new NamespacedKey(namespace, "G_ChestPlate");
                NamespacedKey G_L_key = new NamespacedKey(namespace, "G_Leggings");
                NamespacedKey G_B_key = new NamespacedKey(namespace, "G_Boots");

                //Gold Helmet
                ShapedRecipe H_G_H_Recipe = new ShapedRecipe(G_H_key, GH);
                H_G_H_Recipe.shape("III", "IOI");
                H_G_H_Recipe.setIngredient('I', Material.GOLD_INGOT);
                H_G_H_Recipe.setIngredient('O', Material.IRON_HELMET);
                Bukkit.addRecipe(H_G_H_Recipe);

                //Gold ChestPlate
                ShapedRecipe C_G_H_Recipe = new ShapedRecipe(G_C_key, GC);
                C_G_H_Recipe.shape("IOI", "III", "III");
                C_G_H_Recipe.setIngredient('I', Material.GOLD_INGOT);
                C_G_H_Recipe.setIngredient('O', Material.IRON_CHESTPLATE);
                Bukkit.addRecipe(C_G_H_Recipe);

                //Gold Leggings
                ShapedRecipe L_G_H_Recipe = new ShapedRecipe(G_L_key, GL);
                L_G_H_Recipe.shape("III", "IOI", "I I");
                L_G_H_Recipe.setIngredient('I', Material.GOLD_INGOT);
                L_G_H_Recipe.setIngredient('O', Material.IRON_LEGGINGS);
                Bukkit.addRecipe(L_G_H_Recipe);

                //Gold Boots
                ShapedRecipe B_G_H_Recipe = new ShapedRecipe(G_B_key, GB);
                B_G_H_Recipe.shape("IOI", "I I");
                B_G_H_Recipe.setIngredient('I', Material.GOLD_INGOT);
                B_G_H_Recipe.setIngredient('O', Material.IRON_BOOTS);
                Bukkit.addRecipe(B_G_H_Recipe);
        }
        //DIAMOND
        {
                ItemStack DH = new ItemStack(Material.DIAMOND_HELMET, 1);
                ItemStack DC = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
                ItemStack DL = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
                ItemStack DB = new ItemStack(Material.DIAMOND_BOOTS, 1);

                NamespacedKey D_H_key = new NamespacedKey(namespace, "D_Helmet");
                NamespacedKey D_C_key = new NamespacedKey(namespace, "D_ChestPlate");
                NamespacedKey D_L_key = new NamespacedKey(namespace, "D_Leggings");
                NamespacedKey D_B_key = new NamespacedKey(namespace, "D_Boots");

                //Diamond Helmet
                ShapedRecipe H_D_H_Recipe = new ShapedRecipe(D_H_key, DH);
                H_D_H_Recipe.shape("III", "IOI");
                H_D_H_Recipe.setIngredient('I', Material.DIAMOND);
                H_D_H_Recipe.setIngredient('O', Material.GOLDEN_HELMET);
                Bukkit.addRecipe(H_D_H_Recipe);

                //Diamond ChestPlate
                ShapedRecipe C_D_H_Recipe = new ShapedRecipe(D_C_key, DC);
                C_D_H_Recipe.shape("IOI", "III", "III");
                C_D_H_Recipe.setIngredient('I', Material.DIAMOND);
                C_D_H_Recipe.setIngredient('O', Material.GOLDEN_CHESTPLATE);
                Bukkit.addRecipe(C_D_H_Recipe);

                //Diamond Leggings
                ShapedRecipe L_D_H_Recipe = new ShapedRecipe(D_L_key, DL);
                L_D_H_Recipe.shape("III", "IOI", "I I");
                L_D_H_Recipe.setIngredient('I', Material.DIAMOND);
                L_D_H_Recipe.setIngredient('O', Material.GOLDEN_LEGGINGS);
                Bukkit.addRecipe(L_D_H_Recipe);

                //Diamond Boots
                ShapedRecipe B_D_H_Recipe = new ShapedRecipe(D_B_key, DB);
                B_D_H_Recipe.shape("IOI", "I I");
                B_D_H_Recipe.setIngredient('I', Material.DIAMOND);
                B_D_H_Recipe.setIngredient('O', Material.GOLDEN_BOOTS);
                Bukkit.addRecipe(B_D_H_Recipe);

        //Smiting
        {
                NamespacedKey G_H_S_key = new NamespacedKey(namespace, "S_G_Helmet");
                NamespacedKey G_C_S_key = new NamespacedKey(namespace, "S_G_ChestPlate");
                NamespacedKey G_L_S_key = new NamespacedKey(namespace, "S_G_Leggings");
                NamespacedKey G_B_S_key = new NamespacedKey(namespace, "S_G_Boots");

                ItemStack IHelmet = new ItemStack(Material.IRON_HELMET, 1);
                ItemStack IChest = new ItemStack(Material.IRON_CHESTPLATE, 1);
                ItemStack ILegg = new ItemStack(Material.IRON_LEGGINGS, 1);
                ItemStack IBoots = new ItemStack(Material.IRON_BOOTS, 1);

                ItemStack GHelmet = new ItemStack(Material.GOLDEN_HELMET, 1);
                ItemStack GChest = new ItemStack(Material.GOLDEN_CHESTPLATE, 1);
                ItemStack GLegg = new ItemStack(Material.GOLDEN_LEGGINGS, 1);
                ItemStack GBoots = new ItemStack(Material.GOLDEN_BOOTS, 1);

                ItemStack GoldIngot = new ItemStack(Material.GOLD_INGOT,1);

                RecipeChoice RC = new RecipeChoice.MaterialChoice.ExactChoice(GoldIngot);

                SmithingRecipe H_G_H_S_Recipe = new SmithingRecipe(
                        G_H_S_key,
                        IHelmet,
                        new RecipeChoice.MaterialChoice.ExactChoice(GHelmet),
                        RC
                );
                Bukkit.addRecipe(H_G_H_S_Recipe);

                SmithingRecipe H_G_C_S_Recipe = new SmithingRecipe(
                        G_C_S_key,
                        IChest,
                        new RecipeChoice.MaterialChoice.ExactChoice(GChest),
                        RC
                );
                Bukkit.addRecipe(H_G_C_S_Recipe);

                SmithingRecipe H_G_L_S_Recipe = new SmithingRecipe(
                        G_L_S_key,
                        ILegg,
                        new RecipeChoice.MaterialChoice.ExactChoice(GLegg),
                        RC
                );
                Bukkit.addRecipe(H_G_L_S_Recipe);

                SmithingRecipe H_G_B_S_Recipe = new SmithingRecipe(
                        G_B_S_key,
                        IBoots,
                        new RecipeChoice.MaterialChoice.ExactChoice(GBoots),
                        RC
                );
                Bukkit.addRecipe(H_G_B_S_Recipe);
        }

        }
    }
}
