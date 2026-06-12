import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ui.DashboardView;
import ui.TransactionView;

public class MainFX extends Application {
    @Override

    public void start(Stage stage) {
        TransactionView dashboard = new TransactionView();
        Scene scene =
                new Scene(dashboard, 800,600);
        stage.setTitle("Finance Manager Pro");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}