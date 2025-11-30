package org.example;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    private static int maxNumber = 100;
    private static int maxAttempts = 0;

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to 'Guess the Number' game!👏");

        while (true) {
            chooseDifficulty();
            playRound();

            System.out.print("🔄Would you like to play again?(y/n): ");
            String answer = scanner.next().trim().toLowerCase();

            if (!answer.equals("y")) {
                System.out.println("Thanks for playing!Goodbye👋");
                break;
            }
        }
    }

    public static void chooseDifficulty() {
        System.out.println("Choose difficulty:");
        System.out.println("1) Easy (1–50)");
        System.out.println("2) Medium (1–100)");
        System.out.println("3) Hard (1–500)");
        System.out.println("4) Limited attempts (1–100, 10 attempts)");
        System.out.print("Your choice: ");

        int choice = readInt();
        Random random = new Random();

        switch (choice) {
            case 1:
                maxNumber = 50;
                maxAttempts = 0;
                System.out.println("Difficulty set:Easy (1-50)");
                break;
            case 2:
                maxNumber = 100;
                maxAttempts = 0;
                System.out.println("Difficulty set:Medium (1-100)");
                break;
            case 3:
                maxNumber = 500;
                maxAttempts = 0;
                System.out.println("Difficulty set:Hard (1-500)");
                break;
            case 4:
                maxNumber = 100;
                maxAttempts = 10;
                System.out.println("Difficulty set:Limited attempts (10)");
                break;
            default:
                System.out.println("‼️Invalid choice.🔁Default set: Medium.");
                maxNumber = 100;
                maxAttempts = 0;
                break;
        }
        System.out.println("✅Computer has chosen the number. Try to guess it");
    }

    public static void playRound() {
        Random random = new Random();
        int secret = random.nextInt(maxNumber) + 1;
        int attempts = 0;

        System.out.println("Computer has chosen the number. Try to guess it!");

        while (true) {
            System.out.print("Your answer: ");
            int guess = readInt();
            attempts++;

            if (guess < 1 || guess > maxNumber) {
                System.out.println("❌ The Number must be between 1 and " + maxNumber);
                attempts--;
                continue;
            }

            if (guess > secret) {
                System.out.println("⬆️Too high");
            } else if (guess < secret) {
                System.out.println("⬇️Too low");
            } else {
                System.out.println("🏆Congratulations, you won!");
                System.out.println("Number of attempts: " + attempts);
                break;
            }


            if (maxAttempts > 0 && attempts >= maxAttempts) {
                System.out.println("Game over!You've used all " + maxAttempts + " attempts.");
                System.out.println("The secret number was: " + secret);
                break;
            }
        }
    }

    public static int readInt() {
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextInt()) {
            System.out.println("Error❗️Please enter a number");
            scanner.next();
            System.out.print("Try again: ");
        }
        int number = scanner.nextInt();
        return number;
    }
}