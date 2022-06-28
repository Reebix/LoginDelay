package com.rebix.logindelay;

import org.bukkit.entity.Player;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class LogoutDelayManager {

    public static HashMap<UUID, LocalTime> playerTimeHashMap = new HashMap<>();

    public LogoutDelayManager() {

    }

    public boolean isPlayerAllowedToJoin(Player player) {
        if (!playerTimeHashMap.containsKey(player.getUniqueId()) || player.hasPermission("logindelay.bypass"))
            return true;
        Long delay = Long.valueOf(Objects.requireNonNull(Logindelay.instance.getConfig().getString("Delay")));
        System.out.println(delay);
        LocalTime currentTime = LocalTime.now();
        LocalTime lastTime = getPlayerTime(player).plus(delay, ChronoUnit.SECONDS);

        if(currentTime.isAfter(lastTime)) {
            removePlayerTime(player);
            return true;
        }
        return false;
    }

    public void setPlayerTime(Player player, LocalTime time) {
        playerTimeHashMap.put(player.getUniqueId(), time);
    }

    public LocalTime getPlayerTime(Player player) {
        return playerTimeHashMap.get(player.getUniqueId());
    }

    public void removePlayerTime(Player player) {
        playerTimeHashMap.remove(player);
    }
}
