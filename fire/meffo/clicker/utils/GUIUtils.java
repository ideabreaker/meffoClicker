package fire.meffo.clicker.utils;

import fire.meffo.clicker.managers.UserManager;
import fire.meffo.clicker.objects.User;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GUIUtils {
    public static void Sklep(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9, Util.fix("&8>> &7Sklep"));
        ItemBuilder monety5x = new ItemBuilder(Material.PAPER).setTitle("&8* &75x monety &8*").addLore("&8>> &7Koszt: &6100 pkt").addLore("&8>> &7Co daje?").addLore("&8* &6Dodaje przez 2 minuty 5x wiecej monet").addLore("").addLore("&8>> &7Kliknij aby zakupic ulepszenie!");

        ItemBuilder upgrade1 = new ItemBuilder(Material.STONE_PICKAXE).setTitle("&8* &7Upgrade Kilofa &8*").addLore("&8>> &7Koszt: &625 pkt").addLore("&8>> &7Upgrade na poziom: &62");
        ItemBuilder upgrade2 = new ItemBuilder(Material.IRON_PICKAXE).setTitle("&8* &7Upgrade Kilofa &8*").addLore("&8>> &7Koszt: &675 pkt").addLore("&8>> &7Upgrade na poziom: &63");
        ItemBuilder upgrade3 = new ItemBuilder(Material.DIAMOND_PICKAXE).setTitle("&8* &7Upgrade Kilofa &8*").addLore("&8>> &7Koszt: &6250 pkt").addLore("&8>> &7Upgrade na poziom: &64");
        ItemBuilder brakupgrade = new ItemBuilder(Material.DIAMOND_PICKAXE).setTitle("&8* &7Maksymalny Kilof &8*").addLore("&8>> &7Posiadasz maksymalny poziom kilofa!");

        inv.setItem(4, monety5x.build());
        inv.setItem(5, upgrade1.build());
        User u = UserManager.getUser(p.getName());
        if (u.getKilof() == 2) {
            inv.setItem(5, upgrade2.build());
        } else if (u.getKilof() == 3) {
            inv.setItem(5, upgrade3.build());
        } else if (u.getKilof() == 4) {
            inv.setItem(5, brakupgrade.build());
        }
        p.openInventory(inv);
    }

    public static void Statystyki(Player p) {
        User u = UserManager.getUser(p.getName());
        Inventory inv = Bukkit.createInventory(null, 27, Util.fix("&8>> &7Statystyki"));

        ItemBuilder kopanie = new ItemBuilder(Material.STONE).setTitle("&8* &7Statystyki kopania &8*").addLore("&8>> &7Wykopany Stone: &6" + u.getPunkty()).addLore("&8>> &7Wykopany Iron: &6" + u.getWykopanyIron()).addLore("&8>> &7Wykopany Gold: &6" + u.getWykopanyGold()).addLore("&8>> &7Wykopany Obsydian: &6" + u.getWykopanyObs());
        ItemBuilder stone = new ItemBuilder(Material.STONE).setTitle("&8* &7Stone &8*").addLore("&8>> &7Wykopany stone: &6" + u.getWykopanyStone());
        ItemBuilder iron = new ItemBuilder(Material.IRON_ORE).setTitle("&8* &7Iron &8*").addLore("&8>> &7Wykopany iron: &6" + u.getWykopanyIron());
        ItemBuilder gold = new ItemBuilder(Material.GOLD_ORE).setTitle("&8* &7Gold &8*").addLore("&8>> &7Wykopany gold: &6" + u.getWykopanyGold());
        ItemBuilder obs = new ItemBuilder(Material.OBSIDIAN).setTitle("&8* &7Obsidian &8*").addLore("&8>> &7Wykopany obs: &6" + u.getWykopanyObs());
        ItemBuilder coinsy = new ItemBuilder(Material.PAPER).setTitle("&8* &7Twoje informacje&8 *").addLore("&8>> &7Twoje punkty: &6" + u.getPunkty()).addLore("&8>> &7Twoj aktualny poziom kilofa: &6" + u.getKilof()).addLore("&8>> &7Aktywne ulepszenie 5x monet: &6" + (u.haveMonety5x() ? "Aktywne" : "Nieaktywne"));

        inv.setItem(0, stone.build());
        inv.setItem(1, iron.build());
        inv.setItem(2, gold.build());
        inv.setItem(3, obs.build());
        inv.setItem(26, coinsy.build());
        p.openInventory(inv);
    }
}
