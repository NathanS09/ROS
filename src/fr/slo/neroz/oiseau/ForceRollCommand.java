package fr.slo.neroz.oiseau;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ForceRollCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		Random rand = new Random();
		int roll = rand.nextInt(101);
		
		if(args.length != 1) {
			sender.sendMessage("§e[ForceRoll] §7Merci de faire /forceroll <Nom>");
			sender.sendMessage("§e[ForceRoll] §7Exemple : /forceroll LePnj");
			sender.sendMessage("§e[ForceRoll] §7Résultat dans les 20 blocs autour : ");
			sender.sendMessage("§e§7Roll RP ➤ LePnj a fait "+roll+" sur 100.");
			return true;
		}
		
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
			
			if(p.getLocation().distance(pls.getLocation()) <= 20) {
				
				pls.sendMessage("§e§7Roll RP ➤ "+args[0] + " a fait "+roll+" sur 100.");
				
			}
			
			
		}
		
		
		
		return true;
	}

}
