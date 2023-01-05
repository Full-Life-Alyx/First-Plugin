package me.fuzy_boi.manhuntsnowballs.listerners;

import me.fuzy_boi.manhuntsnowballs.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class Place implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();


        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        Block block = event.getBlock();
        Location location = block.getLocation();
        if (meta != null) {
            PersistentDataContainer data = meta.getPersistentDataContainer();
            if (data.has(new NamespacedKey(Main.getPlugin(), "block_type"), PersistentDataType.STRING)) {
                String bucket_type = data.get(new NamespacedKey(Main.getPlugin(), "block_type"), PersistentDataType.STRING);

                if (Objects.equals(bucket_type, "crafting")) {
                    for (int i = 100; i <= 108; i++) {
                        ItemStack item1 = new ItemStack(Material.STICK);
                        ItemMeta meta1 = item.getItemMeta();
                        if (meta1 == null) continue;
                        meta1.setCustomModelData(i);
                        item1.setItemMeta(meta1);
                        location.getWorld().dropItemNaturally(location, item1);
                    }
                    }
                }
            }
        }

    }

