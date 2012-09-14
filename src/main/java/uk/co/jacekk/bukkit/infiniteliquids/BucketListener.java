package uk.co.jacekk.bukkit.infiniteliquids;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.inventory.ItemStack;

import uk.co.jacekk.bukkit.baseplugin.v2.event.BaseListener;

public class BucketListener extends BaseListener<InfiniteLiquids> {
	
	public BucketListener(InfiniteLiquids plugin){
		super(plugin);
	}
	
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onPlayerBucketFill(PlayerBucketFillEvent event){
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
