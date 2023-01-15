package me.evanskistudios.rm;
import me.evanskistudios.rm.utilis.*;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;

public class Utilities {
    public static void registerGlow() {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Plugin namespace = RaccoonMischief.getPlugin();
            Glow glow = new Glow(new NamespacedKey(namespace, "glow"));
            Enchantment.registerEnchantment(glow);
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
