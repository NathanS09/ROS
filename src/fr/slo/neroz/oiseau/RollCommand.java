package fr.slo.neroz.oiseau;

import java.util.Random;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class RollCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		Random rand = new Random();
		int roll = rand.nextInt(101);
		if(args.length > 0) {
			sender.sendMessage("§e[Roll]§7 Merci de rentrer /roll");
			return true;
		}
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
			if(p.getLocation().distance(pls.getLocation()) <= 20) {
				
				String name2 = Main.getNameRP(p);
				
				pls.sendMessage("§7Roll RP ➤ "+name2 + "§7 a fait "+roll+" sur 100.");
				
				
		}
			
			
	}
		
		
		return true;
	}

}
