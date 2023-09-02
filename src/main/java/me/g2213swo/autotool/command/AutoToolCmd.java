package me.g2213swo.autotool.command;

import me.g2213swo.autotool.AutoTool;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AutoToolCmd implements TabExecutor {
    private final AutoTool plugin;

    public AutoToolCmd(AutoTool plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Component.text("Only players can use this command")
                    .color(TextColor.color(0xE74C3C)));
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(Component.text()
                    .append(Component.text("AutoTool is currently ")
                            .color(TextColor.color(0x2ECC71)))
                    .append(Component.text(plugin.isAutoToolEnabled(player) ? "enabled" : "disabled")
                            .color(TextColor.color(0x3498DB))));
            return true;
        }
        switch (args[0]) {
            case "toggle" -> {
                plugin.setAutoToolEnabled(player, !plugin.isAutoToolEnabled(player));

                player.sendMessage(Component.text()
                        .append(Component.text("AutoTool is now ")
                                .color(TextColor.color(0x2ECC71)))
                        .append(Component.text(plugin.isAutoToolEnabled(player) ? "enabled" : "disabled")
                                .color(TextColor.color(0x3498DB))));
            }
            default -> player.sendMessage(Component.text("Usage: /autotool <toggle>").color(TextColor.color(0xE74C3C)));
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return List.of("toggle");
    }
}
