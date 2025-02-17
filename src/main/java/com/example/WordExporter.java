package com.example;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WordExporter {
    public void exportTasksToWord(List<Task> tasks, String filePath) {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Task List");

        for (Task task : tasks) {
            XWPFParagraph taskParagraph = document.createParagraph();
            XWPFRun taskRun = taskParagraph.createRun();
            taskRun.setText("Task ID: " + task.getId()); // getId メソッドを正しく呼び出し
            taskRun.addBreak();
            taskRun.setText("Task Name: " + task.getTitle());
            taskRun.addBreak();
            taskRun.setText("Description: " + task.getDescription());
            taskRun.addBreak();
            taskRun.setText("Deadline: " + task.getDueDate().toString());
            taskRun.addBreak();
        }

        try (FileOutputStream out = new FileOutputStream(filePath)) {
            document.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}