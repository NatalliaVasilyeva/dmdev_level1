package org.dmdev.natalliavasilyeva.oop.model;

import org.dmdev.natalliavasilyeva.oop.interfaces.Printable;

import java.util.Arrays;
import java.util.Objects;

public class Floor implements Printable {

    private final int number;
    private final Flat[] flats;

    public Floor(int number, Flat[] flats) {
        this.number = number;
        this.flats = flats;
    }

    public int getNumber() {
        return number;
    }

    public Flat[] getFlats() {
        return flats;
    }

    @Override
    public void print() {
        System.out.printf("Floor %d, number of flats - %s%n", getNumber(), getFlats().length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return number == floor.getNumber() && Arrays.equals(flats, floor.getFlats());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(number);
        result = 31 * result + Arrays.hashCode(flats);
        return result;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "number=" + number +
                ", flats=" + Arrays.toString(flats) +
                '}';
    }
}