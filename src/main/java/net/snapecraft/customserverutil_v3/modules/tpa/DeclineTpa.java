package net.snapecraft.customserverutil_v3.modules.tpa;

import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class DeclineTpa {

    public static void declineTpaByPlayer(Player p, String s) {

        //Player p = Player who sends /tpdecline
        //String s = args[0] of /tpdecline


        if(SendTpa.tpaMap.containsKey(s) && SendTpa.tpaMap.get(s).equalsIgnoreCase(p.getName())) {
            SendTpa.tpaMap.remove(s, p.getName());

            p.sendMessage(CustomServerUtilv3.getPrefix() + "§aDu hast die Anfrage abgelehnt");
            Bukkit.getPlayer(s).sendMessage(CustomServerUtilv3.getPrefix() + "§6" + p.getName() + " §ahat deine Teleportanfrage §cabgelehnt!");

        } else {
            p.sendMessage(CustomServerUtilv3.getPrefix() + "§cDu hast keine Teleportanfrage von diesem Spieler bekommen!");
        }


    }

}
