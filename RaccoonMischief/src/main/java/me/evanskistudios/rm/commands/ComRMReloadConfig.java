package me.evanskistudios.rm.commands;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public class ComRMReloadConfig implements CommandExecutor {
    Plugin plugin = RaccoonMischief.getPlugin(RaccoonMischief.class);
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("RMReloadCfg")) {
            plugin.reloadConfig();
            sender.sendMessage("Config.yml Reloaded!");
            String current_ver = "" + RaccoonMischief.Version;
            Object cfg_ver = plugin.getConfig().get("version");
            if (cfg_ver == null || !current_ver.equalsIgnoreCase(""+cfg_ver)){
                plugin.getLogger().log(Level.WARNING,
                    "\n"+"######################### RACCOON MISCHIEF #########################" +"\n"+
                            "Config.yml version is out of date with RM."+current_ver+"\n"+
                            "It is recommended to delete the file for the plugin to regenerate it."+"\n"+
                            "####################################################################"
                );
            }
        }
        return true;
    }
}
