package org.dmdev.natalliavasilyeva.collections.practicetask2.second.car;

import java.util.Objects;

public abstract class Car {
    private Brand brand;
    private Model model;
    private int year;
    private Color color;


    public Car(Brand brand, Model model, int year, Color color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Brand getBrand() {
        return brand;
    }

    public Model getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public Color getColor() {
        return color;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && brand == car.brand && model == car.model && color == car.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand=" + brand +
                ", model=" + model +
                ", year=" + year +
                ", color=" + color +
                '}';
    }
}