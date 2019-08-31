package net.snapecraft.customserverutil_v3.listener;

import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import net.snapecraft.customserverutil_v3.warp.WarpCfg;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

     @EventHandler
    public void onJoin (PlayerJoinEvent e) {
        if(CustomServerUtilv3.getInstance().getConfig().getBoolean("joinmsg")) {
            String msg = CustomServerUtilv3.getInstance().getConfig().getString("jointxt");
            msg = ChatColor.translateAlternateColorCodes('&', msg);
            msg = msg.replaceAll("PLAYERNAME", e.getPlayer().getDisplayName());
            e.setJoinMessage(msg);
        } else {
            e.setJoinMessage("");
        }
        e.getPlayer().teleport(WarpCfg.getWarpLoc("spawn"));
     }

}
