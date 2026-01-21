🚀 Advanced To-Do Manager (Java & MySQL)
A professional-grade Command Line Interface (CLI) application that manages tasks with a MySQL backend. This project serves as a comprehensive demonstration of Object-Oriented Programming (OOP), Database Connectivity (JDBC), and Functional Programming in Java.



🌟 Evolution of the Project
This project evolved from a simple console script into a decoupled, scalable application:
Phase 1: Basic CRUD using ArrayList (In-memory storage).
Phase 2: Persistence layer added using JDBC and MySQL.
Phase 3: Architecture refactored to the DAO (Data Access Object) Pattern.
Phase 4: Transitioned from "Printing-in-DAO" to returning Lists of Objects (List<Task>).
Phase 5: Added advanced analytics using Java Streams and Lambdas.



🛠️ Key Technical Features
✅ Decoupled Architecture: Clean separation between Data (TaskDAO), Model (Task), and UI (Main).
🎨 Color-Coded Priority: Uses ANSI escape codes to visually distinguish High (Red), Medium (Yellow), and Low (Green) tasks.
📊 Stream API Analytics: Implements real-time "Urgent Task" counting using java.util.stream.
🛡️ Secure SQL: Uses PreparedStatement throughout to prevent SQL Injection attacks.
⏱️ Auto-Timestamps: Database-level tracking of when tasks were created.
🧹 Bulk Operations: Feature to clear all completed tasks with a single command.
🏗️ Technical Stack
Language: Java 17+
Database: MySQL 8.0




📁 Project Structure
src/
├── Task.java            # POJO Model (Encapsulation)
├── TaskDAO.java         # Data Access Object (Abstraction & Logic)
├── DatabaseConfig.java  # Connection Utility (Security)
└── Main.java            # Console UI & Stream Analytics (Presentation)



📸 Sample Console Output
ID  | PRIORITY | STATUS   | CREATED AT           | DESCRIPTION
----------------------------------------------------------------------
1   | HIGH     | [ ]      | 2026-01-21 12:41     | Complete Java Final Project
5   | HIGH     | [ ]      | 2026-01-21 12:45     | Prepare for Tech Interview
2   | MED      | [DONE]   | 2026-01-21 11:30     | Go to College
4   | LOW      | [ ]      | 2026-01-21 12:50     | Buy Groceries



🔮 Future Enhancements
[ ] Build a Graphical User Interface (GUI) using Java Swing or JavaFX.
[ ] Implement a User Authentication system (Login/Sign-up).
[ ] Add Task Categories (e.g., Work, Personal, Shopping).
[ ] Export tasks to PDF or CSV formats.
