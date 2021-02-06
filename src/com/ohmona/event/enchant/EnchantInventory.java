package com.ohmona.event.enchant;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.ohmona.event.OhmonaEvent;
import com.ohmona.main.Main;
import com.sun.jdi.Location;

public class EnchantInventory implements Listener{
	
	public static Main plugin;
	
	public static void setPlugin(Main MainPlugin) {
		plugin = MainPlugin;

	}

	
public Inventory enchantInv;
public boolean bool = false;
	
@EventHandler
public void onEnchantTableClick (PlayerInteractEvent e){ 
	
	final EnchantInventory einv = new EnchantInventory();
	
	Block b = e.getClickedBlock();
	
   if (e.getAction() == Action.RIGHT_CLICK_BLOCK){                               
       if (b.getType().equals(Material.ENCHANTING_TABLE)) {
        	e.setCancelled(true);
        	einv.openInventory(e.getPlayer());
            System.out.println("Someone tried to open Enchanting Table.");
       }
	}
}

	@EventHandler
	public boolean onEnchantTableInventoryClick(InventoryClickEvent e) {
		
		Tools tools = new Tools();
		
		final ItemStack BSGP = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemStack cItem = e.getCurrentItem();
		HumanEntity p = e.getWhoClicked();
		InventoryView view = e.getView();
		Player player = (Player) p;
		World w = player.getWorld();
		org.bukkit.Location loc = player.getLocation();
		
		try {
			if(view.getTitle().equals("Enchanting Table")) {
				if(cItem == BSGP) {
					e.setCancelled(true);
				}
				else if(tools.isItemTool(cItem)) {
					e.setCancelled(true);
					tools.enchantItem(cItem);
					enchantInv.setItem(4, cItem);
					openInventory(p);
					w.playSound(loc, Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1,1);
					e.getWhoClicked().sendMessage("clicked");
				}
				else {
					e.setCancelled(true);
					e.getWhoClicked().sendMessage("wrong click");
				}
			}
		} catch(NullPointerException exception) {
			return false;
		}
		return true;
	}
	
	@EventHandler
	public void onGrindstoneClick (PlayerInteractEvent e){ 
		
		final GrindStoneInventory grindInv = new GrindStoneInventory();
		
		Block b = e.getClickedBlock();
		
	   if (e.getAction() == Action.RIGHT_CLICK_BLOCK){                               
	       if (b.getType().equals(Material.GRINDSTONE)) {
	        	e.setCancelled(true);
	        	grindInv.openGrindStoneInventory(e.getPlayer());
	            System.out.println("Someone tried to open  GrindStone.");
	       }
		}
	}
	
	@EventHandler
	public boolean onGrindStoneInventoryClick(InventoryClickEvent e) {
		
		Tools tools = new Tools();
		final GrindStoneInventory grindInv = new GrindStoneInventory();
		
		final ItemStack BSGP = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemStack cItem = e.getCurrentItem();
		HumanEntity p = e.getWhoClicked();
		InventoryView view = e.getView();
		Player player = (Player) p;
		World w = player.getWorld();
		org.bukkit.Location loc = player.getLocation();
		
		try {
			if(view.getTitle().equals("Grind Stone")) {
				if(cItem == BSGP) {
					e.setCancelled(true);
				}
				else if(tools.isItemTool(cItem)) {
					if(cItem.getEnchantments().size() > 0) {
						e.setCancelled(true);
						tools.removeEnchantItem(cItem);
						grindInv.setItem(4, cItem);
						grindInv.openGrindStoneInventory(p);
						w.playSound(loc, Sound.BLOCK_GRINDSTONE_USE, 1,1);
						e.getWhoClicked().sendMessage("clicked");
					}
					else {
					e.setCancelled(true);
					}
				}
				else {
					e.setCancelled(true);
					e.getWhoClicked().sendMessage("wrong click");
				}
			}
		} catch(NullPointerException exception) {
			return false;
		}
		return true;
	}
		
	public  EnchantInventory() {
		
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
		enchantInv = Bukkit.createInventory(null, 9, "Enchanting Table");
		// Put the items into the inventory
		final ItemStack itemBSGP = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
    	
    	
    	enchantInv.setItem(0, itemBSGP);
    	enchantInv.setItem(1, itemBSGP);
    	enchantInv.setItem(2, itemBSGP);
    	enchantInv.setItem(3, itemBSGP);
    	enchantInv.setItem(5, itemBSGP);
    	enchantInv.setItem(6, itemBSGP);
    	enchantInv.setItem(7, itemBSGP);
    	enchantInv.setItem(8, itemBSGP);
		}
	
 // Nice little method to create a gui item with a custom name, and description
    protected ItemStack createGuiItem(final Material material, final String name) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        item.setItemMeta(meta);

        return item;
    }

    // You can open the inventory with this
    public void openInventory(final HumanEntity ent) {
        ent.openInventory(enchantInv);
    }
}
