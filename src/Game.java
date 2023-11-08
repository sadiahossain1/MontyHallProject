import java.util.Scanner;
public class Game {
    private int carPosition;
    private int playerGuess;
    private int revealedGoat;

    public Game() {
        carPosition = (int) (Math.random() * 3) + 1;
    }

    public void guess() {
        System.out.println("Welcome to the Monty Hall Game!\n\nThere are two goats and a car " +
                "randomly placed behind doors 1, 2, and 3");
        Scanner scan = new Scanner(System.in);
        System.out.print("Where do you think the car is? Enter 1, 2, or 3: ");
        playerGuess = scan.nextInt();
    }

    public void goat() {
        revealedGoat = -1;
        if (carPosition != 1 && playerGuess != 1) {
            revealedGoat = 1;
        } else if (carPosition != 2 && playerGuess != 2) {
            revealedGoat = 2;
        } else if (carPosition != 3 && playerGuess != 3) {
            revealedGoat = 3;
        }
        System.out.println("One of the goats is behind door number " + revealedGoat);
    }

    public void switchAndWin() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Do you want to switch your guess? Yes or No: ");
        String switchChoice = scan.nextLine();
        if (switchChoice.equals("Yes")) {
            int switchedDoor = 6 - revealedGoat - playerGuess;
            System.out.println("Guess switched from " + playerGuess + " to " + switchedDoor);
            if (switchedDoor == carPosition) {
                System.out.println("You win!");
            } else {
                System.out.println("The car is behind door " + carPosition + ". You lost! (Or you could say you won a goat!)");
            }
        } else {
            if (playerGuess == carPosition) {
                System.out.println("You win!");
            } else {
                System.out.println("The car is behind door " + carPosition + ". You lost! (Or you could say you won a goat!)");
            }
        }
    }
}