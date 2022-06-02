package org.dmdev.natalliavasilyeva.operations;

/**
 * There is 3 variables:
 *
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 *
 * Write a function that takes these three variables as parameters and returns the result of the operation.
 * Test the function in the main method.
 */

public class Task2 {
    public static void main(String[] args) {

        double resultSum = calculateValue(1, 2, '+');
        System.out.println(resultSum);

        double resultDivision = calculateValue(10, 1, '/');
        System.out.println(resultDivision);

        calculateValue(10, 1, '&');

    }

    public static double calculateValue(double firstOperand, double secondOperand, char operation) {
        double result;
        switch (operation) {
            case '+': result = firstOperand + secondOperand; break;
            case '-': result = firstOperand - secondOperand; break;
            case '*': result = firstOperand * secondOperand; break;
            case '/': result = firstOperand / secondOperand; break;
            case '%': result = firstOperand % secondOperand; break;
            default:
                throw new IllegalArgumentException("Operation doesn't exist");
        }
        return result;
    }
}