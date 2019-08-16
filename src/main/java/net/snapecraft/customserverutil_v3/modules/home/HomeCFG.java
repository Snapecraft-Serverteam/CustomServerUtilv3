package net.snapecraft.customserverutil_v3.modules.home;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeCFG {
    public static File ConfigFile = new File("plugins/CustomServerUtil", "homes.yml");
    public static FileConfiguration Config = YamlConfiguration.loadConfiguration(ConfigFile);

    public static void saveHome() {
        try{
            Config.save(ConfigFile);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
    public static void reloadHome() {
        try {
            Config = YamlConfiguration.loadConfiguration(ConfigFile);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void setHome(Player p, Location loc, String name) {

        if(Config.getString("homes." + p.getName() + ".amount") != null && Config.getInt("homes." + p.getName() + ".amount") != 0){
            int amount = Config.getInt("homes." + p.getName() + ".amount");
            amount = amount + 1;
            Config.set("homes." + p.getName() + ".amount", String.valueOf(amount));
        } else {
            Config.set("homes." + p.getName() + ".amount", 1);
        }
        Config.set("homes." + p.getName() + "." + name + ".WORLD", loc.getWorld().getName());
        Config.set("homes." + p.getName() + "." + name + ".X", loc.getX());
        Config.set("homes." + p.getName() + "." + name + ".Y", loc.getY());
        Config.set("homes." + p.getName() + "." + name + ".Z", loc.getZ());
        Config.set("homes." + p.getName() + "." + name + ".PITCH", loc.getPitch());
        Config.set("homes." + p.getName() + "." + name + ".YAW", loc.getYaw());
        saveHome();
        reloadHome();
    }
    public static Location getHomeLoc(Player p, String name) {
        World locworld = Bukkit.getWorld(Config.getString("homes." + p.getName() + "." + name + ".WORLD"));
        double locx = Double.parseDouble(Config.getString("homes." + p.getName() + "." + name + ".X"));
        double locy = Double.parseDouble(Config.getString("homes." + p.getName() + "." + name + ".Y"));
        double locz = Double.parseDouble(Config.getString("homes." + p.getName() + "." + name + ".Z"));
        float locpitch = Float.parseFloat(Config.getString("homes." + p.getName() + "." + name + ".PITCH"));
        float locyaw = Float.parseFloat(Config.getString("homes." + p.getName() + "." + name + ".YAW"));
        return new Location(locworld, locx, locy, locz, locyaw, locpitch);

    }
    public static Integer getHomeAmount(Player p) {
        if(Config.getString("homes." + p.getName()) != null) {
            if(Config.getInt("homes." + p.getName() + ".amount") != 0) {
                return Config.getInt("homes." + p.getName() + ".amount");
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
    @SuppressWarnings("deprecation")
    public static List<String> listHome(Player p) {
        List<String> homelist = new ArrayList<>();
        for(String key : Config.getConfigurationSection("homes").getKeys(true)){
            if(Bukkit.getPlayer(key) == null) {
                if(Bukkit.getOfflinePlayer(key) == null) {
                    homelist.add(key);
                }
            }
        }

        return homelist;

    }
}
