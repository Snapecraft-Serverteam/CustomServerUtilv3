package net.snapecraft.customserverutil_v3.warp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WarpCfg {

    public static File ConfigFile = new File("plugins/CustomServerUtilv3", "warps.yml");
    public static FileConfiguration Config = YamlConfiguration.loadConfiguration(ConfigFile);

    public static void saveWarp() {
        try{
            Config.save(ConfigFile);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
    public static void reloadWarp() {
        try {
            Config = YamlConfiguration.loadConfiguration(ConfigFile);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void addWarp(String name, Location loc, Integer range) {
        Config.set("warps." + name + ".RANGE", range);
        Config.set("warps." + name + ".WORLD", loc.getWorld().getName());
        Config.set("warps." + name + ".X", loc.getBlockX());
        Config.set("warps." + name + ".Y", loc.getBlockY());
        Config.set("warps." + name + ".Z", loc.getBlockZ());
        Config.set("warps." + name + ".YAW", loc.getYaw());
        Config.set("warps." + name + ".PITCH", loc.getPitch());
        saveWarp();
        reloadWarp();




    }

    public static Location getWarpLoc(String name) {
        if(Config.get("warps." + name + ".WORLD") != null) {
            Location loc = new Location(Bukkit.getWorld(Config.getString("warps." + name + ".WORLD")),
                    Double.parseDouble(Config.getString("warps." + name + ".X")),
                    Double.parseDouble(Config.getString("warps." + name + ".Y")),
                    Double.parseDouble(Config.getString("warps." + name + ".Z")),
                    Float.parseFloat(Config.getString("warps." + name + ".YAW")),
                    Float.parseFloat(Config.getString("warps." + name + ".PITCH")));
            return loc;
        } else {
            return null;
        }



    }

    public static Integer getRangeByName(String name) {

        if(Config.get("warps." + name + ".RANGE") != null) {
            int range = Config.getInt("warps." + name + ".RANGE");

            return range;
        } else {
            return null;
        }

    }


    public static void removeWarp(String name) {
        Config.getConfigurationSection("warps").set(name, null);

        saveWarp();
        reloadWarp();
    }

    public static List<String> getWarps() {

        List<String> warplist = new ArrayList<>();
        for(String s : Config.getConfigurationSection("warps").getKeys(false)) {
            warplist.add(s);
        }

        return warplist;
    }

}