package net.snapecraft.customserverutil_v3;

import net.snapecraft.customserverutil_v3.commands.*;
import net.snapecraft.customserverutil_v3.listener.JoinListener;
import net.snapecraft.customserverutil_v3.listener.QuitListener;
import net.snapecraft.customserverutil_v3.warp.WarpProtection;
import org.bukkit.plugin.java.JavaPlugin;


public class CustomServerUtilv3 extends JavaPlugin {

    public static String getPrefix() {
        return prefix;
    }

    public static final String prefix = "§7[§3Server§7]§5 > §r";

    public static String getNoPerm() {
        return noPerm;
    }

    public static final String noPerm = prefix + "§cDu hast nicht die nötige Berechtigung, um diesen Command auszuführen!";

    public static CustomServerUtilv3 ins = null;
    @Override
    public void onEnable() {
        ins = this;

        System.out.println("\n\n\n                _                  _       _     _                 _____ \n" +
                "               | |                | |     | |   | |               |____ |\n" +
                "  ___ _   _ ___| |_ ___  _ __ ___ | | ___ | |__ | |__  _   ___   __   / /\n" +
                " / __| | | / __| __/ _ \\| '_ ` _ \\| |/ _ \\| '_ \\| '_ \\| | | \\ \\ / /   \\ \\\n" +
                "| (__| |_| \\__ \\ || (_) | | | | | | | (_) | |_) | |_) | |_| |\\ V /.___/ /\n" +
                " \\___|\\__,_|___/\\__\\___/|_| |_| |_|_|\\___/|_.__/|_.__/ \\__, | \\_/ \\____/ \n" +
                "                                                        __/ |            \n" +
                "                                                       |___/             \n\n\n");

        registerConfig();
        registerCommands();
        registerListeners();

        super.onEnable();
    }

    private void registerConfig() {
        saveConfig();
        reloadConfig();
        getConfig().addDefault("joinmsg", true);
        getConfig().addDefault("jointxt", "&7[&a+&7]&2 PLAYERNAME");
        getConfig().addDefault("leavemsg", true);
        getConfig().addDefault("leavetxt", "&7[&c-&7]&2 PLAYERNAME");

        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }


    private void registerCommands() {

        getCommand("tpa").setExecutor(new SendTpaCMD());
        getCommand("tpaccept").setExecutor(new AcceptTpaCMD());
        getCommand("tpdecline").setExecutor(new DeclineTpaCMD());

        getCommand("home").setExecutor(new HomeCMD());
        getCommand("sethome").setExecutor(new HomeCMD());

        getCommand("s").setExecutor(new GameModeCMD());
        getCommand("c").setExecutor(new GameModeCMD());
        getCommand("sp").setExecutor(new GameModeCMD());

       getCommand("sun").setExecutor(new SunCMD());
       getCommand("day").setExecutor(new DayCMD());
       getCommand("night").setExecutor(new NightCMD());

       getCommand("heal").setExecutor(new HealCMD());
       getCommand("fly").setExecutor(new FlyCMD());
       getCommand("build").setExecutor(new BuildModeCMD());


        getCommand("warp").setExecutor(new WarpCMD());
        getCommand("setwarp").setExecutor(new SetWarpCMD());
        getCommand("removewarp").setExecutor(new RemoveWarpCMD());
        getCommand("spawn").setExecutor(new SpawnCMD());

    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new QuitListener(), this);
        getServer().getPluginManager().registerEvents(new WarpProtection(), this);

        if(getServer().getPluginManager().getPlugin("Reset") != null){

        }
    }
    public static CustomServerUtilv3 getInstance() {
        return ins;
    }
}
