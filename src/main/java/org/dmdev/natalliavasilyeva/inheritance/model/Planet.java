package org.dmdev.natalliavasilyeva.inheritance.model;

import java.util.Objects;

public class Planet extends SpaceObject  {
    private final PlanetSize size;
    private final boolean inhabited;
    private final double distanceFromSun;

    public Planet(String name, double weight, double radius, PlanetSize size, boolean inhabited, double distanceFromSun) {
        super(name, weight, radius);
        this.size = size;
        this.inhabited = inhabited;
        this.distanceFromSun = distanceFromSun;
    }

    public PlanetSize getSize() {
        return size;
    }

    public boolean isInhabited() {
        return inhabited;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Planet planet = (Planet) o;
        return isInhabited() == planet.inhabited && Double.compare(planet.distanceFromSun, getDistanceFromSun()) == 0 && getSize() == planet.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSize(), isInhabited(), getDistanceFromSun());
    }

    @Override
    public String toString() {
        return "Planet{" +
                "size=" + size +
                ", inhabited=" + inhabited +
                ", distanceFromSun=" + distanceFromSun +
                '}';
    }
}