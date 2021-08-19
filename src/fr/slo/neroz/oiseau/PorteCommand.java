package fr.slo.neroz.oiseau;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PorteCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length == 0) {
			sender.sendMessage("[Porte] /porte <village> <message> "
					+ "Exemple : /porte Konoha Bonsoir, je m'appelle XXX je viens pour la cargaison." 
					+ "Cela donnera : Une ou des personnes sont devant la porte de Konoha voici le message que les gardes transmettent : \" Bonsoir, je m'appelle XXX je viens pour la cargaison. \"");
			return true;
		}
		
		StringBuilder sb = new StringBuilder();
		for(String arg : args) {
			sb.append(arg+" ");
			
		}
		Player p = (Player) sender;
		sb.toString().replace('&', '§');
		String message = sb.toString().replace(args[0], "");
		
		Bukkit.broadcastMessage("§7Une ou des personnes sont devant la porte de " + args[0] + "voici le message que les gardes transmettent : \"" + message + "\"");
		
		return true;
	}

}
