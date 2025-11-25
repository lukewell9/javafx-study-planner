package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.java.model.DatabaseManager;

public class MainController {

    @FXML private Label upcomingCount;
    @FXML private Label sessionCount;
    @FXML private Label dueTodayCount;
    @FXML private ListView<String> scheduleList;

    public void initialize() {
        updateDashboardStats();
    }

    private void updateDashboardStats() {
        upcomingCount.setText(String.valueOf(DatabaseManager.countUpcomingTasks()));
        dueTodayCount.setText(String.valueOf(DatabaseManager.countDueToday()));
        sessionCount.setText("0"); // Placeholder - upgrade later
    }

    @FXML private void showDashboard() {
        // stays on dashboard
    }

    @FXML private void showPlanner() {
        System.out.println("Study Planner view goes here.");
    }

    @FXML private void showSchedule() {
        System.out.println("Schedule view goes here.");
    }

    @FXML private void showProgress() {
        System.out.println("Progress view goes here.");
    }
}
