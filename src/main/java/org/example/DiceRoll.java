package org.example;

import java.util.Scanner;

public class DiceRoll {
    public static void main(String[] args) {
        Boolean shouldRepeat = true;

        Scanner getInput = new Scanner(System.in);

        while (shouldRepeat) {
            drawDice();
            System.out.println("Welcome to Dice Roller! Would you like to give it a spin? ");
            String userResponse = getInput.nextLine();

            if (userResponse.equalsIgnoreCase("yes") || userResponse.equalsIgnoreCase("y")) {
                shouldRepeat = false;
                rollDice();
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

    private static void rollDice() {
        Scanner getInput = new Scanner(System.in);

        // Set min and max values for roll
        int max = 6;
        int min = 1;
        int range = max - min + 1;
        // Generate number at random between min and max numbers inclusive
        int roll1 = (int) (Math.random() * range) + min;
        System.out.println("Let's go! Press enter to roll the dice.");
        getInput.nextLine();
        System.out.println("Your initial roll is " + roll1 + ". Now let's see how many rolls it takes " +
                "you to match it!"); // Print out initial roll
        getInput.nextLine();

        // Keep rolling dice while the rolls do not match the initial roll
        int count = 0;
        int roll2 = 0;
        while (roll1 != roll2) {
            count++;
            roll2 = (int) (Math.random() * range) + min;
            System.out.println("Roll " + (count) + ": " + roll2);
            if (roll1 == roll2) {
                // Print out the number of rolls required to match initial roll
                System.out.println("\nYou did it, well done! It took " + count + " roll(s).\n");
                break;
            }
            System.out.println("Try again!");
            getInput.nextLine();
        }
    }

    private static void drawDice() {
        System.out.println("       .-------.    ______\n" +
                "      /   o   /|   /\\     \\\n" +
                "     /_______/o|  /o \\  o  \\\n" +
                "     | o     | | /   o\\_____\\\n" +
                "     |   o   |o/ \\o   /o    /\n" +
                "     |     o |/   \\ o/  o  /\n" +
                "     '-------'     \\/____o/");
    }
}