package me.fuzy_boi.manhuntsnowballs.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;


public class GiveBook implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta meta = (BookMeta) book.getItemMeta();
                //NBTTagCompound tag = new NBTTagCompound();




                //meta.setTitle("Cool");
                meta.setAuthor("Ur_mom");
                meta.addPage(ChatColor.GOLD + "[put 2 sleep 4ever]" + " the speedrunner at all costs\n" +
                        ChatColor.RED + "Warning: the Speedrunner has something up his sleeve!\n" +
                        "\n" +
                        "Find out by crafting the [Crafting interceptor & Viewer]\n" +
                        "\n" +
                        "Your rocket has an interceptor, but due to budget cuts...\n" +
                        "You still can't see what is intercepted so make it ASAP");
                book.setItemMeta(meta);
                player.getInventory().addItem(book);
            } else {

                player.sendMessage(ChatColor.RED + "You are not oped");
            }
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage("You are not a player");
        }
        return true;




    }

}
