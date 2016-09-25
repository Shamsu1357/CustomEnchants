package com.legendarycrown.enchantslistener;

import org.bukkit.Bukkit;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;


public class Crush implements Listener{


	@EventHandler
	public void playerFallListener(PlayerMoveEvent e){
		Player p = (Player) e.getPlayer();

		if(p.getVelocity().getY() < -0.6 && p.isSneaking()){
			if(p.getInventory().getBoots() == null || p.getInventory().getBoots().getItemMeta() == null || p.getInventory().getBoots().getItemMeta().getLore() == null) return;
			if(p.getInventory().getBoots().getItemMeta().getLore().contains("§7Crush I")){
				if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().isSolid()){
					for(Entity p1 : p.getNearbyEntities(5, 5, 5)){
						Bukkit.broadcastMessage(p1 + "");
						LivingEntity lentity = (LivingEntity) p1;
						if(lentity.getType() == EntityType.DROPPED_ITEM || lentity.getType() == EntityType.ITEM_FRAME) return;
						
						
						lentity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 5, 3));
						lentity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 5, 3));
					}
					p.setVelocity(new Vector(0, 0, 0));
					Sword.createSmashAbility(e.getPlayer());
				}
			}
		}
	}
}
