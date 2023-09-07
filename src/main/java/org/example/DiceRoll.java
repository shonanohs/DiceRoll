package org.example;

import java.util.Scanner;

public class DiceRoll {
    public static void main(String[] args) {
        boolean shouldRepeat = true;
        Scanner getInput = new Scanner(System.in);

        while (shouldRepeat) {
            drawDice();
            System.out.println("Welcome to Dice Roller! Would you like to give it a spin? ");
            String userResponse = getInput.nextLine();

            if (userResponse.equalsIgnoreCase("yes") || userResponse.equalsIgnoreCase("y")) {
                shouldRepeat = false;
                int point = calculateInitialScore();
                if (point != 0) {
                    calculateSubsequentScore(point);
                }
                System.out.println("Would you like to roll again? ");
                userResponse = getInput.nextLine();
                if (userResponse.equalsIgnoreCase("yes") || userResponse.equalsIgnoreCase("y")) {
                    shouldRepeat = true;
                }
                else {
                    System.out.println("Thanks for playing Dice Roller!");
                }
            }
            else if (userResponse.equalsIgnoreCase("no") || userResponse.equalsIgnoreCase("n")) {
                System.out.println("Ok... see you next time! ");
                shouldRepeat = false;
            }
            else {
                System.out.println("Invalid input. Please enter yes/no. ");
            }
        }
    }


    private static int rollDice() {
        // Set min and max values for roll
        int max = 6;
        int min = 1;
        int range = max - min + 1;
        // Generate number at random between min and max numbers inclusive
        int roll = (int) (Math.random() * range) + min;
        System.out.println("You rolled a " + roll);
        return roll;
    }

    private static int calculateInitialScore() {
        Scanner getInput = new Scanner(System.in);
        System.out.println("Let's go! Press enter to roll the dice.");
        getInput.nextLine();
        int roll1 = rollDice();
        System.out.println("Now roll the second dice... ");
        getInput.nextLine();
        int roll2 = rollDice();
        int point = roll1 + roll2;

        switch (point) {
            case 7, 11 -> {
                System.out.println("Congratulations you win! ");
                point = 0;
            }
            case 2, 3, 12 -> {
                System.out.println("Sorry, you lose... Try again!");
                point = 0;
            }
            default -> {System.out.println("Your point is: " + point + ". Keep rolling! ");}
        }
        return point;
    }

    private static void calculateSubsequentScore(int point) {
        Scanner getInput = new Scanner(System.in);
        System.out.println("Let's roll again...");
        getInput.nextLine();
        int roll1 = rollDice();
        System.out.println("And again... ");
        getInput.nextLine();
        int roll2 = rollDice();
        int sum = roll1 + roll2;

        if (sum == 7) {
            System.out.println("Sorry, you lose!");
        }
        else if (sum == point) {
            System.out.println("Congratulations, you win - you matched your point!");
        }
        else {
                System.out.println("You rolled a " + sum + ". Not a match - keep rolling!");
                calculateSubsequentScore(point);
            }
        }

    private static void drawDice() {
        System.out.println("""
                  .-------.    ______
                 /   o   /|   /\\     \\
                /_______/o|  /o \\  o  \\
                | o     | | /   o\\_____\\
                |   o   |o/ \\o   /o    /
                |     o |/   \\ o/  o  /
                '-------'     \\/____o/""".indent(5));
    }
}