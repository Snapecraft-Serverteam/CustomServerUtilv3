package net.snapecraft.customserverutil_v3.commands;

import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import net.snapecraft.customserverutil_v3.modules.tpa.AcceptTpa;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AcceptTpaCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;

        if(strings.length == 1) {
            AcceptTpa.acceptTpaByPlayer(p, strings[0]);
        } else {
            p.sendMessage(CustomServerUtilv3.getPrefix() + "§cBenutzung: /tpaccept <Spieler>");
        }



        return true;
    }

}
