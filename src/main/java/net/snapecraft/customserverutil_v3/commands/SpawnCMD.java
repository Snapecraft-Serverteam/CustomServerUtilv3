package net.snapecraft.customserverutil_v3.commands;


import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import net.snapecraft.customserverutil_v3.warp.WarpCfg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player p = (Player) commandSender;

        if(WarpCfg.getWarpLoc("spawn") != null) {
            p.teleport(WarpCfg.getWarpLoc("spawn"));
            p.sendMessage(CustomServerUtilv3.prefix + "§aWillkommen am §6Spawn§a!");
        } else {
            p.sendMessage(CustomServerUtilv3.prefix + "§cDer Spawn wurde noch nicht gesetzt! Bitte sage deinem Admin, dass er einen Warp namens" +
                    " 'spawn' einrichten soll!");

            System.out.println("[CustomServerUtil] Der Spieler " + p.getName() + " möchte sich zum Spawn teleportieren, obwohl dieser noch nicht" +
                    " vorhanden ist!");
        }



        return true;
    }
}
