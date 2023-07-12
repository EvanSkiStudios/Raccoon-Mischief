package me.evanskistudios.rm.Utilis;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

enum Holders{
    GUIHOLDER
}

@SuppressWarnings("All") //STFU
public class GUIHolder implements InventoryHolder {

    Holders holder;

    public GUIHolder() {
        this.holder = Holders.GUIHOLDER;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }

    public Holders getPlayer() {
        return holder;
    }
}
