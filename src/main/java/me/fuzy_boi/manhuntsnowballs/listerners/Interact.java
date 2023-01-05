package me.fuzy_boi.manhuntsnowballs.listerners;

import me.fuzy_boi.manhuntsnowballs.Main;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Interact implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            Player player = event.getPlayer();
            ItemStack itemMainHand = player.getInventory().getItemInMainHand();
            ItemMeta metaMainHand = itemMainHand.getItemMeta();
            //declare item data variables

            if (metaMainHand != null) {



                PersistentDataContainer data = metaMainHand.getPersistentDataContainer();
                if (data.has(new NamespacedKey(Main.getPlugin(), "gun_type"), PersistentDataType.STRING)) {
                    String gunType = data.get(new NamespacedKey(Main.getPlugin(), "gun_type"), PersistentDataType.STRING);
                    if (Objects.equals(gunType, "golden")) {


                        ItemStack snowballItem = player.getInventory().getItemInOffHand();

                        ItemMeta snowballMeta = snowballItem.getItemMeta();

                        if (!snowballItem.equals(new ItemStack(Material.AIR))) {
                            if (snowballMeta == null) return;
                            PersistentDataContainer snowballData = snowballMeta.getPersistentDataContainer();

                            if (snowballData.has(new NamespacedKey(Main.getPlugin(), "ammo_type"), PersistentDataType.STRING)) {
                                String ammoType = snowballData.get(new NamespacedKey(Main.getPlugin(), "ammo_type"), PersistentDataType.STRING);
                                if (Objects.equals(ammoType, "golden_snowball")) {


                                    snowballItem.setAmount(snowballItem.getAmount() - 1);


                                    Location location = player.getEyeLocation();
                                    Vector dir = location.getDirection();
                                    World world = location.getWorld();
                                    ArrayList<LivingEntity> hitEntities = new ArrayList<>();

                                    if (world == null) return;
                                    if (location.getWorld() == null) return;
                                    for (double i = 1; i < 50 /* 10 is the length of the line */; i += 0.5 /* 0.5 is the gap between each particle */) {
                                        dir.multiply(i);
                                        location.add(dir);

                                        List<Entity> tempHitEntities = (List<Entity>) location.getWorld().getNearbyEntities(location, 1, 1, 1);
                                        for (Entity entity : tempHitEntities) {
                                            if (entity instanceof LivingEntity) {
                                                if (!hitEntities.contains(entity))
                                                    hitEntities.add((LivingEntity) entity);
                                            }
                                        }
                                        Particle.DustTransition dust = new Particle.DustTransition(Color.ORANGE, Color.fromRGB(212, 175, 55), 2);
                                        world.spawnParticle(Particle.DUST_COLOR_TRANSITION, location, 1, dust);

                                        location.subtract(dir);
                                        dir.normalize();


                                    }
                                    final int gun_damage = 4;
                                    for (LivingEntity livingEntity : hitEntities) {
                                        if (livingEntity == player) continue;
                                        if (livingEntity.getHealth() < gun_damage) {
                                            livingEntity.setHealth(0);
                                        } else {
                                            livingEntity.damage(gun_damage);
                                            //livingEntity.setHealth(livingEntity.getHealth() - gun_damage);
                                        }
                                    }

                                }
                            }
                        }
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
                        player.sendMessage(ChatColor.DARK_RED + "You need ammo to use this weapon");
                    }
                }


            }
        }
    }
}
