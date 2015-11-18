package me.whyssky.ctf.Manager;

import java.io.File;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import me.whyssky.ctf.CTF;

public class ArenaManager {
	
	private static ArenaManager am;
	private CTF plugin = CTF.instance;
	private FileConfiguration getConfig = CTF.instance.getConfig();
	private File afile;

	private Location lobby;
	
	//Prevent instantiation
	private ArenaManager() {}
	
	public void setup() {
		afile = new File(plugin.getDataFolder(), "arenas.yml");
		if(!afile.exists()) {
			try {
				afile.createNewFile();
			}catch(Exception e) {}
		}
	}
	
	public static ArenaManager getManager() {
		if(am == null) {
			am = new ArenaManager();
			return am;
		}
		return am;
	}
}
