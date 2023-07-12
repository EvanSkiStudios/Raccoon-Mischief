package me.evanskistudios.rm.Items;

import me.evanskistudios.rm.RaccoonMischief;
import me.evanskistudios.rm.Utilis.Glow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class ItemUpgradeShard{
    public static ItemStack Item;

    public static ItemStack UpgradeShard(){
        Plugin namespace = RaccoonMischief.getPlugin();

        ItemStack UpShard = new ItemStack(Material.AMETHYST_SHARD, 1);

        ItemMeta UpShard_Meta = UpShard.getItemMeta();

        //Enchant glint
        NamespacedKey EnchantKey = new NamespacedKey(namespace, "Glow");
        Glow glow = new Glow(EnchantKey);
        UpShard_Meta.addEnchant(glow, 1, true);

        UpShard_Meta.setDisplayName(ChatColor.RESET+""+ChatColor.LIGHT_PURPLE+ "Upgrade Shard");
        UpShard_Meta.setLore(List.of(ChatColor.BLUE+""+ChatColor.ITALIC+"A shard of chaos with unknown effects"));

        UpShard_Meta.setCustomModelData(8583);

        NamespacedKey key = new NamespacedKey(namespace, "ud_shard");
        UpShard_Meta.getPersistentDataContainer().set(key, PersistentDataType.DOUBLE, 1.0);

        UpShard.setItemMeta(UpShard_Meta);

        Item = UpShard;
        return Item;
    }




}
