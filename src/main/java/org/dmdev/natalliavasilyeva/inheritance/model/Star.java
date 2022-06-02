package org.dmdev.natalliavasilyeva.inheritance.model;

import java.util.Objects;

public class Star extends SpaceObject {

    private final Color color;
    private final double temperature;

    public Star(String name, double weight, double radius, Color color, double temperature) {
        super(name, weight, radius);
        this.color = color;
        this.temperature = temperature;
    }

    public Color getColor() {
        return color;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public double getDiameter() {

        return getRadius() * 10 / 5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Star star = (Star) o;
        return Double.compare(star.temperature, getTemperature()) == 0 && getColor() == star.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor(), getTemperature());
    }
}