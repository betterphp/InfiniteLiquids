package uk.co.jacekk.bukkit.infiniteliquids;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.inventory.ItemStack;

public class InfiniteLiquidsPlayerListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerBucketFill(PlayerBucketFillEvent event){
		if (event.isCancelled()) return;
		
		Player player = event.getPlayer();
		Block block = event.getBlockClicked();
		Material blockType = block.getType();
		
		if (blockType == Material.STATIONARY_WATER){
			event.setCancelled(true);
			
			player.setItemInHand(new ItemStack(Material.WATER_BUCKET, 1));
		}else if (blockType == Material.STATIONARY_LAVA){
			event.setCancelled(true);
			
			player.setItemInHand(new ItemStack(Material.LAVA_BUCKET, 1));
		}
	}
	
}
