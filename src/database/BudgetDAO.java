package database;
import model.Budget;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class BudgetDAO {
    //Following is a method to add budget.
    public void addBudget(Budget budget){
        String sql = """
                INSERT INTO budgets
                (category, monthly_limit, currency)
                VALUES (?,?,?)
                """;
        try (
                Connection conn = DatabaseManager.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)
                ){
            pstmt.setString(1, budget.getCategory());
            pstmt.setDouble(2, budget.getMonthlyLimit());
            pstmt.setString(3, budget.getCurrency().name());
            pstmt.executeUpdate();
            System.out.println("Budget added successfully!");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
