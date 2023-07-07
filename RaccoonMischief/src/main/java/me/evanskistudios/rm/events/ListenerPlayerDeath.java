package me.evanskistudios.rm.events;

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
import java.util.logging.Level;

enum DeathType {
    Normal,
    Llama,
    Creeper,
    Phantom,
    Warden,
    Fire
}

public class ListenerPlayerDeath implements Listener{
    RaccoonMischief plugin;
    public ListenerPlayerDeath(RaccoonMischief plugin) {this.plugin = plugin;}
    public DeathType DeathCause = DeathType.Normal;
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
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
                    case FIRE, FIRE_TICK ->{
                        DeathCause = DeathType.Fire;
                    }
                }

            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        Plugin namespace = RaccoonMischief.getPlugin();
        namespace.getLogger().log(Level.INFO, "" + DeathCause);

        //players Drop Strange meat
        ItemStack Strange_meat = new ItemStack(Material.BEEF);
        String StrangeMeatName = (ChatColor.RESET+"Strange Meat");
        if (DeathCause == DeathType.Fire) {
            Strange_meat = new ItemStack(Material.COOKED_BEEF);
            StrangeMeatName = (ChatColor.RESET+"Cooked Strange Meat");
        }
        ItemMeta Strange_meat_meta = Strange_meat.getItemMeta();
        Strange_meat_meta.setDisplayName(StrangeMeatName);
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
            default -> {
                //regular death
                player.playSound(player.getLocation(), "custom.player.no", 1.0f, 1.0f);
            }
            case Llama -> {
                //death by llama
                player.playSound(player.getLocation(), "custom.player.llama", 1.0f, 1.0f);
            }
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
                if (!(event.getKeepInventory())) {
                    //custom handling of dropping items so that we can modify them before they drop
                    ItemStack[] ArmorContents = player.getInventory().getArmorContents();
                    event.getDrops().clear();

                    //TO-DO find a way to just remove null from collections then we can just add it all into the drops rather then looping twice
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
