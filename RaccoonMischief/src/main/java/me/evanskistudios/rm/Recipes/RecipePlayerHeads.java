package me.evanskistudios.rm.Recipes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
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

    public static void PlayerHeadCooking(Plugin namespace) {
        float xp = 1.0f;
        //Cooking time is in ticks not seconds
        int Campfire_Time = 600;
        int Furnace_time = 206;
        int Smoker_time = 100;

        FurnaceRecipe PlayerHeadFurnaceRecipe = new FurnaceRecipe(
                new NamespacedKey(namespace,"FurnaceCookingPlayerHead"),
                Strange_Meat(), Material.PLAYER_HEAD, xp, Furnace_time
        );
        Bukkit.addRecipe(PlayerHeadFurnaceRecipe);

        CampfireRecipe PlayerHead_campfire_recipe = new CampfireRecipe(
                new NamespacedKey(namespace,"CampCookingPlayerHead"),
                Strange_Meat(), Material.PLAYER_HEAD, xp,
                Campfire_Time
        );
        Bukkit.addRecipe(PlayerHead_campfire_recipe);

        SmokingRecipe PlayerHead_Smoker_recipe = new SmokingRecipe(
                new NamespacedKey(namespace,"SmokeCookingPlayerHead"),
                Strange_Meat(), Material.PLAYER_HEAD, xp,
                Smoker_time
        );
        Bukkit.addRecipe(PlayerHead_Smoker_recipe);
    }
}
