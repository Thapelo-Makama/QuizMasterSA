/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizmaster;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author thapelo
 */


public class ResultFrame extends JFrame {

    public ResultFrame(int score, int total) {
        setTitle("Quiz Results");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===== HEADER =====
        JPanel header = new JPanel();
        header.setBackground(new Color(37, 99, 235));
        header.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("🎉 Quiz Complete!");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        header.add(title);

        add(header, BorderLayout.NORTH);

        // ===== SCORE =====
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel scoreLabel = new JLabel(score + " / " + total);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 48));
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreLabel.setForeground(new Color(37, 99, 235));

        double percentage = (double) score / total * 100;
        String message;
        String emoji;
        if (percentage >= 80) {
            message = "Excellent! You're a quiz master!";
            emoji = "🏆";
        } else if (percentage >= 60) {
            message = "Good job! Well done.";
            emoji = "👍";
        } else if (percentage >= 40) {
            message = "Not bad, keep learning!";
            emoji = "📖";
        } else {
            message = "Keep practising — you'll improve!";
            emoji = "💪";
        }

        JLabel emojiLabel = new JLabel(emoji);
        emojiLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        emojiLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel percentageLabel = new JLabel(String.format("%.0f%% correct", percentage));
        percentageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        percentageLabel.setForeground(Color.GRAY);
        percentageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        center.add(emojiLabel);
        center.add(Box.createVerticalStrut(10));
        center.add(scoreLabel);
        center.add(Box.createVerticalStrut(10));
        center.add(messageLabel);
        center.add(Box.createVerticalStrut(5));
        center.add(percentageLabel);

        add(center, BorderLayout.CENTER);

        // ===== BUTTONS =====
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));

        JButton restartButton = new JButton("Play Again");
        restartButton.setFont(new Font("Arial", Font.BOLD, 14));
        restartButton.setBackground(new Color(16, 185, 129));
        restartButton.setForeground(Color.WHITE);
        restartButton.setFocusPainted(false);
        restartButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        restartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        restartButton.addActionListener(e -> {
            dispose();
            new QuizFrame().setVisible(true);
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.setFocusPainted(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.addActionListener(e -> System.exit(0));

        buttons.add(restartButton);
        buttons.add(exitButton);

        add(buttons, BorderLayout.SOUTH);
    }
}