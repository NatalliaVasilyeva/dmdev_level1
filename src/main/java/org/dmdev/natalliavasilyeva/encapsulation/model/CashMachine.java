package org.dmdev.natalliavasilyeva.encapsulation.model;

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
        return TWENTY_NOMINAL * getNumberOfTwentyNote();
    }

    public int getSumOfFiftyNotes() {
        return FIFTY_NOMINAL * getNumberOfFiftyNote();
    }

    public int getSumOfTHundredNotes() {
        return HUNDRED_NOMINAL * getNumberOfTHundredNote();
    }

    public void addTwentyNotes(int numberOfNotes) {
        setNumberOfTwentyNote(getNumberOfTwentyNote() + numberOfNotes);
    }

    public void addFiftyNotes(int numberOfNotes) {
        setNumberOfFiftyNote(getNumberOfFiftyNote() + numberOfNotes);
    }

    public void addHundredNotes(int numberOfNotes) {
        setNumberOfTHundredNote(getNumberOfTHundredNote() + numberOfNotes);
    }

    public boolean withdrawMoney(int sum) {

        int cashMachineAllSum = getSumOfTwentyNotes() + getSumOfFiftyNotes() + getSumOfTHundredNotes();
        if (sum > cashMachineAllSum) {
            return false;
        }
        if (sum < TWENTY_NOMINAL) {
            return false;
        }
        if (sum % 10 != 0) {
            return false;
        }
        int currentNumberOfTwentyNote = getNumberOfTwentyNote();
        int currentNumberOfFiftyNote = getNumberOfFiftyNote();
        int currentNumberOfHundredNote = getNumberOfTHundredNote();
        if (cashMachineAllSum == sum) {
            System.out.printf("You withdraw money with next notes: 20 - %d number, 50 - %d, 100 - %d%n", currentNumberOfTwentyNote, currentNumberOfFiftyNote, currentNumberOfHundredNote);
            setNumberOfTwentyNote(0);
            setNumberOfFiftyNote(0);
            setNumberOfTHundredNote(0);
            return true;
        }

        int twentyNotesNumber = 0;
        int fiftyNotesNumber = 0;
        int hundredNotesNumber = 0;

        if (sum >= HUNDRED_NOMINAL) {
            int hundredNotesNumberRequired = sum / HUNDRED_NOMINAL;
            hundredNotesNumber = Math.min(currentNumberOfHundredNote, hundredNotesNumberRequired);
            sum = sum - (hundredNotesNumber * HUNDRED_NOMINAL);
        } else if (sum >= FIFTY_NOMINAL) {
            int fiftyNotesNumberRequired = sum / FIFTY_NOMINAL;
            fiftyNotesNumber = Math.min(currentNumberOfFiftyNote, fiftyNotesNumberRequired);
            sum = sum - (fiftyNotesNumber * FIFTY_NOMINAL);
        } else {
            twentyNotesNumber = sum / TWENTY_NOMINAL;
            sum = sum - (twentyNotesNumber * TWENTY_NOMINAL);
        }

        if (sum == 0) {
            System.out.printf("You withdraw money with next notes: 20 - %d number, 50 - %d, 100 - %d%n", twentyNotesNumber, fiftyNotesNumber, hundredNotesNumber);
            setNumberOfTwentyNote(currentNumberOfTwentyNote - twentyNotesNumber);
            setNumberOfFiftyNote(currentNumberOfFiftyNote - fiftyNotesNumber);
            setNumberOfTHundredNote(currentNumberOfHundredNote - hundredNotesNumber);
            return true;
        } else {
            return false;
        }
    }
}