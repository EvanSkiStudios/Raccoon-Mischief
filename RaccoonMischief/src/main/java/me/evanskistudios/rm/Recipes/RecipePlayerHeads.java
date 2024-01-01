package me.evanskistudios.rm.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class RecipePlayerHeads {
    private static ItemStack Strange_Meat(){
        ItemStack Strange_meat = new ItemStack(Material.COOKED_BEEF);
        String StrangeMeatName = (ChatColor.RESET+"Cooked Strange Meat");
        ItemMeta Strange_meat_meta = Strange_meat.getItemMeta();
        Strange_meat_meta.setDisplayName(StrangeMeatName);
        Strange_meat_meta.setCustomModelData(999);
        Strange_meat.setItemMeta(Strange_meat_meta);

        return Strange_meat;
    }

    public static void PlayerHeadFurnace(Plugin namespace) {
        float xp = 1.0f;
        int Furnace_time = 200;

        FurnaceRecipe PlayerHeadFurnaceRecipe = new FurnaceRecipe(
                new NamespacedKey(namespace,"FurnaceCookingPlayerHead"),
                Strange_Meat(), Material.PLAYER_HEAD, xp, Furnace_time
        );
        Bukkit.addRecipe(PlayerHeadFurnaceRecipe);
    }
}
