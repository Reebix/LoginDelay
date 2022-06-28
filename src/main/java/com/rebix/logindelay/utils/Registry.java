package com.rebix.logindelay.utils;

import com.rebix.logindelay.Logindelay;
import com.rebix.logindelay.eventlisteners.onPlayerJoinEvent;
import com.rebix.logindelay.eventlisteners.onPlayerLeaveEvent;
import org.bukkit.Bukkit;

public class Registry {

    public Registry() {
        Bukkit.getPluginManager().registerEvents(new onPlayerJoinEvent(), Logindelay.instance);
        Bukkit.getPluginManager().registerEvents(new onPlayerLeaveEvent(), Logindelay.instance);

        SecondTicking.start();
    }
}
