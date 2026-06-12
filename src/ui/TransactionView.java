package ui;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
public class TransactionView extends VBox {
    public TransactionView(){
        setSpacing(15);//This is the space between the components.
        setPadding(new Insets(20));//Padding around the window.
        Label title = new Label("Transaction Management");//Screen title.
        Label placeholder = new Label("Transaction table will be displayed here.");//Temporary placeholder text.
        getChildren().addAll(title, placeholder);//Add the components to the layout.
    }
}
