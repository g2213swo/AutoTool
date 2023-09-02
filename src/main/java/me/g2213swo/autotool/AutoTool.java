package me.g2213swo.autotool;

import me.g2213swo.autotool.listener.AutoToolListener;
import me.g2213swo.autotool.nms.NMS;
import me.g2213swo.v1_20_1.V1_20_1;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoTool extends JavaPlugin {

    private static AutoTool instance;

    public static AutoTool getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AutoToolListener(this), this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    public void autoTool(Player player, Block block) {
        NMS nms = new V1_20_1();
        nms.autoTool(player, block);
    }
}
