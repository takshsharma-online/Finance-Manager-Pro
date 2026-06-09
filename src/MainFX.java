import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ui.DashboardView;

public class MainFX extends Application {
    @Override

    public void start(Stage stage) {
        DashboardView dashboard = new DashboardView();
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