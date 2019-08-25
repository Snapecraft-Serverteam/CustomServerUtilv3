package net.snapecraft.customserverutil_v3.commands;

import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player)commandSender;
        if(p.hasPermission("CustomServerUtil.heal")) {
            p.setHealth(20.0);
            p.setFoodLevel(20);
            p.sendMessage(CustomServerUtilv3.prefix + "§aDu bist §6Geheilt");
        } else {
            p.sendMessage(CustomServerUtilv3.noPerm);
        }
        return false;
    }
}

