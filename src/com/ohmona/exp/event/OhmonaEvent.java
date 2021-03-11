package com.ohmona.exp.event;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameRule;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.ohmona.exp.file.OhmonaFile;
import com.ohmona.exp.Main;

public class OhmonaEvent extends OhmonaFile implements Listener {

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
            if (playerLevel > playerSavedLevelInstance) { //비교
                map.put(uuid, playerLevel);
                //p.sendMessage("new level " + playerLevel + " saved : " + uuid);
                playerSavedLevelInstance = playerLevel;
            }
            else {
                if(p.isOp()) {
                    //p.sendMessage("your level is less then your Max");
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
                    //player.sendMessage( exp + "dd");
                }
            }
            else if(exp > 0.75f && exp <= 0.9f) {
                player.setExp(exp *  (33f / 100f));
                if(player.isOp()) {
                    //player.sendMessage( exp + "dd");
                }
            }
            else if(exp > 0.5f  && exp <= 0.749f) {
                player.setExp(exp  *  (35f/ 100f));
                if(player.isOp()) {
                    //player.sendMessage( exp + "dd");
                }
            }
            else if(exp > 0.25f  && exp <= 0.49f ) {
                player.setExp(exp  *  (40f/ 100f));
                if(player.isOp()) {
                    //player.sendMessage( exp + "dd");
                }
            }
            else if(exp <= 0.249999f) {
                if(level >= 3) {
                    player.setLevel((int) (level - 3));
                    player.setExp(0.8f);
                    if(player.isOp()) {
                        //player.sendMessage( exp + "dd");
                    }
                }
                else {
                    player.setLevel(0);
                    player.setExp(0.8f);
                    if(player.isOp()) {
                        //player.sendMessage( exp + "dd");
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
}


















