package net.snapecraft.customserverutil_v3.commands;

import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import net.snapecraft.customserverutil_v3.modules.home.HomeCFG;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.Set;

public class HomeCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player p = (Player) sender;
        if(command.getName().equalsIgnoreCase("home")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("list")) {
                    ConfigurationSection list = HomeCFG.Config.getConfigurationSection("homes." + p.getPlayer());
                    if(list == null) {
                        // No homes
                        p.sendMessage(CustomServerUtilv3.getPrefix() + "§cDu hast keine homes gesetzt.");
                        return true;
                    }
                    Set<String> homes = list.getKeys(false);
                    if(homes.size() == 0) {
                        // No homes
                        p.sendMessage(CustomServerUtilv3.getPrefix() + "§cDu hast keine homes gesetzt.");
                        return true;
                    }
                    String homestr = "";
                    int i = 0;
                    for (String str : homes) {
                        homestr = homestr + str;
                        if(i < (homes.size() - 1)) {
                            homestr = homestr + ", ";
                        }
                    }
                    p.sendMessage(CustomServerUtilv3.getPrefix() + "§6Deine Homes§7: §a" + homestr);
                } else {
                    if (HomeCFG.Config.get("homes." + p.getName() + "." + args[0] + ".X") != null) {
                        p.teleport(HomeCFG.getHomeLoc(p, args[0]));
                        p.sendMessage(CustomServerUtilv3.getPrefix() + "§aTeleportiert!");
                    } else {
                        p.sendMessage(CustomServerUtilv3.getPrefix() + "§cDieses Home existiert nicht. Zum setzen: §r/sethome" + args[0]);
                    }
                }

            } else {
                p.sendMessage(CustomServerUtilv3.getPrefix() + "§cBenutzung: /home <name/list>");
            }
        } if(command.getName().equalsIgnoreCase("sethome")) {
            if(args.length == 1) {
                if(HomeCFG.getHomeAmount(p) <= 3) {
                    HomeCFG.setHome(p, p.getLocation(), args[0]);
                    p.sendMessage( CustomServerUtilv3.getPrefix() + "§aHome §3" + args[0] + " §agesetzt.");

                } else if(p.hasPermission("CustomServerUtil.10homes")) {
                    if(HomeCFG.getHomeAmount(p) <= 10) {
                        HomeCFG.setHome(p, p.getLocation(), args[0]);
                        p.sendMessage( CustomServerUtilv3.getPrefix() + "§aHome §3" + args[0] + " §agesetzt.");
                    } else {
                        p.sendMessage(CustomServerUtilv3.getPrefix() + "§cTrotz deines §6Premium Rangs §cwurden deine maximalen Homes(10) erreicht. Zur Zeit ist aus Platzgründen leider nicht mehr möglich, sorry D:");
                    }
                } else {
                    p.sendMessage(CustomServerUtilv3.getPrefix() + "cDie maximale Anzahl an Homes wurde erreicht. §r Mit dem §6 Premium Rang§r kannst du bis zu 10 Homes festlegen!");
                }
            } else {
                p.sendMessage(CustomServerUtilv3.getPrefix() + "§cBenutzung: /sethome <name>");
            }
        }
        return true;
    }
}
