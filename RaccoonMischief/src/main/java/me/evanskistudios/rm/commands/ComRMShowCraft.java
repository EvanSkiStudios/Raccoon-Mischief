package me.evanskistudios.rm.Commands;

import me.evanskistudios.rm.Items.ItemUpgradeShard;
import me.evanskistudios.rm.Recipes.*;
import me.evanskistudios.rm.Utilis.Glow;
import me.evanskistudios.rm.RaccoonMischief;
import me.evanskistudios.rm.Utilis.GUIHolder;
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

    //Creates guis to show player
    public static class InventoryGUIs {
        public static final Plugin namespace = RaccoonMischief.getPlugin();
        // Default Variables
        private static final ItemStack[] CraftingMatrix = new ItemStack[10];
        private static final ItemStack N = new ItemStack(Material.AIR, 1);
        private static final ItemStack Coal = new ItemStack(Material.COAL, 1);

        // Initialize the default values in a static initialization block
        static {
            Arrays.fill(CraftingMatrix, new ItemStack(Material.AIR));
        }

        public static Inventory InventoryCake(){
            String InventoryTitle = "Cake";
            InventoryType InventoryGUIType = InventoryType.WORKBENCH;

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

            ItemStack[] RecipeMatrix = CraftingMatrix.clone();
            System.arraycopy(Matrix, 0, RecipeMatrix, 0, Matrix.length);
            Inventory RecipeInventory = Bukkit.createInventory(new GUIHolder(), InventoryGUIType, InventoryTitle);
            for (int i = 0; i < RecipeMatrix.length; ++i) {
                RecipeInventory.setItem(i, RecipeMatrix[i]);
            }
            return RecipeInventory;
        }

        public static Inventory InventoryCakeFromSlices(){
            String InventoryTitle = "Cake From Slices";
            InventoryType InventoryGUIType = InventoryType.WORKBENCH;

            ItemStack Cake = new ItemStack(Material.CAKE, 1);
            ItemStack CakeSlice = RecipeCakeSlices.getItem();
            CakeSlice.setAmount(1);

            ItemStack[] Matrix = {
                    Cake,
                    CakeSlice,CakeSlice,N,
                    CakeSlice,CakeSlice,CakeSlice,
                    N,CakeSlice,CakeSlice
            };

            ItemStack[] RecipeMatrix = CraftingMatrix.clone();
            System.arraycopy(Matrix, 0, RecipeMatrix, 0, Matrix.length);
            Inventory RecipeInventory = Bukkit.createInventory(new GUIHolder(), InventoryGUIType, InventoryTitle);
            for (int i = 0; i < RecipeMatrix.length; ++i) {
                RecipeInventory.setItem(i, RecipeMatrix[i]);
            }
            return RecipeInventory;
        }

        public static Inventory InventoryCakeSlices(){
            String InventoryTitle = "Cake Slice";
            InventoryType InventoryGUIType = InventoryType.WORKBENCH;

            ItemStack Cake = new ItemStack(Material.CAKE, 1);
            ItemStack CakeSlice = RecipeCakeSlices.getItem();

            ItemStack[] Matrix = {
                    CakeSlice,
                    N,N,N,
                    N,Cake,
            };

            ItemStack[] RecipeMatrix = CraftingMatrix.clone();
            System.arraycopy(Matrix, 0, RecipeMatrix, 0, Matrix.length);
            Inventory RecipeInventory = Bukkit.createInventory(new GUIHolder(), InventoryGUIType, InventoryTitle);
            for (int i = 0; i < RecipeMatrix.length; ++i) {
                RecipeInventory.setItem(i, RecipeMatrix[i]);
            }
            return RecipeInventory;
        }

        public static Inventory InventoryDirtToSeeds(){
            String InventoryTitle = "Dirt to Seeds";
            InventoryType InventoryGUIType = InventoryType.WORKBENCH;

            ItemStack Dirt = new ItemStack(Material.DIRT, 1);
            ItemStack WheatSeeds = new ItemStack(Material.WHEAT_SEEDS, 1);

            ItemStack[] Matrix = {
                    WheatSeeds,
                    Dirt, Dirt, N,
                    Dirt, Dirt, N,
                    N, N, N
            };

            ItemStack[] RecipeMatrix = CraftingMatrix.clone();
            System.arraycopy(Matrix, 0, RecipeMatrix, 0, Matrix.length);
            Inventory RecipeInventory = Bukkit.createInventory(new GUIHolder(), InventoryGUIType, InventoryTitle);
            for (int i = 0; i < RecipeMatrix.length; ++i) {
                RecipeInventory.setItem(i, RecipeMatrix[i]);
            }
            return RecipeInventory;
        }

        public static Inventory InventoryHarderArmor(){
            String InventoryTitle = "Harder Armor";
            InventoryType InventoryGUIType = InventoryType.WORKBENCH;

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

            ItemStack[] RecipeMatrix = CraftingMatrix.clone();
            System.arraycopy(Matrix, 0, RecipeMatrix, 0, Matrix.length);
            Inventory RecipeInventory = Bukkit.createInventory(new GUIHolder(), InventoryGUIType, InventoryTitle);
            for (int i = 0; i < RecipeMatrix.length; ++i) {
                RecipeInventory.setItem(i, RecipeMatrix[i]);
            }
            return RecipeInventory;
        }

        public static Inventory InventoryJTEApple(){
            String InventoryTitle = "JTE Apple";
            InventoryType InventoryGUIType = InventoryType.WORKBENCH;

            ItemStack G = new ItemStack(Material.GOLD_BLOCK, 1);
            ItemStack A = new ItemStack(Material.APPLE, 1);
            ItemStack EnchantedGoldenApple = RecipeJTEApple.getItem();

            ItemStack[] Matrix = {
                    EnchantedGoldenApple,
                    G, G, G,
                    G, A, G,
                    G, G, G
            };

            ItemStack[] RecipeMatrix = CraftingMatrix.clone();
            System.arraycopy(Matrix, 0, RecipeMatrix, 0, Matrix.length);
            Inventory RecipeInventory = Bukkit.createInventory(new GUIHolder(), InventoryGUIType, InventoryTitle);
            for (int i = 0; i < RecipeMatrix.length; ++i) {
                RecipeInventory.setItem(i, RecipeMatrix[i]);
            }
            return RecipeInventory;
        }

        public static Inventory InventoryMilkPotion(){
            String InventoryTitle = "Milk Potion";
            InventoryType InventoryGUIType = InventoryType.WORKBENCH;

            ItemStack M = new ItemStack(Material.MILK_BUCKET, 1);
            ItemStack G = new ItemStack(Material.GUNPOWDER, 1);
            ItemStack MilkPotion = RecipeMilkPotion.getItem();

            ItemStack[] Matrix = {
                    MilkPotion,
                    M, G,
            };

            ItemStack[] RecipeMatrix = CraftingMatrix.clone();
            System.arraycopy(Matrix, 0, RecipeMatrix, 0, Matrix.length);
            Inventory RecipeInventory = Bukkit.createInventory(new GUIHolder(), InventoryGUIType, InventoryTitle);
            for (int i = 0; i < RecipeMatrix.length; ++i) {
                RecipeInventory.setItem(i, RecipeMatrix[i]);
            }
            return RecipeInventory;
        }

        public static Inventory InventoryRottenFleshToLeather(){
            String InventoryTitle = "RottenFlesh to Leather";
            InventoryType InventoryGUIType = InventoryType.FURNACE;

            ItemStack R = new ItemStack(Material.ROTTEN_FLESH, 1);
            ItemStack Leather = new ItemStack(Material.LEATHER, 1);

            ItemStack[] Matrix = {
                    R,
                    Coal,
                    Leather
            };

            ItemStack[] RecipeMatrix = CraftingMatrix.clone();
            System.arraycopy(Matrix, 0, RecipeMatrix, 0, Matrix.length);
            Inventory RecipeInventory = Bukkit.createInventory(new GUIHolder(), InventoryGUIType, InventoryTitle);
            for (int i = 0; i < 3; ++i) {
                RecipeInventory.setItem(i, RecipeMatrix[i]);
            }
            return RecipeInventory;
        }

        public static Inventory InventoryRedstoneItems(){
            String InventoryTitle = "Redstone Items";
            InventoryType InventoryGUIType = InventoryType.WORKBENCH;

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

            ItemStack[] RecipeMatrix = CraftingMatrix.clone();
            System.arraycopy(Matrix, 0, RecipeMatrix, 0, Matrix.length);
            Inventory RecipeInventory = Bukkit.createInventory(new GUIHolder(), InventoryGUIType, InventoryTitle);
            for (int i = 0; i < RecipeMatrix.length; ++i) {
                RecipeInventory.setItem(i, RecipeMatrix[i]);
            }
            return RecipeInventory;
        }

        public static Inventory InventoryTacticalDirt() {
            String InventoryTitle = "Tactical Dirt";
            InventoryType InventoryGUIType = InventoryType.WORKBENCH;

            ItemStack D = new ItemStack(Material.DIRT, 1);
            ItemStack S = new ItemStack(Material.WHEAT_SEEDS, 1);
            ItemStack Tact_Dirt = RecipeTacticalDirt.getItem();

            ItemStack[] Matrix = {
                    Tact_Dirt,
                    D, S
            };

            ItemStack[] RecipeMatrix = CraftingMatrix.clone();
            System.arraycopy(Matrix, 0, RecipeMatrix, 0, Matrix.length);

            Inventory TacticalDirtInventory = Bukkit.createInventory(new GUIHolder(), InventoryGUIType, InventoryTitle);
            for (int i = 0; i < RecipeMatrix.length; ++i) {
                TacticalDirtInventory.setItem(i, RecipeMatrix[i]);
            }

            return TacticalDirtInventory;
        }

        public static Inventory InventoryThrowableBrick(){
            String InventoryTitle = "Throwable Brick";
            InventoryType InventoryGUIType = InventoryType.WORKBENCH;

            ItemStack B = new ItemStack(Material.BRICK, 1);
            ItemStack Brick = RecipeThrowableBrick.getItem();

            ItemStack[] Matrix = {
                    Brick,
                    N,N,N,
                    N,B,
            };

            ItemStack[] RecipeMatrix = CraftingMatrix.clone();
            System.arraycopy(Matrix, 0, RecipeMatrix, 0, Matrix.length);
            Inventory RecipeInventory = Bukkit.createInventory(new GUIHolder(), InventoryGUIType, InventoryTitle);
            for (int i = 0; i < RecipeMatrix.length; ++i) {
                RecipeInventory.setItem(i, RecipeMatrix[i]);
            }
            return RecipeInventory;
        }

        public static Inventory InventoryUnMetaDataCookies(){
            String InventoryTitle = "Un-MetaData Cookies";
            InventoryType InventoryGUIType = InventoryType.WORKBENCH;


            ItemStack C = new ItemStack(Material.COOKIE, 1);
            ItemStack Cookie = RecipeUnMetaDataCookies.getItem();
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

            ItemStack[] RecipeMatrix = CraftingMatrix.clone();
            System.arraycopy(Matrix, 0, RecipeMatrix, 0, Matrix.length);
            Inventory RecipeInventory = Bukkit.createInventory(new GUIHolder(), InventoryGUIType, InventoryTitle);
            for (int i = 0; i < RecipeMatrix.length; ++i) {
                RecipeInventory.setItem(i, RecipeMatrix[i]);
            }
            return RecipeInventory;
        }

        public static Inventory InventoryXpOrb(){
            String InventoryTitle = "XP Orb";
            InventoryType InventoryGUIType = InventoryType.WORKBENCH;

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

            ItemStack[] RecipeMatrix = CraftingMatrix.clone();
            System.arraycopy(Matrix, 0, RecipeMatrix, 0, Matrix.length);
            Inventory RecipeInventory = Bukkit.createInventory(new GUIHolder(), InventoryGUIType, InventoryTitle);
            for (int i = 0; i < RecipeMatrix.length; ++i) {
                RecipeInventory.setItem(i, RecipeMatrix[i]);
            }
            return RecipeInventory;
        }
    }

    //prevents player from taking items as well as custom actions
    @EventHandler
    public void onMenu(InventoryClickEvent event) {
        if (event.isCancelled()) return;

        Inventory Active_Inventory = event.getClickedInventory();

        if ((Active_Inventory == null) || (Active_Inventory.getHolder() == null) || !(Active_Inventory.getHolder() instanceof GUIHolder)) {
            return;
        }

        event.setCancelled(true);
    }

    //Actual command that player runs
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Plugin namespace = RaccoonMischief.getPlugin();

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Command only works for players!");
            return true;
        }

        Player player = (Player) sender;

        if ( (args == null) || (args.length != 1) ){
            player.sendMessage(ChatColor.RED + "Incorrect amount of arguments!");
            player.sendMessage("Example: /RMShowCraft <RM Recipe>");
            return true;
        }

        //Default values to redefine
        String crafting_recipe = args[0];

        if (crafting_recipe.equalsIgnoreCase("Cake")) {
            player.openInventory(InventoryGUIs.InventoryCake());
            return true;
        }

        if (crafting_recipe.equalsIgnoreCase("Cake_From_Slices")) {
            player.openInventory(InventoryGUIs.InventoryCakeFromSlices());
            return true;
        }

        if (crafting_recipe.equalsIgnoreCase("Cake_Slice")) {
            player.openInventory(InventoryGUIs.InventoryCakeSlices());
            return true;
        }

        if (crafting_recipe.equalsIgnoreCase("Dirt_to_Seeds")) {
            player.openInventory(InventoryGUIs.InventoryDirtToSeeds());
            return true;
        }

        if (crafting_recipe.equalsIgnoreCase("Harder_Armor")) {
            player.openInventory(InventoryGUIs.InventoryHarderArmor());
            return true;
        }

        if (crafting_recipe.equalsIgnoreCase("JTE_Apple")) {
            player.openInventory(InventoryGUIs.InventoryJTEApple());
            return true;
        }

        if (crafting_recipe.equalsIgnoreCase("Milk_Potion")) {
            player.openInventory(InventoryGUIs.InventoryMilkPotion());
            return true;
        }

        if (crafting_recipe.equalsIgnoreCase("RottenFlesh_to_Leather")) {
            player.openInventory(InventoryGUIs.InventoryRottenFleshToLeather());
            return true;
        }

        if (crafting_recipe.equalsIgnoreCase("Redstone_Items")) {
            player.openInventory(InventoryGUIs.InventoryRedstoneItems());
            return true;
        }

        if (crafting_recipe.equalsIgnoreCase("Tactical_Dirt")) {
            player.openInventory(InventoryGUIs.InventoryTacticalDirt());
            return true;
        }

        if (crafting_recipe.equalsIgnoreCase("Throwable_Brick")) {
            player.openInventory(InventoryGUIs.InventoryThrowableBrick());
            return true;
        }

        if (crafting_recipe.equalsIgnoreCase("UnMetaData_Cookies")) {
            player.openInventory(InventoryGUIs.InventoryUnMetaDataCookies());
            return true;
        }

        if (crafting_recipe.equalsIgnoreCase("XP_Orb")) {
            player.openInventory(InventoryGUIs.InventoryXpOrb());
            return true;
        }

        //Did not find recipe
        player.sendMessage(ChatColor.RED + "" + crafting_recipe + " was not found or is not an RM Recipe!");
        player.sendMessage("Example: /RMShowCraft <RM Recipe>");

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            List<String> ListOItems = Arrays.asList(
                    "Cake",
                    "Cake_From_Slices",
                    "Cake_Slice",
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


