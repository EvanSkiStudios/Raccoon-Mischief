package me.evanskistudios.rm.tasks;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import static me.evanskistudios.rm.utilis.UtilityMethods.getRandomPlayer;

public class TaskRekkoRoomCode extends BukkitRunnable implements Listener {

    String RekkoName = "RekNepZ_HBK";
    RaccoonMischief plugin;
    public TaskRekkoRoomCode(RaccoonMischief plugin) {this.plugin = plugin;}

    @Override
    public void run() {

        Player RekkoPlayerRef = null;

        Player randomPlayer = getRandomPlayer();
        if (randomPlayer == null) return;

        String Fake_Player = randomPlayer.getDisplayName();

        //get rekko
        for (Player p : plugin.getServer().getOnlinePlayers()){
            if (p.getDisplayName().equals(RekkoName)){
                RekkoPlayerRef = p;
            }
        }
        if (RekkoPlayerRef == null) return;

        String Whisper = (ChatColor.GRAY+""+ChatColor.ITALIC+"");
        randomPlayer.sendMessage(Whisper+" You whisper to "+RekkoName+": What's the room code?");
        RekkoPlayerRef.sendMessage(Whisper+" "+Fake_Player+" whispers to you: What's the room code?");
        long leftLimit = 600L; //30 secs
        long rightLimit = 6000L; //5 minutes
        long LDelay = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        //create a new task as this one is now finished
        BukkitTask TaskRekkoRoomCode = (BukkitTask) new TaskRekkoRoomCode(plugin).runTaskLater(plugin, LDelay);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        run();
        //there is a possibility that Rek isn't on the server, plus a new player has joined, so we run the main function
        //and it should handle everything
    }
}
