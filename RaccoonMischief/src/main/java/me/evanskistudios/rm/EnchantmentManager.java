package me.evanskistudios.rm;

import me.evanskistudios.rm.utilis.EnchantmentWrapper;
import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class EnchantmentManager {

    public static final Enchantment SOULBOUND = new EnchantmentWrapper("enchantsoulbound", "SoulBound", 1);

    public static void Register(){
        boolean Registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(SOULBOUND);

        if (!Registered){
            RegisterEnchantments(SOULBOUND);
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
