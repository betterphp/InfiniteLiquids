package uk.co.jacekk.bukkit.InfiniteLiquids;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;

public class InfiniteLiquidsLogger {
	
	private InfiniteLiquids plugin;
	private Logger logger;
	
	public InfiniteLiquidsLogger(InfiniteLiquids instance){
		this.plugin = instance;
		this.logger = Logger.getLogger("Minecraft");
	}
	
	private String buildString(String msg){
		PluginDescriptionFile pdFile = plugin.getDescription();
		
		return pdFile.getName() + " " + pdFile.getVersion() + ": " + msg;
	}
	
	public void info(String msg){
		this.logger.info(this.buildString(msg));
	}
	
	public void warn(String msg){
		this.logger.warning(this.buildString(msg));
	}
	
}
