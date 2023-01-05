package me.fuzy_boi.manhuntsnowballs.listerners;

import me.fuzy_boi.manhuntsnowballs.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class Hit implements Listener {
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        //may make null
        Entity hitEntity = event.getHitEntity();
        if(hitEntity instanceof LivingEntity) {
            Entity snowball = event.getEntity();
            if (snowball instanceof Snowball) {

                PersistentDataContainer data = snowball.getPersistentDataContainer();

                LivingEntity l_entity = (LivingEntity) hitEntity;
                if (data.has(new NamespacedKey(Main.getPlugin(), "snowball_damage"), PersistentDataType.INTEGER)) {
                    int Sdamage = data.get(new NamespacedKey(Main.getPlugin(), "snowball_damage"), PersistentDataType.INTEGER);


                    if (l_entity.getHealth() < Sdamage) {
                        l_entity.setHealth(0);
                    } else {
                        l_entity.damage(Sdamage);
                    }

                }
            }
        }

    }
}

