package me.evanskistudios.rm;
import me.evanskistudios.rm.recipes.*;

import org.bukkit.plugin.Plugin;

public class AddRecipes {
    public static void Recipes(Plugin namespace) {
        //ClassFileName.MethodName(namespace);

        tactical_dirt.TactDirt(namespace);
        rottenflesh_to_leather.RotLeather(namespace);
        dirt_to_seeds.DirtSeeds(namespace);
        unmetadata_cookies.NoMDCookies(namespace);
        Harder_Armor.HArmor(namespace);
        milk_potion.SplashPotionOMilk(namespace);
    }

}
