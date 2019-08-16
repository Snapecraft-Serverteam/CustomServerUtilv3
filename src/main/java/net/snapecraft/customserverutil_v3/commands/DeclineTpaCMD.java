package net.snapecraft.customserverutil_v3.commands;

import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import net.snapecraft.customserverutil_v3.modules.tpa.DeclineTpa;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeclineTpaCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;

        if(strings.length == 1) {
            DeclineTpa.declineTpaByPlayer(p, strings[0]);
        } else {
            p.sendMessage(CustomServerUtilv3.prefix + "§cBenutzung: /tpdecline <Spieler>");
        }



        return true;
    }
}
