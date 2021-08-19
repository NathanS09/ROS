package fr.slo.neroz.oiseau;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§e[Report] §7Utilisable seulement aux joueurs ");
			return true;
		}
		
		if(args.length == 0) {
			sender.sendMessage("§e[Report] §7/report <message> ");
			return true;
		}
		
		StringBuilder sb = new StringBuilder();
		for(String arg : args) {
			sb.append(arg+" ");
			
		}
		Player p = (Player) sender;
		String message = sb.toString();
		
		sender.sendMessage("§e[Report] §7Message bien envoyé !");
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
			 if(!(pls.hasPermission("staff.report"))) {
				return true;
			 } else {
				 pls.sendMessage("§e[Report] §fde "+ sender.getName() +" §a("+p.getDisplayName()+") : §7" +message);
			 }
		 }
		
		
		return true;
	}

}
