import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainFX extends Application {
    @Override
    public  void start(Stage stage){
        Label label = new Label("Finance Manager Pro");
        Scene scene = new Scene( new StackPane(label), 600, 400);
        stage.setTitle("Finance Manager Pro");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String [] args){
        launch();
    }
}
