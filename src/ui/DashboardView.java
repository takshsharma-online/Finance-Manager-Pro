package ui;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
public class DashboardView extends VBox {
    //Following is a Constructor.
    public DashboardView(){
        setSpacing(15);//Sets spacing between the components.
        setPadding(new Insets(20));//Adds padding around the edges of the window.
        Label title = new Label("Finance Manager Pro");//Main Application title.
        Label balance = new Label("Current Balance: $0.00");//Displays current account balance.
        Label income = new Label("Income: $0.00");//Displays total income.
        Label expenses = new Label("Expenses: $0.00");//Displays total expenses.

        //Following codes are responsible for adding all the labels to the VBox.
        //They will appear from top to bottom in the order they are added.
        getChildren().addAll(title, balance, income, expenses);
    }
}
