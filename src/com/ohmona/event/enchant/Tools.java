package com.ohmona.event.enchant;


import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Tools {
	
	public Material[] tools = {
			Material.WOODEN_SHOVEL,
			Material.WOODEN_PICKAXE,
		  	Material.WOODEN_HOE,
			Material.WOODEN_AXE,
			 Material.WOODEN_SWORD,
			Material.LEATHER_HELMET,
			 Material.LEATHER_CHESTPLATE,
			 Material.LEATHER_LEGGINGS,
			 Material.LEATHER_BOOTS,
			
			 Material.STONE_SHOVEL,
			 Material.STONE_PICKAXE,
			 Material.STONE_HOE,
			 Material.STONE_AXE,
			 Material.STONE_SWORD,
			 Material.CHAINMAIL_HELMET,
			 Material.CHAINMAIL_CHESTPLATE,
			 Material.CHAINMAIL_LEGGINGS,
			 Material.CHAINMAIL_BOOTS,
			
			 Material.IRON_SHOVEL,
			 Material.IRON_PICKAXE,
			 Material.IRON_HOE,
			 Material.IRON_AXE,
			 Material.IRON_SWORD,
			 Material.IRON_HELMET,
			 Material.IRON_CHESTPLATE,
			 Material.IRON_LEGGINGS,
			 Material.IRON_BOOTS,
			
			Material.GOLDEN_SHOVEL,
			Material.GOLDEN_PICKAXE,
			Material.GOLDEN_HOE,
			Material.GOLDEN_AXE,
			Material.GOLDEN_SWORD,
			Material.GOLDEN_HELMET,
			Material.GOLDEN_CHESTPLATE,
			Material.GOLDEN_LEGGINGS,
			Material.GOLDEN_BOOTS,
			
			Material.DIAMOND_SHOVEL,
			Material.DIAMOND_PICKAXE,
			Material.DIAMOND_HOE,
			Material.DIAMOND_AXE,
			Material.DIAMOND_SWORD,
			Material.DIAMOND_HELMET,
			Material.DIAMOND_CHESTPLATE,
			Material.DIAMOND_LEGGINGS,
			Material.DIAMOND_BOOTS,
			
			Material.NETHERITE_SHOVEL,
			 Material.NETHERITE_PICKAXE,
			Material.NETHERITE_HOE,
			Material.NETHERITE_AXE,
			Material.NETHERITE_SWORD,
			Material.NETHERITE_HELMET,
			 Material.NETHERITE_CHESTPLATE,
			Material.NETHERITE_LEGGINGS,
			Material.NETHERITE_BOOTS,
			
			//TOOLS
			Material.FLINT_AND_STEEL,
			Material.FISHING_ROD,
			Material.SHEARS,
			
			//WEAPONS
			Material.TURTLE_HELMET,
			Material.BOW,
			Material.SHIELD,
			Material.TRIDENT,
			Material.CROSSBOW,
			
			//EASTEREGGS
			Material.STICK,
			Material.BOOK,
			Material.BLAZE_ROD,
	};
	public Enchantment[] enchants = {
			Enchantment.ARROW_DAMAGE,
			Enchantment.ARROW_FIRE,
			Enchantment.ARROW_INFINITE,
			//Enchantment.BINDING_CURSE,
			Enchantment.CHANNELING,
			Enchantment.DAMAGE_ALL,
			Enchantment.DAMAGE_ARTHROPODS,
			Enchantment.DAMAGE_UNDEAD,
			Enchantment.DEPTH_STRIDER,
			Enchantment.DIG_SPEED,
			Enchantment.DURABILITY,
			Enchantment.FIRE_ASPECT,
			Enchantment.FROST_WALKER,
			Enchantment.IMPALING,
			Enchantment.KNOCKBACK,
			Enchantment.LOOT_BONUS_BLOCKS,
			Enchantment.LOOT_BONUS_MOBS,
			Enchantment.LOYALTY,
			Enchantment.LUCK,
			Enchantment.LURE,
			Enchantment.MENDING,
			Enchantment.MULTISHOT,
			Enchantment.OXYGEN,
			Enchantment.PIERCING,
			Enchantment.PROTECTION_ENVIRONMENTAL,
			Enchantment.PROTECTION_EXPLOSIONS,
			Enchantment.PROTECTION_FALL,
			Enchantment.PROTECTION_FIRE,
			Enchantment.PROTECTION_PROJECTILE,
			Enchantment.QUICK_CHARGE,
			Enchantment.RIPTIDE,
			Enchantment.SILK_TOUCH,
			Enchantment.SOUL_SPEED,
			Enchantment.SWEEPING_EDGE,
			Enchantment.THORNS,
			//Enchantment.VANISHING_CURSE,
			Enchantment.WATER_WORKER
	};
	
	public boolean isItemTool(ItemStack item) {
		
		System.out.println(item);
		
		ItemMeta meta = item.getItemMeta();
		Material mat = item.getType();
		
		System.out.println(meta);
	//	System.out.println(enchantment);
	//	System.out.println(enchant);
		System.out.println(item);
		
		for(int i = 0; i < tools.length; i++) {
			if(mat.equals(tools[i])) {
				return true;
			}
			for (int j = 0; j < enchants.length; j++) {
				if(item.containsEnchantment(enchants[j])) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int getRandomEnchantNumber() {
		for(;;) {
			int randomNumber = (int)(Math.random()*100);
			if(randomNumber <= enchants.length) {
				return randomNumber;
			}
		}
	}
	
	public int getRandomEnchantLevelNumber() {
		double randomNumber = Math.random();
		randomNumber = randomNumber * 10;
		if((int)randomNumber == 0) {
			randomNumber = getRandomEnchantLevelNumber();
		}
		
		return (int)randomNumber;
	}
	
	public ItemStack enchantItem(ItemStack item, World w, Location loc) {
		ItemMeta meta = item.getItemMeta();
		
		if(item.getEnchantments().size() < 1) {
			meta.addEnchant(enchants[getRandomEnchantNumber()], getRandomEnchantLevelNumber(), true);
			w.playSound(loc, Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1,1);
		}
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack removeEnchantItem(ItemStack item) {
		
		for(int i = 0 ; i<enchants.length ; i++) {
			item.removeEnchantment(enchants[i]);
		}
		
		return item;
	}
	
}
