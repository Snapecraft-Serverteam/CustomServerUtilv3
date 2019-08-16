package net.snapecraft.customserverutil_v3.commands;

import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCMD implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;

        if(p.hasPermission("CustomServerUtil.gamemode")) {
            if(args.length == 0) {
                if(command.getName().equalsIgnoreCase("s")) {
                    p.setGameMode(GameMode.SURVIVAL);
                } if(command.getName().equalsIgnoreCase("c")) {
                    p.setGameMode(GameMode.CREATIVE);
                } if(command.getName().equalsIgnoreCase("sp")) {
                    p.setGameMode(GameMode.SPECTATOR);
                }
            } else if(args.length == 1) {
                if(Bukkit.getPlayer(args[0]) != null) {
                    if(command.getName().equalsIgnoreCase("s")) {
                        Bukkit.getPlayer(args[0]).setGameMode(GameMode.SURVIVAL);
                    } if(command.getName().equalsIgnoreCase("c")) {
                        Bukkit.getPlayer(args[0]).setGameMode(GameMode.CREATIVE);
                    } if(command.getName().equalsIgnoreCase("sp")) {
                        Bukkit.getPlayer(args[0]).setGameMode(GameMode.SPECTATOR);
                    }
                } else {
                    p.sendMessage(CustomServerUtilv3.getPrefix() + "§cBitte gib einen gültigen Spielernamen ein!");
                }
            }
        } else {
            p.sendMessage(CustomServerUtilv3.getNoPerm());
        }


        return true;
    }
}
