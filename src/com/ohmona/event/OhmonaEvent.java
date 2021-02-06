package com.ohmona.event;

import java.util.HashMap;
import java.util.UUID;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R3.util.CraftMagicNumbers;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ohmona.file.OhmonaFile;
import com.ohmona.main.Main;
import com.ohmona.event.Reward;
import com.ohmona.event.enchant.EnchantInventory;

import net.minecraft.server.v1_16_R3.CriterionConditionPlayer;
import net.minecraft.server.v1_16_R3.DataWatcher.Item;
import net.minecraft.server.v1_16_R3.EntityFireworks;

public class OhmonaEvent extends OhmonaFile  implements Listener {

	public static Main plugin;

	public  static HashMap<UUID, Integer> map = new HashMap<UUID, Integer>();

	public static void setPlugin(Main MainPlugin) {
		plugin = MainPlugin;

	}

	//keepinventory
	@EventHandler
	public void enterPortal(PlayerPortalEvent e) {
		World world = e.getTo().getWorld();

		world.setGameRule(GameRule.KEEP_INVENTORY, true);
	}
	
	//JOIN
	@EventHandler
	public void PlayerJoinEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Inventory inv = p.getInventory();
		ItemStack item = new ItemStack(Material.CLOCK, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "exp clock");
		item.setItemMeta(meta);
		
		e.setJoinMessage(ChatColor.BOLD +""+ Color.fromRGB(235, 165, 25) +  "someone joined");
		
		inv.setItem(8, item);
	}
	
	//level up
	@EventHandler
	public void levelup(PlayerLevelChangeEvent e) {

		UUID uuid = e.getPlayer().getUniqueId();
		Player p = e.getPlayer();
		
		if(map.containsKey(uuid) == false) {
			map.put(uuid, 0);
			plugin.consol.sendMessage("new player's Level is saved");
		}
		
		int playerLevel = p.getLevel();
		float playerSavedLevel = map.get(uuid);
		float playerSavedLevelInstance = playerSavedLevel;
		
			if (map.containsKey(uuid)) {
				if (playerLevel > playerSavedLevelInstance) { //ºñ±³
					map.put(uuid, playerLevel);
					p.sendMessage("new level " + playerLevel + " saved : " + uuid);
					playerSavedLevelInstance = playerLevel;
				}
				else {
					if(p.isOp()) {
						p.sendMessage("your level is less then your Max");
					}
				}
			} 
	}
	
	// if a player's new level is his new record return true
	public boolean isMaxLevel(Player p) {
		
		Player player = p;
		UUID uuid = player.getUniqueId();
		
		int playerLevel = player.getLevel();
		float playerSavedLevel = map.get(uuid);
		float playerSavedLevelInstance = playerSavedLevel;
		
		if(playerLevel > playerSavedLevelInstance) {
			System.out.println("retrun true");
			System.out.println(player.getName() + " : " + playerLevel + " and " + playerSavedLevelInstance);
			playerSavedLevelInstance = playerLevel;
			return true;
		}
		else if(playerLevel <= playerSavedLevelInstance) {
			System.out.println("return false");
			System.out.println(player.getName() + " : " + playerLevel + " and " + playerSavedLevelInstance);
			return false;
		}
		else {
			return false;
		}
	}
	
	// sendDeathMessage for all player in server
	@EventHandler
	public void deathMessage(PlayerDeathEvent e) {
		e.setDeathMessage(null);
		Bukkit.broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD +  "someone died");
	}
	
	// calculates how many exp should be removed from death player.
	@EventHandler
	public void death(PlayerDeathEvent e) {
		Player player = e.getEntity();
		float exp = player.getExp();
		float level = player.getLevel();
		
		if(level > 0.0f || level > 0.99f) {
		if(exp > 0.9f  && exp <= 1.0f) {
			player.setExp(exp *  (30f / 100f));
			if(player.isOp()) {
				player.sendMessage( exp + "dd");
			}
		}
		else if(exp > 0.75f && exp <= 0.9f) {
			player.setExp(exp *  (33f / 100f));
			if(player.isOp()) {
				player.sendMessage( exp + "dd");
			}
		}
		else if(exp > 0.5f  && exp <= 0.749f) {
			player.setExp(exp  *  (35f/ 100f));
			if(player.isOp()) {
				player.sendMessage( exp + "dd");
			}
		}
		else if(exp > 0.25f  && exp <= 0.49f ) {
			player.setExp(exp  *  (40f/ 100f));
			if(player.isOp()) {
				player.sendMessage( exp + "dd");
			}
		}
		else if(exp <= 0.249999f) {
			if(level >= 3) {
				player.setLevel((int) (level - 3));
				player.setExp(0.8f);
				if(player.isOp()) {
					player.sendMessage( exp + "dd");
				}
			}
			else {
				player.setLevel(0);
				player.setExp(0.8f);
				if(player.isOp()) {
					player.sendMessage( exp + "dd");
				}
			}
		}
		}
		else { player.sendMessage("your level is 0!!");}
	}
	
	// Give reward to leveled up player
	@EventHandler
	public void onLevelup(PlayerLevelChangeEvent e) {
		
		Reward reward = new Reward();
		
		Player p = e.getPlayer();
		reward.onLevelupReward(p);
		
	}
	
	@EventHandler
	public void playerRightClickEvent(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action act = e.getAction();
		
		int slot = p.getInventory().getHeldItemSlot();
		ItemMeta meta = p.getInventory().getItemInMainHand().getItemMeta();
		
		if(slot == 8 || e.getPlayer().getInventory().getItemInMainHand().equals(Material.CLOCK)) {
			if(meta.hasDisplayName()) {
				if(meta.getDisplayName().equals(ChatColor.YELLOW + "" + ChatColor.BOLD + "exp clock")) {
					if(act.equals(Action.RIGHT_CLICK_AIR) || act.equals(Action.RIGHT_CLICK_BLOCK)) {
						System.out.println("gue");
					}
				}
				else {
					System.out.println("no you aren't");
				}
			}
			else {
				System.out.println("no you don't have");
			}
		}
		else {
		}
	}
	
	// INVENTORY SECTION
	
}


















