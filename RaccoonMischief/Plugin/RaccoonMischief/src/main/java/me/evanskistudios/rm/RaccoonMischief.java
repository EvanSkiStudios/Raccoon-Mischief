package me.evanskistudios.rm;
import org.bukkit.plugin.Plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class RaccoonMischief extends JavaPlugin {

    @Override
    public void onEnable() {

        // Plugin startup logic
        getLogger().info("RaccoonScriptExtender is Loading!");

        //Remove recipes I want to remove
        RemoveRecipes.Recipes();

        Plugin Namespace = this;
        AddRecipes.Recipes(Namespace);

        getLogger().info("RaccoonScriptExtender is Loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("RaccoonScriptExtender UNLOADED!");
    }
}
