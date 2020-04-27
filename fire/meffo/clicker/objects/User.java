package fire.meffo.clicker.objects;

import fire.meffo.clicker.database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String name;
    private int punkty;
    private int kilof;
    private long monety5x;
    private int wykopanystone;
    private int wykopanyiron;
    private int wykopanygold;
    private int wykopanyobs;

    public User(String name) {
        this.name = name;
        insert();
    }

    public User(ResultSet rs) throws SQLException {
        this.name = rs.getString("name");
        this.punkty = rs.getInt("punkty");
        this.kilof = rs.getInt("kilof");
        this.monety5x = rs.getLong("monety5x");
    }

    public String getName() {
        return this.name;
    }

    public int getPunkty() {
        return this.punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
    }

    public void addPunkty(int ilosc) {
        this.punkty += ilosc;
        update();
    }

    public int getKilof() {
        return this.kilof;
    }

    public void setKilof(int kilof) {
        this.kilof = kilof;
    }

    public long getMonety5x() {
        return this.monety5x;
    }

    public void setMonety5x(long monety5x) {
        this.monety5x = monety5x;
    }

    public boolean haveMonety5x() {
        if (monety5x > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public int getWykopanyStone() {
        return this.wykopanystone;
    }

    public void addWykopanyStone(int ilosc) {
        this.wykopanystone += ilosc;
        update();
    }

    public int getWykopanyIron() {
        return this.wykopanyiron;
    }

    public void addWykopanyIron(int ilosc) {
        this.wykopanyiron += ilosc;
        update();
    }

    public int getWykopanyGold() {
        return this.wykopanygold;
    }

    public void addWykopanyGold(int ilosc) {
        this.wykopanygold += ilosc;
        update();
    }

    public int getWykopanyObs() {
        return this.wykopanyobs;
    }

    public void addWykopanyObs(int ilosc) {
        this.wykopanyobs += ilosc;
        update();
    }



    public void update() {
        Database.executeUpdate("UPDATE `clicker` SET `kilof` = '" + this.kilof + "', `punkty` = '" + this.punkty + "', `monety5x` = '" + this.monety5x + "', `wykopanystone` = '" + this.wykopanystone + "', `wykopanyiron` = '" + this.wykopanyiron + "', `wykopanygold` = '" + this.wykopanygold + "', `wykopanyobs` = '" + this.wykopanyobs + "' WHERE `name` = '" + this.name + "'");
    }

    public void insert() {
        Database.executeUpdate("INSERT INTO `clicker` (`name`, `punkty`, `kilof`, `monety5x`, `wykopanystone`, `wykopanyiron`, `wykopanygold`, `wykopanyobs`) VALUES ('" + this.name + "','" + this.punkty + "','" + this.kilof + "','" + this.monety5x + "','" + this.wykopanystone + "','" + this.wykopanyiron + "','" + this.wykopanygold + "','" + this.wykopanyobs + "');");
    }
}
