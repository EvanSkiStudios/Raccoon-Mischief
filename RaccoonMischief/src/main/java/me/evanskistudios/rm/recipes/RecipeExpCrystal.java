package me.evanskistudios.rm.Recipes;

import me.evanskistudios.rm.Items.ItemUpgradeShard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class RecipeExpCrystal {

    public static ItemStack Item;
    public static void ExpCrystal(Plugin namespace) {

        RecipeChoice UpgradeShard = new RecipeChoice.MaterialChoice.ExactChoice(ItemUpgradeShard.UpgradeShard());

        ItemStack ExpCrystal = new ItemStack(Material.CHORUS_FRUIT, 1);
        ItemMeta ExpCrystal_Meta = ExpCrystal.getItemMeta();

        NamespacedKey key = new NamespacedKey(namespace, "exp_crystal");
        ExpCrystal_Meta.getPersistentDataContainer().set(key, PersistentDataType.DOUBLE, 1.0);

        ExpCrystal_Meta.setDisplayName(ChatColor.RESET+""+ChatColor.GREEN + "Xp Orb");
        ExpCrystal_Meta.setLore(List.of(ChatColor.BLUE+"Contains 1 Exp Level"));
        ExpCrystal_Meta.setCustomModelData(5850);

        ExpCrystal.setItemMeta(ExpCrystal_Meta);

        ShapelessRecipe ExpCrystal_Recipe = new ShapelessRecipe(new NamespacedKey(namespace, "xp_crystal"), ExpCrystal);
        ExpCrystal_Recipe.addIngredient(UpgradeShard);
        ExpCrystal_Recipe.addIngredient(1, Material.GLASS_BOTTLE);


        Bukkit.addRecipe(ExpCrystal_Recipe);

        Item = ExpCrystal;
    }

    public static ItemStack getItem() {
        return Item;
    }
}
