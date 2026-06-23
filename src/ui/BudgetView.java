package ui;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import database.BudgetDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Budget;
import model.Currency;

public class BudgetView extends VBox {
    public BudgetView() {
        setSpacing(15);//This is the space between the components.
        setPadding(new Insets(20));//Padding around the window.
        Label title = new Label("Budget Management");//Screen title.
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
                "Education",
                "Savings",
                "Other"
        );

        //Following are the codes for monthly limit field.
        Label monthlyLimitLabel = new Label("Monthly Limit");
        TextField monthlyLimitField = new TextField();
        monthlyLimitField.setPromptText("Enter monthly limit");

        //Following are the codes for currency dropdown.
        Label currencyLabel = new Label("Currency");
        ComboBox<Currency> currencyBox = new ComboBox<>();
        currencyBox.getItems().addAll(
                Currency.GBP,
                Currency.USD,
                Currency.EUR,
                Currency.INR
        );
        //Creating a new DAO object.
        BudgetDAO dao = new BudgetDAO();
        //Following are the codes for budget table.
        TableView<Budget> budgetTable = new TableView<>();
        TableColumn<Budget, Integer> idColumn =
                new TableColumn<>("ID");
        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        TableColumn<Budget, String> categoryColumn =
                new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(
                new PropertyValueFactory<>("category")
        );
        TableColumn<Budget, Double> limitColumn =
                new TableColumn<>("Monthly Limit");
        limitColumn.setCellValueFactory(
                new PropertyValueFactory<>("monthlyLimit")
        );
        TableColumn<Budget, Currency> currencyColumn =
                new TableColumn<>("Currency");
        currencyColumn.setCellValueFactory(
                new PropertyValueFactory<>("currency")
        );
        budgetTable.getColumns().addAll(
                idColumn,
                categoryColumn,
                limitColumn,
                currencyColumn
        );
        ObservableList<Budget> budgets =
                FXCollections.observableArrayList(
                        dao.getAllBudgets()
                );
        budgetTable.setItems(budgets);
        //Following array stores the selected budget ID.
        final int[] selectedId = {0};
        //Add budget button.
        Button addButton = new Button("Add Budget");
        addButton.setOnAction(event -> {
            try {
                Budget budget =
                        new Budget(
                                0,
                                categoryBox.getValue(),
                                Double.parseDouble(
                                        monthlyLimitField.getText()
                                ),
                                currencyBox.getValue()

                        );
                dao.addBudget(budget);
                budgets.setAll(
                        dao.getAllBudgets()
                );
                Alert alert =
                        new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Budget added successfully!"
                );
                alert.showAndWait();
                categoryBox.setValue(null);
                monthlyLimitField.clear();
                currencyBox.setValue(null);
            } catch (Exception e) {
                Alert alert =
                        new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Please enter valid budget data."
                );
                alert.showAndWait();
                e.printStackTrace();
            }
        });

        //Load selected budget button.
        Button loadButton = new Button("Load Selected");
        loadButton.setOnAction(event -> {
            Budget selectedBudget =
                    budgetTable
                            .getSelectionModel()
                            .getSelectedItem();
            if (selectedBudget != null) {
                selectedId[0] = selectedBudget.getId();
                categoryBox.setValue(
                        selectedBudget.getCategory()
                );
                monthlyLimitField.setText(
                        String.valueOf(
                                selectedBudget.getMonthlyLimit()
                        )
                );
                currencyBox.setValue(
                        selectedBudget.getCurrency()
                );
            } else {
                Alert alert =
                        new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Please select a budget."
                );
                alert.showAndWait();
            }
        });
        //Update budget button.
        Button updateButton = new Button("Update Budget");
        updateButton.setOnAction(event -> {
            try {
                Budget budget =
                        new Budget(
                                selectedId[0],
                                categoryBox.getValue(),
                                Double.parseDouble(
                                        monthlyLimitField.getText()
                                ),
                                currencyBox.getValue()
                        );
                dao.updateBudget(budget);
                budgets.setAll(
                        dao.getAllBudgets()
                );
                Alert alert =
                        new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Budget updated successfully!"
                );
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert =

                        new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Unable to update budget."
                );
                alert.showAndWait();
                e.printStackTrace();
            }
        });
        //Delete selected budget button.
        Button deleteButton = new Button("Delete Selected");
        deleteButton.setOnAction(event -> {
            Budget selectedBudget =
                    budgetTable
                            .getSelectionModel()
                            .getSelectedItem();
            if (selectedBudget != null) {
                dao.deleteBudget(
                        selectedBudget.getId()
                );
                budgets.setAll(
                        dao.getAllBudgets()
                );
                Alert alert =
                        new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Budget deleted successfully!"
                );
                alert.showAndWait();
            } else {
                Alert alert =
                        new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Please select a budget."
                );
                alert.showAndWait();
            }
        });
        // Add everything to screen.
        getChildren().addAll(
                title,
                categoryLabel,
                categoryBox,
                monthlyLimitLabel,
                monthlyLimitField,
                currencyLabel,
                currencyBox,
                addButton,
                loadButton,
                updateButton,
                deleteButton,
                budgetTable
        );
    }
}
