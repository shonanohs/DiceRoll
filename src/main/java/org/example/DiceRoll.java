package org.example;

public class DiceRoll {
    public static void main(String[] args) {
        int[] diceNums = {1, 2, 3, 4, 5, 6};

        int max = 6;
        int min = 1;
        int range = max - min + 1;
        // Roll dice
        int roll1 = (int) (Math.random() * range) + min;
        System.out.println(roll1);




    }
}