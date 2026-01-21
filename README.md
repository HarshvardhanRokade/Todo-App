🚀 Advanced To-Do Manager (Java CRUD)
A professional-grade Command Line Interface (CLI) application that manages tasks with a MySQL backend. This project serves as a comprehensive demonstration of Object-Oriented Programming (OOP), Database Connectivity (JDBC), and Functional Programming in Java.

🌟 Evolution of the Project
This project evolved from a simple console script into a decoupled, scalable application:

Phase 1: Basic CRUD using ArrayList (In-memory storage).

Phase 2: Persistence layer added using JDBC and MySQL.

Phase 3: Architecture refactored to the DAO (Data Access Object) Pattern.

Phase 4: Transitioned from "Print-in-DAO" to returning Lists of Objects for better separation of concerns.

Phase 5: Added advanced analytics using Java Streams and Lambdas.

🛠️ Key Technical Features
Decoupled Architecture: The TaskDAO handles data, the Task POJO represents the model, and Main handles the UI.

Color-Coded Priority: Uses ANSI escape codes to visually distinguish High (Red), Medium (Yellow), and Low (Green) tasks.

Stream API: Implements real-time "Urgent Task" counting and data filtering using java.util.stream.

Secure SQL: Uses PreparedStatement throughout to prevent SQL Injection attacks.

Auto-Timestamps: Database-level tracking of when tasks were created.

Bulk Operations: Feature to clear all completed tasks with a single command.

🏗️ Technical Stack
Language: Java 17+

Database: MySQL 8.0

Driver: MySQL Connector/J

Concepts: JDBC, Collections Framework, Streams, Lambdas, Exception Handling.

📁 Project Structure
Plaintext

src/
├── Task.java            # POJO Model (Encapsulation)
├── TaskDAO.java         # Data Access Object (Abstraction & Logic)
├── DatabaseConfig.java  # Connection Utility
└── Main.java            # Console UI & Stream Analytics (Presentation)
🚀 Installation & Setup
1. Database Configuration
Run this SQL script to create the table structure:

SQL

CREATE DATABASE todo_db;
USE todo_db;

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    priority INT DEFAULT 2, -- 1:High, 2:Med, 3:Low
    is_completed BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
2. Add MySQL Connector
Download the mysql-connector-j.jar and add it to your project's Libraries in IntelliJ/Eclipse.

3. Configure Credentials
Update DatabaseConfig.java with your MySQL username and password.

📸 Sample Output
Plaintext

--- TODO LIST (2 URGENT) ---
ID  | PRIORITY | STATUS   | DESCRIPTION
---------------------------------------------------------------
1   | HIGH     | [ ]      | Complete Java Final Project
5   | HIGH     | [ ]      | Prepare for Technical Interview
2   | MED      | [DONE]   | Go to College
4   | LOW      | [ ]      | Buy Groceries
