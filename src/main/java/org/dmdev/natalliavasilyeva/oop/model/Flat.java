package org.dmdev.natalliavasilyeva.oop.model;

import org.dmdev.natalliavasilyeva.oop.interfaces.Printable;

import java.util.Arrays;
import java.util.Objects;

public class Flat implements Printable {

    private final int number;
    private final Room[] rooms;

    public Flat(int number, Room[] rooms) {
        this.number = number;
        this.rooms = rooms;
    }

    public int getNumber() {
        return number;
    }

    public Room[] getRooms() {
        return rooms;
    }

    @Override
    public void print() {
        System.out.printf("Flat %d has %s rooms%n", getNumber(), getRooms().length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.getNumber() && Arrays.equals(rooms, flat.getRooms());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(number);
        result = 31 * result + Arrays.hashCode(rooms);
        return result;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "number=" + number +
                ", rooms=" + Arrays.toString(rooms) +
                '}';
    }
}