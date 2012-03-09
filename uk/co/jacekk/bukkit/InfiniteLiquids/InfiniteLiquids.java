package uk.co.jacekk.bukkit.InfiniteLiquids;

import org.bukkit.plugin.java.JavaPlugin;

public class InfiniteLiquids extends JavaPlugin {
	
	protected InfiniteLiquidsLogger log;
	
	public void onEnable(){
		this.log = new InfiniteLiquidsLogger(this);
		
		this.getServer().getPluginManager().registerEvents(new InfiniteLiquidsPlayerListener(), this);
		
		this.log.info("Enabled.");
	}
	
	public void onDisable(){
		this.log.info("Disabled.");
		
		this.log = null;
	}
	
}
