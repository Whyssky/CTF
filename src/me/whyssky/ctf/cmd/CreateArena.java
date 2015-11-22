package me.whyssky.ctf.cmd;

import me.whyssky.ctf.Manager.ArenaManager;
import me.whyssky.ctf.util.Language.Lang;

import org.bukkit.entity.Player;

public class CreateArena extends SubCommand{

	@Override
	public void onCommand(Player p, String[] args) {
		ArenaManager.getManager().createArena();
		p.sendMessage(Lang.TITLE + Lang.CREATE.toString().replace("%a", "" + ArenaManager.ids.get(ArenaManager.ids.size())));
	}

	@Override
	public String name() {

		return "create";
	}

	@Override
	public String info() {

		return "Create a new Arena";
	}

	@Override
	public String[] aliases() {

		return new String[] {
				"c"
		};
	}

}
