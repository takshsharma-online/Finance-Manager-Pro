package ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import database.TransactionDAO;
import model.Transaction;

public class TransactionView extends VBox {

    public TransactionView() {

        setSpacing(15);//This is the space between the components.
        setPadding(new Insets(20));//Padding around the window.

        Label title = new Label("Transaction Management");//Screen title.

        Label dateLabel = new Label("Date");//Date field.
        TextField dateField = new TextField();
        dateField.setPromptText("YYYY-MM-DD");

        //Following are the codes for type dropdown.
        Label typeLabel = new Label("Type");
        ComboBox<String> typeBox = new ComboBox<>();
        typeBox.getItems().addAll("Income", "Expense");

        //Following are the codes for category dropdown.
        Label categoryLabel = new Label("Category");
        ComboBox<String> categoryBox = new ComboBox<>();
        categoryBox.getItems().addAll(
                "Food",
                "Transport",
                "Housing",
                "Entertainment",
                "Healthcare",
                "Shopping",
                "Bills",
                "Salary",
                "Freelance",
                "Investment",
                "Gift",
                "Bonus",
                "Other"
        );

        //Following are the codes for amount field.
        Label amountLabel = new Label("Amount");
        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        //Following are the codes for description field.
        Label descriptionLabel = new Label("Description");
        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Enter description");

        //Creating a new DAO object.
        TransactionDAO dao = new TransactionDAO();

        //Add transaction button.
        Button addButton = new Button("Add Transaction");

        addButton.setOnAction(event -> {

            try {

                Transaction transaction =
                        new Transaction(
                                0,
                                dateField.getText(),
                                typeBox.getValue(),
                                categoryBox.getValue(),
                                Double.parseDouble(
                                        amountField.getText()
                                ),
                                descriptionField.getText()
                        );

                dao.addTransaction(transaction);

                Alert alert =
                        new Alert(
                                Alert.AlertType.INFORMATION
                        );

                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Transaction added successfully!"
                );

                alert.showAndWait();

                // Clear form after successful save.
                dateField.clear();
                amountField.clear();
                descriptionField.clear();

                typeBox.setValue(null);
                categoryBox.setValue(null);

            } catch (Exception e) {

                Alert alert =
                        new Alert(
                                Alert.AlertType.ERROR
                        );

                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Please enter valid data."
                );

                alert.showAndWait();

                e.printStackTrace();
            }
        });

        // Add everything to screen.
        getChildren().addAll(
                title,
                dateLabel,
                dateField,
                typeLabel,
                typeBox,
                categoryLabel,
                categoryBox,
                amountLabel,
                amountField,
                descriptionLabel,
                descriptionField,
                addButton
        );
    }
}