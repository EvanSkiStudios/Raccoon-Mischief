package me.evanskistudios.rm.commands;

import me.evanskistudios.rm.RaccoonMischief;
import me.evanskistudios.rm.items.ItemUpgradeShard;
import me.evanskistudios.rm.recipes.*;
import me.evanskistudios.rm.utilis.GUIHolder;
import me.evanskistudios.rm.utilis.Glow;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

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
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Plugin namespace = RaccoonMischief.getPlugin();

        if (!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED+"Command only works for players!");
            return true;
        }

        Player player = (Player) sender;

        if (args == null){
            player.sendMessage(ChatColor.RED+"Incorrect amount of arguments!");
            player.sendMessage("Example: /RMShowCraft <RM Recipe>");
            return true;
        }

        if (args.length != 1){
           player.sendMessage(ChatColor.RED+"Incorrect amount of arguments!");
           player.sendMessage("Example: /RMShowCraft <RM Recipe>");
            return true;
        }


        //Default values to redefine
        String crafting_recipe = args[0];
        boolean found_recipe = false;
        Inventory CraftRecipe;
        ItemStack[] CraftingMatrix = new ItemStack[10];
        Arrays.fill(CraftingMatrix, new ItemStack(Material.AIR));
        String Inventory_title = "ERROR";
        InventoryType Inventory_type = InventoryType.WORKBENCH;
        ItemStack N = new ItemStack(Material.AIR, 1);
        ItemStack Coal = new ItemStack(Material.COAL, 1);

        if (!found_recipe && crafting_recipe.equalsIgnoreCase("Cake")) {

            found_recipe = true;
            Inventory_title = "Cake";

            ItemStack Cake = new ItemStack(Material.CAKE, 1);
            ItemStack Wheat = new ItemStack(Material.WHEAT, 1);
            ItemStack Egg = new ItemStack(Material.EGG, 1);
            ItemStack Sugar = new ItemStack(Material.SUGAR, 1);
            ItemStack SweetBerries = new ItemStack(Material.SWEET_BERRIES, 1);
            ItemStack MilkBucket = new ItemStack(Material.MILK_BUCKET, 1);

            ItemStack[] Matrix = {
                Cake,
                MilkBucket, SweetBerries, MilkBucket,
                Sugar, Egg, Sugar,
                Wheat, Wheat, Wheat
            };

            System.arraycopy(Matrix, 0, CraftingMatrix, 0, Matrix.length);
        }


        if (!found_recipe && crafting_recipe.equalsIgnoreCase("Dirt_to_Seeds")) {

            found_recipe = true;
            Inventory_title = "Dirt to Seeds";

            ItemStack Dirt = new ItemStack(Material.DIRT, 1);
            ItemStack WheatSeeds = new ItemStack(Material.WHEAT_SEEDS, 1);

            ItemStack[] Matrix = {
                   WheatSeeds,
                   Dirt, Dirt, N,
                   Dirt, Dirt, N,
                   N, N, N
            };

            System.arraycopy(Matrix, 0, CraftingMatrix, 0, Matrix.length);
        }

        if (!found_recipe && crafting_recipe.equalsIgnoreCase("Harder_Armor")) {

            found_recipe = true;
            Inventory_title = "Harder Armor";

            ItemStack IronIngot = new ItemStack(Material.IRON_INGOT, 1);
            ItemStack IronChestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);

            ItemStack Leather_armor = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta LA_Meta = Leather_armor.getItemMeta();
            LA_Meta.setDisplayName(ChatColor.RESET+""+ChatColor.GREEN+"Armor recipe needs last tier of armor");

            //Enchant glint
            NamespacedKey EnchantKey = new NamespacedKey(namespace, "Glow");
            Glow glow = new Glow(EnchantKey);
            LA_Meta.addEnchant(glow, 1, true);

            Leather_armor.setItemMeta(LA_Meta);

            ItemStack[] Matrix = {
                    IronChestplate,
                    IronIngot, Leather_armor, IronIngot,
                    IronIngot, IronIngot, IronIngot,
                    IronIngot, IronIngot, IronIngot
            };

            System.arraycopy(Matrix, 0, CraftingMatrix, 0, Matrix.length);
        }

        if (!found_recipe && crafting_recipe.equalsIgnoreCase("JTE_Apple")) {

            found_recipe = true;
            Inventory_title = "JTE Apple";

            ItemStack G = new ItemStack(Material.GOLD_BLOCK, 1);
            ItemStack A = new ItemStack(Material.APPLE, 1);
            ItemStack EnchantedGoldenApple = RecipeJTEApple.getItem();

            ItemStack[] Matrix = {
                    EnchantedGoldenApple,
                    G, G, G,
                    G, A, G,
                    G, G, G
            };

            System.arraycopy(Matrix, 0, CraftingMatrix, 0, Matrix.length);
        }

        if (!found_recipe && crafting_recipe.equalsIgnoreCase("Milk_Potion")) {

            found_recipe = true;
            Inventory_title = "Milk Potion";

            ItemStack M = new ItemStack(Material.MILK_BUCKET, 1);
            ItemStack G = new ItemStack(Material.GUNPOWDER, 1);
            ItemStack MilkPotion = RecipeMilkPotion.getItem();

            ItemStack[] Matrix = {
                    MilkPotion,
                    M, G,
            };

            System.arraycopy(Matrix, 0, CraftingMatrix, 0, Matrix.length);
        }

        if (!found_recipe && crafting_recipe.equalsIgnoreCase("RottenFlesh_to_Leather")) {

            found_recipe = true;
            Inventory_title = "RottenFlesh to Leather";
            Inventory_type = InventoryType.FURNACE;

            ItemStack R = new ItemStack(Material.ROTTEN_FLESH, 1);
            ItemStack Leather = new ItemStack(Material.LEATHER, 1);

            ItemStack[] Matrix = {
                    R,
                    Coal,
                    Leather
            };

            System.arraycopy(Matrix, 0, CraftingMatrix, 0, Matrix.length);
        }

        if (!found_recipe && crafting_recipe.equalsIgnoreCase("Redstone_Items")) {

            found_recipe = true;
            Inventory_title = "Redstone Items";

            ItemStack C = new ItemStack(Material.COPPER_INGOT, 1);
            ItemStack S = new ItemStack(Material.STICK, 1);
            ItemStack R = new ItemStack(Material.REDSTONE, 1);

            ItemStack PoweredRail = new ItemStack(Material.POWERED_RAIL, 1);
            ItemMeta PR_Meta = PoweredRail.getItemMeta();
            PR_Meta.setDisplayName(ChatColor.RESET+""+ChatColor.GREEN+"Redstone recipes that use gold now use copper");

            //Enchant glint
            NamespacedKey EnchantKey = new NamespacedKey(namespace, "Glow");
            Glow glow = new Glow(EnchantKey);
            PR_Meta.addEnchant(glow, 1, true);

            PoweredRail.setItemMeta(PR_Meta);

            ItemStack[] Matrix = {
                    PoweredRail,
                    C, N, C,
                    C, S, C,
                    C, R, C
            };

            System.arraycopy(Matrix, 0, CraftingMatrix, 0, Matrix.length);
        }

        if (!found_recipe && crafting_recipe.equalsIgnoreCase("Tactical_Dirt")) {

            found_recipe = true;
            Inventory_title = "Tactical Dirt";

            ItemStack D = new ItemStack(Material.DIRT, 1);
            ItemStack S = new ItemStack(Material.WHEAT_SEEDS, 1);
            ItemStack Tact_Dirt = Recipe_tactical_dirt.getItem();

            ItemStack[] Matrix = {
                    Tact_Dirt,
                    D, S
            };

            System.arraycopy(Matrix, 0, CraftingMatrix, 0, Matrix.length);
        }

        if (!found_recipe && crafting_recipe.equalsIgnoreCase("Throwable_Brick")) {

            found_recipe = true;
            Inventory_title = "Throwable Brick";

            ItemStack B = new ItemStack(Material.BRICK, 1);
            ItemStack Brick = RecipeThrowableBrick.getItem();

            ItemStack[] Matrix = {
                    Brick,
                    N,N,N,
                    N,B,
            };

            System.arraycopy(Matrix, 0, CraftingMatrix, 0, Matrix.length);
        }

        if (!found_recipe && crafting_recipe.equalsIgnoreCase("UnMetaData_Cookies")) {

            found_recipe = true;
            Inventory_title = "Un-MetaData Cookies";

            ItemStack C = new ItemStack(Material.COOKIE, 1);
            ItemStack Cookie = Recipe_unmetadata_cookies.getItem();
            ItemMeta Cookie_Meta = Cookie.getItemMeta();
            Cookie_Meta.setDisplayName(ChatColor.RESET+""+ChatColor.GREEN+"Removes Meta given to cookies from A-Turtles-Troll");

            //Enchant glint
            NamespacedKey EnchantKey = new NamespacedKey(namespace, "Glow");
            Glow glow = new Glow(EnchantKey);
            Cookie_Meta.addEnchant(glow, 1, true);

            Cookie.setItemMeta(Cookie_Meta);

            ItemStack[] Matrix = {
                    Cookie,
                    N,N,N,
                    N, C, N
            };

            System.arraycopy(Matrix, 0, CraftingMatrix, 0, Matrix.length);
        }

        if (!found_recipe && crafting_recipe.equalsIgnoreCase("XP_Orb")) {

            found_recipe = true;
            Inventory_title = "XP Orb";

            ItemStack XPOrb = RecipeExpCrystal.getItem();

            ItemStack U = ItemUpgradeShard.UpgradeShard();
            ItemStack B = new ItemStack(Material.GLASS_BOTTLE, 1);
            ItemStack EB = new ItemStack(Material.EXPERIENCE_BOTTLE, 1);
            ItemMeta EB_Meta = EB.getItemMeta();
            EB_Meta.setDisplayName(ChatColor.RESET+""+ChatColor.GREEN+"Requires 1 XP Level");

            //Enchant glint
            NamespacedKey EnchantKey = new NamespacedKey(namespace, "Glow");
            Glow glow = new Glow(EnchantKey);
            EB_Meta.addEnchant(glow, 1, true);

            EB.setItemMeta(EB_Meta);

            ItemStack[] Matrix = {
                    XPOrb,
                    U, B, N,
                    N,N,N,
                    N,EB
            };

            System.arraycopy(Matrix, 0, CraftingMatrix, 0, Matrix.length);
        }

        if (found_recipe) {

            CraftRecipe = Bukkit.createInventory(new GUIHolder(), Inventory_type, Inventory_title);

            //Workbench
            if (Inventory_type == InventoryType.WORKBENCH) {
                for (int i = 0; i < CraftingMatrix.length; ++i) {
                    CraftRecipe.setItem(i, CraftingMatrix[i]);
                }
            //Furnace
            }else  if (Inventory_type == InventoryType.FURNACE){
                for (int i = 0; i < 3; ++i) {
                    CraftRecipe.setItem(i, CraftingMatrix[i]);
                }
            }else{
                //DIDN'T FIND ONE ERROR
                player.sendMessage(ChatColor.RED+"You should never see this, if you do please report this!");
                player.sendMessage("Example: /RMShowCraft <RM Recipe>");
                return true;
            }

            player.openInventory(CraftRecipe);

        }else{
            //Did not find recipe
            player.sendMessage(ChatColor.RED+""+crafting_recipe + " was not found or is not an RM Recipe!");
            player.sendMessage("Example: /RMShowCraft <RM Recipe>");
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1){
            List<String> ListOItems = Arrays.asList(
                    "Cake",
                    "Dirt_to_Seeds",
                    "Harder_Armor",
                    "JTE_Apple",
                    "Milk_Potion",
                    "Redstone_Items",
                    "RottenFlesh_to_Leather",
                    "Tactical_Dirt",
                    "Throwable_Brick",
                    "UnMetaData_Cookies",
                    "XP_Orb"
            );
            return ListOItems;
        }

            return null;
    }
}


