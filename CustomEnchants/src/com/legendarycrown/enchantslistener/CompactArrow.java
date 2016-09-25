package com.legendarycrown.enchantslistener;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;


public class CompactArrow implements Listener{

	@EventHandler
	public static void novaBow(final ProjectileHitEvent e){
		if(e.getEntity() instanceof Arrow){

			if(!(e.getEntity().getShooter() instanceof Player)) return;


			Player p = (Player) e.getEntity().getShooter();

			//launch
			if(p.getItemInHand() != null && p.getInventory().getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getLore() != null && p.getItemInHand().getItemMeta().getLore().contains("§7Grappling I")){
				
				if(p.getLocation().getPitch() < -50) return;
				
				p.setVelocity(new Vector(0, 2, 0));
				p.setVelocity(p.getEyeLocation().getDirection().multiply(4));
			}

			//spread shot
			if(p.getItemInHand() != null && p.getInventory().getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getLore() != null && p.getItemInHand().getItemMeta().getLore().contains("§7Compact Arrow I")){
				if(e.getEntity().hasMetadata("novaArrow")) return;
				/*p.setVelocity(p.getLocation().getDirection().multiply(2.5).setY(1.2));*/

				if(p.getItemInHand().getEnchantmentLevel(Enchantment.ARROW_DAMAGE) == 1){

					double speed = 0.75;
					Location loc = e.getEntity().getLocation().add(0, 2, 0);

					Arrow arrow1 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow2 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow3 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow4 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow5 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow6 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow7 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow8 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);

					arrow1.setShooter(p);
					arrow2.setShooter(p);
					arrow3.setShooter(p);
					arrow4.setShooter(p);
					arrow5.setShooter(p);
					arrow6.setShooter(p);
					arrow7.setShooter(p);
					arrow8.setShooter(p);

					arrow1.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow2.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow3.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow4.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow5.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow6.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow7.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow8.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));

					Vector direction1 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0.12, 0, 0.12));
					Vector direction2 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(-0.12, 0, -0.12));
					Vector direction3 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(-0.12, 0, 0.12));
					Vector direction4 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0.12, 0, -0.12));
					Vector direction5 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0, 0, -0.12));
					Vector direction6 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0, 0, 0.12));
					Vector direction7 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0.12, 0, 0));
					Vector direction8 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(-0.12, 0, 0));


					arrow1.setVelocity(direction1.multiply(speed));
					arrow2.setVelocity(direction2.multiply(speed));
					arrow3.setVelocity(direction3.multiply(speed));
					arrow4.setVelocity(direction4.multiply(speed));
					arrow5.setVelocity(direction5.multiply(speed));
					arrow6.setVelocity(direction6.multiply(speed));
					arrow7.setVelocity(direction7.multiply(speed));
					arrow8.setVelocity(direction8.multiply(speed));
					return;
				}
				if(p.getItemInHand().containsEnchantment(Enchantment.ARROW_FIRE)){
					double speed = 0.65;
					Location loc = e.getEntity().getLocation().add(0, 2, 0);

					Arrow arrow1 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow2 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow3 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow4 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow5 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow6 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow7 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
					Arrow arrow8 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);

					arrow1.setFireTicks(Integer.MAX_VALUE);
					arrow2.setFireTicks(Integer.MAX_VALUE);
					arrow3.setFireTicks(Integer.MAX_VALUE);
					arrow4.setFireTicks(Integer.MAX_VALUE);
					arrow5.setFireTicks(Integer.MAX_VALUE);
					arrow6.setFireTicks(Integer.MAX_VALUE);
					arrow7.setFireTicks(Integer.MAX_VALUE);
					arrow8.setFireTicks(Integer.MAX_VALUE);

					arrow1.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow2.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow3.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow4.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow5.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow6.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow7.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
					arrow8.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));

					arrow1.setShooter(p);
					arrow2.setShooter(p);
					arrow3.setShooter(p);
					arrow4.setShooter(p);
					arrow5.setShooter(p);
					arrow6.setShooter(p);
					arrow7.setShooter(p);
					arrow8.setShooter(p);

					Vector direction1 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0.12, 0, 0.12));
					Vector direction2 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(-0.12, 0, -0.12));
					Vector direction3 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(-0.12, 0, 0.12));
					Vector direction4 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0.12, 0, -0.12));
					Vector direction5 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0, 0, -0.12));
					Vector direction6 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0, 0, 0.12));
					Vector direction7 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0.12, 0, 0));
					Vector direction8 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(-0.12, 0, 0));


					arrow1.setVelocity(direction1.multiply(speed));
					arrow2.setVelocity(direction2.multiply(speed));
					arrow3.setVelocity(direction3.multiply(speed));
					arrow4.setVelocity(direction4.multiply(speed));
					arrow5.setVelocity(direction5.multiply(speed));
					arrow6.setVelocity(direction6.multiply(speed));
					arrow7.setVelocity(direction7.multiply(speed));
					arrow8.setVelocity(direction8.multiply(speed));
					return;
				}


				double speed = 0.65;
				Location loc = e.getEntity().getLocation().add(0, 2, 0);

				Arrow arrow1 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
				Arrow arrow2 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
				Arrow arrow3 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
				Arrow arrow4 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
				Arrow arrow5 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
				Arrow arrow6 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
				Arrow arrow7 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);
				Arrow arrow8 = (Arrow) e.getEntity().getLocation().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.ARROW);

				arrow1.setShooter(p);
				arrow2.setShooter(p);
				arrow3.setShooter(p);
				arrow4.setShooter(p);
				arrow5.setShooter(p);
				arrow6.setShooter(p);
				arrow7.setShooter(p);
				arrow8.setShooter(p);

				arrow1.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
				arrow2.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
				arrow3.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
				arrow4.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
				arrow5.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
				arrow6.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
				arrow7.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));
				arrow8.setMetadata("novaArrow", new FixedMetadataValue(JavaPlugin.getProvidingPlugin(CompactArrow.class), "true"));

				Vector direction1 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0.12, 0, 0.12));
				Vector direction2 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(-0.12, 0, -0.12));
				Vector direction3 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(-0.12, 0, 0.12));
				Vector direction4 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0.12, 0, -0.12));
				Vector direction5 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0, 0, -0.12));
				Vector direction6 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0, 0, 0.12));
				Vector direction7 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(0.12, 0, 0));
				Vector direction8 = loc.toVector().subtract(e.getEntity().getLocation().toVector()).normalize().add(new Vector(-0.12, 0, 0));


				arrow1.setVelocity(direction1.multiply(speed));
				arrow2.setVelocity(direction2.multiply(speed));
				arrow3.setVelocity(direction3.multiply(speed));
				arrow4.setVelocity(direction4.multiply(speed));
				arrow5.setVelocity(direction5.multiply(speed));
				arrow6.setVelocity(direction6.multiply(speed));
				arrow7.setVelocity(direction7.multiply(speed));
				arrow8.setVelocity(direction8.multiply(speed));

			}
		}
	}
}
