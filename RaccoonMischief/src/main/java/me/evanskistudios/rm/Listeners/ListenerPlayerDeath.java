package me.evanskistudios.rm.Listeners;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

enum DeathType {
    Normal, Llama, Creeper, Phantom, Warden, Fire
}

public class ListenerPlayerDeath implements Listener{
    RaccoonMischief plugin;
    public ListenerPlayerDeath(RaccoonMischief plugin) {this.plugin = plugin;}
    private DeathType DeathCause = DeathType.Normal;

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        //zombie, creeper, skeleton
        if (event.isCancelled()) return;

        //Entity killerOutput = event.getDamager();
        //Plugin namespace = RaccoonMischief.getPlugin();
        //namespace.getLogger().log(Level.INFO, ""+killerOutput);

        Entity entity = event.getEntity();
        if (entity instanceof Player player) {

            if (event.getFinalDamage() >= player.getHealth()){
                Entity killer = event.getDamager();

                //DeathCause = DeathType.Normal;

                if (killer instanceof LlamaSpit) {
                    DeathCause = DeathType.Llama;
                }

                if (killer instanceof Creeper) {
                    DeathCause = DeathType.Creeper;
                }

                if (killer instanceof Phantom) {
                    DeathCause = DeathType.Phantom;
                }

                if (killer instanceof Warden) {
                    DeathCause = DeathType.Warden;
                }
            }
        }
    }
    @EventHandler
    public void onDamageBlock(EntityDamageByBlockEvent event) {
        //Sweet berry, magma
        if (event.isCancelled()) return;

        //Block killerOutput = event.getDamager();
        //Plugin namespace = RaccoonMischief.getPlugin();
        //namespace.getLogger().log(Level.INFO, "" + killerOutput);

        Entity entity = event.getEntity();
        if (entity instanceof Player player) {
            if (event.getFinalDamage() >= player.getHealth()) {
                Block killer = event.getDamager();
                if (killer == null) return;

               // DeathCause = DeathType.Normal;
            }
        }
    }

    @EventHandler
    public void onHurt(EntityDamageEvent event) {
        //Fire Drowning Freezing
        if (event.isCancelled()) return;

        Entity entity = event.getEntity();
        if (entity instanceof Player player) {
            //EntityDamageEvent.DamageCause killerOutput = event.getCause();
            //Plugin namespace = RaccoonMischief.getPlugin();
            //namespace.getLogger().log(Level.INFO, "" + killerOutput);

            if (event.getFinalDamage() >= player.getHealth()) {
                EntityDamageEvent.DamageCause killer = event.getCause();

                //DeathCause = DeathType.Normal;

                switch(killer){
                    case FIRE, FIRE_TICK -> DeathCause = DeathType.Fire;
                }

            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        // Plugin namespace = RaccoonMischief.getPlugin();
        // namespace.getLogger().log(Level.INFO, "" + DeathCause);

        //players Drop Strange meat
        ItemStack Strange_meat = new ItemStack(Material.BEEF);
        String StrangeMeatName = (ChatColor.RESET+"Strange Meat");
        if (DeathCause == DeathType.Fire) {
            Strange_meat = new ItemStack(Material.COOKED_BEEF);
            StrangeMeatName = (ChatColor.RESET+"Cooked Strange Meat");
        }
        ItemMeta Strange_meat_meta = Strange_meat.getItemMeta();
        Strange_meat_meta.setDisplayName(StrangeMeatName);
        Strange_meat_meta.setCustomModelData(999);
        Strange_meat.setItemMeta(Strange_meat_meta);
        player.getWorld().dropItem(player.getLocation().add(0,1,0), Strange_meat);

        Plugin plugin = RaccoonMischief.getPlugin(RaccoonMischief.class);
        String DropSkulls = "" + plugin.getConfig().get("B_PlayersDropSkulls");
        if (DropSkulls.equalsIgnoreCase("True")) {
            //Player head
            ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta PlayerHead_meta = (SkullMeta) PlayerHead.getItemMeta();
            PlayerHead_meta.setOwner(player.getName());
            PlayerHead.setItemMeta(PlayerHead_meta);
            player.getWorld().dropItem(player.getLocation().add(0, 1, 0), PlayerHead);
        }

        //Custom death sounds/effects
        switch (DeathCause) {
            default -> //regular death
                    player.playSound(player.getLocation(), "custom.player.no", 1.0f, 1.0f);
            case Llama -> //death by llama
                    player.playSound(player.getLocation(), "custom.player.llama", 1.0f, 1.0f);

            case Creeper -> {
                //death by creeper
                String orgDeathMessage = event.getDeathMessage();
                if (orgDeathMessage == null) return;
                orgDeathMessage = orgDeathMessage.replace("up ","");
                event.setDeathMessage(orgDeathMessage);
                //play normal no sound
                player.playSound(player.getLocation(), "custom.player.no", 1.0f, 1.0f);
            }

            case Phantom -> {
                //death by Phantom
                event.setDeathMessage(player.getName() + " got Vectored!");
                //play normal no sound
                player.playSound(player.getLocation(), "custom.hostile.vector.kill", 1.0f, 1.0f);
            }

            case Warden -> {
                String orgDeathMessage = event.getDeathMessage();
                if (orgDeathMessage == null) return;
                orgDeathMessage = orgDeathMessage.replace("shriek","Shrek");
                event.setDeathMessage(orgDeathMessage);
                //play normal no sound
                player.playSound(player.getLocation(), "custom.player.no", 1.0f, 1.0f);
            }

            case Fire -> {
                ItemStack[] InventoryContents = player.getInventory().getContents();
                ArrayList<ItemStack> NewItems= new ArrayList<>();
                for (ItemStack item : InventoryContents){
                    if (item != null){
                        int amount = item.getAmount();
                        ItemMeta meta = item.getItemMeta();

                        switch (item.getType()) {
                            case BEEF ->           item = new ItemStack( Material.COOKED_BEEF,         amount);
                            case CHICKEN ->        item = new ItemStack( Material.COOKED_CHICKEN,      amount);
                            case PORKCHOP ->       item = new ItemStack( Material.COOKED_PORKCHOP,     amount);
                            case MUTTON ->         item = new ItemStack( Material.COOKED_MUTTON,       amount);
                            case RABBIT ->         item = new ItemStack( Material.COOKED_RABBIT,       amount);
                            case COD ->            item = new ItemStack( Material.COOKED_COD,          amount);
                            case SALMON ->         item = new ItemStack( Material.COOKED_SALMON,       amount);
                            case POTATO ->         item = new ItemStack( Material.BAKED_POTATO,        amount);
                            case KELP ->           item = new ItemStack( Material.DRIED_KELP,          amount);
                            case CHORUS_FRUIT ->   item = new ItemStack( Material.POPPED_CHORUS_FRUIT, amount);
                        }
                        item.setItemMeta(meta);
                        NewItems.add(item);
                        //Overwrites item slot with new item
                    }else{
                        NewItems.add(null);
                    }
                }
                if (!(event.getKeepInventory())) {
                    //custom handling of dropping items so that we can modify them before they drop
                    ItemStack[] ArmorContents = player.getInventory().getArmorContents();
                    event.getDrops().clear();

                    //TO-DO find a way to just remove null from collections then we can just add it all into the drops rather than looping twice
                    for (ItemStack item : NewItems) {
                        if (item != null) {
                            event.getDrops().add(item);
                        }
                    }
                    for (ItemStack item : ArmorContents) {
                        if (item != null) {
                            event.getDrops().add(item);
                        }
                    }
                    player.getInventory().clear();
                }else{
                    //in this case keep inventory game-rule is true so don't worry about dropping as we can still modify the items
                    player.getInventory().setContents(NewItems.toArray(new ItemStack[0]));
                }

                player.playSound(player.getLocation(), "custom.player.no", 1.0f, 1.0f);
            }
        }
        DeathCause = DeathType.Normal; //reset so we are not stuck with last one played
    }
}
