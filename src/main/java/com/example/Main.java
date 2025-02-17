package com.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Task task = new Task(1, "新しいタスク", "これは新しいタスクです", LocalDate.now().plusDays(7), "保留中");
        taskManager.addTask(task);

        ExcelExporter excelExporter = new ExcelExporter();
        excelExporter.exportTasksToExcel(taskManager.getAllTasks(), "tasks.xlsx");

        WordExporter wordExporter = new WordExporter();
        wordExporter.exportTasksToWord(taskManager.getAllTasks(), "tasks.docx");
    }
}