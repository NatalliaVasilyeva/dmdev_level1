package org.dmdev.natalliavasilyeva.loops;

/**
 * Immediately after completing the dmdev courses, the programmer Vanya got a job in an IT company
 * as a Junior Java Developer with a salary of $600 per month.
 * He was promised that they would raise his salary by $400 every 6 months.
 * Vanya spends $300 a month on food and entertainment.
 * Vanya monthly transfers 10% of his salary to the broker's account
 * in order to invest in stocks with a yield of 2% per month.
 *
 * Calculate how much Vanya will have on his account and on the broker's account for 3 years and 2 months.
 */

public class Task3 {


    public static void main(String[] args) {

        calculateAccountsSum(600, 400, 6,
                300, 10, 2, 38);

    }

    private static void calculateAccountsSum(double baseSalary,
                                             double salaryIncrease,
                                             int salaryIncreaseDelay,
                                             double expenses,
                                             double brokerTransferPercent,
                                             double stockPercent,
                                             int numberOfMonth) {
        double personalAccountSum = 0;
        double brokerAccountSum = 0;
        double currentSalary = baseSalary;
        for (int i = 1; i <= numberOfMonth; i++) {
            double brokerTransferSum = currentSalary * brokerTransferPercent / 100;
            personalAccountSum = personalAccountSum + currentSalary - expenses - brokerTransferSum;
            brokerAccountSum = brokerAccountSum + brokerTransferSum + brokerAccountSum * stockPercent / 100;
            if (i % salaryIncreaseDelay == 0) {
                currentSalary += salaryIncrease;
            }
        }
        System.out.printf("Personal account sum is %.2f", personalAccountSum);
        System.out.println();
        System.out.printf("Broker account sum is %.2f",brokerAccountSum);
    }
}