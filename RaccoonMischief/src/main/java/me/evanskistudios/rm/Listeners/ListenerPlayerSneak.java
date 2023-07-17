package me.evanskistudios.rm.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ListenerPlayerSneak implements Listener {
    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        /*

        Player player = event.getPlayer();

        if (event.isSneaking()){
            //is sneaking
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, PotionEffect.INFINITE_DURATION, 1));
        }else{
            //is not sneaking
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
        }

        */
    }
}
