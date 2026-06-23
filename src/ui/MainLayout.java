package ui;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
public class MainLayout extends BorderPane{//This class controls navigation between screens.
    public MainLayout() {
        // Navigation buttons.
        Button dashboardButton =
                new Button("Dashboard");
        Button transactionButton =
                new Button("Transactions");
        Button budgetButton =
                new Button("Budgets");
        // Navigation bar.
        HBox navigationBar =
                new HBox(10);
        navigationBar.setPadding(
                new Insets(10)
        );
        navigationBar.getChildren().addAll(
                dashboardButton,
                transactionButton,
                budgetButton
        );
        // Places navigation bar at the top
        setTop(navigationBar);
        // Default screen.
        setCenter(
                new DashboardView()
        );
        // Opens dashboard screen.
        dashboardButton.setOnAction(event -> {
            setCenter(
                    new DashboardView()
            );
        });
        // Opens transaction screen.
        transactionButton.setOnAction(event -> {
            setCenter(
                    new TransactionView()
            );
        });
        // Opens budget screen.
        budgetButton.setOnAction(event -> {
            setCenter(
                    new BudgetView());
        });
    }
}


