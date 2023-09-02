package me.g2213swo.autotool;

import me.g2213swo.autotool.listener.AutoToolListener;
import me.g2213swo.autotool.nms.NMS;
import me.g2213swo.v1_20_1.V1_20_1;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoTool extends JavaPlugin {

    private static AutoTool instance;

    private static NamespacedKey isEnabledKey;

    public static AutoTool getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
        isEnabledKey = new NamespacedKey(instance, "autotool_enabled");
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AutoToolListener(this), this);
        getServer().getPluginCommand("autotool").setExecutor(new me.g2213swo.autotool.command.AutoToolCmd(this));
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    public void autoTool(Player player, Block block) {
        NMS nms = new V1_20_1();
        nms.autoTool(player, block);
    }

    public void setAutoToolEnabled(Player player, boolean enabled) {
        player.getPersistentDataContainer().set(isEnabledKey, PersistentDataType.BOOLEAN, enabled);
    }

    public boolean isAutoToolEnabled(Player player) {
        return player.getPersistentDataContainer().getOrDefault(isEnabledKey, PersistentDataType.BOOLEAN, false);
    }

}
