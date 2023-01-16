package me.evanskistudios.rm;

import me.evanskistudios.rm.Commands.RMtestKiller;
import me.evanskistudios.rm.Commands.getRMVer;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class RaccoonMischief extends JavaPlugin {

    public static double Version = 2.0;
    private static RaccoonMischief plugin;
    @Override
    public void onEnable() {
        plugin = this;

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
            Objects.requireNonNull(this.getCommand("RMVER")).setExecutor(new getRMVer());
            Objects.requireNonNull(this.getCommand("RMtestDeath")).setExecutor(new RMtestKiller());
        }

        getLogger().info("RaccoonMischief 2.0 is Loaded!");
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
