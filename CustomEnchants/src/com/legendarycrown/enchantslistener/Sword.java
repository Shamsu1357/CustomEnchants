package com.legendarycrown.enchantslistener;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Sword implements Listener{


	private static ArrayList<UUID> damage = new ArrayList<UUID>();

	@EventHandler
	public static void novaSwordAbility(EntityDamageByEntityEvent e){
		
		if(e.getDamager() instanceof Player){
			
			Player p = (Player) e.getDamager();
			
			//Super Smash Ability
			if(p.getInventory().getItemInHand() != null && p.getInventory().getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getLore() != null && 
					p.getItemInHand().getItemMeta().getLore().contains("§7Super Smash I")  && p.getItemInHand().getType() != Material.ENCHANTED_BOOK){
				if(e.isCancelled() == true) return;

				if (Math.random() * 100 < 12) {
					createNovaSwordAbility(p, e.getEntity());
				}
			}

			//Poison Blade Ability
			if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
				LivingEntity p1 = (LivingEntity) e.getEntity();
				if(p.getInventory().getItemInHand() != null && p.getInventory().getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getLore() != null && 
						p.getItemInHand().getItemMeta().getLore().contains("§7Poison Blade I") && p.getItemInHand().getType() != Material.ENCHANTED_BOOK){
					if(e.isCancelled() == true) return; 

					if (Math.random() * 100 < 6) {
						p1.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20 * 3, 3));
						p1.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 2, 1));
						p1.sendMessage("§aYou have been poisoned by your attackers Poison Blade!");
						p.sendMessage("§aYou have poisoned your enemy with Poison Blade!");
					}
				}
			}
		}
	}
	//Explosion Listener
	public static void createNovaSwordAbility(Player p, Entity e){
		p.sendMessage("§aExplosion!!");
		damage.add(p.getUniqueId());
		int x = e.getLocation().getBlockX();
		int y = e.getLocation().getBlockY();
		int z = e.getLocation().getBlockZ();
		e.getLocation().getWorld().createExplosion(x, y ,z , 1.5F, false ,false);
		e.getLocation().getWorld().createExplosion(x + 3, y ,z + 3 , 1F, false ,false);
		e.getLocation().getWorld().createExplosion(x - 3, y ,z - 3 , 1F, false ,false);
		e.getLocation().getWorld().createExplosion(x + 3, y ,z - 3 , 1F, false ,false);
		e.getLocation().getWorld().createExplosion(x - 3, y ,z + 3 , 1F, false ,false);
	}

	public static void createSmashAbility(Entity e){
		e.sendMessage("§aExplosion!!");
		damage.add(e.getUniqueId());
		int x = e.getLocation().getBlockX();
		int y = e.getLocation().getBlockY();
		int z = e.getLocation().getBlockZ();
		e.getLocation().getWorld().createExplosion(x, y + 1 ,z , 1F, false ,false);
		e.getLocation().getWorld().createExplosion(x + 1.5, y + 1,z + 1.5, 0.7F, false ,false);
		e.getLocation().getWorld().createExplosion(x - 1.5, y + 1,z - 1.5 , 0.7F, false ,false);
		e.getLocation().getWorld().createExplosion(x + 1.5, y + 1,z - 1.5 , 0.7F, false ,false);
		e.getLocation().getWorld().createExplosion(x - 1.5, y + 1,z + 1.5 , 0.7F, false ,false);
	}

	
	@EventHandler
	public void onPlayerExplode(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player){
			if(e.getCause() == DamageCause.BLOCK_EXPLOSION || e.getCause() == DamageCause.ENTITY_EXPLOSION && damage.contains(e.getEntity().getUniqueId())){
				damage.remove(e.getEntity().getUniqueId());
				e.setCancelled(true);
			}
		}
	}
}
