package com.legendarycrown.enchantslistener;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import com.legendarycrown.customenchants.CustomEnchants;
import com.legendarycrown.customenchants.ItemUtil;
import com.unoverse.particles.ParticleEffect;

public class AoE implements Listener {
	public static ItemStack novaPickaxe = ItemUtil.createItem(Material.DIAMOND_PICKAXE, "§6§lNova Pickaxe", "§aMines out a 3x3x2 area.");
	@EventHandler
	public static void pickaxeBreakEvent(BlockBreakEvent e){

		if(e.getPlayer().getInventory().getItemInHand() != null && e.getPlayer().getInventory().getItemInHand().getItemMeta() != null && e.getPlayer().getInventory().getItemInHand().getItemMeta().getLore() != null){

			if(e.getPlayer().getInventory().getItemInHand().getItemMeta().getLore().contains("§7Area of Effect I") && e.getPlayer().getItemInHand().getType() != Material.ENCHANTED_BOOK){

				Block currentBlock = null;

				for(int xOff = -1; xOff <= 1; ++xOff) {

					for(int yOff = -1; yOff <= 1; ++yOff) {  

						for(int zOff = -1; zOff <= 1; ++zOff) {

							Block relative = e.getBlock().getRelative(xOff, yOff, zOff);

							if(relative.getType() == Material.BEDROCK || relative.getType() == Material.BARRIER || e.isCancelled()){
								e.setCancelled(true); 
								return;
							}
							Vector vec = new Vector();
							vec.setX(xOff);
							vec.setY(yOff);
							vec.setZ(zOff);
							ParticleEffect.FLAME.display(vec, (float)0.50, e.getBlock().getLocation(), 5);
							currentBlock = e.getBlock().getRelative(xOff, yOff, zOff);
							currentBlock.breakNaturally(novaPickaxe);
						}
					}
				}
			}
		}
	}
}

/*				Block topBlock = e.getBlock().getLocation().add(new Vector(0, 1, 0)).getBlock();
				if(e.getBlock().getType() == topBlock.getType()){

					for(ItemStack drop : topBlock.getDrops()){
						topBlock.getLocation().getWorld().dropItemNaturally(topBlock.getLocation(), drop);
					}
					topBlock.setType(Material.AIR);
				}
				for(Block b: getCubeArea(3, e.getBlock().getLocation())){
					if(e.getBlock().getType() == b.getType()){
						for(ItemStack drop : b.getDrops()){
							b.getLocation().getWorld().dropItemNaturally(b.getLocation(), drop);
						}
						e.getPlayer().getItemInHand().setDurability((short) (e.getPlayer().getItemInHand().getDurability() + 1));
						b.getLocation().getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, b.getType());
						b.setType(Material.AIR);
					}
				}
			}
		}
	}
	public static Set<Block> getCubeArea(int radius, Location l){

		Set<Block> blocks = new HashSet<Block>();
		int range = radius;
		int minX = l.getBlockX() - range / 2;
		int minY = l.getBlockY() - range / 2;
		int minZ = l.getBlockZ() - range / 2;

		for(int x = minX; x < minX + range; x++)
		{
			for(int y = minY; y < minY + range; y++)
			{
				for(int z = minZ; z < minZ + range; z++)
				{
					Location loc = new Location(l.getWorld(), x, y, z);
					blocks.add(loc.getBlock());
				}
			}
		}

		return blocks;
	}
 */