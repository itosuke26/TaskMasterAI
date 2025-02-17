package com.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PomodoroTimer {
    private JFrame frame;
    private JLabel timerLabel;
    private Timer timer;
    private int timeLeft; // seconds

    public PomodoroTimer() {
        frame = new JFrame("ポモドーロ・タイマー");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        timerLabel = new JLabel("25:00", SwingConstants.CENTER);
        frame.getContentPane().add(timerLabel);

        timeLeft = 25 * 60; // 25 minutes

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    timeLeft--;
                    int minutes = timeLeft / 60;
                    int seconds = timeLeft % 60;
                    timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(frame, "ポモドーロセッションが終了しました。休憩をとってください！");
                }
            }
        });

        timer.start();

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PomodoroTimer();
            }
        });
    }
}