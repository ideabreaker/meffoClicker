package fire.meffo.clicker.listeners;

import fire.meffo.clicker.Main;
import fire.meffo.clicker.managers.UserManager;
import fire.meffo.clicker.objects.User;
import fire.meffo.clicker.utils.Util;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakListener implements Listener {
    public PlayerBreakListener(Main main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        e.setCancelled(true);
        Player p = e.getPlayer();
        User u = UserManager.getUser(p.getName());
        Block b = e.getBlock();
        if (p.getItemInHand().getType() == Material.AIR && p.isOp()) {
            e.setCancelled(false);
        }
        if (b.getType() == Material.STONE) {
            u.addWykopanyStone(1);
            if (u.getMonety5x() > System.currentTimeMillis()) {
                u.addPunkty(5);
                Util.sendActionbar(p, Util.fix("&8>> &7Na twoje konto wpadlo 5 punktow! &8(&6DODATEK&8)"));
                return;
            }
            u.addPunkty(1);
            Util.sendActionbar(p, Util.fix("&8>> &7Na twoje konto wpadl 1 punkt!"));
        } else if (b.getType() == Material.IRON_ORE) {
            if ((e.getPlayer().getItemInHand().getType() == Material.STONE_PICKAXE) || (e.getPlayer().getItemInHand().getType() == Material.IRON_PICKAXE) || (e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE) ) {
                u.addWykopanyIron(1);
                if (u.haveMonety5x()) {
                    u.addPunkty(10);
                    Util.sendActionbar(p, Util.fix("&8>> &7Na twoje konto wpadlo 10 punktow! &8(&6DODATEK&8)"));
                    return;
                }
                u.addPunkty(2);
                Util.sendActionbar(p, Util.fix("&8>> &7Na twoje konto wpadly 2 punkty!"));
            } else {
                Util.sendActionbar(p, Util.fix("&8>> &7Nie posiadasz odpowiedniego kilofa!"));
            }
        } else if (b.getType() == Material.GOLD_ORE) {
            if ((e.getPlayer().getItemInHand().getType() == Material.IRON_PICKAXE) || (e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE) ) {
                u.addWykopanyGold(1);
                if (u.haveMonety5x()) {
                    u.addPunkty(25);
                    Util.sendActionbar(p, Util.fix("&8>> &7Na twoje konto wpadlo 25 punktow! &8(&6DODATEK&8)"));
                    return;
                }
                u.addPunkty(5);
                Util.sendActionbar(p, Util.fix("&8>> &7Na twoje konto wpadlo 5 punktow!"));
            } else {
                Util.sendActionbar(p, Util.fix("&8>> &7Nie posiadasz odpowiedniego kilofa!"));
            }
        } else if (b.getType() == Material.OBSIDIAN) {
            if ((e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE) ) {
                u.addWykopanyObs(1);
                if (u.haveMonety5x()) {
                    u.addPunkty(15*5);
                    Util.sendActionbar(p, Util.fix("&8>> &7Na twoje konto wpadlo " + 15*5 + " punktow! &8(&6DODATEK&8)"));
                    return;
                }
                u.addPunkty(15);
                Util.sendActionbar(p, Util.fix("&8>> &7Na twoje konto wpadlo 15 punktow!"));
            } else {
                Util.sendActionbar(p, Util.fix("&8>> &7Nie posiadasz odpowiedniego kilofa!"));
            }
        }
    }
}
