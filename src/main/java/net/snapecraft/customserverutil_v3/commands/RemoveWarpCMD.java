package net.snapecraft.customserverutil_v3.commands;


import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import net.snapecraft.customserverutil_v3.warp.WarpCfg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveWarpCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player)commandSender;
        if(p.hasPermission("CustomServerUtil.removeWarp")) {
            if(strings.length == 1) {
                WarpCfg.removeWarp(strings[0]);
                p.sendMessage(CustomServerUtilv3.prefix + "§aDer Warp wurde erfolgreich gelöscht!");
            } else {
                p.sendMessage(CustomServerUtilv3.prefix + "§cBenutzung: /removewarp <name>");
            }
        } else {
            p.sendMessage(CustomServerUtilv3.noPerm);
        }
        return true;
    }
}