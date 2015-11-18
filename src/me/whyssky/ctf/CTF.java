package me.whyssky.ctf;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class CTF extends JavaPlugin{
	
	public static Logger log;

    @Override
    public void onEnable() {
        log = getLogger();
        getLogger().info("Enabled Splath! by: Whyssky_BR");
    }
    
    @Override
    public void onDisable() {
    	getLogger().info("Disabled Splath! by: Whyssky_BR");
    	
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }
}
