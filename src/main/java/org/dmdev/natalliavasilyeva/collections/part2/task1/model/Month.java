package org.dmdev.natalliavasilyeva.collections.part2.task1.model;

public enum Month {
    JANUARY("JANUARY"),
    FEBRUARY("FEBRUARY"),
    MARCH("MARCH"),
    APRIL("APRIL"),
    MAY("MAY"),
    JUNE("JUNE"),
    JULY("JULY"),
    AUGUST("AUGUST"),
    SEPTEMBER("SEPTEMBER"),
    OCTOBER("OCTOBER"),
    NOVEMBER("NOVEMBER"),
    DECEMBER("DECEMBER");

    final String months;

    Month(String months) {
        this.months = months;
    }

    public String getMonths() {
        return months;
    }
}