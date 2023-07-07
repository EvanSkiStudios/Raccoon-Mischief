package me.evanskistudios.rm.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ComRMQuickTest implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            String no_permission = (ChatColor.RED+"You lack sufficient permission to execute this command");

            if (!sender.hasPermission("RaccoonMischief.RMtestDeath")){
                sender.sendMessage(no_permission);
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED+""+sender+" is not a player!");
                return true;
            }
            //DO command things below

            Player player = (Player) sender;

            ItemStack[] InventoryContents = player.getInventory().getContents();
            ArrayList<ItemStack> NewItems= new ArrayList<>();
            for (ItemStack item : InventoryContents){
                if (item != null){
                    int amount = item.getAmount();

                    switch (item.getType()) {
                        case BEEF -> {
                            ItemMeta meta = item.getItemMeta();
                            item = new ItemStack(Material.COOKED_BEEF, amount);
                            item.setItemMeta(meta);
                            //Overwrites item slot with new item
                        }
                    }
                    NewItems.add(item);
                }else{
                    NewItems.add(null);
                }
            }
            player.getInventory().setContents(NewItems.toArray(new ItemStack[0]));

            sender.sendMessage(ChatColor.YELLOW+"COMMAND RAN!");
            return true;
        }
}
