package fr.slo.neroz.oiseau;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(!(sender instanceof Player)){
			sender.sendMessage("[Rise Of Shinobi] Cette commande n'est utilisable qu'en jeu, merci.");
			return true;
		}
		if(args.length == 0) {
			sender.sendMessage("§e[Me] §7Merci de rentrer une action");
			return true;
		}
		
		StringBuilder sb = new StringBuilder();
		for(String arg : args) {
			sb.append(arg+" ");
			
		}
		Player p = (Player) sender;
		String message = sb.toString();
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
				if(p.getLocation().distance(pls.getLocation()) <= 20) {
					
					String name2 = Main.getNameRP(p);
					
					//[Modérateur]
					// do it with other colors
					name2 = ChatColor.stripColor(name2);
					pls.sendMessage("§5"+name2+ " §5" + message);
			}
				
				
		}
		
		
			
	
			 
			
					
		
		
		return true;
	}

	}
