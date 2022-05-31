package org.dmdev.natalliavasilyeva.strings;


/*
Given a string with text that contains numbers from 0 to 9.

Write 2 methods:

- return an array of digits from the passed string
- return the sum of digits from the passed integer array

Calculate the sum of all numbers from a string

For example:
“Hi 8, how are you 1 2? Maybe 4, do 3 things?” -> 18 (8+1+2+4+3)
 */

public class Task2 {

    public static void main(String[] args) {
        String string = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";
        int[] array = catchNumbersFromString(string);
        System.out.println(countSum(array));

    }

    public static int[] catchNumbersFromString(String inputString) {
        if (inputString.isBlank()) {
            return new int[]{};
        }

        inputString = inputString.replaceAll(" ", "");
        StringBuilder num = new StringBuilder();
        char[] char_arr = inputString.toCharArray();
        for (char c : char_arr) {
            if (Character.isDigit(c)) {
                num.append(c);
            }
        }
        char[] digitWords = num.toString().toCharArray();
        int digitWordsLength = digitWords.length;
        int[] result = new int[digitWordsLength];
        for (int i = 0; i < digitWordsLength; i++) {
            result[i] = Character.getNumericValue(digitWords[i]);
        }
        return result;
    }

    public static int countSum(int[] array) {
        int sum = 0;
        if (array.length == 0) {
            return sum;
        }
        for (int j : array) {
            sum += j;
        }
        return sum;
    }
}