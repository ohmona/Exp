package com.ohmona.main;

import org.bukkit.Bukkit;

import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.ohmona.command.OhmonaCommand;
import com.ohmona.command.OhmonaHelp;
import com.ohmona.event.OhmonaEvent;
import com.ohmona.event.enchant.EnchantInventory;
import com.ohmona.file.OhmonaFile;

public class Main extends JavaPlugin {

	public ConsoleCommandSender consol = Bukkit.getConsoleSender();
	
	@Override
	public void onEnable() {
		consol.sendMessage(ChatColor.AQUA + "[플러그인 활성화 중 입니다.]");
		
		OhmonaEvent.setPlugin(this);
		OhmonaFile.setPlugin(this);
		EnchantInventory.setPlugin(this);
		
		OhmonaEvent  ohmonaEvent = new OhmonaEvent();
		OhmonaFile  ohmonaFile = new OhmonaFile();
		EnchantInventory enchantInventory = new EnchantInventory();
		
		getCommand("he").setExecutor(new OhmonaCommand());
		getCommand("ex").setExecutor(new OhmonaHelp());
		
		getServer().getPluginManager().registerEvents(ohmonaEvent, this);
		getServer().getPluginManager().registerEvents(enchantInventory, this);
		ohmonaFile.makeFile(ohmonaFile.f);
		ohmonaFile.mapToFile(ohmonaFile.f, OhmonaEvent.map);
		ohmonaFile.fileToMap(ohmonaFile.f, OhmonaEvent.map);
	}

	@Override
	public void onDisable() {
		
		consol.sendMessage(ChatColor.AQUA + "[플러그인 비활성화 중 입니다.]");
	}

}