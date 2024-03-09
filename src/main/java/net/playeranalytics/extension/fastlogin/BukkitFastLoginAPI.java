package net.playeranalytics.extension.fastlogin;

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
        // Need to wait for the status to become available since the API doesn't provide a Future.
        // https://github.com/plan-player-analytics/Plan/issues/3485
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return plugin.getStatus(playerUUID).getReadableName();
    }
}
