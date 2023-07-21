package me.evanskistudios.rm.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;

public class RecipeHorseArmor {
    private static final List<Material> WoolTypes = Arrays.asList(Material.BLACK_WOOL, Material.BLUE_WOOL, Material.BROWN_WOOL, Material.CYAN_WOOL, Material.GRAY_WOOL, Material.GREEN_WOOL, Material.LIGHT_BLUE_WOOL, Material.LIGHT_GRAY_WOOL, Material.LIME_WOOL, Material.MAGENTA_WOOL, Material.ORANGE_WOOL, Material.PINK_WOOL, Material.PURPLE_WOOL, Material.RED_WOOL, Material.WHITE_WOOL, Material.YELLOW_WOOL);
    private static final RecipeChoice MaterialChoiceWOOL = new RecipeChoice.MaterialChoice(WoolTypes);
    public static void HorseArmor(Plugin namespace) {
        //Leather
        {
            ItemStack LeatherHorseArmor = new ItemStack(Material.LEATHER_HORSE_ARMOR, 1);
            NamespacedKey LeatherHorseArmorKey = new NamespacedKey(namespace, "LeatherHorseArmor");
            ShapedRecipe LeatherHorseArmorRecipe = new ShapedRecipe(LeatherHorseArmorKey, LeatherHorseArmor);

            LeatherHorseArmorRecipe.shape(
                    "NNL",
                    "LWL",
                    "LLL");
            LeatherHorseArmorRecipe.setIngredient('N', Material.AIR);
            LeatherHorseArmorRecipe.setIngredient('L', Material.LEATHER);
            LeatherHorseArmorRecipe.setIngredient('W', MaterialChoiceWOOL);

            Bukkit.addRecipe(LeatherHorseArmorRecipe);
        }
        //Iron
        {
            ItemStack IronHorseArmor = new ItemStack(Material.IRON_HORSE_ARMOR, 1);
            NamespacedKey IronHorseArmorKey = new NamespacedKey(namespace, "IronHorseArmor");
            ShapedRecipe IronHorseArmorRecipe = new ShapedRecipe(IronHorseArmorKey, IronHorseArmor);

            IronHorseArmorRecipe.shape(
                    "AAM",
                    "MWM",
                    "MMM");
            IronHorseArmorRecipe.setIngredient('A', Material.AIR);
            IronHorseArmorRecipe.setIngredient('W', MaterialChoiceWOOL);
            IronHorseArmorRecipe.setIngredient('M', Material.IRON_INGOT);

            Bukkit.addRecipe(IronHorseArmorRecipe);
        }
        //Gold
        {
            ItemStack GoldHorseArmor = new ItemStack(Material.GOLDEN_HORSE_ARMOR, 1);
            NamespacedKey GoldHorseArmorKey = new NamespacedKey(namespace, "GoldHorseArmor");
            ShapedRecipe GoldHorseArmorRecipe = new ShapedRecipe(GoldHorseArmorKey, GoldHorseArmor);

            GoldHorseArmorRecipe.shape(
                    "AAM",
                    "MWM",
                    "MMM");
            GoldHorseArmorRecipe.setIngredient('A', Material.AIR);
            GoldHorseArmorRecipe.setIngredient('W', MaterialChoiceWOOL);
            GoldHorseArmorRecipe.setIngredient('M', Material.GOLD_INGOT);

            Bukkit.addRecipe(GoldHorseArmorRecipe);
        }
        //DIAMOND
        {
            ItemStack DiamondHorseArmor = new ItemStack(Material.DIAMOND_HORSE_ARMOR, 1);
            NamespacedKey DiamondHorseArmorKey = new NamespacedKey(namespace, "DiamondHorseArmor");
            ShapedRecipe DiamondHorseArmorRecipe = new ShapedRecipe(DiamondHorseArmorKey, DiamondHorseArmor);

            DiamondHorseArmorRecipe.shape(
                    "AAM",
                    "MWM",
                    "MMM");
            DiamondHorseArmorRecipe.setIngredient('A', Material.AIR);
            DiamondHorseArmorRecipe.setIngredient('W', MaterialChoiceWOOL);
            DiamondHorseArmorRecipe.setIngredient('M', Material.DIAMOND);

            Bukkit.addRecipe(DiamondHorseArmorRecipe);
        }
    }
}
