package me.fuzy_boi.manhuntsnowballs.Runnables;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.HashMap;
import java.util.List;

public class HomingSnowballs extends BukkitRunnable {
    Snowball snowball;
    Player player;
    public HomingSnowballs(Snowball Isnowball, Player Iplayer) {
        snowball = Isnowball;
        player = Iplayer;
    }

    @Override
    public void run() {

        if (!snowball.isValid()) {
            cancel();
        }


        Location location = snowball.getLocation();
        HashMap<Double,Player> targetCandidates = new HashMap<>();

        if (location.getWorld() == null)
            return;


        List<Entity> nearbyEntities = (List<Entity>) location.getWorld().getNearbyEntities(location, 3,3,3);

        for (Entity entity : nearbyEntities) {
            if (entity instanceof Player) {
                if (entity != player)
                targetCandidates.put(entity.getLocation().distance(snowball.getLocation()),(Player) entity);
            }
        }
        double lowest = 0;
        for (double i : targetCandidates.keySet()) {
            if (lowest < i) {
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1);
                lowest = i;
            }

        }

        if (!targetCandidates.isEmpty()) {
            Player target = targetCandidates.get(lowest);

            snowball.setVelocity(target.getLocation().toVector().subtract(snowball.getLocation().toVector()));

        }
    }

}
