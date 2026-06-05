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

        //Test for deleting transaction.
        TransactionDAO dao = new TransactionDAO();

        dao.deleteTransaction(1);


    }
}