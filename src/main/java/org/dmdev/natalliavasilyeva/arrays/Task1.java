package org.dmdev.natalliavasilyeva.arrays;

/*
 * Given a one-dimensional array of integers.
 * Write a function that removes all negative elements from it (remove means
 * that necessary to create a new array with only positive elements).
 * After removing - multiply each element of the array by its length.
 * For example: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 */

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {

        int[] array = {3, 5, -6, 3, 2, -9, 0, -123};
        int numberOfPositiveNumbers = countPositiveNumbers(array);
        int[] positiveArray = deleteNegativeNumbersFromArrayAndMultiplyToArrayLength(array, numberOfPositiveNumbers);

        System.out.println(Arrays.toString(positiveArray));

    }

    private static int[] deleteNegativeNumbersFromArrayAndMultiplyToArrayLength(int[] array, int lengthOfNewArray) {
        int[] positiveArray = new int[lengthOfNewArray];
        int positiveArrayLength = positiveArray.length;
        int positiveArrayIndex = 0;
        for (int j : array) {
            if (j >= 0) {
                positiveArray[positiveArrayIndex++] = j * positiveArrayLength;
            }
        }
        return positiveArray;
    }

    private static int countPositiveNumbers(int[] array) {
        int numberOfPositiveNumbers = 0;
        for (int j : array) {
            if (j >= 0) {
                numberOfPositiveNumbers++;
            }
        }
        return numberOfPositiveNumbers;
    }
}