package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AiIntegration {
    public static String generateTaskGoal(String prompt) {
        StringBuilder result = new StringBuilder();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", "ai_model.py", prompt);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();

            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String prompt = "タスクの目標を設定してください：";
        String generatedGoal = generateTaskGoal(prompt);
        System.out.println("生成されたタスク目標: " + generatedGoal);
    }
}