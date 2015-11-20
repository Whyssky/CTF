package me.whyssky.ctf.Manager;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.whyssky.ctf.Arena;
import me.whyssky.ctf.CTF;

public class ArenaManager {
	
	private static ArenaManager am;
	private CTF plugin = CTF.instance;
	private FileConfiguration getConfig = CTF.instance.getConfig();
	private File afile;
	public FileConfiguration arenasf;

	private Location lobby;
	
	// Arenas
    private ArrayList<Arena> arenas = new ArrayList<>();
    public static final ArrayList<Integer> ids = new ArrayList<>();
	
	//Prevent instantiation
	private ArenaManager() {}
	
	public void setup() {
		afile = new File(plugin.getDataFolder(), "arenas.yml");
		if(!afile.exists()) {
			try {
				afile.createNewFile();
			}catch(Exception e) {}
		}
		
		arenasf = YamlConfiguration.loadConfiguration(afile);
		
		 try {
			 for (int i : arenasf.getIntegerList("ids")) {
				 if(!ids.contains(i)) {
					 ids.add(i);
	             }
				 
				 Arena a = new Arena(i);
				 
				 arenas.add(a);
				 
				 plugin.saveConfig();
				 plugin.reloadConfig();
			 }
	            
			 if(arenasf.getConfigurationSection("lobby") != null) {
				 World world = Bukkit.getServer().getWorld(arenasf.getConfigurationSection("lobby").getString("world"));
				 int x = (int) arenasf.getConfigurationSection("lobby").getDouble("x");
				 int y = (int) arenasf.getConfigurationSection("lobby").getDouble("y");
				 int z = (int) arenasf.getConfigurationSection("lobby").getDouble("z");
				 Location l = new Location(world, x, y, z);

				 this.lobby = l;
			 }
	            
		}catch (Exception ignored) {}
	}
	
	public ConfigurationSection createConfigurationSection(String path) {
		ConfigurationSection s = arenasf.createSection(path);
		save();
		return s;
	}
	
	private void save() {
		try { arenasf.save(afile); }
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public static ArenaManager getManager() {
		if(am == null) {
			am = new ArenaManager();
			return am;
		}
		return am;
	}
	
	public void addPlayer(Player p, int id) {
		Arena a = getArena(id);
		
		if (a == null) {
            p.sendMessage("null");
            if(ids.contains(id) && arenasf.getConfigurationSection("arenas." + id).getString("world") == null) {
                p.sendMessage("Null");
                return;
            }
            return;
        }
		
		if(this.isInGame(p)) {
            p.sendMessage("InGame");
            return;
        }
        
        if(getArena(id).isStarted()) {
            p.sendMessage("Started");
            return;
        } 
	}
	
	public Arena getArena(int id){
        for (Arena a : arenas) {
            if (a.getId() == id) {
                return a;
            }
        }
 
        return null;
    }
	
	public boolean isInGame(Player p) {
        for (Arena a : this.arenas) {
            for(PlayerData pd : a.getPlayers()) {
            	return pd.getPlayer() == p ? true : false; 
            }
        }
        return false;
    }
}
