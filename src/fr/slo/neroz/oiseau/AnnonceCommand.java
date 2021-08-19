package fr.slo.neroz.oiseau;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AnnonceCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(!(sender instanceof Player)) {
			sender.sendMessage("[Annonce] Utilisable seulement aux joueurs ");
			return true;
		}
		
		if(args.length == 0) {
			sender.sendMessage("[Annonce] /annonce <message> ");
			return true;
		}
		
		StringBuilder sb = new StringBuilder();
		for(String arg : args) {
			sb.append(arg+" ");
			
		}
		Player p = (Player) sender;
		String message = sb.toString().replace('&', '§');
		
		Bukkit.broadcastMessage("       §6-=--== §lRise Of Shinobi §r§6==--=-");
		Bukkit.broadcastMessage(" ");
		Bukkit.broadcastMessage(message+"");
		
		return true;
	}

}
