package me.evanskistudios.rm.commands;

import me.evanskistudios.rm.items.ItemUpgradeShard;
import me.evanskistudios.rm.recipes.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class ComRMGive implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        String no_permission = (ChatColor.RED + "You lack sufficient permission to execute this command");
        if (!sender.hasPermission("RaccoonMischief.RMGive")) {
            sender.sendMessage(no_permission);
            return true;
        }

        if (!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED+"This command is only for players!");
            sender.sendMessage("Example: /RMGive <Item> <(Optional) Int: Amount>");
            return true;
        }
        Player player = (Player) sender;

        int arguments_length = args.length;

        if (arguments_length == 0){
            player.sendMessage(ChatColor.RED+"No Item Key Supplied!");
            player.sendMessage("Example: /RMGive <Item>");
            return true;
        }

        if (arguments_length > 2) {
            player.sendMessage(ChatColor.RED+"Too many Arguments Supplied!");
            player.sendMessage("Example: /RMGive <Item> <(Optional) Int: Amount>");
            return true;
        }

        String Item_arg = args[0];

        int ItemRequestedAmount = 1;

        if (arguments_length == 2) {
            try {
                Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED +""+args[1]+" is not an Integer!");
                player.sendMessage("Example: /RMGive <Item> <INTEGER: Amount>");
                return true;
            }
            // if not an error
            ItemRequestedAmount = Integer.parseInt(args[1]);
        }

        boolean FoundItem = false;
        ItemStack RequestedItem = new ItemStack(Material.AIR,1);


        if (Item_arg.equalsIgnoreCase("JTE_Apple")){
            RequestedItem = RecipeJTEApple.getItem();
            FoundItem = true;
        }

        if (Item_arg.equalsIgnoreCase("Milk_Potion")){
            RequestedItem = RecipeMilkPotion.getItem();
            FoundItem = true;
        }

        if (Item_arg.equalsIgnoreCase("Strange_Meat")){
            //WE make this one because it's set in an event not a recipe
            ItemStack Strange_meat = new ItemStack(Material.BEEF);
            ItemMeta Strange_meat_meta = Strange_meat.getItemMeta();
            Strange_meat_meta.setDisplayName(ChatColor.RESET+"Strange Meat");
            Strange_meat.setItemMeta(Strange_meat_meta);

            RequestedItem = Strange_meat;
            FoundItem = true;
        }

        if (Item_arg.equalsIgnoreCase("Tactical_Dirt")){
            RequestedItem = Recipe_tactical_dirt.getItem();
            FoundItem = true;
        }

        if (Item_arg.equalsIgnoreCase("Upgrade_Shard")){
            RequestedItem = ItemUpgradeShard.UpgradeShard();
            FoundItem = true;
        }

        if (FoundItem){
            for(int i=0; i < ItemRequestedAmount; ++i) {
                player.getInventory().addItem(RequestedItem);
            }
        }else{
            player.sendMessage(ChatColor.RED + Item_arg + " was not found or is not an RM item!");
            player.sendMessage("Example: /RMGive <Item> <Int: Amount>");
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 1){
            List<String> ListOItems = Arrays.asList(
                    "JTE_Apple",
                    "Milk_Potion",
                    "Strange_Meat",
                    "Tactical_Dirt",
                    "Upgrade_Shard"
            );
            return ListOItems;
        }

        return null;
    }
}
