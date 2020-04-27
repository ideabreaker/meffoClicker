package fire.meffo.clicker.listeners;

import fire.meffo.clicker.Main;
import fire.meffo.clicker.managers.UserManager;
import fire.meffo.clicker.objects.User;
import fire.meffo.clicker.utils.DataUtil;
import fire.meffo.clicker.utils.ItemBuilder;
import fire.meffo.clicker.utils.Util;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    public InventoryClickListener(Main main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory().getTitle().equalsIgnoreCase(Util.fix("&8>> &7Sklep"))) {
            e.setCancelled(true);
            Player p = (Player)e.getWhoClicked();
            User u = UserManager.getUser(p.getName());
            if (e.getSlot() == 4) {
                if (u.getMonety5x() > System.currentTimeMillis()) {
                    Util.sendActionbar(p, Util.fix("&8>> &7Posiadasz juz zakupiony ten dodatek!"));
                    p.closeInventory();
                    return;
                }
                if (u.getPunkty() > 99) {
                    u.setPunkty(u.getPunkty() - 100);
                    u.setMonety5x(DataUtil.parseDateDiff("2m", true));
                    u.update();
                    Util.sendActionbar(p, Util.fix("&8>> &7Zakupiono &65x monet na 2 minuty &7biegnij kopac!"));
                    p.closeInventory();
                } else {
                    Util.sendActionbar(p, Util.fix("&8>> &7Nie posiadasz &6100pkt&7! Potrzebujesz jeszcze &6" + (u.getPunkty() - 100) + "pkt").replace("-", ""));
                }
                p.closeInventory();
            }
            if (e.getSlot() == 5) {
                if (e.getCurrentItem().getType() == Material.STONE_PICKAXE) {
                    if (u.getPunkty() > 24) {
                        ItemBuilder kilof2 = new ItemBuilder(Material.STONE_PICKAXE).setTitle("&8* &7Amatorski kilof").addLore("&8>> &7Poziom kilofa: &62").addLore("&8>> &7Moze wykopac: &6STONE&7, &6IRONORE").addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DIG_SPEED, 2);
                        p.getInventory().setItem(0, kilof2.build());
                        u.setPunkty(u.getPunkty() - 25);
                        u.setKilof(2);
                        u.update();
                        Util.sendActionbar(p, Util.fix("&8>> &7Zakupiles upgrade do kilofa! Posiadasz aktualnie poziom &62"));
                        p.closeInventory();
                        return;
                    }
                    Util.sendActionbar(p, Util.fix("&8>> &7Nie posiadasz &625 pkt&7! Potrzebujesz jeszcze &6" + (u.getPunkty() - 25) + "pkt").replace("-", ""));
                }
                if (e.getCurrentItem().getType() == Material.IRON_PICKAXE) {
                    if (u.getPunkty() > 74) {
                        ItemBuilder kilof3 = new ItemBuilder(Material.IRON_PICKAXE).setTitle("&8* &7Srednio Zaawansowany kilof").addLore("&8>> &7Poziom kilofa: &63").addLore("&8>> &7Moze wykopac: &6STONE&7, &6IRONORE&7, &6GOLDORE").addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DIG_SPEED, 3);
                        p.getInventory().setItem(0, kilof3.build());
                        u.setPunkty(u.getPunkty() - 75);
                        u.setKilof(3);
                        u.update();
                        Util.sendActionbar(p, Util.fix("&8>> &7Zakupiles upgrade do kilofa! Posiadasz aktualnie poziom &63"));
                        p.closeInventory();
                        return;
                    }
                    Util.sendActionbar(p, Util.fix("&8>> &7Nie posiadasz &675 pkt&7! Potrzebujesz jeszcze &6" + (u.getPunkty() - 75) + "pkt").replace("-", ""));
                }
                if (e.getCurrentItem().getType() == Material.DIAMOND_PICKAXE) {
                    if (u.getPunkty() > 249) {
                        ItemBuilder kilof4 = new ItemBuilder(Material.DIAMOND_PICKAXE).setTitle("&8* &7Zaawansowany kilof").addLore("&8>> &7Poziom kilofa: &64").addLore("&8>> &7Moze wykopac: &6STONE&7, &6IRONORE&7, &6GOLDORE&7, &6OBSIDIAN").addEnchantment(Enchantment.DURABILITY, 10).addEnchantment(Enchantment.DIG_SPEED, 4);
                        p.getInventory().setItem(0, kilof4.build());
                        u.setPunkty(u.getPunkty() - 250);
                        u.setKilof(4);
                        u.update();
                        Util.sendActionbar(p, Util.fix("&8>> &7Zakupiles upgrade do kilofa! Posiadasz aktualnie poziom &64"));
                        p.closeInventory();
                        return;
                    }
                    Util.sendActionbar(p, Util.fix("&8>> &7Nie posiadasz &6250 pkt&7! Potrzebujesz jeszcze &6" + (u.getPunkty() - 250) + "pkt").replace("-", ""));
                }
            }
        }

        if (e.getInventory().getTitle().equalsIgnoreCase(Util.fix("&8>> &7Statystyki"))) {
            e.setCancelled(true);
        }
    }
}
