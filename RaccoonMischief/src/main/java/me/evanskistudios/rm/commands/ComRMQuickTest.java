package me.evanskistudios.rm.Commands;

import me.evanskistudios.rm.RaccoonMischief;
import me.evanskistudios.rm.Tasks.TaskMercServerFire;
import me.evanskistudios.rm.Utilis.DiscordSRVManager;
import org.bukkit.ChatColor;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class ComRMQuickTest implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            String no_permission = (ChatColor.RED+"You lack sufficient permission to execute this command");

            if (!sender.hasPermission("RaccoonMischief.RMQuickTest")){
                sender.sendMessage(no_permission);
                return true;
            }

            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED+""+sender+" is not a player!");
                return true;
            }

            //DO command things below

            Player player = (Player) sender;

            sender.sendMessage(ChatColor.YELLOW+"COMMAND RAN!");
            return true;
        }
}
