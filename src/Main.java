import database.BudgetDAO;
import database.DatabaseManager;
import database.TransactionDAO;
import model.Budget;
import model.Currency;
import model.Transaction;
import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        //Following is a test for new budget classes.
        BudgetDAO dao= new BudgetDAO();
        Budget foodBudget =
                new Budget(
                        1,
                        "FOOD",
                        400,
                        Currency.GBP
                );
        dao.updateBudget(foodBudget);


    }
}