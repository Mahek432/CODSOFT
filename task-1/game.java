import java.util.Scanner;
import java.util.Random;

public class game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int maxRange = 100; // Maximum number for the random number (1 to 100)
        int maxAttempts = 10; // Maximum attempts allowed per round
        int totalAttempts = 0; // Total attempts across all rounds
        int roundsWon = 0; // Count of rounds won
        
        boolean playAgain = true;
        
        while (playAgain) {
            int secretNumber = random.nextInt(maxRange) + 1; // Generate a random number
            
            System.out.println("Welcome to  Number Guessing Game!");
            System.out.println("I have chosen a number between 1 - 100.");
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess 1-100: ");
                int guess = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                attempts++;
                
                if (guess < 1 || guess > 100) {
                    System.out.println("enter a number within the range of 1 to 100.");
                    continue;
                }
                
                if (guess < secretNumber) {
                    System.out.println(" low! Try guessing higher.");
                } else if (guess > secretNumber) {
                    System.out.println("high! Try guessing lower.");
                } else {
                    System.out.println(" You've guessed the number ...... congratulationsss" + secretNumber + " correctly.");
                    guessedCorrectly = true;
                    roundsWon++;
                }
            }
            
            totalAttempts += attempts;
            
            if (!guessedCorrectly) {
                System.out.println("we are Sorry, you've run out of attempts. The guessed number was " + secretNumber + ".");
            }
            
            System.out.println("Round over. Attempts taken by you is: " + attempts);
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine().toLowerCase();
            
            if (!playAgainInput.equals("yes") && !playAgainInput.equals("y")) {
                playAgain = false;
            }
        }
        
        System.out.println("your Game over ........... played " + roundsWon + " rounds with total of " + totalAttempts + " attempt(s).");
        
        scanner.close();
    }
}

