package com.rebix.logindelay.eventlisteners;

import com.rebix.logindelay.Logindelay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.time.LocalTime;
import java.util.Objects;

public class onPlayerLeaveEvent implements Listener {

    @EventHandler
    public void PlayerLeaveEvent(org.bukkit.event.player.PlayerQuitEvent event) {
        Logindelay.getLogoutDelayManager().setPlayerTime(event.getPlayer(), Integer.parseInt(Objects.requireNonNull(Logindelay.instance.getConfig().getString("Delay"))));
        System.out.println("Player " + event.getPlayer().getName() + " has left the server at time: " + LocalTime.now());
    }
}
