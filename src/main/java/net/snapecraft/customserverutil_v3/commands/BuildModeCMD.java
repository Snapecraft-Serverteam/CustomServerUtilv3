package net.snapecraft.customserverutil_v3.commands;


import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BuildModeCMD implements CommandExecutor {

    public static List<Player> buildModePlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;
        if(p.hasPermission("CustomServerUtil.buildMode")) {
            if (!buildModePlayers.contains(p)) {
                buildModePlayers.add(p);
                p.sendMessage(CustomServerUtilv3.prefix + "§aDu bist nun im §6Baumodus§a!");
            } else {
                buildModePlayers.remove(p);
                p.sendMessage(CustomServerUtilv3.prefix + "§cDu bist nun nicht mehr im §6Baumodus§c!");
            }
        } else {
            p.sendMessage(CustomServerUtilv3.noPerm);
        }
        return true;

    }
}