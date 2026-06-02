package database;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseManager {
    private static final String URL =

            "jdbc:sqlite:finance_manager.db";
    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}