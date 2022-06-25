package com.rebix.logindelay;

import com.rebix.logindelay.utils.Registry;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Logindelay extends JavaPlugin {
    static LogoutDelayManager logoutDelayManager = new LogoutDelayManager();
    public static Logindelay instance;

    public static LogoutDelayManager getLogoutDelayManager() {
        return logoutDelayManager;
    }


    @Override
    public void onEnable() {
        instance = this;
        if(getConfig().getString("ErrorMessage") == null)
            getConfig().set("ErrorMessage", "§4You are not allowed to join try in %%seconds%% seconds");
        if(getConfig().get("Delay") == null)
            getConfig().set("Delay", 10L);
        instance.saveConfig();
        new Registry();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
