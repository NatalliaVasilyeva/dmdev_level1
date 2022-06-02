package org.dmdev.natalliavasilyeva.inheritance.model;

import java.util.Objects;

public class Satellite extends SpaceObject {

    private final double distanceToPlanet;
    private final SpaceObject spaceObject;

    public Satellite(String name, double weight, double radius, double distanceToPlanet, SpaceObject spaceObject) {
        super(name, weight, radius);
        this.distanceToPlanet = distanceToPlanet;
        this.spaceObject = spaceObject;
    }

    public double getDistanceToPlanet() {
        return distanceToPlanet;
    }

    public SpaceObject getSpaceObject() {
        return spaceObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Satellite satellite = (Satellite) o;
        return Double.compare(satellite.distanceToPlanet, getDistanceToPlanet()) == 0 && Objects.equals(getSpaceObject(), satellite.spaceObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDistanceToPlanet(), getSpaceObject());
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "distanceToPlanet=" + distanceToPlanet +
                ", spaceObject=" + spaceObject +
                '}';
    }
}