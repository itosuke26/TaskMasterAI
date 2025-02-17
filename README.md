プロジェクト名: TaskMasterAI
概要
TaskMasterAIは、タスク管理を効率化するためのアプリケーションです。ユーザーがタスクを入力・管理し、AIを用いてタスク目標を生成する機能を持ちます。また、タスクをExcelおよびWord形式でエクスポートできます。

主要機能
タスクの入力・管理

タスクのデータベース保存（MySQL）

AIによるタスク目標の生成

タスクのExcelおよびWord形式へのエクスポート

プロジェクトの実行手順
1. セットアップ
   プロジェクトのクローン

cmd
git clone https://github.com/username/TaskMasterAI.git
cd TaskMasterAI
Pythonの仮想環境の設定

cmd
cd src/main/python
python -m venv venv
venv\Scripts\activate
pip install -r requirements.txt
2. 環境変数の設定
   Windowsの環境変数にMYSQL_PASSWORDを追加

「スタート」ボタンを右クリックし、「システム」を選択します。

「システムの詳細設定」を選択し、「環境変数」をクリックします。

「ユーザー環境変数」で「新規」をクリックし、以下の情報を入力します。

変数名: MYSQL_PASSWORD

変数値: あなたのMySQLパスワード

「OK」をクリックして保存し、コマンドプロンプトやPowerShellを再起動します。

3. タスクの管理
   タスクの入力

TaskManagerUIまたはJavaコード内でタスクを入力します。

java
Task task1 = new Task("新しいタスク1", "これは新しいタスク1です", LocalDate.now().plusDays(7), "保留中");
taskManager.addTask(task1);
データベースに保存

java
dbManager.saveTask(task1);
データベースからタスクを取得して表示

java
dbManager.getAllTasks().forEach(t -> {
System.out.println(t.getTitle() + ": " + t.getDescription() + " (締め切り: " + t.getDueDate() + ", ステータス: " + t.getStatus() + ")");
});
4. Pythonコードの実行
   AIモデルを使用してタスク目標を生成

cmd
python ai_model.py
5. エクスポート機能の確認
   ExcelおよびWord形式へのエクスポート

java
ExcelExporter excelExporter = new ExcelExporter();
excelExporter.exportTasksToExcel(taskManager.getAllTasks(), "tasks.xlsx");

WordExporter wordExporter = new WordExporter();
wordExporter.exportTasksToWord(taskManager.getAllTasks(), "tasks.docx");
生成されたファイルの確認 プロジェクトディレクトリ内にtasks.xlsxおよびtasks.docxファイルが正しく生成されていることを確認します。