package com.ohmona.exp.event.enchant;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GrindStoneInventory {

    public Inventory grindInv;

    public  GrindStoneInventory() {

        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        grindInv = Bukkit.createInventory(null, 9, "Grind Stone");
        // Put the items into the inventory
        final ItemStack itemBSGP = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);


        grindInv.setItem(0, itemBSGP);
        grindInv.setItem(1, itemBSGP);
        grindInv.setItem(2, itemBSGP);
        grindInv.setItem(3, itemBSGP);
        grindInv.setItem(5, itemBSGP);
        grindInv.setItem(6, itemBSGP);
        grindInv.setItem(7, itemBSGP);
        grindInv.setItem(8, itemBSGP);
    }

    public void openGrindStoneInventory(final HumanEntity ent) {
        ent.openInventory(grindInv);
    }

    public void setItem(int slot, ItemStack item) {
        grindInv.setItem(slot, item);
    }

}
