package me.evanskistudios.rm;
import me.evanskistudios.rm.Recipes.*;

import org.bukkit.Material;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.Plugin;

import java.util.Iterator;

import static org.bukkit.Bukkit.getServer;

public class RecipeManager {
    public static void Recipes(){
        RemoveRecipes();
        AddRecipes();
    }

    public static void RemoveRecipes() {
        Iterator<Recipe> it = getServer().recipeIterator();

        while (it.hasNext()) {
            Recipe recipe = it.next();
            if (recipe != null) {
                //check what it makes, not what it uses, then remove it
                Material RecipeResult = recipe.getResult().getType();

                switch (RecipeResult) {
                    default -> {/*Default don't do anything*/}
                    case IRON_HELMET, IRON_CHESTPLATE, IRON_LEGGINGS, IRON_BOOTS,
                            GOLDEN_HELMET, GOLDEN_CHESTPLATE, GOLDEN_LEGGINGS, GOLDEN_BOOTS,
                            DIAMOND_HELMET, DIAMOND_CHESTPLATE, DIAMOND_LEGGINGS, DIAMOND_BOOTS,
                            LIGHT_WEIGHTED_PRESSURE_PLATE, CLOCK, POWERED_RAIL, CAKE, CRAFTING_TABLE, FURNACE, CHEST, TRAPPED_CHEST
                            -> it.remove();

                }
            }
        }
    }

    public static void AddRecipes() {
        Plugin P = RaccoonMischief.getPlugin();
        //ClassFileName.MethodName(namespace);

        RecipeCakeSlices.CakeSlice(P); //Has to be above Recipe Cake from slices because that requires the item from this one
        RecipeCakeFromSlices.CakeFromSlice(P);

        RecipeDirtToSeeds.DirtSeeds(P);

        RecipeExpCrystal.ExpCrystal(P);

        RecipeHarderArmor.HardArmor(P);

        RecipeHorseArmor.HorseArmor(P);

        RecipeJTEApple.JTEApple(P);

        RecipeMilkPotion.SplashPotionOMilk(P);

        RecipeNetherWart.NetherWart(P);

        RecipeNewCake.Cake(P);

        RecipeNewCopperRedstone.NewCopperRedstoneItems(P);

        RecipeNewWorkbenches.HarderWorkBenches(P);

        RecipeRedMushroomDye.MushroomDye(P);

        RecipeRottenFleshToLeather.RotLeather(P);

        RecipeTacticalDirt.TactDirt(P);

        RecipeThrowableBrick.ThrowableBrick(P);

        RecipeUnMetaDataCookies.NoMDCookies(P);
    }
}
