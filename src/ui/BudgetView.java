package ui;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

import javafx.scene.control.Label;

public class BudgetView extends VBox {
    public BudgetView(){
        setSpacing(15);//Vertical Spacing.
        setPadding(new Insets(20));//Padding around the screen.
        Label title = new Label("Budget Management");//Screen title.
        Label placeholder = new Label("Budget information will be displayed here.");
        getChildren().addAll(title, placeholder);//Add components.
    }
}
