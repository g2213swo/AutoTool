package me.g2213swo.autotool.listener;

import me.g2213swo.autotool.AutoTool;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class AutoToolListener implements Listener {

    private final AutoTool plugin;

    public AutoToolListener(AutoTool plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent e) {
        if (e.getInstaBreak()) return;
        plugin.autoTool(e.getPlayer(), e.getBlock());
    }

}
