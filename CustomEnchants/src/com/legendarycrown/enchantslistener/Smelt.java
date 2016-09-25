package com.legendarycrown.enchantslistener;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;


public class Smelt implements Listener{
	
	@EventHandler
	public static void pickaxeBreakEvent(BlockBreakEvent e){

		if(e.getPlayer().getInventory().getItemInHand() != null && e.getPlayer().getInventory().getItemInHand().getItemMeta() != null && e.getPlayer().getInventory().getItemInHand().getItemMeta().getLore() != null){

			if(e.getPlayer().getInventory().getItemInHand().getItemMeta().getLore().contains("§7Smelt I") && e.getPlayer().getItemInHand().getType() != Material.ENCHANTED_BOOK){
				Random rand = new Random();

				if(rand.nextInt(50) < 30){
										
					if(e.isCancelled()) return;
					
					switch(e.getBlock().getType()){
		
						case IRON_ORE:
							e.setCancelled(true);
							e.getBlock().setType(Material.AIR);
							e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
							break;
						case GOLD_ORE:
							e.setCancelled(true);
							e.getBlock().setType(Material.AIR);
							e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
							break;
						
						default:
							break;
					}
						
				}

			}
		}
	}
}
