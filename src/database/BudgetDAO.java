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
    //Following is a method to get all budget.
    public List<Budget> getAllBudgets(){
        List<Budget> budgets = new ArrayList<>();
        String sql = "SELECT * FROM budgets";
        try (
                Connection conn = DatabaseManager.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()
        ) {
            while (rs.next()) {
                Budget budget =
                        new Budget(
                                rs.getInt("id"),
                                rs.getString("category"),
                                rs.getDouble("monthly_limit"),
                                model.Currency.valueOf(
                                        rs.getString("currency")
                                )
                        );
                budgets.add(budget);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return budgets;
    }
    //Following is a method to update budget.
    public void updateBudget(Budget budget){
        String sql = """
                UPDATE budgets
                SET category = ?,
                monthly_limit = ?,
                currency = ?
                WHERE id = ?
                """;
        try (
                Connection conn = DatabaseManager.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, budget.getCategory());
            pstmt.setDouble(2, budget.getMonthlyLimit());
            pstmt.setString(3, budget.getCurrency().name());
            pstmt.setInt(4, budget.getId());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Budget updated successfully!");
            } else {
                System.out.println("Budget not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Following is a method to delete a budget using its ID.
    public void deleteBudget(int id){
        String sql = """
            DELETE FROM budgets
            WHERE id = ?
            """;
        try (
                Connection conn = DatabaseManager.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Budget deleted successfully!");
            } else {
                System.out.println("Budget not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
