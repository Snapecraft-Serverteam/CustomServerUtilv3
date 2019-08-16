package net.snapecraft.customserverutil_v3.modules.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PluginConfig {
    public static File ConfigFile = new File("plugins/CustomServerUtil", "config.yml");
    public static FileConfiguration Config = YamlConfiguration.loadConfiguration(ConfigFile);

    public static void saveCFG() {
        try{
            Config.save(ConfigFile);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
    public static void reloadCFG() {
        try {
            Config = YamlConfiguration.loadConfiguration(ConfigFile);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
