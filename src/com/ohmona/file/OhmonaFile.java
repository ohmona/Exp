 package com.ohmona.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.ohmona.main.Main;

public class OhmonaFile {

	public static Main plugin;
	
	public  final File f  = new File(plugin.getDataFolder(), "data.txt");
	
	public static void setPlugin(Main MainPlugin) {
		plugin = MainPlugin;

	}
	
	public void makeFile(File f) {
		if (!f.exists() || !f.isFile()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void mapToFile(File f, HashMap<UUID, Integer> map) {
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable() {

			@Override
			public void run() {
				try {
					plugin.consol.sendMessage(ChatColor.GREEN + "�����͸� ���� �߽��ϴ�");
					FileWriter writer = new FileWriter(f, false); // Map to File
					for (UUID uuid : map.keySet()) {
						writer.write(uuid.toString() + "|" + map.get(uuid) + "\n");
					}
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, 20 * 30, 20 * 30);

	}
	
	public void mapToFileOnDisable(File f, HashMap<UUID, Integer> map) {
		try {
			FileWriter writer = new FileWriter(f, false);
			for(UUID uuid : map.keySet()){
				writer.write(uuid.toString()+"|"+map.get(uuid)+"\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fileToMap(File f, HashMap<UUID, Integer> map) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f)); // File to Map
			String fileLine = null;
			while ((fileLine = reader.readLine()) != null) {

				UUID uuid = UUID.fromString(fileLine.split("\\|")[0]);
				String str = fileLine.split("\\|")[1];

				map.put(uuid, Integer.parseInt(str));
			}
		} catch (FileNotFoundException e3) {
			e3.printStackTrace();
		} catch (IOException e4) {
			e4.printStackTrace();
		}
	}
	
	
}
