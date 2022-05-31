package org.dmdev.natalliavasilyeva.operations;

/**
 * There are two right triangles.
 * Each of them is given by two integer variables a and b - sides of the triangle.
 * Write code that calculates the square of each triangle and then compares those squares with each other.
 *
 * You need to write 2 functions.
 * First: calculate square using sides of the triangle.
 * Second: compares the squares of two triangles and print is the first triangle greater,
 * less or equal than second.
 *
 * Keep in mind  - the square can be a real number.
 */

public class Task3 {

    public static void main(String[] args) {
        double firstSquare = calculateTriangleSquare(3, 10);
        double secondSquare = calculateTriangleSquare(2, 5);
        System.out.println(compareSquareOfTwoTriangles(firstSquare, secondSquare));
    }

    private static double calculateTriangleSquare(double a, double b) {
        return (a * b) / 2;
    }

    private static String compareSquareOfTwoTriangles(double firstTriangleSquare, double secondTriangleSquare) {
        return firstTriangleSquare > secondTriangleSquare ? "The square of the first triangle is greater than the square of the second triangle" :
              firstTriangleSquare < secondTriangleSquare ? "The square of the first triangle is less than the square of the second triangle" :
                      "The square of the first triangle is equal to the square of the second triangle";
    }
}