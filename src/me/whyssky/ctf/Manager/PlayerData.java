package me.whyssky.ctf.Manager;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

public class PlayerData {
	
	private Player player;
	private Team team;
	private ItemStack[] contents, armorContents;
	private Location loc;
	
	public PlayerData(Player player, Team team, ItemStack[] contents, ItemStack[] armorContents, Location loc) {
		this.player = player;
		this.team = team;
		this.contents = contents;
		this.armorContents = armorContents;
		this.loc = loc;
	}
	
	public Player getPlayer() {
		return player;
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
