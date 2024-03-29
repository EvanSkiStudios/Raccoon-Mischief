package me.evanskistudios.rm.Tasks;

import me.evanskistudios.rm.EnchantManager;
import me.evanskistudios.rm.RaccoonMischief;
import me.evanskistudios.rm.Enums.InvSlot;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Random;

public class TaskPlayerLevitation extends BukkitRunnable {
    RaccoonMischief plugin;

    HashMap<String, Player> affected_players = new HashMap<String, Player>();

    public TaskPlayerLevitation(RaccoonMischief plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for(Player player : plugin.getServer().getOnlinePlayers()) {
            String player_name = player.getDisplayName();

            Object player_in_map = affected_players.get(player_name);

            boolean effect = player.hasPotionEffect(PotionEffectType.LEVITATION);
            if (effect) {

                //Check if player has HeavyStep boots
                ItemStack PlayerArmorBoots = player.getInventory().getItem(InvSlot.ArmorBoots.ordinal());
                if (PlayerArmorBoots != null) {

                    boolean BootsHasHeavyStep = false;
                    ItemMeta PlayerArmorBoots_Meta = PlayerArmorBoots.getItemMeta();
                    if (PlayerArmorBoots_Meta != null) {
                        BootsHasHeavyStep = PlayerArmorBoots_Meta.hasEnchant(EnchantManager.HEAVYSTEP);
                    }

                    if (BootsHasHeavyStep){
                        player.removePotionEffect(PotionEffectType.LEVITATION);
                        return;
                    }
                }

                //Player does not have HeavyStep boots
                if (player_in_map == null) {
                    // Player has levitation
                    Random rand = new Random();
                    float volume = rand.nextFloat();
                    player.playSound(player.getLocation(), "custom.player.levitating", volume, 1.0f);

                    //add player to map, so they don't get the sound played again
                    affected_players.put(player_name, player);
                }
            } else {
                if (player_in_map != null) {
                    //Remove player from map, so they can get the sound played again
                    affected_players.remove(player_name);
                }
            }
        }
    }
}
