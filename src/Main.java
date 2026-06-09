import database.BudgetDAO;
import database.DatabaseManager;
import database.TransactionDAO;
import model.Budget;
import model.Currency;
import model.Transaction;
import services.FinanceService;

import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        //Following is a test to get transactions count.
        FinanceService financeService = new FinanceService();
        System.out.println("Transactions: " + financeService.getTransactionCount());
        //Following is the test for largestExpense() method.
        System.out.println("Largest Expense: " + financeService.getLargestExpense()
        );
        System.out.println("Average Expense: " + financeService.getAverageExpense());
}
}