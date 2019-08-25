package net.snapecraft.customserverutil_v3.warp;


import net.snapecraft.customserverutil_v3.commands.BuildModeCMD;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class WarpProtection implements Listener {
    public Location loc;
    public Integer range;
    @EventHandler
    public void onDestruct(PlayerInteractEvent e) {
        if(!BuildModeCMD.buildModePlayers.contains(e.getPlayer())) {
            if(WarpCfg.ConfigFile.length() > 6) {
                for(String secton : WarpCfg.Config.getConfigurationSection("warps").getKeys(true)) {

                    if(WarpCfg.getWarpLoc(secton) != null) {
                        if(WarpCfg.getWarpLoc(secton).getWorld() == e.getPlayer().getLocation().getWorld()) {
                            loc = WarpCfg.getWarpLoc(secton);
                            range = WarpCfg.getRangeByName(secton);

                            if(loc.distance(e.getPlayer().getLocation()) > 50) {
                                continue;
                            } else {
                                break;
                            }


                        }

                    }
                }
                if(loc.distance(e.getPlayer().getEyeLocation()) <= range) {
                    e.setCancelled(true);
                } else {
                    e.setCancelled(false);
                }
            } else {
                e.setCancelled(false);
            }

        } else {
            e.setCancelled(false);
        }
    }


}