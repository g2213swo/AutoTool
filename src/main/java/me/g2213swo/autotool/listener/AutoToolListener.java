package me.g2213swo.autotool.listener;

import me.g2213swo.autotool.AutoTool;
import net.william278.husksync.event.BukkitSyncCompleteEvent;
import net.william278.husksync.player.OnlineUser;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class AutoToolListener implements Listener {

    private final AutoTool plugin;

    public AutoToolListener(AutoTool plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        if (event.getInstaBreak()) return;
        Player player = event.getPlayer();
        if (!plugin.isAutoToolEnabled(player)) return;

        plugin.autoTool(player, event.getBlock());
    }

    @EventHandler
    public void onSyncDone(BukkitSyncCompleteEvent event) {
        OnlineUser user = event.getUser();
        Player player = Bukkit.getPlayer(user.uuid);
        if (player == null) return;
        if (plugin.isAutoToolEnabled(player)) {
            plugin.getLogger().warning("AutoTool enabled for " + player.getName());
        } else {
            plugin.getLogger().warning("AutoTool disabled for " + player.getName());
        }
    }
}
