package net.snapecraft.customserverutil_v3.listener;

import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (CustomServerUtilv3.getInstance().getConfig().getBoolean("leavemsg")) {
            String msg = CustomServerUtilv3.getInstance().getConfig().getString("leavetxt");
            msg = ChatColor.translateAlternateColorCodes('&', msg);
            msg = msg.replaceAll("PLAYERNAME", e.getPlayer().getDisplayName());
            e.setQuitMessage(msg);

        } else {
            e.setQuitMessage("");
        }
    }
}
