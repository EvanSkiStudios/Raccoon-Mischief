package me.evanskistudios.rm.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
               return true;
            }
        }
        return true;
    }
}