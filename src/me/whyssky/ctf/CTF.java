package me.whyssky.ctf;

import java.util.logging.Logger;

import me.whyssky.ctf.Manager.ArenaManager;

import org.bukkit.plugin.java.JavaPlugin;

public class CTF extends JavaPlugin{
	
	public static CTF instance;
	public static Logger log;

    @Override
    public void onEnable() {
        log = getLogger();
        instance = this;
        ArenaManager.getManager().setup();
        
        getLogger().info("Enabled CTF! by: Whyssky_BR");
    }
    
    @Override
    public void onDisable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        
        getLogger().info("Disabled CTF! by: Whyssky_BR");
    }
}
