import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.TransactionView;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) {
        TransactionView transactionView =
                new TransactionView();
        Scene scene =
                new Scene(
                        transactionView,
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