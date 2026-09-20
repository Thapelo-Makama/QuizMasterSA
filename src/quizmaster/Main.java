/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizmaster;
import javax.swing.SwingUtilities;

/**
 *
 * @author thapelo
 */




public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            QuizFrame frame = new QuizFrame();
            frame.setVisible(true);
        });
    }
}