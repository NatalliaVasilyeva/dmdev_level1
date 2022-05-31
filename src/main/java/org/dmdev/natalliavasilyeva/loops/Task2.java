package org.dmdev.natalliavasilyeva.loops;

/**
 * Given an integer number.
 * Write a function that takes an integer and returns a reverse of it number (not a string!).
 * Print the result to the console.
 * For example: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 *
 * Note: the solution may required: Math.pow(number, power)
 */

public class Task2 {

    public static void main(String[] args) {
        System.out.println(reverseNumber(4508));
        System.out.println(reverseNumber(4700));
        System.out.println(reverseNumber(1234567));
    }

    public static int reverseNumber(int number) {
        number = number > 0 ? number : number * -1;
        int result = 0;
        int firstDigit;
        while (number > 0) {
            firstDigit = number % 10;
            result = result * 10 + firstDigit;
            number = number / 10;
        }
        return result;
    }
}