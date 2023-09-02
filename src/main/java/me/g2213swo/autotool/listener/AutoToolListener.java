package me.g2213swo.autotool.listener;

import me.g2213swo.autotool.AutoTool;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

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
}
