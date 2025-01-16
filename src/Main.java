import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 1. Wczytujemy pytania z pliku "questions.txt" do listy
        List<Question> allQuestions = new ArrayList<>();
        String fileName = "questions.txt"; // ścieżka do pliku

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (true) {
                // Odczytaj 6 linii na jedno pytanie
                String questionText = br.readLine();
                if (questionText == null) {
                    // Osiągnęliśmy koniec pliku
                    break;
                }

                String answerA = br.readLine();
                if (answerA == null) break;

                String answerB = br.readLine();
                if (answerB == null) break;

                String answerC = br.readLine();
                if (answerC == null) break;

                String answerD = br.readLine();
                if (answerD == null) break;

                String correct = br.readLine();
                if (correct == null) break;

                // Zakładamy, że w pliku 'a', 'b', 'c', 'd' są zawsze małymi literami
                char correctAnswer = correct.trim().charAt(0);

                // Utwórz obiekt Question i dodaj do listy
                Question question = new Question(questionText, answerA, answerB,
                        answerC, answerD, correctAnswer);
                allQuestions.add(question);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return; // Kończymy, bo bez pytań nie ma quizu
        }

        // 2. Losujemy kolejność pytań
        Collections.shuffle(allQuestions);

        // 3. Wybieramy 30 pytań (jeśli jest ich więcej niż 30)
        int numberOfQuestions = 30;
        if (allQuestions.size() < numberOfQuestions) {
            numberOfQuestions = allQuestions.size();
        }
        List<Question> selectedQuestions = allQuestions.subList(0, numberOfQuestions);

        // 4. Przeprowadzamy quiz w konsoli
        Scanner scanner = new Scanner(System.in);
        int correctCount = 0;
        int wrongCount = 0;

        for (int i = 0; i < selectedQuestions.size(); i++) {
            Question q = selectedQuestions.get(i);

            System.out.println("Question " + (i + 1) + ": " + q.getQuestionText());
            System.out.println("a) " + q.getAnswerA());
            System.out.println("b) " + q.getAnswerB());
            System.out.println("c) " + q.getAnswerC());
            System.out.println("d) " + q.getAnswerD());
            System.out.print("Your answer: ");

            String userInput = scanner.nextLine().trim().toLowerCase();

            // Sprawdzamy, czy wpisano a, b, c lub d
            if (userInput.length() > 0) {
                char userAnswer = userInput.charAt(0);

                if (userAnswer == q.getCorrectAnswer()) {
                    correctCount++;
                    System.out.println("Correct!");
                } else {
                    wrongCount++;
                    System.out.println("Wrong!");
                }
            } else {
                // Wpis pusty albo nieprawidłowy - liczymy jako błąd
                wrongCount++;
                System.out.println("No valid answer provided. Counting as wrong.");
            }
            System.out.println();
        }

        // 5. Wyświetlamy wynik
        System.out.println("Quiz finished!");
        System.out.println("Correct answers: " + correctCount);
        System.out.println("Wrong answers: " + wrongCount);
        System.out.println("Score: " + correctCount + "/" + numberOfQuestions);

        double percentage = (correctCount / (double) numberOfQuestions) * 100;
        System.out.println("Score: " + correctCount + "/" + numberOfQuestions
                + " (" + String.format("%.2f", percentage) + "%)");
    }
}
