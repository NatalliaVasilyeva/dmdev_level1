package org.dmdev.natalliavasilyeva.collections.practicetask2.second.car;

import java.util.Objects;

public class Bus extends Car {

    private int numberOfSeats;

    public Bus(Brand brand, Model model, int year, Color color, int numberOfSeats) {
        super(brand, model, year, color);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return numberOfSeats == bus.numberOfSeats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfSeats);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "numberOfSeats=" + numberOfSeats +
                '}' + super.toString();
    }
}