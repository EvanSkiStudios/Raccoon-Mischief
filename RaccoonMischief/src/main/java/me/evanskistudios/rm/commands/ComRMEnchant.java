package me.evanskistudios.rm.Commands;

import me.evanskistudios.rm.EnchantManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComRMEnchant implements TabExecutor {

    public static List<String> EnchantList;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String no_permission = (ChatColor.RED + "You lack sufficient permission to execute this command");
        if (!sender.hasPermission("RaccoonMischief.RMEnchant")) {
            sender.sendMessage(no_permission);
            return true;
        }

        if (!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED+"This command is only for players!");
            sender.sendMessage("Example: /RMEnchant <RM Enchant> <(Optional) Int: Level>");
            return true;
        }
        Player player = (Player) sender;

        int arguments_length = args.length;

        if (arguments_length == 0){
            player.sendMessage(ChatColor.RED+"No Enchantment Supplied!");
            player.sendMessage("Example: /RMEnchant <RM Enchant>");
            return true;
        }

        ItemStack MainHandItem = player.getInventory().getItemInMainHand();

        if (MainHandItem.getType() == Material.AIR){
            player.sendMessage(ChatColor.RED+"No Item in Hand!");
            player.sendMessage("Example: /RMEnchant <RM Enchant> <(Optional) Int: Level>");
            return true;
        }

        String Enchantment = args[0];

        List<String> ListOfEnchant = EnchantList;
        Enchantment[] Enchants = EnchantManager.getEnchants();

        Enchantment Enchant = null;

        for (int i = 0; i < Enchants.length; ++i) {

            String enchant = ListOfEnchant.get(i);

            if (Enchantment.equalsIgnoreCase(enchant)) {
                Enchant = Enchants[i];
                break;
            }
        }

        if (Enchant == null) {
            player.sendMessage(ChatColor.RED+"Enchant does not exist or is not RM Enchant!");
            player.sendMessage("Example: /RMEnchant <RM Enchant>");
            return true;
        }

        if (MainHandItem.containsEnchantment(Enchant)){
            player.sendMessage(ChatColor.RED+"Item already has Enchantment "+Enchantment+"!");
            player.sendMessage("Example: /RMEnchant <RM Enchant> <(Optional) Int: Level>");
            return true;
        }

        String EnchantName = EnchantManager.getEnchantName(Enchantment);

        boolean IsEnchant = Arrays.stream(org.bukkit.enchantments.Enchantment.values()).collect(Collectors.toList()).contains(Enchant);
        if (IsEnchant) {

            int level = 1;

            if (args.length == 2) {
                try {
                    level = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "" + args[1] + " is not a whole number!");
                    player.sendMessage("Example: /RMEnchant <RM Enchant> <INT: Level>");
                    return true;
                }
            }

            if (level < 1){
                player.sendMessage(ChatColor.RED + "Int can not be less then 1!");
                player.sendMessage("Example: /RMEnchant <RM Enchant> <INT: Level>");
                return true;
            }

            MainHandItem.addUnsafeEnchantment(Enchant, level);

            ItemMeta MainHandItem_meta = MainHandItem.getItemMeta();

            List<String> Lore = new ArrayList<String>();

            if ( (level == 1) ){
                Lore.add(ChatColor.GRAY + "" + EnchantName + " ");
            }else{
                Lore.add(ChatColor.GRAY + "" + EnchantName + " " + level);
            }

            if (MainHandItem_meta == null){
                //I doubt this will ever trigger but on the edge case that it does
                player.sendMessage(ChatColor.RED + "Error: Item Meta is Null???");
                return true;
            }

            if (MainHandItem_meta.hasLore()) {
                List<String> itemLore = MainHandItem_meta.getLore();
                if (itemLore != null) {
                    Lore.addAll(itemLore);
                }
            }

            MainHandItem_meta.setLore(Lore);
            MainHandItem.setItemMeta(MainHandItem_meta);

        }else{
            player.sendMessage(ChatColor.RED+"Enchant is not RM Enchant!");
            player.sendMessage("Example: /RMEnchant <RM Enchant>");
            return true;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1){
            List<String> ListOEnchants = Arrays.asList(
                    "TELEKINESIS",
                    "HEAVYSTEP",
                    "SOULBOUND"
            );
            EnchantList = ListOEnchants;

            return ListOEnchants;
        }
        return null;
    }
}
