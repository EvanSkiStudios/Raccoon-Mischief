package me.evanskistudios.rm.events;

import me.evanskistudios.rm.recipes.RecipeCakeSlices;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Cake;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ListenerPlayerBreakBlock  implements Listener {
    @EventHandler
    public static void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        GameMode PlayerGameMode = player.getGameMode();

        //Player is in wrong GameMode
        if (PlayerGameMode == GameMode.CREATIVE || PlayerGameMode == GameMode.SPECTATOR) return;

        Block BrokenBlock = event.getBlock();
        Material BrokenBlockMaterial = BrokenBlock.getType();

        if (BrokenBlockMaterial == Material.CAKE){
            Cake cake = (Cake) BrokenBlock.getState().getBlockData();
            int Slices = ( 7 - cake.getBites() ); // 7 is max slices of cake, bites is how many slices have been taken

            BrokenBlock.getDrops().clear();

            ItemStack CakeSlice = RecipeCakeSlices.getItem();
            CakeSlice.setAmount(Slices);

            player.getWorld().dropItem(BrokenBlock.getLocation(), CakeSlice);
        }
    }
}
