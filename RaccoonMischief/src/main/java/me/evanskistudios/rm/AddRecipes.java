package me.evanskistudios.rm;
import me.evanskistudios.rm.recipes.*;

import org.bukkit.plugin.Plugin;

public class AddRecipes {
    public static void Recipes() {
        Plugin P = RaccoonMischief.getPlugin();
        //ClassFileName.MethodName(namespace);

        Recipe_dirt_to_seeds.DirtSeeds(P);

        Recipe_RottenFlesh_to_leather.RotLeather(P);

        Recipe_tactical_dirt.TactDirt(P);

        Recipe_unmetadata_cookies.NoMDCookies(P);

        RecipeHarderArmor.HardArmor(P);

        RecipeMilkPotion.SplashPotionOMilk(P);

        RecipeNewCopperRedstone.NewCopperRedstoneItems(P);

        RecipeJTEApple.JTEApple(P);

    }
}
