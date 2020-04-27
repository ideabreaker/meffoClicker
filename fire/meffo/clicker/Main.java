package fire.meffo.clicker;

import fire.meffo.clicker.config.Config;
import fire.meffo.clicker.database.Database;
import fire.meffo.clicker.listeners.InventoryClickListener;
import fire.meffo.clicker.listeners.JoinListener;
import fire.meffo.clicker.listeners.PlayerBreakListener;
import fire.meffo.clicker.listeners.PlayerInteractListener;
import fire.meffo.clicker.managers.UserManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        Database.connect();
        Database.executeUpdate("CREATE TABLE IF NOT EXISTS `clicker` (`name` text NOT NULL, `punkty` int NOT NULL, `kilof` int NOT NULL, `monety5x` long NOT NULL, `wykopanystone` int NOT NULL, `wykopanyiron` int NOT NULL, `wykopanygold` int NOT NULL, `wykopanyobs` int NOT NULL);");
        UserManager.loadUsers();
        Config.load(this);

        new JoinListener(this);
        new PlayerInteractListener(this);
        new InventoryClickListener(this);
        new PlayerBreakListener(this);
    }
}
