package me.whyssky.ctf;

import java.util.ArrayList;
import java.util.List;

import me.whyssky.ctf.Manager.ArenaManager;
import me.whyssky.ctf.Manager.PlayerData;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Arena {

	private int id;
	private boolean started = false;
    private boolean endTime = false;
    private boolean cd = false;
    private Location redSpawn, blueSpawn;
    private ArrayList<PlayerData> players = new ArrayList<PlayerData>();
    public Team red, blue;
    
    private Scoreboard sb;
	private Objective o;
	private Score sRed, sBlue;
	
	public Arena(int id) {
		this.id = id;
		
		ConfigurationSection conf = ArenaManager.getManager().arenasf.getConfigurationSection(id + "");
		
		this.redSpawn = getLocation(conf.getConfigurationSection("redspawn"));
		this.blueSpawn = getLocation(conf.getConfigurationSection("bluespawn"));
	}
	
	private Location getLocation(ConfigurationSection path) {
		return new Location(
				Bukkit.getServer().getWorld(path.getString("world")),
				path.getDouble("x"),
				path.getDouble("y"),
				path.getDouble("z")
				);
	}
	
	public int getId() {
		return id;
	}
	
	 public List<PlayerData> getPlayers() {
	        return this.players;
	 }
	 
	 public boolean isStarted() {
		 return started;
	 }
	 
	 public Location getRedSpawn() {
		 return redSpawn;
	 }
	 
	 public Location getBlueSpawn() {
		 return blueSpawn;
	 }
	 
	 public void setRedSpawn(Location l) {
		 this.redSpawn = l;
	 }
	 
	 public void setBlueSpawn(Location l) {
		 this.blueSpawn = l;
	 }
}
