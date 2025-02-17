package com.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // アプリケーションのエントリーポイント
        System.out.println("ようこそTaskMasterAIへ！");

        // 例としての使用法
        TaskManager taskManager = new TaskManager();
        Task task = new Task("新しいタスク", "これは新しいタスクです", LocalDate.now().plusDays(7), "保留中");
        taskManager.addTask(task);

        // すべてのタスクを表示
        taskManager.getAllTasks().forEach(t -> {
            System.out.println(t.getTitle() + ": " + t.getDescription() + " (締め切り: " + t.getDueDate() + ", ステータス: " + t.getStatus() + ")");
        });

        // データベースに保存
        TaskDatabaseManager dbManager = new TaskDatabaseManager();
        dbManager.saveTask(task);
    }
}