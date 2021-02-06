package com.ohmona.event;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Reward  {
	
	OhmonaEvent ohmonaevent = new OhmonaEvent();
	
	public  void onLevelupReward(Player player) {
		int exp = player.getLevel();
		Location loc = player.getLocation();
		
		if(ohmonaevent.isMaxLevel(player)) {
			if(exp == 10) {
				Bukkit.broadcastMessage( ChatColor.RED + player.getName()  + ChatColor.WHITE + " has leveled up to " + ChatColor.YELLOW + "10");
			}
			else if(exp == 30) {
				Bukkit.broadcastMessage( ChatColor.RED + player.getName()  + ChatColor.WHITE + " has leveled up to " + ChatColor.YELLOW + "30");
			}
			else if(exp == 50) {
				player.sendTitle( ChatColor.RED + player.getName() + ChatColor.WHITE +  " has leveled up to " + ChatColor.YELLOW + "50", ChatColor.GRAY + "congratulations!!", 20 , 50 , 20);
				spawnFirework(loc, player.getWorld(), Color.WHITE);
				giveReward(1 , player);
			}
			else if(exp == 70) {
				Bukkit.broadcastMessage( ChatColor.RED + player.getName()  + ChatColor.WHITE + " has leveled up to " + ChatColor.YELLOW + "70");
			}
			else if(exp == 100) {
				player.sendTitle( ChatColor.RED + player.getName() + ChatColor.WHITE +  " has leveled up to " + ChatColor.YELLOW + "100", ChatColor.GRAY + "well done!!", 20 , 50 , 20);
				spawnFirework(loc, player.getWorld(), Color.WHITE);
				giveReward(2, player);
			}
			else if(exp == 130) {
				Bukkit.broadcastMessage( ChatColor.RED + player.getName()  + ChatColor.WHITE + " has leveled up to " + ChatColor.YELLOW + "130");
			}
			else if(exp == 160) {
				Bukkit.broadcastMessage( ChatColor.RED + player.getName()  + ChatColor.WHITE + " has leveled up to " + ChatColor.YELLOW + "160");
			}
			else if(exp == 180) {
				Bukkit.broadcastMessage( ChatColor.RED + player.getName()  + ChatColor.WHITE + " has leveled up to " + ChatColor.YELLOW + "180");
			}
			else if(exp == 200) {
				player.sendTitle( ChatColor.RED + player.getName() + ChatColor.WHITE +  " has leveled up to " + ChatColor.YELLOW + "200", ChatColor.GRAY + "amazing!!!", 20 , 50 , 20);
				spawnFirework(loc, player.getWorld(), Color.WHITE);
				giveReward(3, player);
			}
			else if(exp == 210) {
				player.sendTitle( ChatColor.RED + player.getName() + ChatColor.WHITE +  " has leveled up to " + ChatColor.YELLOW + "210", ChatColor.GRAY + "cool!", 20 , 50 , 20);
				spawnFirework(loc, player.getWorld(), Color.WHITE);
				giveReward(1, player);
			}
			else if(exp == 230) {
				Bukkit.broadcastMessage( ChatColor.RED + player.getName()  + ChatColor.WHITE + " has leveled up to " + ChatColor.YELLOW + "230");
			}
			else if(exp == 250) {
				player.sendTitle( ChatColor.RED + player.getName() + ChatColor.WHITE +  " has leveled up to " + ChatColor.YELLOW + "250", ChatColor.GRAY + "HOW", 20 , 50 , 20);
				spawnFirework(loc, player.getWorld(), Color.WHITE);
				giveReward(2, player);
			}
			else if(exp == 280) {
				Bukkit.broadcastMessage( ChatColor.RED + player.getName()  + ChatColor.WHITE + " has leveled up to " + ChatColor.YELLOW + "280");
			}
			else if(exp == 300) {
				player.sendTitle( ChatColor.RED + player.getName() + ChatColor.WHITE +  " has leveled up to " + ChatColor.YELLOW + "300", ChatColor.GRAY + "NICE!!", 20 , 50 , 20);
				spawnFirework(loc, player.getWorld(), Color.WHITE);
				giveReward(3, player);
			}
			else if(exp == 310) {
				player.sendTitle( ChatColor.RED + player.getName() + ChatColor.WHITE +  " has leveled up to " + ChatColor.YELLOW + "310", ChatColor.GRAY + "Good", 20 , 50 , 20);
				spawnFirework(loc, player.getWorld(), Color.WHITE);
				giveReward(1, player);
			}
			else if(exp == 330) {
				Bukkit.broadcastMessage( ChatColor.RED + player.getName()  + ChatColor.WHITE + " has leveled up to " + ChatColor.YELLOW + "330");
			}
			else if(exp == 350) {
				player.sendTitle( ChatColor.RED + player.getName() + ChatColor.WHITE +  " has leveled up to " + ChatColor.YELLOW + "350", ChatColor.GRAY + "Great", 20 , 50 , 20);
				spawnFirework(loc, player.getWorld(), Color.WHITE);
				giveReward(2, player);
			}
			else if(exp == 390) {
				Bukkit.broadcastMessage( ChatColor.RED + player.getName()  + ChatColor.WHITE + " has leveled up to " + ChatColor.YELLOW + "390");
			}
			else if(exp == 400) {
				player.sendTitle( ChatColor.RED + player.getName() + ChatColor.WHITE +  " has leveled up to " + ChatColor.YELLOW + "400", ChatColor.GRAY + "wonderful!!", 20 , 50 , 20);
				spawnFirework(loc, player.getWorld(), Color.WHITE);
				giveReward(3, player);
			}
		}
	}
	
public void giveReward(int size, Player player) {
		
		switch(size) {
		//small reward
		case 1: {
			   player.addPotionEffect((new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 1)));
			   player.addPotionEffect((new PotionEffect(PotionEffectType.REGENERATION, 100, 1)));
			   player.addPotionEffect((new PotionEffect(PotionEffectType.FIRE_RESISTANCE , 100, 1)));	   
			break;
		}
		//big reward
		case 2: {
			player.addPotionEffect((new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 4)));
			player.addPotionEffect((new PotionEffect(PotionEffectType.REGENERATION , 100, 4)));
			player.addPotionEffect((new PotionEffect(PotionEffectType.FIRE_RESISTANCE , 400, 4)));
			player.addPotionEffect((new PotionEffect(PotionEffectType.INCREASE_DAMAGE , 600, 4)));
			break;
		}
		//best reward
		case 3: {
			player.addPotionEffect((new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 6000, 100)));
			player.addPotionEffect((new PotionEffect(PotionEffectType.REGENERATION , 6000, 100)));
			player.addPotionEffect((new PotionEffect(PotionEffectType.FIRE_RESISTANCE , 6000, 1)));
			player.addPotionEffect((new PotionEffect(PotionEffectType.INCREASE_DAMAGE , 6000, 100)));
			break;
		}
		}
	}

	public void spawnFirework(Location location, World world, Color color) {
	    Firework firework = world.spawn(location, Firework.class);
	    FireworkMeta fireworkMeta = firework.getFireworkMeta();
	    FireworkEffect effect = FireworkEffect.builder().withColor(Color.WHITE, Color.YELLOW, Color.RED).withFade(Color.RED).with(FireworkEffect.Type.BALL_LARGE).trail(false).flicker(true).build();
	    fireworkMeta.addEffect(effect);
	    fireworkMeta.setPower(1);
	    firework.setFireworkMeta(fireworkMeta);
	}
}
