package me.whyssky.ctf.Manager;

import java.util.ArrayList;
import java.util.Arrays;

import me.whyssky.ctf.cmd.SubCommand;
import me.whyssky.ctf.util.Language.Lang;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor{
    
    private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();
	
	public void setup() {
		
	}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Lang.TITLE + "You must be a player to make this!");
            return false;
        }
        Player p = (Player) sender;
        
        if(cmd.getName().equalsIgnoreCase("splath")) {
            if(args.length == 0) {
                if(p.hasPermission("splath.list.cmds")) {
                    for(SubCommand c : commands) {
                        sender.sendMessage(Lang.TITLE + "§b§l/splath " + c.name() + "(" + aliases(c) + ") " + c.info());
                    }
                }
                return false;
            }
            
            SubCommand target = get(p, args[0]);
            
            if(target == null) {
                sender.sendMessage(Lang.TITLE + args[0] + " is not a valid subcommand!");
                return false;
            
            }
            ArrayList<String> a = new ArrayList<>();
            a.addAll(Arrays.asList(args));
            a.remove(0);
            args = a.toArray(new String[a.size()]);
			
            try {
		target.onCommand(p, args);
            }catch (Exception e) {
            }
        }
        
        return true;
    }
    
    private String aliases(SubCommand cmd) {
		String fin = "";
		
		for (String a : cmd.aliases()) {
			fin += a + " | ";
		}
		
		return fin.substring(0, fin.lastIndexOf(" | "));
	}
	
    private SubCommand get(Player p, String name) {
    	for (SubCommand cmd : commands) {
    		if (cmd.name().equalsIgnoreCase(name)) return cmd;
    			for (String alias : cmd.aliases()) if (name.equalsIgnoreCase(alias)) return cmd;
    	}
        return null;
    }
    
}
