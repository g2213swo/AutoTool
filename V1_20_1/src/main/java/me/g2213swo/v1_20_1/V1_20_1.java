package me.g2213swo.v1_20_1;

import me.g2213swo.autotool.nms.NMS;
import net.minecraft.world.item.Item;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_20_R1.block.CraftBlock;
import org.bukkit.craftbukkit.v1_20_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class V1_20_1 implements NMS {
    @Override
    public void autoTool(Player entity, Block block) {
        PlayerInventory inventory = entity.getInventory();
        float highest = 0;
        int highestSlot = -1;
        for (int i = 0; i < 9; i++) {
            ItemStack itemStack = inventory.getItem(i);
            if (itemStack == null || itemStack.getType() == Material.AIR || block.getDrops(itemStack).isEmpty()) {
                continue;
            }
            net.minecraft.world.item.ItemStack nmsItemStack = CraftItemStack.asNMSCopy(itemStack);
            Item nmsItem = nmsItemStack.getItem();

            net.minecraft.world.level.block.state.BlockState nmsBlockState = ((CraftBlock) block).getNMS();
            float destroySpeed = nmsItem.getDestroySpeed(nmsItemStack, nmsBlockState);
            if (destroySpeed > highest) {
                highest = destroySpeed;
                highestSlot = i;
            }
        }
        if (highestSlot == -1) return;
        inventory.setHeldItemSlot(highestSlot);
    }
}
