package fire.meffo.clicker.managers;

import fire.meffo.clicker.database.Database;
import fire.meffo.clicker.objects.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static Map<String, User> users = new HashMap();

    public static User getUser(String name) {
        return (User)users.get(name);
    }

    public static void loadUsers()
    {
        ResultSet res = Database.executeQuery("SELECT * FROM `clicker`");
        try {
            while (res.next()) {
                User user = new User(res);
                users.put(user.getName(), user);
            }
            System.out.println("[meffoClicker] Zaladowano " + users.size() + " graczy!");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createUser(String name) {
        users.put(name, new User(name));
        System.out.println("[meffoClicker] Stworzono gracza " + name + "!");
    }
}
