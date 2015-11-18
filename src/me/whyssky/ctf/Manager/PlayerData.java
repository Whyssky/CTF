package me.whyssky.ctf.Manager;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

public class PlayerData {
	
	private String name;
	private Team team;
	private ItemStack[] contents, armorContents;
	private Location loc;
	
	public PlayerData(String name, Team team, ItemStack[] contents, ItemStack[] armorContents, Location loc) {
		this.name = name;
		this.team = team;
		this.contents = contents;
		this.armorContents = armorContents;
		this.loc = loc;
	}
	
	public String getPlayerName() {
		return name;
	}
	
	public Team getTeam() {
		return team;
	}
	
	public ItemStack[] getContents() {
		return contents;
	}
	
	public ItemStack[] getArmorContents() {
		return armorContents;
	}
	
	public Location getLocation() {
		return loc;
	}
}
