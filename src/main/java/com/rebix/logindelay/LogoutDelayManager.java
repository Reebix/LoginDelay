package com.rebix.logindelay;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class LogoutDelayManager {

    public static HashMap<UUID, Integer> playerTimeHashMap = new HashMap<>();

    public LogoutDelayManager() {

    }

    public boolean isPlayerAllowedToJoin(Player player) {
        if (!playerTimeHashMap.containsKey(player.getUniqueId()) || player.hasPermission("logindelay.bypass"))
            return true;
        return false;
    }

    public void setPlayerTime(Player player, Integer time) {
        playerTimeHashMap.put(player.getUniqueId(), time);
    }

    public Integer getPlayerTime(Player player) {
        return playerTimeHashMap.get(player.getUniqueId());
    }

    public void countdown(UUID player) {
        if (playerTimeHashMap.containsKey(player)) {
            int time = playerTimeHashMap.get(player);
            if (time > 0) {
                playerTimeHashMap.put(player, time - 1);
            } else {
                playerTimeHashMap.remove(player);
            }
        }
    }

    public void tick() {
        for (UUID uuid : playerTimeHashMap.keySet())
            countdown(uuid);
    }
}
