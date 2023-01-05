package me.fuzy_boi.manhuntsnowballs.listerners;

import me.fuzy_boi.manhuntsnowballs.Main;
import me.fuzy_boi.manhuntsnowballs.Runnables.HomingSnowballs;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitTask;

import java.util.Objects;

public class Throw implements Listener {
    @EventHandler
    public void onProjectileThrownEvent(ProjectileLaunchEvent event) {
        Entity entity = event.getEntity();
        if (!(event.getEntity().getShooter() instanceof Player)) return;
        Player player = (Player) event.getEntity().getShooter();
        if (event.getEntity() instanceof Snowball) {

            if (player != null) {
                //declare item data variables
                ItemStack item = player.getInventory().getItemInMainHand();
                ItemMeta meta = item.getItemMeta();
                if (meta == null) return;
                PersistentDataContainer data = meta.getPersistentDataContainer();

                if (player.getInventory().getItemInOffHand().equals(new ItemStack(Material.SNOWBALL)) || Objects.equals(data.get(new NamespacedKey(Main.getPlugin(), "gun_type"), PersistentDataType.STRING),"golden")) event.setCancelled(true);

                if (data.has(new NamespacedKey(Main.getPlugin(), "snowball_damage"), PersistentDataType.INTEGER)) {
                    int Sdamage = data.get(new NamespacedKey(Main.getPlugin(), "snowball_damage"), PersistentDataType.INTEGER);
                    data.set(new NamespacedKey(Main.getPlugin(), "snowball_damage"), PersistentDataType.INTEGER, Sdamage);
                }
                if (data.has(new NamespacedKey(Main.getPlugin(), "snowball_homing_distance"), PersistentDataType.INTEGER)) {
                    int homing_distance = data.get(new NamespacedKey(Main.getPlugin(), "snowball_homing_distance"), PersistentDataType.INTEGER);
                    data.set(new NamespacedKey(Main.getPlugin(), "snowball_homing_distance"), PersistentDataType.INTEGER, homing_distance);
                    Snowball snowball = (Snowball) entity;
                    BukkitTask homing = new HomingSnowballs(snowball, player).runTaskTimer(Main.getPlugin(), 0L, 1L);
                }
            }

        }
        /*if (event.getEntity() instanceof EnderSignal) {
            if (player != null) {
                player.sendMessage("sus");
                //declare item data variables
                ItemStack item = player.getInventory().getItemInMainHand();
                ItemMeta meta = item.getItemMeta();
                if (meta != null) {
                    PersistentDataContainer data = meta.getPersistentDataContainer();
                    if (data.has(new NamespacedKey(Main.getPlugin(), "weapon_type"), PersistentDataType.STRING)) {
                        String weapon_type = data.get(new NamespacedKey(Main.getPlugin(), "weapon_type"), PersistentDataType.STRING);
                        if (Objects.equals(weapon_type, "eye")) {
                            event.setCancelled(true);
                            Snowball snowball = player.getWorld().spawn(player.getEyeLocation(), Snowball.class);
                            snowball.setShooter(player);
                            snowball.setVelocity(player.getLocation().getDirection().multiply(2));
                        }
                    }
                }
            }
        }*/
        /*ItemMeta offhandMeta = player.getInventory().getItemInMainHand().getItemMeta();




                if (offhandMeta == null) return;



                PersistentDataContainer offhandData = offhandMeta.getPersistentDataContainer();

                //PersistentDataContainer entity_data = entity.getPersistentDataContainer();
                if (data.has(new NamespacedKey(Main.getPlugin(), "ammo_type"), PersistentDataType.STRING)) {
                    String ammoType = data.get(new NamespacedKey(Main.getPlugin(), "ammo_type"), PersistentDataType.STRING);
                    if (Objects.equals(ammoType,"golden_snowball")) {
                        event.setCancelled(true);
                        return;
                    }
                }

                if (offhandData.has(new NamespacedKey(Main.getPlugin(), "ammo_type"), PersistentDataType.STRING)) {
                    String ammoType = offhandData.get(new NamespacedKey(Main.getPlugin(), "ammo_type"), PersistentDataType.STRING);
                    if (Objects.equals(ammoType,"golden_snowball")) {
                        event.setCancelled(true);
                        return;
                    }
                }*/
    }
}
