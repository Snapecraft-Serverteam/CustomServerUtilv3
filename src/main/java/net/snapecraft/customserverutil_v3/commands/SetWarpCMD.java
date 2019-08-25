package net.snapecraft.customserverutil_v3.commands;


import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import net.snapecraft.customserverutil_v3.modules.warp.API;
import net.snapecraft.customserverutil_v3.warp.WarpCfg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarpCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;
        if(p.hasPermission("CustomServerUtil.setWarp")) {
            if(args.length == 1) {
                if(!args[0].equalsIgnoreCase("list")) {
                    WarpCfg.addWarp(args[0], p.getLocation(), 0);
                    p.sendMessage(CustomServerUtilv3.prefix + "§aDer Warp wurde gesetzt!");
                } else {
                    p.sendMessage(CustomServerUtilv3.prefix + "§cDu darfst keinen Warp mit dem Namen 'list' erstellen!");
                }

            } else if(args.length == 2) {
                if (API.isInt(args[1])) {
                    if(Integer.parseInt(args[1]) < 50) {
                        WarpCfg.addWarp(args[0], p.getLocation(), Integer.parseInt(args[1]));
                        p.sendMessage(CustomServerUtilv3.prefix + "§aDer Warp wurde erstellt!");
                    } else {
                        p.sendMessage(CustomServerUtilv3.prefix + "§cDie Range darf nicht größer/gleich als 50 sein!");
                    }

                } else {
                    p.sendMessage(CustomServerUtilv3.prefix + "§cBitte gib eine gültige Zahl ein!");
                }
            } else{
                p.sendMessage(CustomServerUtilv3.prefix + "§cBenutzung: /setwarp <name> [range]");
            }
        } else {
            p.sendMessage(CustomServerUtilv3.noPerm);
        }



        return true;
    }
}