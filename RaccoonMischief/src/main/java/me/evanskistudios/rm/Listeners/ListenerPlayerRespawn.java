package me.evanskistudios.rm.Listeners;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import static me.evanskistudios.rm.Utilis.UtilityMethods.Choose;

public class ListenerPlayerRespawn  implements Listener {

    private static final String[] KickMessages = {"Kicked by Plugin","Forgor huw 2 respiwn", "Oops! Try again", "A Boot to the Head!"};

    public void RespawnEffect(Player player){
        Random random = new Random();
        int randomNumber = random.nextInt(5);

        if (randomNumber == 0) {
            int randomEffect = random.nextInt(6);
            switch (randomEffect) {
                default -> {}

                case 1 -> player.showDemoScreen();

                case 2 -> {
                    Location loc = player.getLocation();
                    Entity Chicken = loc.getWorld().spawnEntity(loc, EntityType.CHICKEN);
                    player.addPassenger(Chicken);
                }

                case 3 -> {
                    // CHANGE THIS ITS ANNOYING

                    Collection<? extends Player> OnlinePlayers = RaccoonMischief.getPlugin().getServer().getOnlinePlayers();

                    if (OnlinePlayers.size() > 2) {
                        ArrayList<Player> playersArray = new ArrayList<>();
                        for (Player p : OnlinePlayers) {
                            if (p != player) {
                                playersArray.add(p);
                            }
                        }
                        int max = (playersArray.size() - 1), min = 0;
                        int index = random.nextInt(max - min + 1) + min;
                        Player randomPlayer = playersArray.get(index);
                        player.teleport(randomPlayer.getLocation());
                    }
                }

                case 4 -> {
                    String kickMessage = Choose(KickMessages).toString();

                    for (Player p : RaccoonMischief.getPlugin().getServer().getOnlinePlayers()) {
                        p.sendMessage(ChatColor.ITALIC+""+ChatColor.GRAY+"Kicked "+player.getDisplayName()+" for "+kickMessage);
                    }

                    player.kickPlayer(kickMessage);
                }

                case 5 ->{
                    // MAKE THIS LESS OFTEN OR CHANGE HOW IT IS DONE

                    for (Player otherPlayer : RaccoonMischief.getPlugin().getServer().getOnlinePlayers()) {
                        if (otherPlayer != player) {
                            Location player_location = player.getLocation();
                            player.teleport(otherPlayer.getLocation());
                            otherPlayer.teleport(player_location);

                            player.sendMessage("You have switched places with " + otherPlayer.getDisplayName());
                            otherPlayer.sendMessage("You have switched places with " + player.getDisplayName());
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        RespawnEffect(player);

    }
}
