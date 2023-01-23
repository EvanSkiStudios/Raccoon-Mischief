package me.evanskistudios.rm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class ComRMTestDeath implements CommandExecutor  {
    @Override
    public boolean onCommand(CommandSender sender,Command command, String label, String[] args) {
        String no_permission = (ChatColor.RED+"You lack sufficient permission to execute this command");

        if (!sender.hasPermission("RaccoonMischief.RMtestDeath")){
            sender.sendMessage(no_permission);
            return true;
        }

        if (sender instanceof Player){
           Player p = (Player) sender;
           p.setFoodLevel(1);
           p.setSaturation(0);
           p.setHealth(0.1);
        }
        if (sender instanceof ConsoleCommandSender){
            sender.sendMessage(ChatColor.RED + "Server Console is not a player!");
        }

        if (sender instanceof BlockCommandSender){
            sender.sendMessage(ChatColor.RED + "Command Block is not a player!");
        }
        return true;
    }
}