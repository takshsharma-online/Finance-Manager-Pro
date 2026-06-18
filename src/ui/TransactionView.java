package ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import database.TransactionDAO;
import model.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        final int[] selectedId = {0};//Helps remember which transaction is being edited.
//Following are the codes for transaction table.
        TableView<Transaction> transactionTable =
                new TableView<>();
        TableColumn<Transaction, Integer> idColumn =
                new TableColumn<>("ID");
        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );
        TableColumn<Transaction, String> dateColumn =
                new TableColumn<>("Date");
        dateColumn.setCellValueFactory(
                new PropertyValueFactory<>("date")
        );
        TableColumn<Transaction, String> typeColumn =
                new TableColumn<>("Type");
        typeColumn.setCellValueFactory(
                new PropertyValueFactory<>("type")
        );
        TableColumn<Transaction, String> categoryColumn =
                new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(
                new PropertyValueFactory<>("category")
        );

        TableColumn<Transaction, Double> amountColumn =
                new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(
                new PropertyValueFactory<>("amount")
        );
        TableColumn<Transaction, String> descriptionColumn =
                new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(
                new PropertyValueFactory<>("description")
        );
        transactionTable.getColumns().addAll(
                idColumn,
                dateColumn,
                typeColumn,
                categoryColumn,
                amountColumn,
                descriptionColumn

        );

        ObservableList<Transaction> transactions = FXCollections.observableArrayList(dao.getAllTransactions());

        transactionTable.setItems(transactions);
        //Add transaction button.
        Button addButton = new Button("Add Transaction");
        //Delete transaction button.
        Button deleteButton =
                new Button("Delete Selected");
        //Load transaction button.
        Button loadButton = new Button("Load Selected");
//Update transaction button.
        Button updateButton = new Button("Update Transaction");
        //Following is the logic to update transaction.
        updateButton.setOnAction(event -> {
            try {
                Transaction transaction =
                        new Transaction(
                                selectedId[0],
                                dateField.getText(),
                                typeBox.getValue(),
                                categoryBox.getValue(),
                                Double.parseDouble(
                                        amountField.getText()
                                ),
                                descriptionField.getText()
                        );
                dao.updateTransaction(transaction);
                transactions.setAll(
                        dao.getAllTransactions()
                );
                Alert alert =
                        new Alert(
                                Alert.AlertType.INFORMATION
                        );
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Transaction updated successfully!"
                );
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert =
                        new Alert(
                                Alert.AlertType.ERROR
                        );
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Unable to update transaction."
                );
                alert.showAndWait();
            }
        });
//Following is the logic for loading the selected transaction.
        loadButton.setOnAction(event -> {
            Transaction selectedTransaction =
                    transactionTable
                            .getSelectionModel()
                            .getSelectedItem();
            if (selectedTransaction != null) {
                selectedId[0] =
                        selectedTransaction.getId();
                dateField.setText(
                        selectedTransaction.getDate()
                );
                typeBox.setValue(
                        selectedTransaction.getType()
                );
                categoryBox.setValue(
                        selectedTransaction.getCategory()
                );
                amountField.setText(
                        String.valueOf(
                                selectedTransaction.getAmount()
                        )
                );
                descriptionField.setText(
                        selectedTransaction.getDescription()
                );
            } else {
                Alert alert =
                        new Alert(
                                Alert.AlertType.WARNING
                        );
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Please select a transaction."
                );
                alert.showAndWait();
            }
        });
        //Following is the logic for deleting transaction.
        deleteButton.setOnAction(event -> {
            Transaction selectedTransaction =
                    transactionTable
                            .getSelectionModel()
                            .getSelectedItem();
            if (selectedTransaction != null) {
                dao.deleteTransaction(
                        selectedTransaction.getId()
                );
                transactions.setAll(
                        dao.getAllTransactions()
                );
                Alert alert =
                        new Alert(
                                Alert.AlertType.INFORMATION
                        );
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Transaction deleted successfully!"
                );
                alert.showAndWait();
            } else {
                Alert alert =
                        new Alert(
                                Alert.AlertType.WARNING
                        );
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Please select a transaction."
                );
                alert.showAndWait();
            }
        });
//Following is the add button logic
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
                transactions.setAll(dao.getAllTransactions());

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
                addButton,
                deleteButton,
                loadButton,
                updateButton,
                transactionTable
        );
  }
}