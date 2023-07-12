package me.evanskistudios.rm.Commands;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

//import java.util.logging.Level;

public class ComGetRMVer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Plugin namespace = RaccoonMischief.getPlugin();
        String version_string = "RaccoonMischief V." + RaccoonMischief.Version;

        sender.sendMessage(ChatColor.GREEN + version_string);

        //namespace.getLogger().log(Level.INFO,version_string);
        return true;
    }
}
