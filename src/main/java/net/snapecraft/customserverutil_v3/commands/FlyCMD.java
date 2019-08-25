package net.snapecraft.customserverutil_v3.commands;

import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCMD implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings)
    {
        if(strings.length == 0) {
            Player p = (Player)commandSender;
            if (p.hasPermission("CustomLobby.Fly"))
            {
                if (!p.getAllowFlight())
                {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.sendMessage(CustomServerUtilv3.prefix + "§aDu kannst nun fliegen.");
                }
                else
                {
                    p.setFlying(false);
                    p.setAllowFlight(false);
                    p.sendMessage(CustomServerUtilv3.prefix + "§aDu kannst nun §6nicht mehr fliegen.");
                }
            }
            else {
                p.sendMessage(CustomServerUtilv3.noPerm);
            }
        } else if(strings.length == 1) {
            Player target = Bukkit.getPlayer(strings[0]);
            if(commandSender.hasPermission("CustomLoby.FlyOthers")) {
                if(target != null) {

                    if (!target.getAllowFlight())
                    {
                        target.setAllowFlight(true);
                        target.setFlying(true);
                        target.sendMessage(CustomServerUtilv3.prefix + "§aDu kannst nun fliegen.");
                    }
                    else
                    {
                        target.setFlying(false);
                        target.setAllowFlight(false);
                        target.sendMessage(CustomServerUtilv3.prefix + "§aDu kannst nun §6nicht mehr fliegen.");
                    }


                } else {
                    commandSender.sendMessage(CustomServerUtilv3.getPrefix() + " §cSpieler nicht gefunden!");
                }
            }
        } else {
            commandSender.sendMessage(CustomServerUtilv3.getPrefix() + " §cWrong Usage: /fly oder /fly <Name>");
        }

        return true;
    }
}
