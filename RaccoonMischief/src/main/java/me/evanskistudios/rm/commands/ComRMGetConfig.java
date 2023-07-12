package me.evanskistudios.rm.Commands;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComRMGetConfig implements TabExecutor {
    Plugin plugin = RaccoonMischief.getPlugin(RaccoonMischief.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        int args_length = args.length;

        if (args_length == 0){
            sender.sendMessage(ChatColor.RED+"Not enough arguments supplied");
            sender.sendMessage("Example: /RMGetCfg <Key>");
            return true;
        }

        if (args_length > 1){
            sender.sendMessage(ChatColor.RED + "Too many Arguments supplied");
            sender.sendMessage("Example: /RMGetCfg <Key>");
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

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1){

            String[] config_options = new String[plugin.getConfig().getKeys(false).size()];
            plugin.getConfig().getKeys(false).toArray(config_options);

            List<String> ListOptions = new ArrayList<>(Arrays.asList(config_options));
            ListOptions.remove("info");

            return ListOptions;
        }

        return null;
    }
}
