package fr.slo.neroz.oiseau;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.slo.neroz.oiseau.events.PlayerChat;

public class Main extends JavaPlugin {

	public static Main instance;
	File file = new File(getDataFolder(), "config.yml");
	FileConfiguration config = YamlConfiguration.loadConfiguration(file);
	
	@Override
	public void onEnable() {
		if(!file.exists()) {
			saveDefaultConfig();
		}
		try {
			getConfig().save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		instance = this;
		Bukkit.getConsoleSender().sendMessage("§c[RiseOfShinobi] Plugin actif");
		Bukkit.getConsoleSender().sendMessage("§c[RiseOfShinobi] Plugin developpe par moi");
		 this.getCommand("oiseau").setExecutor(new OiseauCommand());
		 this.getCommand("roll").setExecutor(new RollCommand());
		 this.getCommand("forceroll").setExecutor(new ForceRollCommand());
		 this.getCommand("report").setExecutor(new ReportCommand());
		 this.getCommand("rumeur").setExecutor(new RumeurCommand());
		 this.getCommand("annonce").setExecutor(new AnnonceCommand());
		 this.getCommand("me").setExecutor(new MeCommand());
		 //this.getCommand("porte").setExecutor(new PorteCommand());
		 PluginManager pm = Bukkit.getPluginManager();
		 pm.registerEvents(new PlayerChat(), this);
		 
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§c[RiseOfShinobi] Le plugin est inactif");
	}
	
	public static String getNameRP(Player p) {
		String name2 = p.getDisplayName();
		name2 = name2.replace("§f", "");
		name2 = name2.replace("§8", "");
		name2 = name2.replace("§2", "");
		name2 = name2.replace("§a", "");
		name2 = name2.replace("§6", "");
		name2 = name2.replace("§b", "");
		name2 = name2.replace("§c", "");
		name2 = name2.replace("§1", "");
		name2 = name2.replace("§4", "");
		name2 = name2.replace("§d", "");
		name2 = name2.replace("§5", "");
		name2 = name2.replace("§9", "");
		name2 = name2.replace("§7", "");
		name2 = name2.replace("§3", "");
		name2 = name2.replace("§e", "");
		name2 = name2.replace("[", "");
		name2 = name2.replace("]", "");
		name2 = name2.replace("Modérateur ", "");
		name2 = name2.replace("Builder ", "");
		name2 = name2.replace("Responsable ", "");
		name2 = name2.replace("Community Manager ", "");
		name2 = name2.replace("Fondateur ", "");
		name2 = name2.replace("Animateur ", "");
		name2 = name2.replace("Développeur ", "");
		name2 = name2.replace("Suna ", "");
		name2 = name2.replace("Iwa ", "");
		name2 = name2.replace("Konoha ", "");
		name2 = name2.replace("Kiri ", "");
		name2 = name2.replace("Kumo ", "");
		name2 = name2.replace("Kazekage ", "");
		name2 = name2.replace("Hokage ", "");
		name2 = name2.replace("Raikage ", "");
		name2 = name2.replace("Mizukage ", "");
		name2 = name2.replace("Tsuchikage ", "");
		name2 = name2.replace("Oto ", "");
		name2 = name2.replace("Ame ", "");
		name2 = name2.replace("Maitre de jeu ", "");
		name2 = name2.replace("Maître du jeu ", "");
		name2 = name2.replace("Ishi ", "");
		name2 = name2.replace("ishi ", "");
		name2 = name2.replace("Nukenin ", "");
		name2 = name2.replace("Administrateur ", "");
		name2 = name2.replace("Intégrateur ", "");
		name2 = name2.replace("Integrateur ", "");
		name2 = name2.replace("Uzushio ", "");
		name2 = name2.replace(" ", "");
		
		return name2;
	}
	
}
//playerOne.getLocation().distanceSquared(playerTwo.getLocation())

