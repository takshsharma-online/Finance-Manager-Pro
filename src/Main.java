import database.DatabaseManager;
import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        Connection conn = DatabaseManager.connect();
        if(conn != null) {
            System.out.println("Connected!");
        }
    }
}