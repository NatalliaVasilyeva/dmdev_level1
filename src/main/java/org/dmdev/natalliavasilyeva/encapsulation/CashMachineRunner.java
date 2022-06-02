package org.dmdev.natalliavasilyeva.encapsulation;

import org.dmdev.natalliavasilyeva.encapsulation.model.CashMachine;

public class CashMachineRunner {

    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine
                (20, 10, 5);

        cashMachine.addTwentyNotes(1);
        cashMachine.addFiftyNotes(1);
        cashMachine.addHundredNotes(1);

        System.out.println(cashMachine.withdrawMoney(1080));

    }
}