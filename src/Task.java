import java.sql.Timestamp;

public class Task {
    private int id;
    private String description;
    private int priority;
    private boolean isCompleted;
    private Timestamp createdAt;

    public Task(int id, String description, int priority, boolean isCompleted, Timestamp createdAt) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.isCompleted = isCompleted;
        this.createdAt = createdAt;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public int getPriority() {
        return priority;
    }
    public boolean isCompleted() {
        return isCompleted;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
}