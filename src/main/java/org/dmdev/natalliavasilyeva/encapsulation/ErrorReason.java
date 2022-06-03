package org.dmdev.natalliavasilyeva.encapsulation;

public enum ErrorReason {
    NOT_ENOUGH_MONEY("Not enough money in the ATM. Please find another ATM or withdrow a smaller sum"),
    TOO_SMALL_SUM("You sum is too small. Please find another ATM or withdrow a smaller sum"),
    NOT_ROUND_SUM("You sum is not a round. Please input other sum"),
    NOT_EXIST_NECESSARY_NOTES("There is no possibility to give you money with exists notes");

    private final String reason;

    ErrorReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}