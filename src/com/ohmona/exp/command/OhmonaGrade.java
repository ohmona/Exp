package com.ohmona.exp.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class OhmonaGrade implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (p.isOp()) {
                if (p.getItemInHand() != null) {
                    ItemStack item = p.getItemInHand();
                    ItemMeta meta = item.getItemMeta();
                    List<String> grade = item.getItemMeta().getLore();
                    if (!item.getItemMeta().hasLore()) {
                        ArrayList<String> gradename = new ArrayList<String>();
                        gradename.add("II");
                        meta.setLore(gradename);
                        item.setItemMeta(meta);
                        return true;
                    } else if (grade.get(0).equals("II")) {
                        ArrayList<String> gradename = new ArrayList<String>();
                        gradename.add("III");
                        meta.setLore(gradename);
                        item.setItemMeta(meta);
                        return true;
                    } else if (grade.get(0).equals("III")) {
                        ArrayList<String> gradename = new ArrayList<String>();
                        gradename.add("IV");
                        meta.setLore(gradename);
                        item.setItemMeta(meta);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
