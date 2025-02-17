package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskDatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/task_manager";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // タスクの保存
    public void saveTask(Task task) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO tasks (id, title, description, due_date, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getId()); // getId メソッドを正しく呼び出し
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.setDate(4, java.sql.Date.valueOf(task.getDueDate()));
            statement.setString(5, task.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // タスクの取得
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM tasks";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task(
                        resultSet.getInt("id"), // getId メソッドを正しく呼び出し
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("due_date").toLocalDate(),
                        resultSet.getString("status")
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}