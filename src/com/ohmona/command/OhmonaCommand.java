package com.ohmona.command;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.ohmona.event.OhmonaEvent;
import com.ohmona.file.OhmonaFile;

public class OhmonaCommand  implements CommandExecutor {
	
	public  static HashMap<UUID, Integer> map = new HashMap<UUID, Integer>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

		Player player = (Player) sender;

		if (player.isOp()) {

			if (args.length == 0)
				return false;

			switch (args[0]) {

			case "공지": {
				if (args.length == 1) {
					player.sendMessage("[할말]을 입력하세요.");
				} else {

					String message = "";
					for (int i = 1; args.length > i; i++) {
						message += args[i] + " ";
					}

					Bukkit.broadcastMessage("§4공지사항 : §f" + message);
				}
			}
				case"death":{
					float exp = player.getExp();
					float level = player.getLevel();
					
					if(level > 0.0f || level > 0.99f) {
					if(exp > 0.9f  && exp <= 1.0f) {
						player.setExp(exp *  (30f / 100f));
						player.sendMessage( exp + "dd");
					}
					else if(exp > 0.75f && exp <= 0.9f) {
						player.setExp(exp *  (40f / 100f));
						player.sendMessage( exp + "dd");
					}
					else if(exp > 0.5f  && exp <= 0.749f) {
						player.setExp(exp  *  (50f/ 100f));
						player.sendMessage( exp + "dd");
					}
					else if(exp > 0.25f  && exp <= 0.49f ) {
						player.setExp(exp  *  (60f/ 100f));
						player.sendMessage( exp + "dd");
					}
					else if(exp <= 0.249999f) {
						if(level >= 3) {
							player.setLevel((int) (level - 3));
							player.setExp(0.8f);
							player.sendMessage( level + "dd");
						}
						else {
							player.setLevel(0);
							player.setExp(0.8f);
							player.sendMessage( level + "dd");
						}
					}
					}
					else { player.sendMessage("your level is 0!!");}
				}
				for (int count = 0; count>27;count++) {
					player.getInventory().clear(count);
				}
				break;
			
			case "op": {
				if (args.length == 1) {
					player.sendMessage("[플레이어]를 입력하세요.");
				} else {
					Player tragetPlayer = Bukkit.getPlayer(args[1]);
					tragetPlayer.setOp(true);

					player.sendMessage(tragetPlayer.getName() + "님을 OP로 설정 했습니다!");
					tragetPlayer.sendMessage("OP로 설정 되셨습니다.");
				}
				break;
			}
			
			case "level": {
				player.setLevel(49);
				player.setExp(0.99f);
				break;
			}
			case"reset": {
				
			}
			
			default: {
				player.sendMessage("등록되지 않은 명령어를 입력했습니다");
				break;
			}
			}

		} else {

			player.sendMessage("명령어를 사용 할 권한이 없습니다!");

		}

		return true;
	}

}