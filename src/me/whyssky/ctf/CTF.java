package me.whyssky.ctf;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import me.whyssky.ctf.Manager.ArenaManager;
import me.whyssky.ctf.util.Language.Lang;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class CTF extends JavaPlugin {
	
	public static CTF instance;
	public static Logger log;
	
	public static YamlConfiguration LANG;
	public static File LANG_FILE;

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
    
    /**
    * Load the lang.yml file.
 	*/
    public void loadLang() {
        File lang = new File(getDataFolder(), "lang.yml");
        if (!lang.exists()) {
            try {
                getDataFolder().mkdir();
                lang.createNewFile();
                InputStream defConfigStream = this.getResource("lang.yml");
                if (defConfigStream != null) {
                    @SuppressWarnings("deprecation")
					YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
                    defConfig.save(lang);
                    Lang.setFile(defConfig);
                    return;
                }
            } catch(IOException e) {
                log.severe("[CTF] Couldn't create language file.");
                log.severe("[CTF] This is a fatal error. Now disabling");
                this.setEnabled(false);
            }
        }
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(lang);
        for(Lang item : Lang.values()) {
            if (conf.getString(item.getPath()) == null) {
                conf.set(item.getPath(), item.getDefault());
            }
        }
        Lang.setFile(conf);
        CTF.LANG = conf;
        CTF.LANG_FILE = lang;
        try {
            conf.save(getLangFile());
        } catch(IOException e) {
            log.log(Level.WARNING, "CTF: Failed to save lang.yml.");
            log.log(Level.WARNING, "CTF: Report this stack trace to <Whyssky_BR (Rennancge)>.");
        }
    }

    /**
    * Gets the lang.yml config.
    * @return The lang.yml config.
    */
    public YamlConfiguration getLang() {
        return LANG;
    }

    /**
    * Get the lang.yml file.
    * @return The lang.yml file.
    */
    public File getLangFile() {
        return LANG_FILE;
    }
    
}
