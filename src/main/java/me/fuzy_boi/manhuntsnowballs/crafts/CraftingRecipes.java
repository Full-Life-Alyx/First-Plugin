package me.fuzy_boi.manhuntsnowballs.crafts;

import me.fuzy_boi.manhuntsnowballs.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CraftingRecipes {

    public static void init_crafting() {
        rocky_snowball();
        spike_snowball();
        bucketSnow();
        iceKingSlippers();
        iceKingPickaxe();
        goldenSniper();
        golden_snowball();
        diamond_snowball();
        craftingOby();

    }

    private static void rocky_snowball() {
        //ItemStack
        ItemStack item = new ItemStack(Material.SNOWBALL, 4);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            PersistentDataContainer data = meta.getPersistentDataContainer();
            data.set((new NamespacedKey(Main.getPlugin(), "snowball_damage")), PersistentDataType.INTEGER, 1);
            meta.setCustomModelData(100);
            meta.setDisplayName(ChatColor.RESET + "Rocky Snowball");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RESET + "This snowball does damage,");
            lore.add(ChatColor.RESET + "unlike other snowballs");
            lore.add("");
            lore.add(ChatColor.RESET + "" + ChatColor.GRAY + "+1 snowball damage");
            meta.setLore(lore);
        }
        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("snowball_rocky"), item);

        recipe.shape("_S_"
                    , "SCS"
                    , "_S_");
        recipe.setIngredient('S', Material.SNOWBALL);
        recipe.setIngredient('C', Material.COBBLESTONE);
        recipe.setIngredient('_', Material.AIR);

        Bukkit.getServer().addRecipe(recipe);
    }
    private static void spike_snowball() {
        //ItemStack
        ItemStack item = new ItemStack(Material.SNOWBALL);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            PersistentDataContainer data = meta.getPersistentDataContainer();
            data.set((new NamespacedKey(Main.getPlugin(), "snowball_damage")), PersistentDataType.INTEGER, 3);
            meta.setCustomModelData(101);
            meta.setDisplayName(ChatColor.RESET + "Spiked Snowball");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RESET + "It hurts a lot more when you get");
            lore.add(ChatColor.RESET + "hit by this snowball");
            lore.add("");
            lore.add(ChatColor.RESET + "" + ChatColor.GRAY + "+3 snowball damage");
            meta.setLore(lore);
        }
        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("snowball_spike"), item);

        recipe.shape("_I_"
                , "ISI"
                , "_I_");
        recipe.setIngredient('I', Material.IRON_NUGGET);
        recipe.setIngredient('S', Material.SNOWBALL);
        recipe.setIngredient('_', Material.AIR);

        Bukkit.getServer().addRecipe(recipe);
    }
    private static void golden_snowball() {
        //ItemStack
        ItemStack item = new ItemStack(Material.SNOWBALL);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            PersistentDataContainer data = meta.getPersistentDataContainer();
            data.set((new NamespacedKey(Main.getPlugin(), "ammo_type")), PersistentDataType.STRING, "golden_snowball");
            data.set((new NamespacedKey(Main.getPlugin(), "snowball_damage")), PersistentDataType.INTEGER, 2);
            meta.setCustomModelData(102);
            meta.setDisplayName(ChatColor.RESET + "Golden Snowball");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RESET + "This snowball barely does any damage");
            lore.add(ChatColor.RESET + "Hint: It's ammo for a specific weapon");
            meta.setLore(lore);
        }
        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("snowball_gold"), item);

        recipe.shape("_G_"
                , "GSG"
                , "_G_");
        recipe.setIngredient('G', Material.GOLD_NUGGET);
        recipe.setIngredient('S', Material.SNOWBALL);
        recipe.setIngredient('_', Material.AIR);

        Bukkit.getServer().addRecipe(recipe);
    }
    private static void diamond_snowball() {
        //ItemStack
        ItemStack item = new ItemStack(Material.SNOWBALL);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            PersistentDataContainer data = meta.getPersistentDataContainer();
            data.set((new NamespacedKey(Main.getPlugin(), "snowball_damage")), PersistentDataType.INTEGER, 4);
            data.set((new NamespacedKey(Main.getPlugin(), "snowball_homing_distance")), PersistentDataType.INTEGER, 10);

            meta.setCustomModelData(103);
            meta.setDisplayName(ChatColor.RESET + "Diamond Snowball");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RESET + "This snowball is very scary,");
            lore.add(ChatColor.RESET + "It's homing...");
            lore.add("");
            lore.add(ChatColor.RESET + "" + ChatColor.GRAY + "+4 snowball damage");
            meta.setLore(lore);
        }
        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("snowball_diamond"), item);

        recipe.shape("SSS"
                , "SDS"
                , "SSS");
        recipe.setIngredient('D', Material.DIAMOND);
        recipe.setIngredient('S', Material.SNOWBALL);

        Bukkit.getServer().addRecipe(recipe);
    }
    private static void bucketSnow() {
        /*ItemStack item = new ItemStack(Material.POWDER_SNOW_BUCKET);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            //nbt
            PersistentDataContainer data = meta.getPersistentDataContainer();
            data.set((new NamespacedKey(Main.getPlugin(), "bucket_type")), PersistentDataType.STRING, "snow");
            //display
            meta.setDisplayName(ChatColor.RESET + "Bucket of Snow");
            meta.setLore(Collections.singletonList(ChatColor.RESET + "This is not a bucket of powder snow"));
        }


        item.setItemMeta(meta);*/

        ItemStack item = new ItemStack(Material.SNOW_BLOCK);
        ShapelessRecipe recipe_sl = new ShapelessRecipe(NamespacedKey.minecraft("easy_snow"), item);
        recipe_sl.addIngredient(1, Material.WATER_BUCKET);
        recipe_sl.addIngredient(1, Material.SNOWBALL);



        ShapedRecipe recipe_s = new ShapedRecipe(NamespacedKey.minecraft("hard_snow"), item);
        recipe_s.shape("CIC"
                , "IBI"
                , "CIC");
        recipe_s.setIngredient('I', Material.IRON_INGOT);
        recipe_s.setIngredient('C', Material.COAL);
        recipe_s.setIngredient('B', Material.WATER_BUCKET);

        Bukkit.getServer().addRecipe(recipe_s);
        Bukkit.getServer().addRecipe(recipe_sl);


    }
    private static void craftingOby() {
        ItemStack item = new ItemStack(Material.CRYING_OBSIDIAN);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            //nbt
            PersistentDataContainer data = meta.getPersistentDataContainer();
            data.set((new NamespacedKey(Main.getPlugin(), "block_type")), PersistentDataType.STRING, "crafting");
            //display
            meta.setDisplayName(ChatColor.RESET + "Obsidian that knows");
            meta.setLore(Collections.singletonList(ChatColor.RESET + "Place me down"));
        }


        item.setItemMeta(meta);

        //ItemStack item = new ItemStack(Material.SNOW_BLOCK);

        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("obsidian_crafting"), item);
        recipe.shape("NBN"
                , "QOQ"
                , "bBb");
        recipe.setIngredient('b', Material.BLACKSTONE);
        recipe.setIngredient('O', Material.OBSIDIAN);
        recipe.setIngredient('B', Material.BASALT);
        recipe.setIngredient('N', Material.NETHERRACK);
        recipe.setIngredient('Q', Material.QUARTZ);


        Bukkit.getServer().addRecipe(recipe);


    }
    private static void iceKingSlippers() {
        ItemStack item = new ItemStack(Material.IRON_BOOTS);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            PersistentDataContainer data = meta.getPersistentDataContainer();
            data.set((new NamespacedKey(Main.getPlugin(), "boots_type")), PersistentDataType.STRING, "ice_king");


            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.setDisplayName(ChatColor.RESET + "" + ChatColor.AQUA + ChatColor.BOLD + "Ice King's Slippers");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RESET + "Works great with the Ice King's Pickaxe");
            lore.add(ChatColor.RESET + "Hold sneak to make nearby ice unmeltable");
            meta.setLore(lore);
        }
        item.setItemMeta(meta);
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("ice_king_boots"), item);

        recipe.shape("LLL"
                , "WBW"
                , "SSS");
        recipe.setIngredient('B', Material.IRON_BOOTS);
        recipe.setIngredient('L', Material.LAPIS_LAZULI);
        recipe.setIngredient('W', Material.WHITE_WOOL);
        recipe.setIngredient('S', Material.SNOWBALL);

        Bukkit.getServer().addRecipe(recipe);
    }
    private static void iceKingPickaxe() {
        ItemStack item = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            PersistentDataContainer data = meta.getPersistentDataContainer();
            data.set((new NamespacedKey(Main.getPlugin(), "pickaxe_type")), PersistentDataType.STRING, "ice_king");


            meta.addEnchant(Enchantment.DIG_SPEED, 100, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.setUnbreakable(true);
            meta.setDisplayName(ChatColor.RESET + "" + ChatColor.AQUA + ChatColor.BOLD + "Ice King's Pickaxe");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RESET + "For every ice you break, you get one snowball!");
            lore.add(ChatColor.RESET + "Works great with the Ice King's Slippers");
            meta.setLore(lore);

        }
        item.setItemMeta(meta);
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("ice_king_pickaxe"), item);

        recipe.shape("SDS"
                , "GLG"
                , "GLG");
        recipe.setIngredient('G', Material.GLOW_LICHEN);
        recipe.setIngredient('L', Material.LIGHTNING_ROD);
        recipe.setIngredient('D', Material.DIAMOND);
        recipe.setIngredient('S', Material.SNOWBALL);

        Bukkit.getServer().addRecipe(recipe);
    }
    private static void goldenSniper() {
        ItemStack item = new ItemStack(Material.GOLDEN_HOE);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            //persistent data
            PersistentDataContainer data = meta.getPersistentDataContainer();
            data.set((new NamespacedKey(Main.getPlugin(), "gun_type")), PersistentDataType.STRING, "golden");
            meta.setCustomModelData(100);
            //lore
            meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BOLD + "" + ChatColor.GOLD + "Golden Snowball Launcher");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RESET + "This gun really packs a punch!");
            lore.add("");
            lore.add(ChatColor.RESET + "" + ChatColor.GRAY + "Wall break");
            lore.add(ChatColor.RESET + "" + ChatColor.GRAY + "+5 gun damage");
            lore.add(ChatColor.RESET + "" + ChatColor.GRAY + "(requires golden snowballs");
            lore.add(ChatColor.RESET + "" + ChatColor.GRAY + "to be in the offhand slot)");

            meta.setLore(lore);

            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);

        }
        item.setItemMeta(meta);
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("golden_sniper"), item);

        recipe.shape("GGG"
                , "DNN"
                , "BLG");
        recipe.setIngredient('G', Material.GLOWSTONE_DUST);
        recipe.setIngredient('D', Material.DIAMOND);
        recipe.setIngredient('N', Material.NETHER_BRICK);
        recipe.setIngredient('B', Material.BLAZE_ROD);
        recipe.setIngredient('L', Material.LEVER);

        Bukkit.getServer().addRecipe(recipe);
    }
    /*private static void frozenEye() {
        ItemStack item = new ItemStack(Material.ENDER_EYE);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            PersistentDataContainer data = meta.getPersistentDataContainer();
            data.set((new NamespacedKey(Main.getPlugin(), "weapon_type")), PersistentDataType.STRING, "eye");


            meta.addEnchant(Enchantment.LUCK, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.setDisplayName(ChatColor.RESET + "" + ChatColor.BLUE + ChatColor.BOLD + "The Frozen Eye");
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.RESET + "This is basically a snowball machine gun");
            meta.setLore(lore);

        }
        item.setItemMeta(meta);
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("frozen_eye"), item);

        recipe.shape("SSS"
                , "DED"
                , "SSS");
        recipe.setIngredient('E', Material.ENDER_EYE);
        recipe.setIngredient('D', Material.DIAMOND);
        recipe.setIngredient('S', Material.SNOWBALL);

        Bukkit.getServer().addRecipe(recipe);
    }*/


}
