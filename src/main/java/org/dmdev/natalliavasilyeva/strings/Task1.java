package org.dmdev.natalliavasilyeva.strings;

/*
Given a line.
Remove from it all repeated characters, case insensitive, if they follow one another. Also remove spaces.
The result is converted to upper case.

For example:
"abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */

public class Task1 {

    public static void main(String[] args) {
        String string = "abc Cpddd Dio OsfWw";
        printResult(removeDublicates(string));
    }

    public static String removeDublicates(String inputString) {
        if (inputString.isBlank()) {
            return "";
        }

        if (inputString.length() == 1) {
            return inputString.toUpperCase();
        }

        StringBuilder sb = new StringBuilder();
        char[] charArray = inputString.replaceAll("\\s+", "").toUpperCase().toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                sb.append(charArray[i]);
                break;
            }
            if (charArray[i] != charArray[i + 1]) {
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }

    public static void printResult(String result) {
        System.out.println(result);
    }
}