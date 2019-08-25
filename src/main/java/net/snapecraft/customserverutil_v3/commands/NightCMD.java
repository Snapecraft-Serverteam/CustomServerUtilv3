package net.snapecraft.customserverutil_v3.commands;

import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NightCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        if (p.hasPermission("CustomServerUtil.time")) {
            p.getLocation().getWorld().setTime(16000);
            p.sendMessage(CustomServerUtilv3.prefix + "§aEs ist nun §6Nacht!");


        } else {
            p.sendMessage(CustomServerUtilv3.getNoPerm());
        }
        return true;
    }
}
