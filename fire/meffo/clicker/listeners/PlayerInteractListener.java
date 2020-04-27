package fire.meffo.clicker.listeners;

import fire.meffo.clicker.Main;
import fire.meffo.clicker.utils.GUIUtils;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class PlayerInteractListener implements Listener {
    public PlayerInteractListener(Main main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getPlayer().getItemInHand().getType() == Material.NETHER_STAR) {
            GUIUtils.Sklep(e.getPlayer());
        }
        if (e.getPlayer().getItemInHand().getType() == Material.GOLD_NUGGET) {
            GUIUtils.Statystyki(e.getPlayer());
        }
        else if (e.getPlayer().getItemInHand().getType() == Material.SUGAR) {
            e.getPlayer().setVelocity(new Vector(0, 1, 0));
        }
    }
}
