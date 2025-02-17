package com.example;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // タスクの追加
    public void addTask(Task task) {
        tasks.add(task);
    }

    // タスクの読み取り
    public List<Task> getAllTasks() {
        return tasks;
    }

    // タスクの更新
    public void updateTask(int index, Task task) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, task);
        }
    }

    // タスクの削除
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }
}