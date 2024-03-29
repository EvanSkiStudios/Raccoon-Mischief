package me.evanskistudios.rm;

import me.evanskistudios.rm.Utilis.EnchantmentWrapper;
import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class EnchantManager {
    public static Enchantment[] EnchantTypes;
    public static Enchantment[] getEnchants() {
        return EnchantTypes;
    }

    public static String getEnchantName(String Enchant) {
        Enchant = Enchant.toUpperCase();
        for (Enchantment enchantType : EnchantTypes) {
            String EnchantName = enchantType.getName();
            if (Enchant.equalsIgnoreCase(EnchantName)) {
                return EnchantName;
            }
        }
        return null;
    }

    public static final Enchantment TELEKINESIS = new EnchantmentWrapper("enchanttelekinesis", "Telekinesis", 1);
    public static final Enchantment HEAVYSTEP = new EnchantmentWrapper("enchantheavystep", "Heavy Step", 1);
    public static final Enchantment SOULBOUND = new EnchantmentWrapper("enchantsoulbound", "Soul Bound", 1);
    public static final Enchantment EXPLOSIVE = new EnchantmentWrapper("enchantexplosive", "Explosive", 1);

    public static void Register(){
        Enchantment[] Enchantments = {TELEKINESIS, HEAVYSTEP, SOULBOUND, EXPLOSIVE};
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
