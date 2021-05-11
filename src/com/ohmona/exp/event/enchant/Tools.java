package com.ohmona.exp.event.enchant;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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

    public int getRandomEnchantLevelNumber(int lv) {
        double randomNumber = Math.random();

        randomNumber = randomNumber * 100;
        int intRan = (int) randomNumber;

        if(intRan > 0 && intRan <= 18) {
            return 1;
        }
        else if(intRan >= 19 && intRan <= 36) {
            return 2;
        }
        else if(intRan >= 37 && intRan <= 52) {
            return 3;
        }
        else if(intRan >= 53 && intRan <= 65) {
            return 4;
        }
        else if(intRan >= 66 && intRan <= 76) {
            return 5;
        }
        else if(intRan >= 77 && intRan <= 84) {
            return 6;
        }
        else if(intRan >= 85 && intRan <= 90) {
            return 7;
        }
        else if(intRan >= 91 && intRan <= 95) {
            return 8;
        }
        else if(intRan >= 96 && intRan <= 98) {
            return 9;
        }
        else if(intRan == 99) {
            return 10;
        }
        else {
            return 1;
        }
    }

    public int getRandomGradeUpNumber() {
        double random = Math.random();
        random *= 10000;
        random = (int) random;
        if(random > 10000) {
            while(random > 10000) {
                random = getRandomGradeUpNumber();
            }
        }
        return (int)random;
    }

    public ItemStack enchantItem(ItemStack item, World w,Player p, Location loc, int lv) {
        ItemMeta meta = item.getItemMeta();
        int grade = getItemGradeAsInt(item);

        if(grade == 1) {
            if(item.getEnchantments().size() < 1) {
                int randomGrade = getRandomGradeUpNumber();

                meta.addEnchant(enchants[getRandomEnchantNumber()], getRandomEnchantLevelNumber(lv), true);
                w.playSound(loc, Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1, 1);

                // grade system
                if(randomGrade <= 100) {
                    ArrayList<String> gradename = new ArrayList<String>();
                    gradename.add("II");
                    meta.setLore(gradename);

                    p.stopSound(Sound.BLOCK_ENCHANTMENT_TABLE_USE);
                    p.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Grade UP !");
                }

                // 레벨제거
                p.setLevel(lv - removeLevel(p));
            }
        }
        else if(grade == 2) {
            if(item.getEnchantments().size() < 1) {
                int randomGrade = getRandomGradeUpNumber();
                // grade system
                if(randomGrade <= 10) {
                    ArrayList<String> gradename = new ArrayList<String>();
                    gradename.add("III");
                    meta.setLore(gradename);

                    p.stopSound(Sound.BLOCK_ENCHANTMENT_TABLE_USE);
                    p.playSound(loc, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    p.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Grade UP !");
                    spawnFirework(loc, p.getWorld(), Color.WHITE);
                }

                meta.addEnchant(enchants[getRandomEnchantNumber()], getRandomEnchantLevelNumber(lv), true);
                meta.addEnchant(enchants[getRandomEnchantNumber()], getRandomEnchantLevelNumber(lv), true);
                w.playSound(loc, Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1, 1);

                // 레벨제거
                p.setLevel(lv - removeLevel(p));
            }
        }
        else if(grade == 3) {
            if(item.getEnchantments().size() < 1) {
                int randomGrade = getRandomGradeUpNumber();
                // grade system
                if(randomGrade <= 1) {
                    ArrayList<String> gradename = new ArrayList<String>();
                    gradename.add("IV");
                    meta.setLore(gradename);

                    p.stopSound(Sound.BLOCK_ENCHANTMENT_TABLE_USE);
                    p.playSound(loc, Sound.UI_TOAST_CHALLENGE_COMPLETE, 1, 1);
                    p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Grade UP !");
                    spawnFirework(loc, p.getWorld(), Color.WHITE);
                    for(Player eachPlayer : Bukkit.getOnlinePlayers()) {
                        eachPlayer.sendTitle(ChatColor.GOLD + "This player is legendary",ChatColor.GRAY + p.getName()+ "", 20, 50, 20);
                    }
                }
                for (int i = 1; i <= 3; i++) {
                    meta.addEnchant(enchants[getRandomEnchantNumber()], getRandomEnchantLevelNumber(lv), true);
                    w.playSound(loc, Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1, 1);
                }

                // 레벨제거
                p.setLevel(lv - removeLevel(p));
            }
        }
        else if(grade == 4) {
            if(item.getEnchantments().size() < 1) {
                for (int i = 1; i <= 4; i++) {
                    meta.addEnchant(enchants[getRandomEnchantNumber()], getRandomEnchantLevelNumber(lv), true);
                    w.playSound(loc, Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1, 1);
                }

                // 레벨제거
                p.setLevel(lv - removeLevel(p));
            }
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

    public int removeLevel(Player p) {
        int lv = p.getLevel();
        lv /= 100;
        if(lv == 0) {
            return 1;
        }
        if(lv == 1) {
            return 2;
        }
        if(lv == 2) {
            return 3;
        }
        if(lv == 3) {
            return 4;
        }
        if(lv == 4) {
            return 5;
        }
        if(lv == 5) {
            return 6;
        }
        return 1;
    }

    public int getItemGradeAsInt(ItemStack item) {
        String name = item.getItemMeta().getDisplayName();
        List<String> grade = item.getItemMeta().getLore();

        if(grade.get(0).equals("II")) {
            return 2;
        }
        else if(grade.get(0).equals("III")) {
            return 3;
        }
        else if(grade.get(0).equals("IV")) {
            return 4;
        }
        else {
            return 1;
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
