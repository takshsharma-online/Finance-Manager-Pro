package ui;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import services.FinanceService;
public class DashboardView extends VBox {
    public DashboardView() {
        // Creates FinanceService object so we can access calculations.
        FinanceService financeService = new FinanceService();
        
        // Space between components.
        setSpacing(15);

        // Padding around the screen.
        setPadding(new Insets(20));

        // Dashboard title.
        Label title = new Label("Finance Manager Pro");

        // Current Balance
        Label balanceTitle = new Label("Current Balance");
        Label balanceValue = new Label("£" + financeService.getCurrentBalance());

        // Total Income
        Label incomeTitle = new Label("Income");
        Label incomeValue = new Label("£" + financeService.getTotalIncome());

        // Total Expenses
        Label expenseTitle = new Label("Expenses");
        Label expenseValue = new Label("£" + financeService.getTotalExpense());
        // Transaction Count
        Label transactionTitle = new Label("Transactions");
        Label transactionValue = new Label(String.valueOf(financeService.getTransactionCount()));

        // Following codes add all labels to dashboard.
        getChildren().addAll(
                title,
                balanceTitle,
                balanceValue,
                incomeTitle,
                incomeValue,
                expenseTitle,
                expenseValue,
                transactionTitle,
                transactionValue);
    }
}