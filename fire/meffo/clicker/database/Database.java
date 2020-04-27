package fire.meffo.clicker.database;

import fire.meffo.clicker.config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private static Connection connection;

    public static void connect() {
        try {
            //connection = DriverManager.getConnection("jdbc:mysql://mysql.titanaxe.com:3306/srv52090?user=srv52090&password=d3QVLa2T");
            connection = DriverManager.getConnection("jdbc:mysql://" + Config.host + ":"+Config.port+"/"+Config.database+"?user="+Config.user+"&password="+Config.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeUpdate(String update)
    {
        try {
            connection.createStatement().executeUpdate(update);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query)
    {
        try {
            return connection.createStatement().executeQuery(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void disconnect()
    {
        if (connection != null) {
            try {
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
