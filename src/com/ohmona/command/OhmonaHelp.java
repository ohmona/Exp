package com.ohmona.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import com.ohmona.event.OhmonaEvent;
import com.ohmona.file.OhmonaFile;

public class OhmonaHelp  implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

		Player player = (Player) sender;
		int requiredTotalExp = player.getExpToLevel();
		double current = (double)(player.getExp() * 100f);
		double requiredExp = requiredTotalExp - ((current/100) * requiredTotalExp);
		
		OhmonaFile  ohmonaFile = new OhmonaFile();
		
		switch(args[0]) {
		case "next": {
			player.sendMessage("required points for level up : " +(((int) requiredExp) + 1));
			player.sendMessage("You reached currently " + (int)current + "%" );
			break;
		}
		case"save": {
			ohmonaFile.mapToFile(ohmonaFile.f, OhmonaEvent.map);
			player.sendMessage("saved");
			break;
		}
		case"reset": {
			player.setLevel(0);
			player.setExp(0.0f);
			player.sendMessage("your experience points are reseted");
			break;
		}
		default: {
			player.sendMessage(ChatColor.RED + "/ex {next ,save , ...}");
			break;
		}
		}
		
		return true;
	}
}
