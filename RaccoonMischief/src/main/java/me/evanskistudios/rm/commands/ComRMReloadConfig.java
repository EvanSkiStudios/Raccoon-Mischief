package me.evanskistudios.rm.Commands;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;

public class ComRMReloadConfig implements CommandExecutor {
    Plugin plugin = RaccoonMischief.getPlugin(RaccoonMischief.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String no_permission = (ChatColor.RED+"You lack sufficient permission to execute this command");

        if (!sender.hasPermission("RaccoonMischief.RMReloadCfg")){
            sender.sendMessage(no_permission);
            return true;
        }

        plugin.reloadConfig();
        sender.sendMessage("Config.yml Reloaded!");
        String current_ver = "" + RaccoonMischief.Version;

        String reload_warn_version = (
            "\n"+"######################### RACCOON MISCHIEF #########################" +"\n"+
                 " Config.yml version is out of date with RM." + current_ver +"\n"+
                 " It is recommended to delete the file for the plugin to regenerate it." +"\n"+
                 "####################################################################"
        );

        Object cfg_ver = plugin.getConfig().get("version");
        if (cfg_ver == null || !current_ver.equalsIgnoreCase(""+cfg_ver)){
            plugin.getLogger().log(Level.WARNING, reload_warn_version);
            sender.sendMessage(ChatColor.YELLOW+""+reload_warn_version);
        }

        return true;
    }
}
