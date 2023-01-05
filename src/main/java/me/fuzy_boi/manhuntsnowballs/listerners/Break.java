package me.fuzy_boi.manhuntsnowballs.listerners;

import me.fuzy_boi.manhuntsnowballs.Main;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class Break implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        World world = block.getWorld();
        

        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            PersistentDataContainer data = meta.getPersistentDataContainer();
            if (data.has(new NamespacedKey(Main.getPlugin(), "pickaxe_type"), PersistentDataType.STRING)) {
                String pickaxe_type = data.get(new NamespacedKey(Main.getPlugin(), "pickaxe_type"), PersistentDataType.STRING);
                if (Objects.equals(pickaxe_type, "ice_king")) {
                    if (block.getType() == Material.FROSTED_ICE || block.getType() == Material.ICE) {
                        block.setType(Material.AIR);
                        world.dropItemNaturally(block.getLocation(), new ItemStack(Material.SNOWBALL));

                    }
                    event.setCancelled(true);
                }
            }
        }
    }
}
