# TaskMasterAI

## 概要
TaskMasterAIは、タスク管理を効率化するためのアプリケーションです。ユーザーがタスクを入力・管理し、AIを用いてタスク目標を生成する機能を持ちます。また、タスクをExcelおよびWord形式でエクスポートできます。

## 主要機能
- タスクの入力・管理
- タスクのデータベース保存（MySQL）
- AIによるタスク目標の生成
- タスクのExcelおよびWord形式へのエクスポート

このプロジェクトは、Microsoft Copilotと共同しながら作成していきました。

## セットアップ

### 1. プロジェクトのクローン
```bash
git clone https://github.com/itosuke26/TaskMasterAI.git
cd TaskMasterAI
```

2. Pythonの仮想環境の設定
```bash
cd src/main/python
python -m venv venv
venv\Scripts\activate
pip install -r requirements.txt
```

3. 環境変数の設定
Windowsの環境変数にMYSQL_PASSWORDを追加します。

「スタート」ボタンを右クリックし、「システム」を選択します。

「システムの詳細設定」を選択し、「環境変数」をクリックします。

「ユーザー環境変数」で「新規」をクリックし、以下の情報を入力します。

変数名: MYSQL_PASSWORD

変数値: あなたのMySQLパスワード

「OK」をクリックして保存し、コマンドプロンプトやPowerShellを再起動します。

プロジェクトの実行手順
タスクの管理
タスクの入力と保存
TaskManagerUIまたはJavaコード内でタスクを入力します。

```java
Task task1 = new Task("新しいタスク1", "これは新しいタスク1です", LocalDate.now().plusDays(7), "保留中");
taskManager.addTask(task1);
データベースに保存します。
```

```java
dbManager.saveTask(task1);
データベースからタスクを取得して表示します。
```

```java
dbManager.getAllTasks().forEach(t -> {
    System.out.println(t.getTitle() + ": " + t.getDescription() + " (締め切り: " + t.getDueDate() + ", ステータス: " + t.getStatus() + ")");
});
```

初期のMain.javaコード
```java
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
```

Pythonコードの実行
AIモデルを使用してタスク目標を生成します。

```bash
python ai_model.py
```

ユーザーインターフェースの確認
Main.javaコードを書き換えます：
```java
package com.example;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskManagerUI();
            }
        });
    }
}
```

これを保存し、以下のコマンドで実行します：

```bash
.\gradlew.bat run
```

エクスポート機能の確認
Main.javaコードを書き換えます：
```java
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

        // エクスポート機能のテスト
        ExcelExporter excelExporter = new ExcelExporter();
        excelExporter.exportTasksToExcel(taskManager.getAllTasks(), "tasks.xlsx");

        WordExporter wordExporter = new WordExporter();
        wordExporter.exportTasksToWord(taskManager.getAllTasks(), "tasks.docx");
    }
}
```

これを保存し、以下のコマンドで実行します：

```bash
.\gradlew.bat run
```

AI生成タスク目標の確認
Main.javaコードを書き換えます：
```java
package com.example;

public class Main {
    public static void main(String[] args) {
        // AI統合のテスト
        AiIntegration aiIntegration = new AiIntegration();
        String prompt = "タスクの目標を設定してください：";
        String generatedGoal = aiIntegration.generateTaskGoal(prompt);
        System.out.println("生成されたタスク目標: " + generatedGoal);
    }
}
```

これを保存し、以下のコマンドで実行します：

```bash
.\gradlew.bat run
```

生成されたファイルの確認
プロジェクトディレクトリ内にtasks.xlsxおよびtasks.docxファイルが正しく生成されていることを確認します。

注意事項
公開リポジトリにパスワードを含めないようにするため、環境変数を使用してください。

必要に応じてMySQLパスワードを変更してください。