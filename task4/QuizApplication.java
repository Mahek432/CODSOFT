import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        String[][] questions = {
                {"What is the capital of France?", "A. Paris", "B. Rome", "C. Berlin", "D. Madrid", "A"},
                {"Who is the author of 'Harry Potter' series?", "A. J.R.R. Tolkien", "B. J.K. Rowling", "C. George R.R. Martin", "D. Stephen King", "B"},
                {"Which planet is known as the Red Planet?", "A. Venus", "B. Mars", "C. Jupiter", "D. Saturn", "B"}
                // Add more questions here
        };
        int numberOfQuestions = questions.length;
        final int QUESTION_TIMEOUT_SECONDS = 15; // Timeout for each question in seconds

        System.out.println("Welcome to the Quiz!");
        System.out.println("You will have " + QUESTION_TIMEOUT_SECONDS + " seconds to answer each question.");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < numberOfQuestions; i++) {
            String[] currentQuestion = questions[i];
            String question = currentQuestion[0];
            String optionA = currentQuestion[1];
            String optionB = currentQuestion[2];
            String optionC = currentQuestion[3];
            String optionD = currentQuestion[4];
            String correctAnswer = currentQuestion[5];

            System.out.println("Question " + (i + 1) + ": " + question);
            System.out.println(optionA);
            System.out.println(optionB);
            System.out.println(optionC);
            System.out.println(optionD);
            System.out.println("Please enter your answer (A, B, C, or D):");

            // Timer logic
            long startTime = System.currentTimeMillis();
            while (true) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - startTime >= QUESTION_TIMEOUT_SECONDS * 1000) {
                    System.out.println("Time's up!");
                    break;
                }
                if (scanner.hasNextLine()) {
                    String userAnswer = scanner.nextLine().trim().toUpperCase();
                    if (userAnswer.equals(correctAnswer)) {
                        System.out.println("Correct!");
                        score++;
                    } else {
                        System.out.println("Incorrect! The correct answer is " + correctAnswer);
                    }
                    break;
                }
            }
            System.out.println("---------------------------------------------------------------");
        }

        // Display final score
        System.out.println("Quiz completed!");
        System.out.println("Your final score is: " + score + " out of " + numberOfQuestions);

        // Optionally, display summary of correct and incorrect answers
        int incorrectAnswers = numberOfQuestions - score;
        System.out.println("Correct answers: " + score);
        System.out.println("Incorrect answers: " + incorrectAnswers);

        scanner.close();
    }
}
