package org.dmdev.natalliavasilyeva.operations;

/**
 * The variable "minutes" contains a value from 0 to 59.
 * Write a function that takes the value of minutes as a parameter and prints result in console.
 * Result shows which quarter does given number of minutes represents (first, second, third or fourth).
 * <p>
 * Test the function in the main method.
 */

public class Task1 {

    public static void main(String[] args) {
        getHourQuarter(40);
        getHourQuarter(101);
    }

    public static void getHourQuarter(int minutes) {
        String result;
        if (isCorrectMinutesValue(minutes)) {
            if (minutes >= 0 && minutes <= 15) {
                result = String.format("%d minutes is the first quarter of the hour", minutes);
            } else if (minutes > 15 && minutes <= 30) {
                result = String.format("%d minutes is the second quarter of the hour", minutes);
            } else if (minutes > 30 && minutes <= 45) {
                result = String.format("%d minutes is the third quarter of the hour", minutes);
            } else {
                result = String.format("%d minutes is the fourth quarter of the hour", minutes);
            }
        } else {
            result = String.format("%d minutes is not valid", minutes);
        }
        System.out.println(result);
    }

    private static boolean isCorrectMinutesValue(int minutes) {
        return minutes >= 0 && minutes <= 59;
    }
}