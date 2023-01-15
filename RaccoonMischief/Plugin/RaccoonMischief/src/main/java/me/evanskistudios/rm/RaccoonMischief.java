package me.evanskistudios.rm;
import org.bukkit.plugin.Plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class RaccoonMischief extends JavaPlugin {

    @Override
    public void onEnable() {
        Plugin Namespace = this;

        Utilities.registerGlow(Namespace);

        //Remove recipes I want to remove
        RemoveRecipes.Recipes();

        //Add my recipes
        AddRecipes.Recipes(Namespace);

        getLogger().info("RaccoonScriptExtender 2.0 is Loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("RaccoonScriptExtender UNLOADED!");
    }
}
