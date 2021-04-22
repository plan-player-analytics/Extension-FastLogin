package com.djrapitops.extension;

import com.djrapitops.plan.extension.NotReadyException;
import com.github.games647.fastlogin.bukkit.FastLoginBukkit;
import org.bukkit.Bukkit;

import java.util.UUID;

public class BukkitFastLoginAPI {

    FastLoginBukkit plugin;

    public BukkitFastLoginAPI() {
        plugin = (FastLoginBukkit) Bukkit.getPluginManager().getPlugin("FastLogin");
        if (plugin == null) throw new NotReadyException();
    }

    public String getPremiumStatus(UUID playerUUID) {
        return plugin.getStatus(playerUUID).getReadableName();
    }
}
