import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Define the range of numbers
        int min = 1;
        int max = 100;

        // Number of attempts allowed
        int maxAttempts = 5;

        // Initialize variables
        int score = 0;
        int rounds = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            rounds++;
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("\nRound " + rounds + ":");
            System.out.println("I have selected a number between " + min + " and " + max + ". Can you guess it?");

            while (!correctGuess && attempts < maxAttempts) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else if (guess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }

            score += maxAttempts - attempts + 1;

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
