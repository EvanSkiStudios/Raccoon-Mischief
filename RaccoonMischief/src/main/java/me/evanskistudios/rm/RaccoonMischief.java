package me.evanskistudios.rm;

import me.evanskistudios.rm.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Level;

public final class RaccoonMischief extends JavaPlugin {
    public static String Version = "2.0.1";
    private static RaccoonMischief plugin;
    @Override
    public void onEnable() {
        plugin = this;

        //Config
        {
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
            getConfig().options().copyDefaults();
            saveDefaultConfig();
        }

        //Register utilities
        Utilities.registerGlow();

        //Remove recipes I want to remove
        RemoveRecipes.Recipes();

        //Add my recipes
        AddRecipes.Recipes();

        //Register Events
        EventManager.Events();

        //Register Commands
        {
            Objects.requireNonNull(this.getCommand("RMVER")).setExecutor(new ComGetRMVer());
            Objects.requireNonNull(this.getCommand("RMtestDeath")).setExecutor(new ComRMTestDeath());
            Objects.requireNonNull(this.getCommand("RMGetCfg")).setExecutor(new ComRMGetConfig());
            Objects.requireNonNull(this.getCommand("RMReloadCfg")).setExecutor(new ComRMReloadConfig());
            Objects.requireNonNull(this.getCommand("RMGive")).setExecutor(new ComRMGive());
            Objects.requireNonNull(this.getCommand("RMShowCraft")).setExecutor(new ComRMShowCraft());
        }

        //Tasks
        TaskManager.tasks();

        //Shredder UnMercer
        ShredderManager.ShredderEnable();

        getLogger().info("RaccoonMischief " + Version + " is Loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("RaccoonMischief UNLOADED!");
    }

    //Getter for plugin instance
    public static RaccoonMischief getPlugin() {
        return plugin;
    }
}
