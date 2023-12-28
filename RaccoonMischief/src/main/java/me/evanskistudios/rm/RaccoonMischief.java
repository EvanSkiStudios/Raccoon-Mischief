package me.evanskistudios.rm;

import me.evanskistudios.rm.Utilis.Glow;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.logging.Level;

public final class RaccoonMischief extends JavaPlugin{
    public static String Version = "2.4.0";
    private static RaccoonMischief plugin;
    //Getter for plugin instance
    public static RaccoonMischief getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;

        //Config
        {
            Object cfg_ver_ignore = getConfig().get("B_IgnoreConfigVersionMisMatch");
            if ("False".equalsIgnoreCase("" + cfg_ver_ignore)) {
                String current_ver = "" + Version;
                Object cfg_ver = getConfig().get("version");
                if (cfg_ver == null || !current_ver.equalsIgnoreCase("" + cfg_ver)) {
                    getLogger().log(Level.WARNING,
                            "\n" + "######################### RACCOON MISCHIEF #########################" + "\n" +
                                    " Config.yml version is out of date with RM." + current_ver + "\n" +
                                    " It is recommended to delete the file for the plugin to regenerate it." + "\n" +
                                    "####################################################################"
                    );
                }
            }
            getConfig().options().copyDefaults();
            saveDefaultConfig();
        }

        //Register utilities
        Glow.registerGlow();

        //Add my recipes
        RecipeManager.Recipes();

        //Register Events
        ListenerManager.Events();

        //Register Commands
        ComManager.commands();

        //Tasks
        TaskManager.tasks();

        //Custom Enchants
        EnchantManager.Register();

        //Scoreboard Manager
        ScoreboardsManager.Events();
        ScoreboardsManager.Scoreboards();

        //FINISH
        getLogger().info("RaccoonMischief " + Version + " is Loaded!");
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //getLogger().info("RaccoonMischief UNLOADED!");
    }
}
