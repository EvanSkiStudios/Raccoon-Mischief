package me.evanskistudios.rm.enchantevents;

import me.evanskistudios.rm.EnchantmentManager;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;

public class EnchantListenerTest implements Listener {
    @EventHandler
    public static void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        GameMode PlayerGameMode = player.getGameMode();

        //Player is in wrong GameMode
        if (PlayerGameMode == GameMode.CREATIVE || PlayerGameMode == GameMode.SPECTATOR) return;

        ItemStack MainHandItem = player.getInventory().getItemInMainHand();
        Material MainHandItemType = MainHandItem.getType();

        //Player is holding nothing
        if (MainHandItemType == Material.AIR) return;
        //PLayer item has no meta
        if (!MainHandItem.hasItemMeta()) return;

        ItemMeta MainHandItemMeta = MainHandItem.getItemMeta();
        if (MainHandItemMeta == null) return;
        //Player item not have enchantment
        if (!MainHandItemMeta.hasEnchant(EnchantmentManager.SOULBOUND)) return;
        //PLayer has no free inventory space
        if (player.getInventory().firstEmpty() == -1) return;

        Block BrokenBlock = event.getBlock();
        //Block is container
        if (BrokenBlock.getState() instanceof Container) return;

        event.setDropItems(false);

        Collection<ItemStack> Drops = BrokenBlock.getDrops(MainHandItem);
        if (Drops.isEmpty()) return;

        player.getInventory().addItem(Drops.iterator().next());
    }
}
