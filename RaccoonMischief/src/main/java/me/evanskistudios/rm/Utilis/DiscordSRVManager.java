package me.evanskistudios.rm.Utilis;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.util.DiscordUtil;
import org.bukkit.Bukkit;

public class DiscordSRVManager {
    public static void discordBroadcast(String message) {
        // Regular non-Discord broadcast
        //Bukkit.getServer().broadcast(message)
        // Then do Discord stuff
        var discord = (DiscordSRV)Bukkit.getServer().getPluginManager().getPlugin("DiscordSRV");
        if (discord != null) {
            var textChannel = discord.getOptionalTextChannel("global");
            DiscordUtil.sendMessage(textChannel, message);
        }
    }
}
