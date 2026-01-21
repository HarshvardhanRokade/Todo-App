import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    // CREATE
    public void addTask(String description, int priority) {
        String sql = "INSERT INTO tasks (description, priority) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, description);
            pstmt.setInt(2, priority);
            pstmt.executeUpdate();
            System.out.println("✔ Task added successfully!");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // READ (Returns a List for the UI to handle)
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks ORDER BY priority ASC, created_at DESC";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tasks.add(new Task(
                        rs.getInt("id"), rs.getString("description"),
                        rs.getInt("priority"), rs.getBoolean("is_completed"),
                        rs.getTimestamp("created_at")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return tasks;
    }

    // UPDATE: Status
    public void markAsCompleted(int id) {
        String sql = "UPDATE tasks SET is_completed = true WHERE id = ?";
        executeSimpleUpdate(sql, id, "Task marked as done!");
    }

    // UPDATE: Description
    public void updateDescription(int id, String newDesc) {
        String sql = "UPDATE tasks SET description = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newDesc);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // DELETE
    public void deleteTask(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        executeSimpleUpdate(sql, id, "Task deleted!");
    }

    // BULK DELETE
    public void clearCompleted() {
        String sql = "DELETE FROM tasks WHERE is_completed = true";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement()) {
            int count = stmt.executeUpdate(sql);
            System.out.println("✔ Cleared " + count + " completed tasks.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private void executeSimpleUpdate(String sql, int id, String msg) {
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            if (pstmt.executeUpdate() > 0) System.out.println("✔ " + msg);
            else System.out.println("⚠️ ID not found.");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}


//
//private static final String ANSI_RESET = "\u001B[0m";
//private static final String ANSI_RED = "\u001B[31m";    // High Priority
//private static final String ANSI_YELLOW = "\u001B[33m"; // Medium Priority
//private static final String ANSI_GREEN = "\u001B[32m";