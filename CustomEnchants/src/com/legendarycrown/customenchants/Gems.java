package com.legendarycrown.customenchants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Gems implements Listener{

	@EventHandler
	public void blockBreakEvent(BlockBreakEvent e){
		Block b = e.getBlock();
		
		List<String> lore = new ArrayList<String>();
		lore.add("§aUse this at the Gem table at §c/spawn");
		
		ItemStack gem = new ItemStack(Material.EMERALD);
		ItemMeta gemMeta = gem.getItemMeta();
		gemMeta.setDisplayName("§6Enchantment §aGem");
		gemMeta.setLore(lore);
		gem.setItemMeta(gemMeta);
		
		if(b.getType() == Material.GRASS || b.getType() == Material.YELLOW_FLOWER || b.getType() == Material.RED_ROSE) 
			return;
		
		Random random = new Random();
		int chance = random.nextInt(650); 
		if(chance <= 3){
			e.getPlayer().getInventory().addItem(gem);
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 10, 1);
		}
		
	}
	
	@EventHandler
	public void entityKillEvent(EntityDeathEvent e){
		
		List<String> lore = new ArrayList<String>();
		lore.add("§aUse this at the Gem table at §c/spawn");
		
		ItemStack gem = new ItemStack(Material.EMERALD);
		ItemMeta gemMeta = gem.getItemMeta();
		gemMeta.setDisplayName("§6Enchantment §aGem");
		gemMeta.setLore(lore);
		gem.setItemMeta(gemMeta);
		
		Player p = (Player) e.getEntity().getKiller();
		if(e.getEntity() instanceof Player){
			Random random = new Random();
			int chance = random.nextInt(250); 
			if(chance <= 4){
				p.getInventory().addItem(gem);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 1);
			}
			return;
		}
		
		Random random = new Random();
		int chance = random.nextInt(450); 
		if( chance <= 3 ){
			p.getInventory().addItem(gem);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 1);
		}
		
	}
	
}
