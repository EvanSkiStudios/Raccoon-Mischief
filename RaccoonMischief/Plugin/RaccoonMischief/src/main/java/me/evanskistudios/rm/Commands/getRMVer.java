package me.evanskistudios.rm.commands;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

//import java.util.logging.Level;

public class getRMVer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,@NotNull String[] args) {
        Plugin namespace = RaccoonMischief.getPlugin();
        String version_string = "RaccoonMischief V." + RaccoonMischief.Version;

        if (command.getName().equalsIgnoreCase("RMVER")){
            sender.sendMessage(ChatColor.GREEN + version_string);

            //namespace.getLogger().log(Level.INFO,version_string);
        }
        return true;
    }
}
