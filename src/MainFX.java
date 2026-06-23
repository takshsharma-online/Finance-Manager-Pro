import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.TransactionView;
import ui.BudgetView;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) {
        BudgetView budgetView =
                new BudgetView();
        Scene scene =
                new Scene(
                        budgetView,
                        800,
                        600
                );
        stage.setTitle("Finance Manager Pro");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}