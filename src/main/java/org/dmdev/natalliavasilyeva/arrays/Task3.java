package org.dmdev.natalliavasilyeva.arrays;

import java.util.Arrays;

/**
 * Given a one-dimensional array of integers.
 *
 * Write a function that takes this array and splits it into 3 others:
 * with only negative numbers, only positive numbers, and only zeros.
 * If there are no values for any of the arrays, then an empty array must be created.
 * The function returns these three arrays as one two-dimensional array.
 */

public class Task3 {
    public static void main(String[] args) {
        int [] array = {-4, 0, 1, 9, 0, -18, 3};
        int[][] result = splitOneArrayToThree(array);
        System.out.println(Arrays.deepToString(result));

    }

    public static int[][] splitOneArrayToThree(int[] array) {
        int[] arrayOfNumberCountResult = countNumbersInEachCategory(array);
        int[] positiveArray = new int[arrayOfNumberCountResult[0]];
        int[] negativeArray = new int[arrayOfNumberCountResult[1]];
        int[] zeroArray = new int[arrayOfNumberCountResult[2]];
        int positiveIndex = 0;
        int negativeIndex = 0;
        int zeroIndex = 0;

        for (int j : array) {
            if (j > 0) {
                positiveArray[positiveIndex++] = j;
            } else if (j < 0) {
                negativeArray[negativeIndex++] = j;
            } else {
                zeroArray[zeroIndex++] = j;
            }
        }
        return new int[][]{positiveArray, negativeArray, zeroArray};
    }

    public static int[] countNumbersInEachCategory(int[] array) {
        int numberOfPositiveNumbers = 0;
        int numberOfNegativeNumbers = 0;
        int numberOfZeroNumbers = 0;

        for (int j : array) {
            if (j > 0) {
                numberOfPositiveNumbers++;
            } else if (j < 0) {
                numberOfNegativeNumbers++;
            } else {
                numberOfZeroNumbers++;
            }
        }
        return new int[]{numberOfPositiveNumbers, numberOfNegativeNumbers, numberOfZeroNumbers};
    }
}