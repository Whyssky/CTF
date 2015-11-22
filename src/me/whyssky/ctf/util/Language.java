package me.whyssky.ctf.util;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

public class Language {
	public enum Lang {

        TITLE("title-name", "&3&lCTF&8&l> "),
        CREATE("create-arena", "&aCreated Arena %a!");
        
        private String path;
        private String def;
        private static YamlConfiguration LANG;
        
        /**
        * Lang enum constructor.
        * @param path The string path.
        * @param start The default string.
        */
        Lang(String path, String start) {
            this.path = path;
            this.def = start;
        }
        
        /**
        * Set the {@code YamlConfiguration} to use.
        * @param config The config to set.
        */
        public static void setFile(YamlConfiguration config) {
            LANG = config;
        }   
        
        @Override
        public String toString() {
            return ChatColor.translateAlternateColorCodes('&', LANG.getString(this.path, def));
        }
        
        /**
        * Get the default value of the path.
        * @return The default value of the path.
        */
        public String getDefault() {
            return this.def;
        }
        
        /**
        * Get the path to the string.
        * @return The path to the string.
        */
        public String getPath() {
            return this.path;
        }
    }
}
