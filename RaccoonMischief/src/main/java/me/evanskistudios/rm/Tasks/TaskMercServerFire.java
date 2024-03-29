package me.evanskistudios.rm.Tasks;


import me.evanskistudios.rm.RaccoonMischief;
import me.evanskistudios.rm.Utilis.DiscordSRVManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Collection;
import java.util.Locale;
public class TaskMercServerFire extends BukkitRunnable{

    String MercName = "Mercerenies";
    RaccoonMischief plugin;
    public TaskMercServerFire(RaccoonMischief plugin) {this.plugin = plugin;}

    public void Restart(){

        long leftLimit = 1200L; //1 minute
        long rightLimit = 6000L; //5 minutes
        long LDelay = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        //create a new task as this one is now finished

        BukkitTask TaskMercServerFire = (BukkitTask) new TaskMercServerFire(plugin).runTaskLater(plugin, LDelay);
    }

    @Override
    public void run() {

        Collection<? extends Player> PlayersOnline = RaccoonMischief.getPlugin().getServer().getOnlinePlayers();

        if (PlayersOnline.isEmpty()){
            Restart();
            return;
        }

        Player MercPlayerRef = null;

        for (Player p : PlayersOnline) {
            if (p.getDisplayName().equals(MercName)) {
                MercPlayerRef = p;
            }
        }
        if (MercPlayerRef == null){
            Restart();
            return;
        }

        LocalDate currentDate = LocalDate.now();

        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        int dayOfMonth = currentDate.getDayOfMonth();
        Month Month = currentDate.getMonth();
        int Year = currentDate.getYear();

        String monthAbbreviation = Month.getDisplayName(TextStyle.SHORT, Locale.getDefault());
        String dayAbbreviation = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault());
        ZonedDateTime currentTimeUTC = ZonedDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTimeUTC.format(formatter);

        //Fri, 11. Aug 2023 17:53:11 UTC @MercName, the server room is on 🔥‼️
        String TimeString = dayAbbreviation + ", " + dayOfMonth + ". " + monthAbbreviation + " " + Year + " " + formattedTime + " UTC";
        String emojiString = "🔥!!";

        long unixTime = System.currentTimeMillis() / 1000L;
        String DiscordTimeString = "<t:"+ unixTime +":F>";

        for (Player p : PlayersOnline) {
            /*
            if (!(p.getDisplayName().equals(MercName))) {
                String Format = (ChatColor.GRAY+""+ChatColor.ITALIC+"");
                p.sendMessage(Format+"Do you smell something burning?");
            }
            */
            if ((p.getDisplayName().equals(MercName))) {
                for (int i = 0; i < 3; ++i) {
                    p.sendMessage(TimeString + " @" + MercName + ", the server room is on " + emojiString);
                    DiscordSRVManager.discordBroadcast(DiscordTimeString + "@mercerenies , the server room is on " + emojiString);
                }

                Block blockAtFeet = p.getWorld().getBlockAt(p.getLocation());
                if (blockAtFeet.getType() == Material.AIR) {
                    blockAtFeet.setType(Material.FIRE);
                }
            }else{
                p.sendMessage(TimeString + " @" + MercName + ", the server room is on " + emojiString);
            }
        }

        Restart();
    }
}
