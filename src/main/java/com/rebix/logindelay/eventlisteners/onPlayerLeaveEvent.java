package com.rebix.logindelay.eventlisteners;

import com.rebix.logindelay.Logindelay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.time.LocalTime;

public class onPlayerLeaveEvent implements Listener {

    @EventHandler
    public void PlayerLeaveEvent(org.bukkit.event.player.PlayerQuitEvent event) {
        Logindelay.getLogoutDelayManager().setPlayerTime(event.getPlayer(), LocalTime.now());
        System.out.println("Player " + event.getPlayer().getName() + " has left the server at time: " + LocalTime.now());
    }
}
