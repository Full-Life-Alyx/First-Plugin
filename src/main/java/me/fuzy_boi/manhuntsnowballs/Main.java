package me.fuzy_boi.manhuntsnowballs;

import me.fuzy_boi.manhuntsnowballs.Runnables.HomingSnowballs;
import me.fuzy_boi.manhuntsnowballs.listerners.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import static me.fuzy_boi.manhuntsnowballs.crafts.CraftingRecipes.init_crafting;

public final class Main extends JavaPlugin {
    private static Main plugin;
    @Override
    public void onEnable() {

        plugin = this;
        //listeners
        getServer().getPluginManager().registerEvents(new Hit(), this);
        getServer().getPluginManager().registerEvents(new Throw(), this);
        getServer().getPluginManager().registerEvents(new Place(), this);
        getServer().getPluginManager().registerEvents(new Break(), this);
        getServer().getPluginManager().registerEvents(new Move(), this);
        getServer().getPluginManager().registerEvents(new Interact(), this);

        //commands
        //getCommand("givesnowball").setExecutor(new GiveSnowball());
        //getCommand("givebook").setExecutor(new GiveBook());

        //tasks
        //BukkitTask snowball_task = new HomingSnowballs().runTaskLater(this, 1L).
        //crafting
        init_crafting();
    }
    public static Main getPlugin() {
        return plugin;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
