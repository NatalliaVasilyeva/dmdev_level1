package org.dmdev.natalliavasilyeva.collections.practicetask2.second.car;

import java.util.Objects;

public class Truck extends Car{

   private int loadCapacity;

    public Truck(Brand brand, Model model, int year, Color color, int loadCapacity) {
        super(brand, model, year, color);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck track = (Truck) o;
        return loadCapacity == track.loadCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), loadCapacity);
    }

    @Override
    public String toString() {
        return "Track{" +
                "loadCapacity=" + loadCapacity +
                '}' + super.toString();
    }
}