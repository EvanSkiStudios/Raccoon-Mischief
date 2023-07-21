package me.evanskistudios.rm.Tasks;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Collection;

import static me.evanskistudios.rm.Utilis.UtilityMethods.RandomPlayer;

public class TaskRekkoRoomCode extends BukkitRunnable implements Listener {

    String RekkoName = "RekNepZ_HBK";
    RaccoonMischief plugin;
    public TaskRekkoRoomCode(RaccoonMischief plugin) {this.plugin = plugin;}

    public void Restart(){
        long leftLimit = 600L; //30 secs
        long rightLimit = 6000L; //5 minutes
        long LDelay = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        //create a new task as this one is now finished
        BukkitTask TaskRekkoRoomCode = (BukkitTask) new TaskRekkoRoomCode(plugin).runTaskLater(plugin, LDelay);
    }

    @Override
    public void run() {

        Player RekkoPlayerRef = null;
        String Fake_Player;
        Player randomPlayer;

        Collection<? extends Player> PlayersOnline = RaccoonMischief.getPlugin().getServer().getOnlinePlayers();

        if (PlayersOnline.isEmpty()){
            Restart();
            return;
        }

        for (Player p : PlayersOnline){
            //get rekko
            if (p.getDisplayName().equals(RekkoName)){
                RekkoPlayerRef = p;
            }
        }

        randomPlayer = (Player) RandomPlayer();
        Fake_Player = randomPlayer.getDisplayName();

        if (RekkoPlayerRef == null){
            Restart();
            return;
        }

        //Hey look everything worked heres a meme
        String Whisper = (ChatColor.GRAY+""+ChatColor.ITALIC+"");
        randomPlayer.sendMessage(Whisper+" You whisper to "+RekkoName+": What's the room code?");
        RekkoPlayerRef.sendMessage(Whisper+" "+Fake_Player+" whispers to you: What's the room code?");

        Restart();
    }
}
