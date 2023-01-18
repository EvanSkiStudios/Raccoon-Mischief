package me.evanskistudios.rm.commands;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ComRMGetConfig implements CommandExecutor {
    Plugin plugin = RaccoonMischief.getPlugin(RaccoonMischief.class);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (command.getName().equals("RMGetCfg")) {
            int args_length = args.length;

            if (args_length == 0){
                sender.sendMessage(ChatColor.RED+"Not enough arguments supplied");
                sender.sendMessage("Example: /RMGetCfg <Key>");
                return true;
            }

            if (args_length > 1){
                sender.sendMessage(ChatColor.RED + "Too many Arguments supplied");
                sender.sendMessage("Example: /RMGetCfg <Set> <Key> <Value>");
                return true;
            }

            String Key = args[0];
            Object key_value = plugin.getConfig().get(Key);

            if (key_value == null) {
                sender.sendMessage(ChatColor.RED + " \"" + Key + "\" does not exist in config.yml");
                return true;
            }

            sender.sendMessage(ChatColor.YELLOW +""+ Key + " = " + ChatColor.YELLOW +""+ key_value);
            return true;
        }
        return false;
    }
}
