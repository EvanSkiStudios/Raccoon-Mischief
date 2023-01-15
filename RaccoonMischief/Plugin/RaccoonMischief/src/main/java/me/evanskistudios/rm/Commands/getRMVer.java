package me.evanskistudios.rm.Commands;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class getRMVer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,@NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("RMVER")){
            sender.sendMessage(ChatColor.GREEN + "RaccoonMischief V." + RaccoonMischief.Version);
            System.out.println("" + RaccoonMischief.Version);
        }
        return true;
    }
}
