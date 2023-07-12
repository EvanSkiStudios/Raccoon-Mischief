package me.evanskistudios.rm.Utilis;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class EnchantmentWrapper extends Enchantment{
    private final String Name;
    private final int MaxLevel;

    public EnchantmentWrapper(String Namespace, String name, int level) {
        super(NamespacedKey.minecraft(Namespace));
        this.Name = name;
        this.MaxLevel = level;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public int getMaxLevel() {
        return MaxLevel;
    }

    @Override
    public int getStartLevel() {
        return 0;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return false;
    }
}
