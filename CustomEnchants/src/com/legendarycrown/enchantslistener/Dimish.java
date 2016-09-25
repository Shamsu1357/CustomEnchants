package com.legendarycrown.enchantslistener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Dimish implements Listener{

	@EventHandler
	public static void playerDamagePlayer(EntityDamageByEntityEvent e){

		if(e.isCancelled()) return;

		if(e.getEntity() instanceof Player){ 

			if(Math.random() * 100 < 5){
				
				Player p = (Player) e.getDamager();
				Player target = (Player) e.getEntity();
				
				if(p.getItemInHand() != null && p.getInventory().getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getLore() != null && p.getItemInHand().getItemMeta().getLore().contains("§7Diminish I")){

					if(target.getInventory().getArmorContents() != null){

						for(ItemStack i : target.getInventory().getArmorContents()){
							i.setDurability((short) (i.getDurability() + 6));
						}
						p.sendMessage("§aSMASH!");
					}
				}
			}
		}
	}
}