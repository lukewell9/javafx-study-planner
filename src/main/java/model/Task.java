package main.java.model;

import java.time.LocalDate;

public class Task {
    private String name;
    private LocalDate dueDate;
    private String priority;

    public Task(String name, LocalDate dueDate, String priority) {
        this.name = name;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getName() { return name; }
    public LocalDate getDueDate() { return dueDate; }
    public String getPriority() { return priority; }
}
