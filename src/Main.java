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

        TransactionDAO dao = new TransactionDAO();
        new Transaction(
                1,
                "2026-06-04",
                "Expense",
                "Food",
                20.00,
                "Updated lunch cost"
        );
        Transaction updatedTransaction =

                new Transaction(

                        1,

                        "2026-06-04",

                        "Expense",

                        "Food",

                        20.00,

                        "Updated lunch cost"

                );
        dao.updateTransaction(updatedTransaction);

        System.out.println(dao.getAllTransactions());
    }
}