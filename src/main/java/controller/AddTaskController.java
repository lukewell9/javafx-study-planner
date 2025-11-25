package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.java.model.DataBaseManager;
import main.java.model.Task;

import java.time.LocalDate;

public class AddTaskController {

    @FXML
    private TextField taskNameField;

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private ComboBox<String> priorityBox;

    // Called when the "Save Task" button is clicked
    @FXML
    private void saveTask() {
        String name = taskNameField.getText();
        LocalDate dueDate = dueDatePicker.getValue();
        String priority = priorityBox.getValue();

        // Basic validation
        if (name == null || name.isBlank()
                || dueDate == null
                || priority == null) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Missing information");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields before saving.");
            alert.showAndWait();
            return;
        }

        // Create model object
        Task task = new Task(name, dueDate, priority);

        // Save to DB
        DataBaseManager.addTask(task);

        // Close this window
        Stage stage = (Stage) taskNameField.getScene().getWindow();
        stage.close();
    }
}
