import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.MainLayout;
public class MainFX extends Application {
    @Override
    public void start(Stage stage) {
        MainLayout mainLayout =
                new MainLayout();
        Scene scene =
                new Scene(
                        mainLayout,
                        1000, 700
                );
        stage.setTitle("Finance Manager Pro");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}