package uk.co.jacekk.bukkit.infiniteliquids;

import uk.co.jacekk.bukkit.baseplugin.v9.BasePlugin;

public class InfiniteLiquids extends BasePlugin {
	
	public void onEnable(){
		super.onEnable(false);
		
		this.pluginManager.registerEvents(new BucketListener(this), this);
	}
	
}
