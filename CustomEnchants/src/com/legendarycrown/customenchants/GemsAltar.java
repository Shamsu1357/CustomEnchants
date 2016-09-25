package com.legendarycrown.customenchants;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_8_R3.MobSpawnerAbstract;

public class GemsAltar implements Listener{

	String commonGem = "§6Common §6Enchantment §aGem";
	String rareGem = "§bRare §6Enchantment §aGem";
	String legendGem = "§eLegendary §6Enchantment §aGem";

	private static ItemStack poisonBlade = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Sword)", "§7Poison Blade I");
	private static ItemStack aoe = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Pickaxe)", "§7Area of Effect I");
	private static ItemStack superSmash = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Sword)", "§7Super Smash I");
	private static ItemStack diminish = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Weapon)", "§7Diminish I");
	private static ItemStack compactArrow = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Bow)", "§7Compact Arrow I");
	private static ItemStack dodge = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Chestplate)", "§7Dodge");
	private static ItemStack smelt = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Pickaxe)", "§7Smelt I");
	private static ItemStack crush = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on Boots)", "§7Crush I");

	@EventHandler
	public void getGem(PlayerToggleSneakEvent e){

		List<String> lore = new ArrayList<String>();
		lore.add("§aUse this at the Enchantment Altar at §c/spawn");

		ItemStack gem = new ItemStack(Material.EMERALD);
		ItemMeta gemMeta = gem.getItemMeta();
		gemMeta.setDisplayName(commonGem);
		gemMeta.setLore(lore);
		gem.setItemMeta(gemMeta);

		ItemStack raregem = new ItemStack(Material.EMERALD);
		ItemMeta raregemMeta = raregem.getItemMeta();
		raregemMeta.setDisplayName(rareGem);
		raregemMeta.setLore(lore);
		raregem.setItemMeta(raregemMeta);

		ItemStack legendarygem = new ItemStack(Material.EMERALD);
		ItemMeta legendarygemMeta = legendarygem.getItemMeta();
		legendarygemMeta.setDisplayName(legendGem);
		legendarygemMeta.setLore(lore);
		legendarygem.setItemMeta(legendarygemMeta);

		e.getPlayer().getInventory().addItem(gem);
		e.getPlayer().getInventory().addItem(raregem);
		e.getPlayer().getInventory().addItem(legendarygem);

	}

	@EventHandler
	public void playerInteractEvent(PlayerInteractEvent e){
		if(!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;

		/** Location **/
		Location loc = new Location(e.getPlayer().getWorld(), -179, 64, 187);
		
		/**Altar Code**/
		if(e.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE){

			if(e.getClickedBlock().getLocation().equals(loc)){
				/**Common Gems*/
				if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getItemMeta() != null && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(commonGem)){
					e.setCancelled(true);

					if(e.getPlayer().getItemInHand().getAmount() == 1)
						e.getPlayer().getInventory().remove(e.getPlayer().getItemInHand());

					e.getPlayer().getItemInHand().setAmount(e.getPlayer().getItemInHand().getAmount() - 1);

					e.getPlayer().updateInventory();

					Random randomGenerator = new Random();
					int randomInt = randomGenerator.nextInt(3) + 1;

					switch(randomInt){
					case 1:
						/**Common*/
						e.getPlayer().getInventory().addItem(poisonBlade);
						e.getPlayer().sendMessage("§6You recieved the §aPosion Blade §6Enchantment.");
						break;
					case 2:
						/**Common*/
						e.getPlayer().getInventory().addItem(aoe);
						e.getPlayer().sendMessage("§6You recieved the §aArea of Effect §6Enchantment.");
						break;
					case 3:
						/**Common**/
						e.getPlayer().getInventory().addItem(smelt);
						e.getPlayer().sendMessage("§6You recieved the §aSmelt §6Enchantment.");
						break;
					}

				}
			}

			/**Rare Gems*/
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getItemMeta() != null && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(rareGem)){
				if(!e.getClickedBlock().getLocation().equals(loc)) return;
				
				e.setCancelled(true);

				if(e.getPlayer().getItemInHand().getAmount() == 1)
					e.getPlayer().getInventory().remove(e.getPlayer().getItemInHand());

				e.getPlayer().getItemInHand().setAmount(e.getPlayer().getItemInHand().getAmount() - 1);

				e.getPlayer().updateInventory();

				Random randomGenerator = new Random();
				int randomIntRare = randomGenerator.nextInt(3) + 1;

				switch(randomIntRare){

				case 1:
					/**Rare*/
					e.getPlayer().getInventory().addItem(superSmash);
					e.getPlayer().sendMessage("§6You recieved the §aSuper Smash §6Enchantment.");
					break;
					/**Rare**/
				case 2:
					e.getPlayer().getInventory().addItem(crush);
					e.getPlayer().sendMessage("§6You recieved the §aCrush §6Enchantment.");
					break;

				case 3:
					/**Rare*/
					e.getPlayer().getInventory().addItem(dodge);
					e.getPlayer().sendMessage("§6You recieved the §aDodge §6Enchantment.");
					break;
				}
				return;
			}
		}
		/**Legendary Gems*/
		if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getItemMeta() != null && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(legendGem)){
			
			if(!e.getClickedBlock().getLocation().equals(loc)) return;
			
			e.setCancelled(true);

			if(e.getPlayer().getItemInHand().getAmount() == 1)
				e.getPlayer().getInventory().remove(e.getPlayer().getItemInHand());

			e.getPlayer().getItemInHand().setAmount(e.getPlayer().getItemInHand().getAmount() - 1);

			e.getPlayer().updateInventory();

			
			Random randomGenerator = new Random();
			int randomIntRare = randomGenerator.nextInt(2) + 1;

			switch(randomIntRare){					
			case 1:
			 /**Legend*/
				e.getPlayer().getInventory().addItem(diminish);
				e.getPlayer().sendMessage("§6You recieved the §aDiminish §6Enchantment.");
				break;
			case 2:
			  /**Legend*/
				e.getPlayer().getInventory().addItem(compactArrow);
				e.getPlayer().sendMessage("§6You recieved the §aCompact Arrow §6Enchantment.");
				break;
			}
		}
	}
}
