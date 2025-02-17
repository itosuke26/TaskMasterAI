package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskManagerUI {
    private JFrame frame;
    private JTextField taskField;
    private JTextArea taskArea;

    public TaskManagerUI() {
        frame = new JFrame("TaskMasterAI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        taskField = new JTextField(20);
        taskArea = new JTextArea(10, 30);
        taskArea.setEditable(false);

        JButton addButton = new JButton("タスク追加");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskTitle = taskField.getText();
                if (!taskTitle.isEmpty()) {
                    taskArea.append("タスク: " + taskTitle + "\n");
                    taskField.setText("");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("タスク名:"));
        panel.add(taskField);
        panel.add(addButton);
        panel.add(new JScrollPane(taskArea));

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskManagerUI();
            }
        });
    }
}