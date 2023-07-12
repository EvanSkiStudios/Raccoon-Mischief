package me.evanskistudios.rm.Recipes;

import me.evanskistudios.rm.Utilis.Glow;
import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class RecipeMilkPotion {

    public static ItemStack Item;
    public static void SplashPotionOMilk(Plugin namespace) {
        ItemStack MilkPotion = new ItemStack(Material.SPLASH_POTION, 1);

        ItemMeta MilkPotion_Meta = MilkPotion.getItemMeta();
        MilkPotion_Meta.setCustomModelData(1);

        //Tag
        NamespacedKey TagKey = new NamespacedKey(namespace, "milk_potion");
        MilkPotion_Meta.getPersistentDataContainer().set(TagKey, PersistentDataType.DOUBLE, 1.0);

        //Text
        MilkPotion_Meta.setDisplayName(ChatColor.RESET + "Splash potion of Milk");
        MilkPotion_Meta.setLore(null);
        MilkPotion_Meta.setLore(List.of(ChatColor.BLUE +"Removes all potion effects"));

        //Enchant glint
        NamespacedKey EnchantKey = new NamespacedKey(namespace, "Glow");
        Glow glow = new Glow(EnchantKey);
        MilkPotion_Meta.addEnchant(glow, 1, true);

        //set Item meta
        MilkPotion.setItemMeta(MilkPotion_Meta);

        //Color
        PotionMeta MilkPotion_PotionMeta = (PotionMeta) MilkPotion_Meta;
        MilkPotion_PotionMeta.setColor(Color.WHITE);

        //set potion meta
        MilkPotion.setItemMeta(MilkPotion_PotionMeta);

        //Crafting
        NamespacedKey key = new NamespacedKey(namespace, "ListenerMilkPotion");

        ShapelessRecipe MilkPotion_Recipe = new ShapelessRecipe(key, MilkPotion);
        MilkPotion_Recipe.addIngredient(1, Material.MILK_BUCKET);
        MilkPotion_Recipe.addIngredient(1, Material.GUNPOWDER);

        Bukkit.addRecipe(MilkPotion_Recipe);

        Item = MilkPotion;
    }
    public static ItemStack getItem() {
        return Item;
    }
}
