package org.dmdev.natalliavasilyeva.oop.model;

import org.dmdev.natalliavasilyeva.oop.interfaces.Printable;

import java.util.Arrays;
import java.util.Objects;

public class House implements Printable {
    private final int number;

    private final Floor[] floors;

    public House(int number, Floor[] floors) {
        this.number = number;
        this.floors = floors;
    }

    public int getNumber() {
        return number;
    }

    public Floor[] getFloors() {
        return floors;
    }

    @Override
    public void print() {
        System.out.printf("House %d, number of floors - %s%n", getNumber(), getFloors().length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return number == house.getNumber() && Arrays.equals(floors, house.getFloors());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(number);
        result = 31 * result + Arrays.hashCode(floors);
        return result;
    }

    @Override
    public String toString() {
        return "House{" +
                "number=" + number +
                ", floors=" + Arrays.toString(floors) +
                '}';
    }
}