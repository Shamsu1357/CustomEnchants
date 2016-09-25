package com.legendarycrown.enchantslistener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftInventoryPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.legendarycrown.customenchants.ItemUtil;

public class BookEnchantments implements Listener{

	private static ItemStack poisonBlade = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Sword)", "§7Poison Blade I");
	private static ItemStack aoe = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Pickaxe)", "§7Area of Effect I");
	private static ItemStack superSmash = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Sword)", "§7Super Smash I");
	private static ItemStack diminish = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Weapon)", "§7Diminish I");
	private static ItemStack compactArrow = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Bow)", "§7Compact Arrow I");
	private static ItemStack dodge = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Chestplate)", "§7Dodge");
	private static ItemStack smelt = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on a Pickaxe)", "§7Smelt I");
	private static ItemStack crush = ItemUtil.createItem(Material.ENCHANTED_BOOK, "§eEnchanted Book §7(Click on Boots)", "§7Crush I");

	@SuppressWarnings("deprecation")
	@EventHandler
	public static void clickItemEvent(InventoryClickEvent e){

		Inventory inv = (CraftInventoryPlayer) e.getWhoClicked().getInventory();

		//Sword Enchantment
		if(e.getCursor().isSimilar(poisonBlade) && e.getCurrentItem().getType() == Material.DIAMOND_SWORD){

			if(e.getInventory().getType() == InventoryType.ENCHANTING || e.getInventory().getType() == InventoryType.ANVIL || e.getInventory().getType() == InventoryType.CHEST) {
				e.getWhoClicked().sendMessage("§cCan't enchant with a gui open");
				return;
			}
			//The Poison Enchantment
			ArrayList <String> lore = new ArrayList <String>();
			lore.add("§7Poison Blade I");

			if(e.getCurrentItem().getItemMeta().hasLore()){
				lore.addAll(e.getCurrentItem().getItemMeta().getLore());
			}

			ItemStack novaSword = ItemUtil.createItem(Material.DIAMOND_SWORD, e.getCurrentItem().getItemMeta().getDisplayName(), lore);

			for(Enchantment en : e.getCurrentItem().getEnchantments().keySet()){
				int i = e.getCurrentItem().getEnchantmentLevel(en);
				novaSword.addEnchantment(en, i);
			}

			novaSword.setDurability(e.getCurrentItem().getDurability());

			e.getCurrentItem().setAmount(e.getCurrentItem().getAmount() - 1);
			e.setCursor(new ItemStack(Material.AIR));
			e.setCancelled(true);
			inv.setItem(e.getSlot(), novaSword);

			//Pickaxe Enchantments
		}else 
			if(e.getCursor().isSimilar(aoe)){

				if(e.getInventory().getType() == InventoryType.ENCHANTING || e.getInventory().getType() == InventoryType.ANVIL || e.getInventory().getType() == InventoryType.CHEST) {
					e.getWhoClicked().sendMessage("§cCan't enchant with a gui open");
					return;
				} 
				if(e.getCurrentItem().getType() == Material.AIR) return;
				if(e.getCurrentItem().getType() == Material.DIAMOND_PICKAXE) {

					ArrayList <String> lore = new ArrayList <String>();
					lore.add("§7Area of Effect I");

					//Checks if it currently has lore, if so adds them.
					if(e.getCurrentItem().getItemMeta().hasLore()){
						lore.addAll(e.getCurrentItem().getItemMeta().getLore());
					}

					ItemStack pickaxe = ItemUtil.createItem(Material.DIAMOND_PICKAXE, e.getCurrentItem().getItemMeta().getDisplayName(), lore);

					//Gets Current Enchantments and applies them
					for(Enchantment en : e.getCurrentItem().getEnchantments().keySet()){
						int i = e.getCurrentItem().getEnchantmentLevel(en);
						pickaxe.addEnchantment(en, i);
					}
					//Gets current durability, to prevent it from repairing when enchanted.
					pickaxe.setDurability(e.getCurrentItem().getDurability());

					e.getCurrentItem().setAmount(e.getCurrentItem().getAmount() - 1);
					e.setCursor(new ItemStack(Material.AIR));
					e.setCancelled(true);
					inv.setItem(e.getSlot(), pickaxe);
				}else{
					e.getWhoClicked().sendMessage("§cYou must use a Diamond Pickaxe for this enchantment. :(");
				}

			}else
				if(e.getCursor().isSimilar(smelt)){
					if(e.getInventory().getType() == InventoryType.ENCHANTING || e.getInventory().getType() == InventoryType.ANVIL || e.getInventory().getType() == InventoryType.CHEST) {
						e.getWhoClicked().sendMessage("§cCan't enchant with a gui open");
						return;
					} 
					if(e.getCurrentItem().getType() == Material.AIR) return;

					ArrayList <String> lore = new ArrayList <String>();
					lore.add("§7Smelt I");

					if(e.getCurrentItem().getItemMeta().hasLore()){
						lore.addAll(e.getCurrentItem().getItemMeta().getLore());
					}

					ItemStack pickaxe = ItemUtil.createItem(Material.DIAMOND_PICKAXE, e.getCurrentItem().getItemMeta().getDisplayName(), lore);

					for(Enchantment en : e.getCurrentItem().getEnchantments().keySet()){
						int i = e.getCurrentItem().getEnchantmentLevel(en);
						pickaxe.addEnchantment(en, i);
					}

					//Gets current durability, to prevent it from repairing when enchanted.
					pickaxe.setDurability(e.getCurrentItem().getDurability());

					e.getCurrentItem().setAmount(e.getCurrentItem().getAmount() - 1);
					e.setCursor(new ItemStack(Material.AIR));
					e.setCancelled(true);
					inv.setItem(e.getSlot(), pickaxe);

				}else //Sword enchantments
					if(e.getCursor().isSimilar(superSmash) && e.getCurrentItem().getType() == Material.DIAMOND_SWORD){

						if(e.getInventory().getType() == InventoryType.ENCHANTING || e.getInventory().getType() == InventoryType.ANVIL || e.getInventory().getType() == InventoryType.CHEST) {
							e.getWhoClicked().sendMessage("§cCan't enchant with a gui open");
							return;
						}
						if(e.getCurrentItem().getType() == Material.AIR) return;

						if(e.getCurrentItem().getType() != Material.DIAMOND_SWORD){
							e.getWhoClicked().sendMessage("§aYou may only use a Diamond Sword for this enchantment.");
						}

						ArrayList <String> lore = new ArrayList <String>();
						lore.add("§7Super Smash I");


						ItemStack armor = ItemUtil.createItem(e.getCurrentItem().getType(), e.getCurrentItem().getItemMeta().getDisplayName(), lore);

						armor.setDurability(e.getCurrentItem().getDurability());

						if(e.getCurrentItem().getItemMeta().hasLore()){
							lore.addAll(e.getCurrentItem().getItemMeta().getLore());
						}

						for(Enchantment en : e.getCurrentItem().getEnchantments().keySet()){
							int i = e.getCurrentItem().getEnchantmentLevel(en);
							armor.addEnchantment(en, i);
						}

						e.getCurrentItem().setAmount(e.getCurrentItem().getAmount() - 1);
						e.setCursor(new ItemStack(Material.AIR));
						e.setCancelled(true);
						inv.setItem(e.getSlot(), armor);

					}else //Sword and Axe Enchantment
						if(e.getCursor().isSimilar(diminish) && e.getCurrentItem().getType() == Material.DIAMOND_SWORD){

							if(e.getInventory().getType() == InventoryType.ENCHANTING || e.getInventory().getType() == InventoryType.ANVIL || e.getInventory().getType() == InventoryType.CHEST) {
								e.getWhoClicked().sendMessage("§cCan't enchant with a gui open");
								return;
							}

							ArrayList <String> lore = new ArrayList <String>();
							lore.add("§7Diminish I");

							if(e.getCurrentItem().getItemMeta().hasLore()){
								lore.addAll(e.getCurrentItem().getItemMeta().getLore());
							}

							if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
								ItemStack sword = ItemUtil.createItem(Material.DIAMOND_SWORD, e.getCurrentItem().getItemMeta().getDisplayName(), lore);

								for(Enchantment en : e.getCurrentItem().getEnchantments().keySet()){
									int i = e.getCurrentItem().getEnchantmentLevel(en);
									sword.addEnchantment(en, i);
								}

								sword.setDurability(e.getCurrentItem().getDurability());
								e.getCurrentItem().setAmount(e.getCurrentItem().getAmount() - 1);
								e.setCursor(new ItemStack(Material.AIR));
								e.setCancelled(true);;
								inv.setItem(e.getSlot(), sword);
							}
						}else
							if(e.getCursor().isSimilar(diminish) && e.getCurrentItem().getType() == Material.DIAMOND_AXE){

								if(e.getInventory().getType() == InventoryType.ENCHANTING || e.getInventory().getType() == InventoryType.ANVIL || e.getInventory().getType() == InventoryType.CHEST) {
									e.getWhoClicked().sendMessage("§cCan't enchant with a gui open");
									return;
								}

								ArrayList <String> lore = new ArrayList <String>();
								lore.add("§7Diminish I");

								if(e.getCurrentItem().getItemMeta().hasLore()){
									lore.addAll(e.getCurrentItem().getItemMeta().getLore());
								}

								if(e.getCurrentItem().getType() == Material.DIAMOND_AXE){
									ItemStack sword = ItemUtil.createItem(Material.DIAMOND_AXE, e.getCurrentItem().getItemMeta().getDisplayName(), lore);

									for(Enchantment en : e.getCurrentItem().getEnchantments().keySet()){
										int i = e.getCurrentItem().getEnchantmentLevel(en);
										sword.addEnchantment(en, i);
									}

									sword.setDurability(e.getCurrentItem().getDurability());
									e.getCurrentItem().setAmount(e.getCurrentItem().getAmount() - 1);
									e.setCursor(new ItemStack(Material.AIR));
									e.setCancelled(true);
									inv.setItem(e.getSlot(), sword);

								}
							}else
								if(e.getCursor().isSimilar(compactArrow) && e.getCurrentItem().getType() == Material.BOW){

									if(e.getInventory().getType() == InventoryType.ENCHANTING || e.getInventory().getType() == InventoryType.ANVIL || e.getInventory().getType() == InventoryType.CHEST) {
										e.getWhoClicked().sendMessage("§cCan't enchant with a gui open");
										return;
									}

									ArrayList <String> lore = new ArrayList <String>();
									lore.add("§7Compact Arrow I");

									if(e.getCurrentItem().getItemMeta().hasLore()){
										lore.addAll(e.getCurrentItem().getItemMeta().getLore());
									}

									ItemStack bow = ItemUtil.createItem(Material.BOW, e.getCurrentItem().getItemMeta().getDisplayName() , lore);

									for(Enchantment en : e.getCurrentItem().getEnchantments().keySet()){
										int i = e.getCurrentItem().getEnchantmentLevel(en);
										bow.addEnchantment(en, i);
									}

									bow.setDurability(e.getCurrentItem().getDurability());
									e.getCurrentItem().setAmount(e.getCurrentItem().getAmount() - 1);
									e.setCursor(new ItemStack(Material.AIR));
									e.setCancelled(true);
									inv.setItem(e.getSlot(), bow);

								}else	
									if(e.getCursor().isSimilar(dodge)){
										if(e.getInventory().getType() == InventoryType.ENCHANTING || e.getInventory().getType() == InventoryType.ANVIL || e.getInventory().getType() == InventoryType.CHEST) {
											e.getWhoClicked().sendMessage("§cCan't enchant with a gui open");
											return;
										}
										ArrayList <String> lore = new ArrayList <String>();
										lore.add("§7Dodge");

										if(e.getCurrentItem().getType().equals(Material.AIR)) return;

										if(e.getCurrentItem().getType().equals(Material.LEATHER_CHESTPLATE)|| e.getCurrentItem().getType().equals(Material.CHAINMAIL_CHESTPLATE) || e.getCurrentItem().getType().equals(Material.IRON_CHESTPLATE) || e.getCurrentItem().getType().equals(Material.DIAMOND_CHESTPLATE) || e.getCurrentItem().getType().equals(Material.GOLD_CHESTPLATE)){

											if(e.getCurrentItem().getItemMeta().hasLore()){
												lore.addAll(e.getCurrentItem().getItemMeta().getLore());
											}

											ItemStack armor = ItemUtil.createItem(e.getCurrentItem().getType(), e.getCurrentItem().getItemMeta().getDisplayName(), lore);

											for(Enchantment en : e.getCurrentItem().getEnchantments().keySet()){
												int i = e.getCurrentItem().getEnchantmentLevel(en);
												armor.addEnchantment(en, i);
											}

											e.getCurrentItem().setAmount(e.getCurrentItem().getAmount() - 1);
											e.setCursor(new ItemStack(Material.AIR));
											e.setCancelled(true);
											inv.setItem(e.getSlot(), armor);
											armor.setDurability(e.getCurrentItem().getDurability());
										}else{
											e.getWhoClicked().sendMessage("§cThis enchantment can only be used on a chestplate.");
											return;
										}
									}else 
										if(e.getCursor().isSimilar(crush)){

											if(e.getCurrentItem().getType() == Material.AIR) return;
											
											if(e.getCurrentItem().getType().equals(Material.LEATHER_BOOTS)|| e.getCurrentItem().getType().equals(Material.CHAINMAIL_BOOTS) || e.getCurrentItem().getType().equals(Material.IRON_BOOTS) || e.getCurrentItem().getType().equals(Material.DIAMOND_BOOTS) || e.getCurrentItem().getType().equals(Material.GOLD_BOOTS)){

												if(e.getInventory().getType() == InventoryType.ENCHANTING || e.getInventory().getType() == InventoryType.ANVIL || e.getInventory().getType() == InventoryType.CHEST) {
													e.getWhoClicked().sendMessage("§cCan't enchant with a gui open");
													return;
												}

												ArrayList <String> lore = new ArrayList <String>();
												lore.add("§7Crush I");

												ItemStack boots = ItemUtil.createItem(e.getCurrentItem().getType(), e.getCurrentItem().getItemMeta().getDisplayName(), lore);

												for(Enchantment en : e.getCurrentItem().getEnchantments().keySet()){
													int i = e.getCurrentItem().getEnchantmentLevel(en);
													boots.addEnchantment(en, i);
												}

												e.getCurrentItem().setAmount(e.getCurrentItem().getAmount() - 1);
												e.setCursor(new ItemStack(Material.AIR));
												e.setCancelled(true);
												inv.setItem(e.getSlot(), boots);
												boots.setDurability(e.getCurrentItem().getDurability());
											}else{
												e.getWhoClicked().sendMessage("§cThis enchantment can only be used on a pair of boots.");
											}
										}
	}
}
