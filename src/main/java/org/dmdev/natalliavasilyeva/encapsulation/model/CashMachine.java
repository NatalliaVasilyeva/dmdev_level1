package org.dmdev.natalliavasilyeva.encapsulation.model;

import org.dmdev.natalliavasilyeva.encapsulation.ErrorReason;

public class CashMachine {

    private static final int TWENTY_NOMINAL = 20;
    private static final int FIFTY_NOMINAL = 50;
    private static final int HUNDRED_NOMINAL = 100;


    private int numberOfTwentyNote;
    private int numberOfFiftyNote;
    private int numberOfTHundredNote;

    public CashMachine(int numberOfTwentyNote, int numberOfFiftyNote, int numberOfTHundredNote) {
        this.numberOfTwentyNote = numberOfTwentyNote;
        this.numberOfFiftyNote = numberOfFiftyNote;
        this.numberOfTHundredNote = numberOfTHundredNote;
    }

    public int getNumberOfTwentyNote() {
        return numberOfTwentyNote;
    }

    public int getNumberOfFiftyNote() {
        return numberOfFiftyNote;
    }

    public int getNumberOfTHundredNote() {
        return numberOfTHundredNote;
    }

    public void setNumberOfTwentyNote(int numberOfTwentyNote) {
        this.numberOfTwentyNote = numberOfTwentyNote;
    }

    public void setNumberOfFiftyNote(int numberOfFiftyNote) {
        this.numberOfFiftyNote = numberOfFiftyNote;
    }

    public void setNumberOfTHundredNote(int numberOfTHundredNote) {
        this.numberOfTHundredNote = numberOfTHundredNote;
    }

    public int getSumOfTwentyNotes() {
        return TWENTY_NOMINAL * this.numberOfTwentyNote;
    }

    public int getSumOfFiftyNotes() {
        return FIFTY_NOMINAL * this.numberOfFiftyNote;
    }

    public int getSumOfTHundredNotes() {
        return HUNDRED_NOMINAL * this.numberOfTHundredNote;
    }

    public void addTwentyNotes(int numberOfNotes) {
        this.numberOfTwentyNote += numberOfNotes;
    }

    public void addFiftyNotes(int numberOfNotes) {
        this.numberOfFiftyNote += numberOfNotes;
    }

    public void addHundredNotes(int numberOfNotes) {
        this.numberOfTHundredNote += numberOfNotes;
    }

    public boolean withdrawMoney(int sum) {

        int cashMachineAllSum = getCashMachineBalance();
        if (sum > cashMachineAllSum) {
            printNegativeResult(ErrorReason.NOT_ENOUGH_MONEY);
            return false;
        }
        if (sum < TWENTY_NOMINAL) {
            printNegativeResult(ErrorReason.TOO_SMALL_SUM);
            return false;
        }
        if (sum % 10 != 0) {
            printNegativeResult(ErrorReason.NOT_ROUND_SUM);
            return false;
        }
        int currentNumberOfTwentyNote = getNumberOfTwentyNote();
        int currentNumberOfFiftyNote = getNumberOfFiftyNote();
        int currentNumberOfHundredNote = getNumberOfTHundredNote();
        if (cashMachineAllSum == sum) {
            printPositiveResult(currentNumberOfTwentyNote, currentNumberOfFiftyNote, currentNumberOfHundredNote);
            setNumberOfTwentyNote(0);
            setNumberOfFiftyNote(0);
            setNumberOfTHundredNote(0);
            return true;
        }

        int twentyNotesNumber = 0;
        int fiftyNotesNumber = 0;
        int hundredNotesNumber = 0;

        if (sum >= HUNDRED_NOMINAL) {
            hundredNotesNumber = Math.min(currentNumberOfHundredNote, countNecessaryNumberOfNotes(sum, HUNDRED_NOMINAL));
            sum = countBalanceOfNotes(sum, hundredNotesNumber, HUNDRED_NOMINAL);
            currentNumberOfHundredNote -= hundredNotesNumber;
        }
        if (sum >= FIFTY_NOMINAL) {
            fiftyNotesNumber = Math.min(currentNumberOfFiftyNote, countNecessaryNumberOfNotes(sum, FIFTY_NOMINAL));
            sum = countBalanceOfNotes(sum, fiftyNotesNumber, FIFTY_NOMINAL);
            currentNumberOfFiftyNote -= fiftyNotesNumber;
        }
        if (sum >= TWENTY_NOMINAL) {
            twentyNotesNumber = countNecessaryNumberOfNotes(sum, TWENTY_NOMINAL);
            sum = countBalanceOfNotes(sum, twentyNotesNumber, TWENTY_NOMINAL);
            currentNumberOfTwentyNote -= twentyNotesNumber;
        }

        if (sum == 0) {
            printPositiveResult(twentyNotesNumber, fiftyNotesNumber, hundredNotesNumber);
            setNumberOfTwentyNote(currentNumberOfTwentyNote);
            setNumberOfFiftyNote(currentNumberOfFiftyNote);
            setNumberOfTHundredNote(currentNumberOfHundredNote);
            return true;
        }
        printNegativeResult(ErrorReason.NOT_EXIST_NECESSARY_NOTES);
        return false;
    }

    private int getCashMachineBalance() {
        return getSumOfTwentyNotes() + getSumOfFiftyNotes() + getSumOfTHundredNotes();
    }

    private int countNecessaryNumberOfNotes(int sum, int noteNominal) {
        return sum / noteNominal;
    }

    private int countBalanceOfNotes(int sum, int numberOfNotes, int noteNominal) {
        return sum - (numberOfNotes * noteNominal);
    }

    private void printPositiveResult(int twentyNotesNumber, int fiftyNotesNumber, int hundredNotesNumber) {
        System.out.printf("You withdraw money with next notes: 20 - %d number, 50 - %d, 100 - %d%n", twentyNotesNumber, fiftyNotesNumber, hundredNotesNumber);

    }

    private void printNegativeResult(ErrorReason reason) {
        System.out.println(reason.getReason());

    }
}