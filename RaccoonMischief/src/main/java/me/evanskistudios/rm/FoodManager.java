package me.evanskistudios.rm;

import me.evanskistudios.rm.Utilis.Glow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FoodManager {
    public static Plugin plugin = RaccoonMischief.getPlugin();

    public static final NamespacedKey NSKEY_DEBUG_CHICKEN = new NamespacedKey(plugin, "Debug_Chicken");
    public static final NamespacedKey NSKEY_BOTTLEOLAVA = new NamespacedKey(plugin, "BottleOLava");
    public static final NamespacedKey NSKEY_BOTTLEOMILK = new NamespacedKey(plugin, "BottleOMilk");
    public static final NamespacedKey NSKEY_FRUITSALAD = new NamespacedKey(plugin, "FruitSalad");

    public static ItemStack FoodItem(Material BaseFood, String DisplayName, String LoreString,  int CustomModelData, NamespacedKey FoodKey, Boolean EnchantGlow){
        ItemStack NewFood = new ItemStack(BaseFood, 1);
        ItemMeta NewFood_Meta = NewFood.getItemMeta();
        NewFood_Meta.setDisplayName(ChatColor.RESET +""+ DisplayName);
        NewFood_Meta.setCustomModelData(CustomModelData);
        NewFood_Meta.getPersistentDataContainer().set(FoodKey, PersistentDataType.DOUBLE, 1.0);

        if (EnchantGlow) {
            NamespacedKey EnchantKey = new NamespacedKey(plugin, "Glow");
            Glow glow = new Glow(EnchantKey);
            NewFood_Meta.addEnchant(glow, 1, true);
        }

        if (!LoreString.equals("")) {
            NewFood_Meta.setLore(List.of(LoreString));
        }

        NewFood.setItemMeta(NewFood_Meta);

        return NewFood;
    }

    public static void AddRecipes(){
        // Recipes for new food items

    }


    public static ItemStack DebugChicken = FoodItem(Material.CHICKEN, ChatColor.GREEN +""+ ChatColor.ITALIC + "DEBUG CHICKEN", "", 69, NSKEY_DEBUG_CHICKEN, false);
    public static ItemStack BottleOLava = FoodItem(Material.HONEY_BOTTLE, "Bottle o' Lava", "", 1, NSKEY_BOTTLEOLAVA, false);
    public static ItemStack BottleOMilk = FoodItem(Material.HONEY_BOTTLE, "Bottle o' Milk", ChatColor.ITALIC +""+ChatColor.BLUE  +"Removes all potion effects", 2, NSKEY_BOTTLEOMILK, true);
    public static ItemStack FruitSalad = FoodItem(Material.RABBIT_STEW, "Fruit Salad", ChatColor.ITALIC +"Very Yummy", 7083, NSKEY_FRUITSALAD, false);
}
