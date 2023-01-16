package me.evanskistudios.rm;
import me.evanskistudios.rm.recipes.*;

import org.bukkit.plugin.Plugin;

public class AddRecipes {
    public static void Recipes() {
        Plugin namespace = RaccoonMischief.getPlugin();
        //ClassFileName.MethodName(namespace);

        dirt_to_seeds.DirtSeeds(namespace);
        Harder_Armor.HArmor(namespace);
        milk_potion.SplashPotionOMilk(namespace);
        notch_apple.NotchApple(namespace);
        rottenflesh_to_leather.RotLeather(namespace);
        tactical_dirt.TactDirt(namespace);
        unmetadata_cookies.NoMDCookies(namespace);
    }
}
