package com.rebix.logindelay.eventlisteners;

import com.rebix.logindelay.Logindelay;
import com.rebix.logindelay.LogoutDelayManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class onPlayerJoinEvent implements Listener {

    @EventHandler
    public void PlayerJoinEvent(PlayerLoginEvent event) {
        LogoutDelayManager logoutDelayManager = Logindelay.getLogoutDelayManager();
        if(!logoutDelayManager.isPlayerAllowedToJoin(event.getPlayer())) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, Objects.requireNonNull(Logindelay.instance.getConfig().getString("ErrorMessage")).replace("%%seconds%%", logoutDelayManager.getPlayerTime(event.getPlayer()) + ""));
        }
    }
}
