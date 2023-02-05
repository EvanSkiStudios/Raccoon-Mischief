package me.evanskistudios.rm;

import me.evanskistudios.rm.utilis.EnchantmentWrapper;
import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class EnchantmentManager {
    public static Enchantment[] EnchantTypes;
    public static Enchantment[] getEnchants() {
        return EnchantTypes;
    }

    public static String getEnchantName(String Enchant) {
        //Logic to convert ALL caps Enchant name to Lowercase first letter upper string
        String Name = Enchant;
        Name = Name.toLowerCase();
        String FirstLetter = String.valueOf(Name.charAt(0)).toUpperCase();
        Name = Name.replace(Name.charAt(0), FirstLetter.charAt(0));

        return Name;
    }

    public static final Enchantment TELEKINESIS = new EnchantmentWrapper("enchanttelekinesis", "Telekinesis", 1);
    public static final Enchantment HEAVYSTEP = new EnchantmentWrapper("enchantheavystep", "HeavyStep", 1);

    public static void Register(){
        Enchantment[] Enchantments = {TELEKINESIS, HEAVYSTEP};
        EnchantTypes = Enchantments;

        for (Enchantment Enchant : Enchantments) {

            boolean Registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(Enchant);

            if (!Registered) {
                RegisterEnchantments(Enchant);
            }
        }
    }

    public static void RegisterEnchantments(Enchantment enchantment){
        boolean Registered = true;
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        }catch(Exception e){
            Registered = false;
            e.printStackTrace();
        }
        if (Registered){
            //print to console
        }
    }
}