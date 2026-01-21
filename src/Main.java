import java.util.*;

public class Main {
    // Colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";

    public static void main(String[] args) {
        TaskDAO taskDAO = new TaskDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add | 2. View | 3. Complete | 4. Edit | 5. Delete | 6. Clear Done | 7. Exit");
            System.out.print("Choice: ");
            try {
                int choice = sc.nextInt(); sc.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Desc: "); String d = sc.nextLine();
                        System.out.print("Priority (1-High, 2-Med, 3-Low): ");
                        taskDAO.addTask(d, sc.nextInt());
                    }
                    case 2 -> {
                        List<Task> tasks = taskDAO.getAllTasks();
                        long urgent = tasks.stream().filter(t -> t.getPriority() == 1 && !t.isCompleted()).count();
                        System.out.println("\n--- TODO LIST (" + urgent + " URGENT) ---");
                        System.out.printf("%-3s | %-8s | %-8s | %s%n", "ID", "PRIORITY", "STATUS", "DESCRIPTION");
                        System.out.println("---------------------------------------------------------------");

                        tasks.forEach(t -> {
                            // 1. Determine Color
                            String color = switch(t.getPriority()) {
                                case 1 -> RED;
                                case 2 -> YELLOW;
                                default -> GREEN;
                            };

                            // 2. Determine Label correctly (Fixes the "MED" bug)
                            String priorityLabel = switch(t.getPriority()) {
                                case 1 -> "HIGH";
                                case 2 -> "MED ";
                                case 3 -> "LOW ";
                                default -> "??? ";
                            };

                            System.out.printf("%-3d | %s%s%s | %-8s | %s%n",
                                    t.getId(),
                                    color, priorityLabel, RESET,
                                    (t.isCompleted() ? "[DONE]" : "[ ]"),
                                    t.getDescription());
                        });
                    }
                    case 3 -> { System.out.print("ID: "); taskDAO.markAsCompleted(sc.nextInt()); }
                    case 4 -> {
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("New Desc: "); taskDAO.updateDescription(id, sc.nextLine());
                    }
                    case 5 -> { System.out.print("ID: "); taskDAO.deleteTask(sc.nextInt()); }
                    case 6 -> taskDAO.clearCompleted();
                    case 7 -> System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Invalid input!"); sc.nextLine();
            }
        }
    }
}