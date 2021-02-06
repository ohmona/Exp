package com.ohmona.event.enchant;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Tools {
	
	public ItemStack[] tools = {
			new ItemStack(Material.WOODEN_SHOVEL),
			new ItemStack(Material.WOODEN_PICKAXE),
			new ItemStack(Material.WOODEN_HOE),
			new ItemStack(Material.WOODEN_AXE),
			new ItemStack(Material.WOODEN_SWORD),
			new ItemStack(Material.LEATHER_HELMET),
			new ItemStack(Material.LEATHER_CHESTPLATE),
			new ItemStack(Material.LEATHER_LEGGINGS),
			new ItemStack(Material.LEATHER_BOOTS),
			
			new ItemStack(Material.STONE_SHOVEL),
			new ItemStack(Material.STONE_PICKAXE),
			new ItemStack(Material.STONE_HOE),
			new ItemStack(Material.STONE_AXE),
			new ItemStack(Material.STONE_SWORD),
			new ItemStack(Material.CHAINMAIL_HELMET),
			new ItemStack(Material.CHAINMAIL_CHESTPLATE),
			new ItemStack(Material.CHAINMAIL_LEGGINGS),
			new ItemStack(Material.CHAINMAIL_BOOTS),
			
			new ItemStack(Material.IRON_SHOVEL),
			new ItemStack(Material.IRON_PICKAXE),
			new ItemStack(Material.IRON_HOE),
			new ItemStack(Material.IRON_AXE),
			new ItemStack(Material.IRON_SWORD),
			new ItemStack(Material.IRON_HELMET),
			new ItemStack(Material.IRON_CHESTPLATE),
			new ItemStack(Material.IRON_LEGGINGS),
			new ItemStack(Material.IRON_BOOTS),
			
			new ItemStack(Material.GOLDEN_SHOVEL),
			new ItemStack(Material.GOLDEN_PICKAXE),
			new ItemStack(Material.GOLDEN_HOE),
			new ItemStack(Material.GOLDEN_AXE),
			new ItemStack(Material.GOLDEN_SWORD),
			new ItemStack(Material.GOLDEN_HELMET),
			new ItemStack(Material.GOLDEN_CHESTPLATE),
			new ItemStack(Material.GOLDEN_LEGGINGS),
			new ItemStack(Material.GOLDEN_BOOTS),
			
			new ItemStack(Material.DIAMOND_SHOVEL),
			new ItemStack(Material.DIAMOND_PICKAXE),
			new ItemStack(Material.DIAMOND_HOE),
			new ItemStack(Material.DIAMOND_AXE),
			new ItemStack(Material.DIAMOND_SWORD),
			new ItemStack(Material.DIAMOND_HELMET),
			new ItemStack(Material.DIAMOND_CHESTPLATE),
			new ItemStack(Material.DIAMOND_LEGGINGS),
			new ItemStack(Material.DIAMOND_BOOTS),
			
			new ItemStack(Material.NETHERITE_SHOVEL),
			new ItemStack(Material.NETHERITE_PICKAXE),
			new ItemStack(Material.NETHERITE_HOE),
			new ItemStack(Material.NETHERITE_AXE),
			new ItemStack(Material.NETHERITE_SWORD),
			new ItemStack(Material.NETHERITE_HELMET),
			new ItemStack(Material.NETHERITE_CHESTPLATE),
			new ItemStack(Material.NETHERITE_LEGGINGS),
			new ItemStack(Material.NETHERITE_BOOTS),
			
			//TOOLS
			new ItemStack(Material.FLINT_AND_STEEL),
			new ItemStack(Material.FISHING_ROD),
			new ItemStack(Material.SHEARS),
			
			//WEAPONS
			new ItemStack(Material.TURTLE_HELMET),
			new ItemStack(Material.BOW),
			new ItemStack(Material.SHIELD),
			new ItemStack(Material.TRIDENT),
			new ItemStack(Material.CROSSBOW),
			
			//EASTEREGGS
			new ItemStack(Material.STICK),
			new ItemStack(Material.BOOK),
			new ItemStack(Material.BLAZE_ROD),
	};
	public Enchantment[] enchants = {
			Enchantment.ARROW_DAMAGE,
			Enchantment.ARROW_FIRE,
			Enchantment.ARROW_INFINITE,
			Enchantment.ARROW_KNOCKBACK,
			Enchantment.BINDING_CURSE,
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
			Enchantment.VANISHING_CURSE,
			Enchantment.WATER_WORKER
	};
	
	public boolean isItemTool(ItemStack item) {
		
		System.out.println(item);
		
		Enchantment ent = (Enchantment) item.getEnchantments();
		item.removeEnchantment(ent);
		
		System.out.println(item);
		
		for(int i = 0; i < tools.length; i++) {
			if(item.equals(tools[i])) {
				return true;
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
		
		return (int)randomNumber;
	}
	
	public ItemStack enchantItem(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		
		meta.addEnchant(enchants[getRandomEnchantNumber()], getRandomEnchantLevelNumber(), true);
		item.setItemMeta(meta);
		return item;
	}
	
	public ItemStack removeEnchantItem(ItemStack item) {
		Enchantment ent = (Enchantment) item.getEnchantments();
		item.removeEnchantment(ent);
		return item;
	}
	
}
