package me.evanskistudios.rm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
public class RMtestKiller implements CommandExecutor  {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("RMtestDeath")){
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
        }
        return true;
    }
}