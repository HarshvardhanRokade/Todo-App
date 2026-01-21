import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    // 3306 is the default MySQL port. Replace 'todo_db' with your database name.
    private static final String URL = "jdbc:mysql://localhost:3306/todo_db";
    private static final String USER = "root";
    private static final String PASSWORD = "harsh231104";

    public static Connection getConnection() throws SQLException {
        // Modern JDBC (Connector/J 8.0+) automatically loads the driver,
        // but it's good practice to know it's there.
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}