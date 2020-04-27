package fire.meffo.clicker.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;

import java.util.List;

public class Config {
    public static Location spawn;
    public static String host;
    public static int port;
    public static String user;
    public static String database;
    public static String password;

    public static void load(JavaPlugin pl) {
        pl.saveDefaultConfig();
        FileConfiguration config = pl.getConfig();
        host = config.getString("config.database.host");
        user = config.getString("config.database.user");
        password = config.getString("config.database.password");
        database = config.getString("config.database.database");
        port = config.getInt("config.database.port");
        spawn = new Location(Bukkit.getWorld(config.getString("config.spawn.world")), config.getDouble("config.spawn.x"), config.getDouble("config.spawn.y"), config.getDouble("config.spawn.z"));
    }
}
