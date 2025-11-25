package main.java.model;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:tasks.db";

    static {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = """
                CREATE TABLE IF NOT EXISTS tasks (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    dueDate TEXT NOT NULL,
                    priority TEXT NOT NULL
                )
            """;
            conn.createStatement().execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addTask(Task t) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "INSERT INTO tasks(name, dueDate, priority) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, t.getName());
            stmt.setString(2, t.getDueDate().toString());
            stmt.setString(3, t.getPriority());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int countDueToday() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String today = LocalDate.now().toString();
            String sql = "SELECT COUNT(*) FROM tasks WHERE dueDate = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, today);
            ResultSet rs = stmt.executeQuery();
            return rs.getInt(1);
        } catch (Exception e) {
            return 0;
        }
    }

    public static int countUpcomingTasks() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String today = LocalDate.now().toString();
            String sql = "SELECT COUNT(*) FROM tasks WHERE dueDate > ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, today);
            ResultSet rs = stmt.executeQuery();
            return rs.getInt(1);
        } catch (Exception e) {
            return 0;
        }
    }
}
