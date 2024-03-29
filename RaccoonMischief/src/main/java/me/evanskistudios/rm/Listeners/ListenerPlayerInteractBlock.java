package me.evanskistudios.rm.Listeners;

import me.evanskistudios.rm.FoodManager;
import me.evanskistudios.rm.MaterialManager;
import net.minecraft.world.level.block.LavaCauldronBlock;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class ListenerPlayerInteractBlock implements Listener {

    private void AutoReplaceCrops(Player player, Block interactedBlock){
        Material blockType = interactedBlock.getType();

        Ageable ageableCrop = (Ageable) interactedBlock.getBlockData();
        int cropAge = ageableCrop.getAge();
        int cropMaxAge = ageableCrop.getMaximumAge();
        if (cropAge < cropMaxAge) return;

        ItemStack MainHandItem = player.getInventory().getItemInMainHand();
        Collection<ItemStack> Drops = interactedBlock.getDrops(MainHandItem);
        if (!(Drops.isEmpty())) {
            for (ItemStack stack : Drops) {
                //Airman's favorite line
                if ( (stack.getType() == Material.WHEAT_SEEDS) || (stack.getType() == Material.CARROT) || (stack.getType() == Material.POTATO) || (stack.getType() == Material.BEETROOT) ){
                    stack.setAmount( stack.getAmount() - 1);
                }
                player.getInventory().addItem(stack);
            }
            player.playSound(player.getLocation(),"entity.item.pickup", 1.0f, 1.0f);
        }

        //break the block
        double coord_x = interactedBlock.getLocation().getX();
        double coord_y = interactedBlock.getLocation().getY();
        double coord_z = interactedBlock.getLocation().getZ();

        Particle particle = Particle.BLOCK_DUST;
        BlockData particleData = interactedBlock.getBlockData();
        player.playSound(player.getLocation(), "block.crop.break", 1.0f, 1.0f);
        player.spawnParticle(particle, coord_x + 0.50, coord_y + 0.50, coord_z + 0.50, 50, particleData);

        //place new crop
        player.getWorld().getBlockAt((int) coord_x, (int) coord_y, (int) coord_z).setType(blockType);
        player.playSound(player.getLocation(), "item.crop.plant", 1.0f, 1.0f);
    }

    @EventHandler
    public void onUseBlock(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block interactedBlock = event.getClickedBlock();
        Action playerAction = event.getAction();

        //if we didn't right-click then we don't care
        if (playerAction != Action.RIGHT_CLICK_BLOCK) return;

        GameMode PlayerGameMode = player.getGameMode();
        //Player is in wrong GameMode
        if (PlayerGameMode == GameMode.CREATIVE || PlayerGameMode == GameMode.SPECTATOR) return;

        //get block
        if (interactedBlock == null) return;
        Material blockType = interactedBlock.getType();

        //got a block what do?
        switch (blockType) {
            default -> {return;}

            case WHEAT,BEETROOTS,POTATOES,CARROTS -> {
                AutoReplaceCrops(player, interactedBlock);
            }

            case LAVA_CAULDRON -> {
                ItemStack MainHandItem = player.getInventory().getItemInMainHand();
                if (MainHandItem.getType() != Material.GLASS_BOTTLE) { return; }

                if (MainHandItem.getAmount() > 1){
                    MainHandItem.setAmount(MainHandItem.getAmount() - 1);
                    player.getInventory().addItem(FoodManager.BottleOLava);
                    player.playSound(player.getLocation(), "item.bottle.fill", 1.0f, 1.0f);
                }else{
                    player.getInventory().setItemInMainHand(FoodManager.BottleOLava);
                    player.playSound(player.getLocation(), "item.bottle.fill", 1.0f, 1.0f);
                }
            }
        }
    }
}
