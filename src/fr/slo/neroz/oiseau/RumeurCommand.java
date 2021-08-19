package fr.slo.neroz.oiseau;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RumeurCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(!(sender instanceof Player)) {
			sender.sendMessage("§e[Rumeur]§7 Utilisable seulement aux joueurs ");
			return true;
		}
		
		if(args.length == 0) {
			sender.sendMessage("§e[Rumeur]§7 /rumeur <message> ");
			return true;
		}
		
		StringBuilder sb = new StringBuilder();
		for(String arg : args) {
			sb.append(arg+" ");
			
		}
		Player p = (Player) sender;
		String message = sb.toString();
		
		Bukkit.broadcastMessage("§7§oUne rumeur se répand dans le monde shinobi...");
		Bukkit.broadcastMessage("§7" + message);
		return true;
	}

}
