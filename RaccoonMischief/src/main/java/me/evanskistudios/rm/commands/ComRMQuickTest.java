package me.evanskistudios.rm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class ComRMQuickTest implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            String no_permission = (ChatColor.RED+"You lack sufficient permission to execute this command");

            if (!sender.hasPermission("RaccoonMischief.RMtestDeath")){
                sender.sendMessage(no_permission);
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED+""+sender+" is not a player!");
                return true;
            }
            //DO command things below

            Player p = (Player) sender;



            return true;
        }
}
