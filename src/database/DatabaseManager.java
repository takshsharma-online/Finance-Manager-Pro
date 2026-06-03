package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:finance_manager.db";
    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void createTransactionsTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS transactions (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    date TEXT NOT NULL,
                    type TEXT NOT NULL,
                    category TEXT NOT NULL,
                    amount REAL NOT NULL,
                    description TEXT
                );
                """;
        try (
                Connection conn = connect();
                Statement stmt = conn.createStatement()
        ) {
            stmt.execute(sql);
            System.out.println("Transactions table ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}