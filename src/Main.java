import database.DatabaseManager;
import database.TransactionDAO;
import model.Transaction;
import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        Connection conn = DatabaseManager.connect();
        if(conn != null) {
            System.out.println("Connected!");
        }
        DatabaseManager.createTransactionsTable();
        //Test for transactions.
        Transaction transaction =
                new Transaction(
                        0,
                        "2025-06-02",
                        "Expense",
                        "Food",
                        15.50,
                        "Lunch"
                );
        TransactionDAO dao = new TransactionDAO();
        dao.addTransaction(transaction);
        System.out.println(dao.getAllTransactions());
    }
}