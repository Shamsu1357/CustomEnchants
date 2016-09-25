package com.legendarycrown.customenchants;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.legendarycrown.enchantslistener.AoE;
import com.legendarycrown.enchantslistener.BookEnchantments;
import com.legendarycrown.enchantslistener.CompactArrow;
import com.legendarycrown.enchantslistener.Dimish;
import com.legendarycrown.enchantslistener.Dodge;
import com.legendarycrown.enchantslistener.FreezeBomb;
import com.legendarycrown.enchantslistener.Crush;
import com.legendarycrown.enchantslistener.Smelt;
import com.legendarycrown.enchantslistener.Sword;

public class CustomEnchants extends JavaPlugin{
	
	private static ItemStack poisonBlade = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on an item)", "§7Poison Blade I");
	private static ItemStack aoe = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on an item)", "§7Area of Effect I");
	private static ItemStack superSmash = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on an item)", "§7Super Smash I");
	private static ItemStack diminish = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on an item)", "§7Diminish I");
	private static ItemStack compactArrow = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on an item)", "§7Compact Arrow I");
	private static ItemStack dodge = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on an item)", "§7Dodge");

	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Dodge(), this);
		getServer().getPluginManager().registerEvents(new AoE(), this);
		getServer().getPluginManager().registerEvents(new CompactArrow(), this);
		getServer().getPluginManager().registerEvents(new Sword(), this);
		getServer() .getPluginManager().registerEvents(new Smelt(), this);
		getServer() .getPluginManager().registerEvents(new FreezeBomb(), this);
		getServer() .getPluginManager().registerEvents(new Dimish(), this);
		getServer() .getPluginManager().registerEvents(new BookEnchantments(), this);
		getServer() .getPluginManager().registerEvents(new GemsAltar(), this);
		getServer() .getPluginManager().registerEvents(new Gems(), this);
		getServer() .getPluginManager().registerEvents(new Crush(), this);
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String label, String[] args) {
		
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("novapickaxe")){ 
			ArrayList <String> lore = new ArrayList <String>();
			lore.add("§7Area of Effect I");
			lore.add ("§aMines out a 3x3x2 area.");
			ItemStack novaPickaxe = ItemUtil.createItem(Material.DIAMOND_PICKAXE, "§6§lNova Pickaxe", lore);
			novaPickaxe.addEnchantment(Enchantment.DIG_SPEED, 2);
			p.getInventory().addItem(novaPickaxe);
		}
		
		if(cmd.getName().equalsIgnoreCase("novasword")){
			
			ArrayList<String> lore = new ArrayList<String>();
			lore.add("§7Super Smash I");
			lore.add("§7Poison Blade I");
			lore.add("§aHas a chance to cause an explosion damaging all other entities nearby.");
			ItemStack novaSword = ItemUtil.createItem(Material.DIAMOND_SWORD, "§b§lNova Sword", lore);
			p.getInventory().addItem(novaSword);
		}
		
		if(cmd.getName().equalsIgnoreCase("novabow")){
			ArrayList<String> lore = new ArrayList<String>();
			lore.add("§7Grappling I");
			lore.add("§aHas a scatter affect when an arrow hits the ground or an entity.");
			ItemStack novaBow = ItemUtil.createItem(Material.BOW, "§a§lNova Bow", lore);
			p.getInventory().addItem(novaBow);
		}
		
		if(cmd.getName().equalsIgnoreCase("novaaxe")){
			ArrayList<String> lore = new ArrayList<String>();
			lore.add("§7Diminish I");
			ItemStack novaAxe = ItemUtil.createItem(Material.DIAMOND_AXE, "§a§lNova Axe", lore);
			p.getInventory().addItem(novaAxe);
		}
		if(cmd.getName().equalsIgnoreCase("novabomb")){
			ItemStack novaBomb = ItemUtil.createItem(Material.EYE_OF_ENDER, "§e§lNova Bomb §7Right-Click", "§aGives a slow effect to players in a 5 x 5 radius.");
			p.getInventory().addItem(novaBomb);
		}
		if(cmd.getName().equalsIgnoreCase("books")){
			p.getInventory().addItem(poisonBlade);
			p.getInventory().addItem(aoe);
			p.getInventory().addItem(superSmash);
			p.getInventory().addItem(diminish);
			p.getInventory().addItem(compactArrow);
			p.getInventory().addItem(dodge);
		}
		return false;
	}
	
}
