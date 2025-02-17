package com.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // アプリケーションのエントリーポイント
        System.out.println("ようこそTaskMasterAIへ！");

        // 例としての使用法
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("新しいタスク1", "これは新しいタスク1です", LocalDate.now().plusDays(7), "保留中");
        Task task2 = new Task("新しいタスク2", "これは新しいタスク2です", LocalDate.now().plusDays(14), "進行中");

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        // データベースに保存
        TaskDatabaseManager dbManager = new TaskDatabaseManager();
        dbManager.saveTask(task1);
        dbManager.saveTask(task2);

        // すべてのタスクを表示
        taskManager.getAllTasks().forEach(t -> {
            System.out.println(t.getTitle() + ": " + t.getDescription() + " (締め切り: " + t.getDueDate() + ", ステータス: " + t.getStatus() + ")");
        });

        // データベースからタスクを取得して表示
        dbManager.getAllTasks().forEach(t -> {
            System.out.println(t.getTitle() + ": " + t.getDescription() + " (締め切り: " + t.getDueDate() + ", ステータス: " + t.getStatus() + ")");
        });
    }
}