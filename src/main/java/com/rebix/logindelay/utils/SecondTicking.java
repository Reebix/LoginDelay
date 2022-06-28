package com.rebix.logindelay.utils;

import com.rebix.logindelay.Logindelay;
import com.rebix.logindelay.LogoutDelayManager;
import org.bukkit.Bukkit;

public class SecondTicking {
    public static void start() {
        Bukkit.getScheduler().runTaskTimer(Logindelay.instance, new Runnable() {
            @Override
            public void run() {
                Logindelay.getLogoutDelayManager().tick();
            }
        }, 20L, 20L);
    }
}
