package com.legendarycrown.enchantslistener;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import com.legendarycrown.customenchants.ItemUtil;
import com.unoverse.particles.ParticleEffect;


public class FreezeBomb implements Listener{

	static ItemStack novaBomb = ItemUtil.createItem(Material.EYE_OF_ENDER, "§e§lNova Bomb §7Right-Click", "§aGives a slow effect to players in a 5 x 5 radius.");
	private static ArrayList<UUID> freeze = new ArrayList<UUID>();
	private static ArrayList<UUID> player = new ArrayList<UUID>();
	@EventHandler
	public static void playerInteract(PlayerInteractEvent e){
		final Player p = (Player) e.getPlayer();
		if(p.getInventory().getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName() != null && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lNova Bomb §7Right-Click")){
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) e.setCancelled(true);
			
			for(final Entity p1 : p.getNearbyEntities(5, 5, 5)){
				if(p1 instanceof Player){
					freeze.add(p1.getUniqueId());
					player.add(p.getUniqueId());
					p1.sendMessage("§cA §e§lNova Bomb §c has affected you! You are now slowed for 5 seconds!");
					ParticleEffect.EXPLOSION_LARGE.display(null, p.getLocation().add(0, 1.5, 0), 5);
					ParticleEffect.EXPLOSION_LARGE.display(null, p.getLocation().add(1, 1.5, 1), 5);
					ParticleEffect.EXPLOSION_LARGE.display(null, p.getLocation().add(-1, 1.5, -1), 5);
					ParticleEffect.EXPLOSION_LARGE.display(null, p.getLocation().add(1, 1.5, -1), 5);
					ParticleEffect.EXPLOSION_LARGE.display(null, p.getLocation().add(-1, 1.5, 1), 5);
					
					//setup(p.getLocation());
					BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
					scheduler.scheduleSyncDelayedTask(JavaPlugin.getProvidingPlugin(FreezeBomb.class), new Runnable() {
						
						@Override
						public void run() {
							freeze.remove(p1.getUniqueId());
							p1.sendMessage("§bYou are now unfrozen!");
							((Player) p1).playSound(p1.getLocation(), Sound.NOTE_PIANO, 10, 1);
						}
					}, 20L * 5);
				}
			}
			if(player.contains(p.getUniqueId())){
				p.sendMessage("\n§cYou used a §e§lNova Bomb! §6Nearby players are now slowed down for 5 seconds!\n");
				p.playSound(p.getLocation(), Sound.ORB_PICKUP, 10, 1);
				
				if(p.getItemInHand().getAmount() == 1){ 
					p.getInventory().remove(novaBomb);
					player.remove(p.getUniqueId());
					return;
				}
					
				p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
				
				player.remove(p.getUniqueId());
				
				return;
			}
			p.sendMessage("§cNo nearby players, didn't execute.");
		}
	}
	@EventHandler
	public static void tempFreeze(PlayerMoveEvent e){
		if(freeze.contains(e.getPlayer().getUniqueId())){
			e.getPlayer().setVelocity(new Vector(0,0,0));
		}
	}
	public static void setup(final Location loc){
		ArmorStand stand = loc.getWorld().spawn(loc, ArmorStand.class);
		stand.setGravity(false);
		stand.setVisible(false);
		stand.setRightArmPose(new EulerAngle(90, 50, 90));
		stand.setArms(true);
		stand.setItemInHand(new ItemStack(Material.EYE_OF_ENDER));
		/*		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		scheduler.scheduleSyncDelayedTask(JavaPlugin.getProvidingPlugin(NovaBomb.class), new Runnable() {
			@Override
			public void run() {
				loc.getBlock().setType(Material.AIR);
				Bukkit.broadcastMessage((Location) loc + "");
			}
		}, 20L * 5);*/
	}
}

