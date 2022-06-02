package org.dmdev.natalliavasilyeva.loops;

/**
 * Count the even and odd digits of number and print them to the console.
 * There is necessary to write 2 functions that will take the number,
 * and will return the number of even digits (and of odd digits).
 */

public class Task1 {
    public static void main(String[] args) {

        System.out.println("Number of odd digits: " + countOddDigit(228910));
        System.out.println("Number of even digits: " + countEvenDigit(228910));

    }

    public static int countEvenDigit(int number) {
        int numberOfOddDigits = 0;
        int lastDigit;
        while (number > 0) {
            lastDigit = number % 10;
            number = number / 10;
            if (lastDigit % 2 == 0) {
                numberOfOddDigits++;
            }
        }
        return numberOfOddDigits;
    }

    public static int countOddDigit(int number) {
        int numberOfEvenDigits = 0;
        int lastDigit;
        while (number > 0) {
            lastDigit = number % 10;
            number = number / 10;
            if (lastDigit % 2 != 0) {
                numberOfEvenDigits++;
            }
        }
        return numberOfEvenDigits;
    }
}