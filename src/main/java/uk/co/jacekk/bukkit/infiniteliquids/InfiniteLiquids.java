package uk.co.jacekk.bukkit.infiniteliquids;

import org.bukkit.plugin.java.JavaPlugin;

public class InfiniteLiquids extends JavaPlugin {
	
	protected InfiniteLiquidsLogger log;
	
	public void onEnable(){
		this.log = new InfiniteLiquidsLogger(this);
		
		this.getServer().getPluginManager().registerEvents(new InfiniteLiquidsPlayerListener(), this);
	}
	
}
