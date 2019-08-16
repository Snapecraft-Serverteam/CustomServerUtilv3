package net.snapecraft.customserverutil_v3.modules.tpa;

import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class AcceptTpa {

    public static void acceptTpaByPlayer(Player p, String s) {

        //Player p = Player who sends /tpaccept
        //String s = args[0] of /tpaccept


        if(SendTpa.tpaMap.containsKey(s) && SendTpa.tpaMap.get(s).equalsIgnoreCase(p.getName())) {
            SendTpa.tpaMap.remove(s, p.getName());
            Bukkit.getPlayer(s).sendMessage(CustomServerUtilv3.getPrefix() + "§6" + p.getName() + " §ahat deine Teleportanfrage angenommen!");
            Bukkit.getPlayer(s).teleport(p);
            Bukkit.getPlayer(s).sendMessage(CustomServerUtilv3.getPrefix() + "§aDu wurdest zum Spieler §6" + p.getName() + " §ateleportiert!");
        } else {
            p.sendMessage(CustomServerUtilv3.getPrefix() + "§cDu hast keine Teleportanfrage von diesem Spieler bekommen!");
        }


    }

}
