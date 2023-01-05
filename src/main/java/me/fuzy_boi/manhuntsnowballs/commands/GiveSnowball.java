package me.fuzy_boi.manhuntsnowballs.commands;

import me.fuzy_boi.manhuntsnowballs.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class GiveSnowball implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (args.length > 0) {
                    ItemStack item = new ItemStack(Material.SNOWBALL);

                    ItemMeta meta = item.getItemMeta();

                    if (meta != null) {
                        PersistentDataContainer data = meta.getPersistentDataContainer();
                        try {
                            data.set((new NamespacedKey(Main.getPlugin(), "snowball_damage")), PersistentDataType.INTEGER, Integer.parseInt(args[0]));
                            item.setItemMeta(meta);
                            player.getInventory().addItem(item);
                        } catch (NumberFormatException exception ) {
                            player.sendMessage(ChatColor.RED + "Please provide an integer (Number you stupid)");
                        }


                    }

                } else {
                    player.sendMessage(ChatColor.RED + "You are not oped");
                }
            }else {
                player.sendMessage(ChatColor.RED + "Please provide an argument");
            }
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage("You are not a player");
        }
    return true;
    }
}
