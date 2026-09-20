/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizmaster;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thapelo
 */



public class QuizData {

    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        // === POLITICS ===
        questions.add(new Question(
            "Who is the current President of South Africa (2026)?",
            new String[]{"Cyril Ramaphosa", "Jacob Zuma", "Julius Malema", "Thabo Mbeki"},
            0, "Politics"));

        questions.add(new Question(
            "How many provinces does South Africa have?",
            new String[]{"7", "8", "9", "10"},
            2, "Politics"));

        questions.add(new Question(
            "What is the name of South Africa's parliament in Cape Town?",
            new String[]{"Union Buildings", "Parliament", "Luthuli House", "Constitutional Court"},
            1, "Politics"));

        questions.add(new Question(
            "In which year did South Africa hold its first democratic election?",
            new String[]{"1990", "1992", "1994", "1996"},
            2, "Politics"));

        questions.add(new Question(
            "What does ANC stand for?",
            new String[]{"African National Congress", "African National Coalition", "African New Council", "African Native Congress"},
            0, "Politics"));

        // === ECONOMICS ===
        questions.add(new Question(
            "What is the currency of South Africa?",
            new String[]{"Dollar", "Rand", "Pound", "Euro"},
            1, "Economics"));

        questions.add(new Question(
            "What does GDP stand for?",
            new String[]{"General Domestic Product", "Gross Domestic Product", "Gross Development Plan", "General Development Product"},
            1, "Economics"));

        questions.add(new Question(
            "Which is South Africa's largest bank by assets?",
            new String[]{"FNB", "Standard Bank", "ABSA", "Nedbank"},
            1, "Economics"));

        questions.add(new Question(
            "What is inflation?",
            new String[]{"Rise in prices over time", "Fall in prices", "Increase in wages", "Decrease in taxes"},
            0, "Economics"));

        questions.add(new Question(
            "Which sector employs the most people in South Africa?",
            new String[]{"Mining", "Agriculture", "Services", "Manufacturing"},
            2, "Economics"));

        // === PERSONAL LIFE ===
        questions.add(new Question(
            "How many hours of sleep does an average adult need per night?",
            new String[]{"3-4 hours", "5-6 hours", "7-9 hours", "10-12 hours"},
            2, "Personal Life"));

        questions.add(new Question(
            "What is the healthiest way to deal with stress?",
            new String[]{"Exercise and rest", "Ignore it", "Smoke", "Skip meals"},
            0, "Personal Life"));

        questions.add(new Question(
            "How often should you drink water daily?",
            new String[]{"Never", "Once", "Regularly throughout the day", "Only when sick"},
            2, "Personal Life"));

        questions.add(new Question(
            "What is a balanced diet?",
            new String[]{"Only meat", "Only vegetables", "A mix of all food groups", "Only fruits"},
            2, "Personal Life"));

        questions.add(new Question(
            "What is the best way to save money?",
            new String[]{"Spend everything", "Budget and save regularly", "Borrow money", "Ignore finances"},
            1, "Personal Life"));

        // === GENERAL KNOWLEDGE ===
        questions.add(new Question(
            "What is the capital of South Africa?",
            new String[]{"Johannesburg", "Cape Town", "Pretoria", "Durban"},
            2, "General Knowledge"));

        questions.add(new Question(
            "How many colours are in the South African flag?",
            new String[]{"4", "5", "6", "7"},
            2, "General Knowledge"));

        questions.add(new Question(
            "What is the largest ocean on Earth?",
            new String[]{"Atlantic", "Indian", "Pacific", "Arctic"},
            2, "General Knowledge"));

        questions.add(new Question(
            "Which planet is known as the Red Planet?",
            new String[]{"Venus", "Mars", "Jupiter", "Saturn"},
            1, "General Knowledge"));

        questions.add(new Question(
            "Who wrote the play 'Romeo and Juliet'?",
            new String[]{"Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"},
            1, "General Knowledge"));

        return questions;
    }
}