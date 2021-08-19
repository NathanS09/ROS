package fr.slo.neroz.oiseau;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;


public class OiseauCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		int metreparseconde = Main.instance.getConfig().getInt("metreparseconde");
		
		if(!(sender instanceof Player)){
			sender.sendMessage("§e[Oiseau]§7 Cette commande n'est utilisable qu'en jeu, merci.");
			return true;
		}
		
		Player p = (Player) sender;
		ItemStack bookit = new ItemStack(Material.BOOK_AND_QUILL, 1);
		
		ItemStack bookwriteit = new ItemStack(Material.WRITTEN_BOOK, 1);
		
		
		
		if(args.length > 2 || args.length == 0) {
			p.sendMessage("§e[Oiseau]§7 Merci d'utiliser /oiseau <suna|konoha|kiri|iwa|kumo> ou /oiseau nom <nom rp>");
			return true;
		}
		
		
			if(p.getItemInHand().getType() == bookit.getType() || p.getItemInHand().getType() == bookwriteit.getType()) {
				ItemStack itsend = p.getItemInHand();
				
				
				
				if(args[0].equalsIgnoreCase("suna")){
					Location locsuna = new Location(p.getWorld(), Main.instance.getConfig().getDouble("locations.suna_oiseau.x"), Main.instance.getConfig().getInt("locations.suna_oiseau.y"), Main.instance.getConfig().getDouble("locations.suna_oiseau.z"));
					if(locsuna.getBlock().getType() == Material.CHEST) {
						
						
						
						p.sendMessage("§e[Oiseau] §7L'oiseau s'envole...");
						Chest chest = (Chest) locsuna.getBlock().getState();
						Inventory invsuna = chest.getInventory();
						Location loc_secours = new Location(p.getWorld(), Main.instance.getConfig().getDouble("locations.coffre_secours_oiseau.x"), Main.instance.getConfig().getInt("locations.coffre_secours_oiseau.y"), Main.instance.getConfig().getDouble("locations.coffre_secours_oiseau.z"));
						Chest chest_secours = (Chest) loc_secours.getBlock().getState();
						Inventory inv_secours = chest_secours.getInventory();
						inv_secours.addItem(itsend);
						double distance = p.getLocation().distance(locsuna);
						
						
						new BukkitRunnable() {
							public double timer = distance/metreparseconde;
							@Override
							public void run() {
								
								

								timer = timer -1;
								if(timer <1) {
									invsuna.addItem(itsend);
									inv_secours.remove(itsend);
									Bukkit.broadcastMessage("§o§7Un message vient d'arriver à Suna");
									cancel();
								}
								
								
							}
						}.runTaskTimerAsynchronously(Main.instance, 20, 20);
						p.getInventory().remove(itsend);
						
						
						
						
						return true;
					} else {
						p.sendMessage("[Oiseau] Il n'y a pas de coffres");
						return true;
					}
				} else if(args[0].equalsIgnoreCase("konoha")){
				//-1254, 85, -1344
					Location lockonoha = new Location(p.getWorld(), Main.instance.getConfig().getDouble("locations.konoha_oiseau.x"), Main.instance.getConfig().getInt("locations.konoha_oiseau.y"), Main.instance.getConfig().getDouble("locations.konoha_oiseau.z"));
					if(lockonoha.getBlock().getType() == Material.CHEST) {
						
						
						
						
						p.sendMessage("§e[Oiseau] §7L'oiseau s'envole...");
						Chest chest = (Chest) lockonoha.getBlock().getState();
						Inventory invkonoha = chest.getInventory();
						Location loc_secours = new Location(p.getWorld(), Main.instance.getConfig().getDouble("locations.coffre_secours_oiseau.x"), Main.instance.getConfig().getInt("locations.coffre_secours_oiseau.y"), Main.instance.getConfig().getDouble("locations.coffre_secours_oiseau.z"));
						Chest chest_secours = (Chest) loc_secours.getBlock().getState();
						Inventory inv_secours = chest_secours.getInventory();
						inv_secours.addItem(itsend);
						double distance = p.getLocation().distance(lockonoha);
						p.getInventory().remove(itsend);
						
						new BukkitRunnable() {
							public double timer = distance/metreparseconde;
							@Override
							public void run() {
								
								

								timer = timer -1;
								if(timer <1) {
									invkonoha.addItem(itsend);
									inv_secours.remove(itsend);
									Bukkit.broadcastMessage("§o§7Un message vient d'arriver à Konoha");
									cancel();
								}
								
								
							}
						}.runTaskTimerAsynchronously(Main.instance, 20, 20);
						
						return true;
					} else {
						p.sendMessage("[Oiseau] Il n'y a pas de coffres");
						return true;
					}
				
				  } else if(args[0].equalsIgnoreCase("iwa")){
					//-4910, 120, -4019
					  
					  Location lociwa = new Location(p.getWorld(), Main.instance.getConfig().getDouble("locations.iwa_oiseau.x"), Main.instance.getConfig().getInt("locations.iwa_oiseau.y"), Main.instance.getConfig().getDouble("locations.iwa_oiseau.z"));
						if(lociwa.getBlock().getType() == Material.CHEST) {
							
							
							
							
							p.sendMessage("§e[Oiseau] §7L'oiseau s'envole...");
							Chest chest = (Chest) lociwa.getBlock().getState();
							Inventory inviwa = chest.getInventory();
							Location loc_secours = new Location(p.getWorld(), Main.instance.getConfig().getDouble("locations.coffre_secours_oiseau.x"), Main.instance.getConfig().getInt("locations.coffre_secours_oiseau.y"), Main.instance.getConfig().getDouble("locations.coffre_secours_oiseau.z"));
							Chest chest_secours = (Chest) loc_secours.getBlock().getState();
							Inventory inv_secours = chest_secours.getInventory();
							inv_secours.addItem(itsend);
							p.getInventory().remove(itsend);
							double distance = p.getLocation().distance(lociwa);
							
							
							new BukkitRunnable() {
								public double timer = distance/metreparseconde;
								@Override
								public void run() {
									
									

									timer = timer -1;
									if(timer <1) {
										inviwa.addItem(itsend);
										inv_secours.remove(itsend);
										Bukkit.broadcastMessage("§o§7Un message vient d'arriver à iwa");
										cancel();
									}
									
									
								}
							}.runTaskTimerAsynchronously(Main.instance, 20, 20);
							
							return true;
						} else {
							p.sendMessage("§e[Oiseau] §7Il n'y a pas de coffres");
							return true;
						}
					  
				} else if(args[0].equalsIgnoreCase("kiri")){
				 //4019, 94, 736
					
					Location lockiri = new Location(p.getWorld(), Main.instance.getConfig().getDouble("locations.kiri_oiseau.x"), Main.instance.getConfig().getInt("locations.kiri_oiseau.y"), Main.instance.getConfig().getDouble("locations.kiri_oiseau.z"));
					if(lockiri.getBlock().getType() == Material.CHEST) {
						
						
						
						
						p.sendMessage("§e[Oiseau]§7 L'oiseau s'envole...");
						Chest chest = (Chest) lockiri.getBlock().getState();
						Inventory invkiri = chest.getInventory();
						Location loc_secours = new Location(p.getWorld(), Main.instance.getConfig().getDouble("locations.coffre_secours_oiseau.x"), Main.instance.getConfig().getInt("locations.coffre_secours_oiseau.y"), Main.instance.getConfig().getDouble("locations.coffre_secours_oiseau.z"));
						Chest chest_secours = (Chest) loc_secours.getBlock().getState();
						Inventory inv_secours = chest_secours.getInventory();
						inv_secours.addItem(itsend);
						p.getInventory().remove(itsend);
						double distance = p.getLocation().distance(lockiri);
						
						
						new BukkitRunnable() {
							public double timer = distance/metreparseconde;
							@Override
							public void run() {
								
								

								timer = timer -1;
								if(timer <1) {
									invkiri.addItem(itsend);
									inv_secours.remove(itsend);
									Bukkit.broadcastMessage("§o§7Un message vient d'arriver à kiri");
									cancel();
								}
								
								
							}
						}.runTaskTimerAsynchronously(Main.instance, 20, 20);
						
						return true;
					} else {
						p.sendMessage("§e[Oiseau]§7 Il n'y a pas de coffres");
						return true;
					}
					
				} else if(args[0].equalsIgnoreCase("kumo")){
					 //1804, 129, -5174
					
						Location lockumo = new Location(p.getWorld(), Main.instance.getConfig().getDouble("locations.kumo_oiseau.x"), Main.instance.getConfig().getInt("locations.kumo_oiseau.y"), Main.instance.getConfig().getDouble("locations.kumo_oiseau.z"));
						if(lockumo.getBlock().getType() == Material.CHEST) {
							

							
							p.getInventory().remove(itsend);
							p.sendMessage("§e[Oiseau]§7 L'oiseau s'envole...");
							Chest chest = (Chest) lockumo.getBlock().getState();
							Inventory invkumo = chest.getInventory();
							
							Location loc_secours = new Location(p.getWorld(), Main.instance.getConfig().getDouble("locations.coffre_secours_oiseau.x"), Main.instance.getConfig().getInt("locations.coffre_secours_oiseau.y"), Main.instance.getConfig().getDouble("locations.coffre_secours_oiseau.z"));
							Chest chest_secours = (Chest) loc_secours.getBlock().getState();
							Inventory inv_secours = chest_secours.getInventory();
							inv_secours.addItem(itsend);
							double distance = p.getLocation().distance(lockumo);
							
							
							new BukkitRunnable() {
								public double timer = distance/metreparseconde;
								@Override
								public void run() {
									
									

									timer = timer -1;
									if(timer <1) {
										invkumo.addItem(itsend);
										inv_secours.remove(itsend);
										cancel();
									}
									
									
								}
							}.runTaskTimerAsynchronously(Main.instance, 20, 20);
							
							
							Bukkit.broadcastMessage("§o§7Un message vient d'arriver à kumo");
							
							return true;
						} else {
							p.sendMessage("§e[Oiseau]§7 Il n'y a pas de coffres");
							return true;
						}
						
					} else {
					
					if(args.length == 1 ) {
						sender.sendMessage("§e[Oiseau]§7 Merci d'entrer un nom (/oiseau nom Hayato)");
						return true;
					}
					
					for(Player pls : Bukkit.getOnlinePlayers()) {
						
						String name = args[1];
						name = name.replace("§f", "");
						name = name.replace("§7", "");
						name = name.replace("§8", "");
						name = name.replace("§2", "");
						name = name.replace("§a", "");
						name = name.replace("§b", "");
						name = name.replace("§c", "");
						name = name.replace("§4", "");
						name = name.replace("§e", "");
						// do it with other colors
						name = ChatColor.stripColor(name);
						
						String name2 = Main.getNameRP(pls);
						
						
						//&e[Modérateur] &7
						// do it with other colors
						name2 = ChatColor.stripColor(name2);
						
					if(name.equalsIgnoreCase(name2)) {
						Inventory invtarget = pls.getInventory();
						sender.sendMessage("§e[Oiseau]§7 L'oiseau s'envole..");
						p.getInventory().remove(itsend);
						Location loc_secours = new Location(p.getWorld(), Main.instance.getConfig().getDouble("locations.coffre_secours_oiseau.x"), Main.instance.getConfig().getInt("locations.coffre_secours_oiseau.y"), Main.instance.getConfig().getDouble("locations.coffre_secours_oiseau.z"));
						Chest chest = (Chest) loc_secours.getBlock().getState();
						Inventory inv_secours = chest.getInventory();
						inv_secours.addItem(itsend);
						double distance = p.getLocation().distance(pls.getLocation());
						
						
						new BukkitRunnable() {
							public double timer = distance/metreparseconde;
							@Override
							public void run() {
								
								if(!(pls.isOnline())) {
									if(p.isOnline()) {
										sender.sendMessage("§e[Oiseau]§7 L'oiseau n'a pas trouvé le destinataire et revient...");
										inv_secours.remove(itsend);
										p.getInventory().addItem(itsend);
										cancel();
									} else {
										cancel();
									}
								}

								timer = timer -1;
								if(timer <1) {
									pls.sendMessage("§e[Oiseau] §7Un oiseau arrive...");
									invtarget.addItem(itsend);
									inv_secours.remove(itsend);
									cancel();
								}
								
								
							}
						}.runTaskTimerAsynchronously(Main.instance, 20, 20);
						
						return true;
						
					} else {
						

					}

					}	

				}		
					
		
				
			} else {
				sender.sendMessage("§e[Oiseau] §7Merci de prendre le livre voulu dans votre main.");
				return true;
			}
			
		
		
		
		return true;
	}

}
