package net.snapecraft.customserverutil_v3.listener;

import de.limacity.pepe44.far.events.WorldResetEvent;
import net.snapecraft.customserverutil_v3.CustomServerUtilv3;
import net.snapecraft.customserverutil_v3.warp.WarpCfg;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FixWarpLocation implements Listener {

    @EventHandler
    private void onNewWorld(WorldResetEvent event){
        WarpCfg.removeWarp("Farmwelt");
        Bukkit.getScheduler().runTaskLater(CustomServerUtilv3.getPlugin(CustomServerUtilv3.class), new Runnable() {
            @Override
            public void run() {
                WarpCfg.addWarp("Farmwelt",event.getLocation(),10);
            }
        },20*10);
    }
}
