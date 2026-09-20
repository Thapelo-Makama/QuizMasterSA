/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizmaster;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;


/**
 *
 * @author thapelo
 */



public class QuizFrame extends JFrame {

    private List<Question> questions;
    private int currentIndex = 0;
    private int score = 0;
    private int totalQuestions;

    private JLabel categoryLabel;
    private JLabel questionCounterLabel;
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionsGroup;
    private JButton nextButton;
    private JProgressBar progressBar;

    public QuizFrame() {
        questions = QuizData.getQuestions();
        totalQuestions = questions.size();

        initComponents();
        loadQuestion();
    }

    private void initComponents() {
        setTitle("QuizMaster SA — General Knowledge Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        // ===== TOP PANEL =====
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(37, 99, 235));
        topPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        categoryLabel = new JLabel("Category");
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 16));

        questionCounterLabel = new JLabel("Question 1 of 20");
        questionCounterLabel.setForeground(Color.WHITE);
        questionCounterLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        topPanel.add(categoryLabel, BorderLayout.WEST);
        topPanel.add(questionCounterLabel, BorderLayout.EAST);

        // ===== PROGRESS BAR =====
        progressBar = new JProgressBar(0, totalQuestions);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(16, 185, 129));
        progressBar.setBackground(new Color(229, 231, 235));

        JPanel progressWrapper = new JPanel(new BorderLayout());
        progressWrapper.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        progressWrapper.add(progressBar, BorderLayout.CENTER);

        JPanel northWrapper = new JPanel(new BorderLayout());
        northWrapper.add(topPanel, BorderLayout.NORTH);
        northWrapper.add(progressWrapper, BorderLayout.SOUTH);
        add(northWrapper, BorderLayout.NORTH);

        // ===== CENTER PANEL =====
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        questionLabel = new JLabel("Question goes here");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        questionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        centerPanel.add(questionLabel);

        optionButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton("Option " + (i + 1));
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 15));
            optionButtons[i].setAlignmentX(Component.LEFT_ALIGNMENT);
            optionButtons[i].setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 0));
            optionsGroup.add(optionButtons[i]);
            centerPanel.add(optionButtons[i]);
        }

        add(centerPanel, BorderLayout.CENTER);

        // ===== BOTTOM PANEL =====
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 15));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        nextButton = new JButton("Next →");
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.setBackground(new Color(37, 99, 235));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        nextButton.addActionListener((ActionEvent e) -> handleNext());

        bottomPanel.add(nextButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void loadQuestion() {
        if (currentIndex >= totalQuestions) {
            showResults();
            return;
        }

        Question q = questions.get(currentIndex);

        categoryLabel.setText("📚 " + q.getCategory());
        questionCounterLabel.setText("Question " + (currentIndex + 1) + " of " + totalQuestions);
        questionLabel.setText("<html><body style='width: 500px;'>" + q.getQuestionText() + "</body></html>");

        String[] opts = q.getOptions();
        optionsGroup.clearSelection();
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(opts[i]);
        }

        progressBar.setValue(currentIndex);
        progressBar.setString("Score: " + score + " | " + currentIndex + "/" + totalQuestions);
    }

    private void handleNext() {
        // Check if an option is selected
        int selectedIndex = -1;
        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected()) {
                selectedIndex = i;
                break;
            }
        }

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this,
                "Please select an answer before continuing.",
                "No Answer Selected",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Check if correct
        Question q = questions.get(currentIndex);
        if (selectedIndex == q.getCorrectAnswerIndex()) {
            score++;
        }

        currentIndex++;

        if (currentIndex >= totalQuestions) {
            showResults();
        } else {
            loadQuestion();
        }
    }

    private void showResults() {
        dispose();
        new ResultFrame(score, totalQuestions).setVisible(true);
    }
}