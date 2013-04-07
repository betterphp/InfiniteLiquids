package uk.co.jacekk.bukkit.infiniteliquids;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.inventory.ItemStack;

import uk.co.jacekk.bukkit.baseplugin.event.BaseListener;

public class BucketListener extends BaseListener<InfiniteLiquids> {
	
	private HashMap<Material, ItemStack> buckets;
	
	public BucketListener(InfiniteLiquids plugin){
		super(plugin);
		
		this.buckets = new LinkedHashMap<Material, ItemStack>(2);
		this.buckets.put(Material.STATIONARY_WATER, new ItemStack(Material.WATER_BUCKET, 1));
		this.buckets.put(Material.STATIONARY_LAVA, new ItemStack(Material.LAVA_BUCKET, 1));
	}
	
	private boolean isPool(Block block){
		Block[] checks = new Block[]{
			block.getRelative(BlockFace.DOWN),
			block.getRelative(BlockFace.NORTH),
			block.getRelative(BlockFace.SOUTH),
			block.getRelative(BlockFace.EAST),
			block.getRelative(BlockFace.WEST),
		};
		
		Material blockType = block.getType();
		int found = 0;
		
		for (Block check : checks){
			if (check.getType() == blockType){
				if (++found == 3){
					return true;
				}
			}
		}
		
		return false;
	}
	
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onPlayerBucketFill(PlayerBucketFillEvent event){
		Player player = event.getPlayer();
		Block block = event.getBlockClicked();
		Material blockType = block.getType();
		
		if ((blockType == Material.STATIONARY_WATER || blockType == Material.STATIONARY_LAVA) && this.isPool(block)){
			event.setCancelled(true);
			
			player.sendBlockChange(block.getLocation(), blockType, block.getData());
			player.setItemInHand(this.buckets.get(blockType));
		}
	}
	
}
