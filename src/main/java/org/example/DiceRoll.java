package org.example;

import java.util.Scanner;

public class DiceRoll {
    public static void main(String[] args) {
        Boolean shouldRepeat = true;

        Scanner getInput = new Scanner(System.in);

        while (shouldRepeat) {
            drawDice();
            System.out.println("Would you like to roll the dice? ");
            String UserResponse = getInput.nextLine();

            if (UserResponse.equalsIgnoreCase("yes") || UserResponse.equalsIgnoreCase("y")) {
                shouldRepeat = false;
                rollDice();
            }
            else if (UserResponse.equalsIgnoreCase("no") || UserResponse.equalsIgnoreCase("n")) {
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
        System.out.println("Let's go! Your initial roll is " + roll1); // Print out initial roll

        // Keep rolling dice while the rolls do not match the initial roll
        int count = 0;
        int roll2 = 0;
        while (roll1 != roll2) {
            roll2 = (int) (Math.random() * range) + min;
            if (roll1 == roll2) {
                break;
            }
            System.out.println("Roll " + (count + 1) + ": " + roll2);
            System.out.println("Try again!");
            getInput.nextLine();
            count++;
        }

        // Print out the number of rolls required to match initial roll
        System.out.println("Final roll: " + roll2);
        System.out.println("You did it, well done! It took " + count + " rolls.");
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