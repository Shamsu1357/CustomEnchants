package com.legendarycrown.enchantslistener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Dodge implements Listener{

	@EventHandler
	public static void damageListener(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(!(e.getEntity() instanceof Player)) return;
			if(Math.random() * 100 < 15){
				if(p.getInventory().getChestplate().getItemMeta() != null && p.getInventory().getChestplate() != null && p.getInventory().getChestplate().getItemMeta().getLore().contains("§7Dodge")){
					e.setCancelled(true);
					p.sendMessage("§cDodged!");
				}
			}
		}
	}
}