package me.fuzy_boi.manhuntsnowballs.listerners;

import me.fuzy_boi.manhuntsnowballs.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class Move implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        //ice king boots
        
        ItemStack item = player.getInventory().getBoots();
        if (item == null) return;
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            PersistentDataContainer data = meta.getPersistentDataContainer();

            if (data.has(new NamespacedKey(Main.getPlugin(), "boots_type"), PersistentDataType.STRING)) {
                String boots_type = data.get(new NamespacedKey(Main.getPlugin(), "boots_type"), PersistentDataType.STRING);
                if (Objects.equals(boots_type, "ice_king")) {
                    // Grab the location of something with rounded coordinate values (no decimals)
                    Location location = player.getLocation().getBlock().getLocation();

                    int radius = 5;

                    for (int x = (radius * -1); x <= radius; x++) {
                        for (int z = (radius * -1); z <= radius; z++) {
                            // Grab block
                            Location loc = new Location(location.getWorld(), location.getBlockX() + x, location.getBlockY() - 1, location.getBlockZ() + z);
                            Block block = loc.getBlock();
                            if (loc.distance(location) > radius)
                                continue; // Outside radius
                            if (loc.getBlock().getType() == Material.WATER || loc.getBlock().getType() == Material.BUBBLE_COLUMN) {
                                loc.getBlock().setType(Material.ICE);
                            } else if (block.getBlockData() instanceof Waterlogged) {
                                ItemStack block_item = new ItemStack(block.getType(), 1);
                                loc.getWorld().dropItemNaturally(loc, block_item);

                            }

                        }
                    }
                }

            }
        }



    }
}