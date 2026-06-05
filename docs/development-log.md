# Development Log
## 4th June 2026
**Completed**
* Created a GitHub Repository.
* Established project structure.
* Set up Java 25 development environment.
* Created SQLite database.
* Designed database schema.
* Created transactions table.
* Connected Java application to SQLite using JDBC.
* Implemented Transaction model.
* Implemented TransactionDAO.
* Added functionality to insert transactions into the database. 
* Added functionality to retrieve transactions from the database.

**Challenges**
* Troubleshooting IntelliJ project configuration.
* Resolving SQLite JDBC driver issues.
* Establishing a successful database connection.

**Next Objectives**
* Implement update transaction functionality.
* Implement delete transaction functionality.
* Calculate total income, expenses and account balance.

## 5th June 2026
**Completed**
* Implemented updateTransaction() method.
* Implemented a test for updating the transactions in Main.java.


![Database Connection](../screenshots/update_test.png)
* In the screenshot above it can be clearly seen that the id = '1' was changed.
Following is a brief description of the process that happened in the background-
1. The row with id = 1 was found.
2. The UPDATE query executed successfully.
3. The amount was changed to 15.5 to 20.0.
4. The description changed to "Updated lunch cost".
5. The second transaction was not affected.

* Implemented  deleteTransaction() method.
* Implemented a test for deleting the transactions in Main.java.


  ![Database Connection](../screenshots/delete_test.png)
* In the screenshot above it can be clearly seen that id = '1' is no longer there
  Following is a brief description of the process that happened in the background-
1. The row with id = 1 was found.
2. The DELETE query executed successfully.
3. The row with id = '1' was deleted.