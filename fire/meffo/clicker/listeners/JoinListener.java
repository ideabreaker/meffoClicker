package fire.meffo.clicker.listeners;

import fire.meffo.clicker.Main;
import fire.meffo.clicker.managers.UserManager;
import fire.meffo.clicker.objects.User;
import fire.meffo.clicker.utils.ItemBuilder;
import fire.meffo.clicker.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class JoinListener implements Listener {
    public JoinListener(Main main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        User u = UserManager.getUser(p.getName());
        if (u == null) {
            UserManager.createUser(p.getName());
            p.kickPlayer(Util.fix("&8>> &7Stworzono uzytkownika! Dolacz ponownie na serwer!"));
            return;
        }
        p.getInventory().clear();
        ItemBuilder kilof1 = new ItemBuilder(Material.WOOD_PICKAXE).setTitle("&8* &7Startowy kilof").addLore("&8>> &7Poziom kilofa: &61").addLore("&8>> &7Moze wykopac: &6STONE").addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DIG_SPEED, 1);
        ItemBuilder kilof2 = new ItemBuilder(Material.STONE_PICKAXE).setTitle("&8* &7Amatorski kilof").addLore("&8>> &7Poziom kilofa: &62").addLore("&8>> &7Moze wykopac: &6STONE&7, &6IRONORE").addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DIG_SPEED, 2);
        ItemBuilder kilof3 = new ItemBuilder(Material.IRON_PICKAXE).setTitle("&8* &7Srednio Zaawansowany kilof").addLore("&8>> &7Poziom kilofa: &63").addLore("&8>> &7Moze wykopac: &6STONE&7, &6IRONORE&7, &6GOLDORE").addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DIG_SPEED, 3);
        ItemBuilder kilof4 = new ItemBuilder(Material.DIAMOND_PICKAXE).setTitle("&8* &7Zaawansowany kilof").addLore("&8>> &7Poziom kilofa: &64").addLore("&8>> &7Moze wykopac: &6STONE&7, &6IRONORE&7, &6GOLDORE&7, &6OBSIDIAN").addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DIG_SPEED, 4);
        ItemBuilder sklep = new ItemBuilder(Material.NETHER_STAR).setTitle("&8>> &7Sklep");
        ItemBuilder statystyki = new ItemBuilder(Material.GOLD_NUGGET).setTitle("&8>> &7Statystyki");
        p.getInventory().setItem(8, sklep.build());
        p.getInventory().setItem(7, statystyki.build());
        p.getInventory().setItem(0, kilof1.build());
        if (u.getKilof() == 2) {
            p.getInventory().setItem(0, kilof2.build());
        } else if (u.getKilof() == 3) {
            p.getInventory().setItem(0, kilof3.build());
        } else if (u.getKilof() == 4) {
            p.getInventory().setItem(0, kilof4.build());
        }
        p.getInventory().addItem();
    }
}
