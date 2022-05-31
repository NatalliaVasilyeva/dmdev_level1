package org.dmdev.natalliavasilyeva.arrays;

/*
  Given a one-dimensional array of characters.
  Convert it to a one-dimensional array of numbers, where number is a character code
  (any character is a number in computer memory).
  For example: ['a', '6', 'y', 'P', 'T', 'q', '9', '+'] -> [97, 54, 121, 80, 84, 113, 57, 43]

  Next, determine the average value of all elements in array and print to
  the console only those elements that are greater than average value.
 */

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
        char[] charArray = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};
        int[] integerArray = convertArrayOfCharToArrayOfInteger(charArray);
        System.out.println(Arrays.toString(integerArray));
        double averageValue = calculateAverageValueOfIntegerArray(integerArray);
        printElementsGreaterAverage(integerArray, averageValue);

    }

    public static int[] convertArrayOfCharToArrayOfInteger(char[] charArray) {
        int charArrayLength = charArray.length;
        int[] intArray = new int[charArrayLength];

        for (int i = 0; i < charArrayLength; i++) {
            intArray[i] = charArray[i];
        }
        return intArray;
    }

    public static double calculateAverageValueOfIntegerArray(int[] integerArray) {
        int arrayLength = integerArray.length;
        double result;
        if (arrayLength != 0) {
            int sum = 0;
            for (int j : integerArray) {
                sum += j;
            }
            result = sum / arrayLength;
        } else {
            throw new NullPointerException("Array is empty");
        }
        return result;
    }

    public static void printElementsGreaterAverage(int[] array, double averageValue) {
        for (int j : array) {
            if (j > averageValue) {
                System.out.println(j);
            }
        }
    }
}