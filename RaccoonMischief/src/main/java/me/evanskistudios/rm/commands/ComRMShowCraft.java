package me.evanskistudios.rm.commands;

import me.evanskistudios.rm.RaccoonMischief;
import me.evanskistudios.rm.utilis.GUIHolder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class ComRMShowCraft implements TabExecutor, Listener {

    @EventHandler
    public void onMenu(InventoryClickEvent event){
        if (event.isCancelled()) return;

        Inventory Active_Inventory = event.getClickedInventory();

        if (Active_Inventory != null && Active_Inventory.getHolder() != null && Active_Inventory.getHolder() instanceof GUIHolder){
            event.setCancelled(true);
        }

    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Plugin namespace = RaccoonMischief.getPlugin();

        if (!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED+"Command only works for players!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1){
           player.sendMessage(ChatColor.RED+"Incorrect amount of arguments!");
           player.sendMessage("Example: /RMShowCraft <RM Recipe>");
        }

        String crafting_recipe = args[0];
        boolean found_recipe = false;
        Inventory CraftRecipe = null;

        if (crafting_recipe.equalsIgnoreCase("Dirt_to_Seeds")) {

            found_recipe = true;

            String Inventory_title = "Dirt to Seeds";

            ItemStack N = new ItemStack(Material.AIR, 1);
            ItemStack Dirt = new ItemStack(Material.DIRT, 1);
            ItemStack WheatSeeds = new ItemStack(Material.WHEAT_SEEDS, 1);

            ItemStack[] CraftingMatrix = {
                    WheatSeeds,
                    Dirt, Dirt, N,
                    Dirt, Dirt, N,
                    N, N, N
            };

            CraftRecipe = Bukkit.createInventory(new GUIHolder(), InventoryType.WORKBENCH, Inventory_title);
            for (int i = 0; i < CraftingMatrix.length; ++i) {
                CraftRecipe.setItem(i, CraftingMatrix[i]);
            }
        }

        if (found_recipe) {
            player.openInventory(CraftRecipe);
        }else{
            player.sendMessage(ChatColor.RED+""+crafting_recipe + " was not found or is not an RM Recipe!");
            player.sendMessage("Example: /RMShowCraft <RM Recipe>");
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1){
            List<String> ListOItems = Arrays.asList(
                    "Dirt_to_Seeds",
                    "JTE_Apple",
                    "Milk_Potion",
                    "RottenFlesh_to_Leather",
                    "Strange_Meat",
                    "Tactical_Dirt",
                    "UnMetaData_Cookies",
                    "Upgrade_Shard",
                    "XP_Orb"
            );
            return ListOItems;
        }

            return null;
    }
}


