package me.whyssky.ctf;

import java.util.ArrayList;

import me.whyssky.ctf.Manager.PlayerData;

import org.bukkit.Location;
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
	}
}
