package services;
import model.Transaction;//Import transaction model.
import database.TransactionDAO;//Importing the database in order to get the transactions.
public class FinanceService {
    private TransactionDAO transactionDAO;//This is a DAO object used to communicate with the database.
    //Following is a constructor.
    public FinanceService(){
        transactionDAO = new TransactionDAO();//Created a TransactionDAO Instance.
    }
    //Following is a method to calculate total expense.
    public double getTotalExpense(){
        double total = 0;//This is the variable where the total amount will be saved.
        //Following is a loop through every transaction in the database.
        for (Transaction transaction : transactionDAO.getAllTransactions()){
            //Following codes check if transaction type is expense.
            if (transaction.getType().equalsIgnoreCase("Expense")){
                total += transaction.getAmount();
            }
        }
        return total;//Returns the final expense total.
    }
    //Following is a method to calculate total income transactions.
    public double getTotalIncome(){
        double total = 0;//This is a variable used to store the income total.
        //Following is a loop through every transaction in the database just like the previous method.
        for (Transaction transaction : transactionDAO.getAllTransactions()){
            //Following is an if statement to check if the transaction type is income.
            if (transaction.getType().equalsIgnoreCase("Income")){
                    total += transaction.getAmount();//Adds income amount to total.
        }
        }
        return total;//Returns the final income total.
}
//Following is a method to calculate current balance.
    public double getCurrentBalance(){
        //Balance = Income - Expenses
        return getTotalIncome() - getTotalExpense();
    }
    //Following is a method to get total number of Transactions stored.
    public int getTransactionCount(){
        return transactionDAO.getAllTransactions().size();
    }
}
