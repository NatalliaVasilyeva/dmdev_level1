package org.dmdev.natalliavasilyeva.inheritance.model;

import java.util.Objects;

public class SpaceObject {
    private final String name;
    private final double weight;
    private final double radius;

    public SpaceObject(String name, double weight, double radius) {
        this.name = name;
        this.weight = weight;
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getRadius() {
        return radius;
    }

    public double getDiameter() {
        return getRadius() * 2;
    }

    public int compareTwoSpaceObjectsWeight(SpaceObject spaceObject) {
        return this.getWeight() - spaceObject.getWeight() > 1 ?
                1 : getWeight() - spaceObject.getWeight() < 1 ?
                -1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceObject that = (SpaceObject) o;
        return Double.compare(that.weight, getWeight()) == 0 &&
                Double.compare(that.radius, getRadius()) == 0 &&
                Objects.equals(getName(), that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWeight(), getRadius());
    }
}