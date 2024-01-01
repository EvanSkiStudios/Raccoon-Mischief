package me.evanskistudios.rm;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class FoodManager {
    public static Plugin plugin = RaccoonMischief.getPlugin();

    public static final NamespacedKey NSKEY_DEBUG_CHICKEN = new NamespacedKey(plugin, "Debug_Chicken");

    public static ItemStack FoodItem(Material BaseFood, String DisplayName,  int CustomModelData, NamespacedKey FoodKey){
        ItemStack NewFood = new ItemStack(BaseFood, 1);
        ItemMeta NewFood_Meta = NewFood.getItemMeta();
        NewFood_Meta.setDisplayName(DisplayName);
        NewFood_Meta.setCustomModelData(CustomModelData);
        NewFood_Meta.getPersistentDataContainer().set(FoodKey, PersistentDataType.DOUBLE, 1.0);
        NewFood.setItemMeta(NewFood_Meta);

        return NewFood;
    }

    public static void AddRecipes(){
        // Recipes for new food items

    }


    public static ItemStack DebugChicken = FoodItem(Material.CHICKEN, ChatColor.GREEN +""+ ChatColor.ITALIC + "DEBUG CHICKEN", 69, NSKEY_DEBUG_CHICKEN);
}
