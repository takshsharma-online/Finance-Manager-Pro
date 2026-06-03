package database;
import model.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    public void addTransaction(Transaction transaction) {
        String sql = """
                INSERT INTO transactions
                (date, type, category, amount, description)
                VALUES (?, ?, ?, ?, ?)
                """;
        try (
                Connection conn = DatabaseManager.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, transaction.getDate());
            pstmt.setString(2, transaction.getType());
            pstmt.setString(3, transaction.getCategory());
            pstmt.setDouble(4, transaction.getAmount());
            pstmt.setString(5, transaction.getDescription());
            pstmt.executeUpdate();
            System.out.println("Transaction added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Transaction> getAllTransactions() {
 List<Transaction> transactions = new ArrayList<>();
 String sql = "SELECT * FROM transactions";
        try (
                Connection conn = DatabaseManager.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                Transaction transaction =
                        new Transaction(
                                rs.getInt("id"),
                                rs.getString("date"),
                                rs.getString("type"),
                                rs.getString("category"),
                                rs.getDouble("amount"),
                                rs.getString("description")
                        );
                transactions.add(transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }}