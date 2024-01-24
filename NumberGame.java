import java.util.Random;
import java.util.Scanner;

public class NumberGame {

  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 7;
        int rounds = 0;
        int totalAttempts = 0;
        int totalRoundsWon = 0;
        int generatedNumber;

        System.out.println("Welcome to the Number Guessing Game!");

        // Main game loop
        while (true) {
            generatedNumber = generateRandomNumber(minRange, maxRange);
            rounds++;
            totalAttempts = 0;

            System.out.println("\nRound " + rounds + ": Try to guess the number between " + minRange + " and " + maxRange);

            // Game loop for a single round
            while (totalAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");

                try {
                    int userGuess = Integer.parseInt(scanner.nextLine());

                    if (userGuess < minRange || userGuess > maxRange) {
                        System.out.println("Invalid guess. Please enter a number between " + minRange + " and " + maxRange);
                        continue;
                    }

                    totalAttempts++;

                    if (userGuess == generatedNumber) {
                        System.out.println("Congratulations! Your guess is correct.");
                        totalRoundsWon++;
                        break;
                    } else if (userGuess < generatedNumber) {
                        System.out.println("Your guess is too low!");
                    } else {
                        System.out.println("Your guess is too high!");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            System.out.println("Round over.");
            System.out.println("The number was: " + generatedNumber);
            System.out.println("Attempts in this round: " + totalAttempts);
            System.out.println("Total rounds won: " + totalRoundsWon);

            //If the user wants to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your final score: " + totalRoundsWon);
                break; // Exit the game 
            }

        }

        
        scanner.close();
    }

    // Helper method to generate a random number within the specified range
    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
