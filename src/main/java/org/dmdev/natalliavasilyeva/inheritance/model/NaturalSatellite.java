package org.dmdev.natalliavasilyeva.inheritance.model;

import org.dmdev.natalliavasilyeva.inheritance.interfaces.Countable;

import java.util.Objects;

public class NaturalSatellite extends Satellite implements Countable {

    private final boolean isEarthSatellite;
    private final double velocity;

    public NaturalSatellite(String name, double weight, double radius, double distanceToPlanet, SpaceObject spaceObject, boolean isEarthSatellite, double velocity) {
        super(name, weight, radius, distanceToPlanet, spaceObject);
        this.isEarthSatellite = isEarthSatellite;
        this.velocity = velocity;
    }

    public boolean isEarthSatellite() {
        return isEarthSatellite;
    }

    public double getVelocity() {
        return velocity;
    }

    @Override
    public double getTime() {
        return 2 * Math.pow(Math.PI, 2) / getVelocity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NaturalSatellite that = (NaturalSatellite) o;
        return isEarthSatellite() == that.isEarthSatellite && Double.compare(that.velocity, getVelocity()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isEarthSatellite(), getVelocity());
    }

    @Override
    public String toString() {
        return "NaturalSatellite{" +
                "isEarthSatellite=" + isEarthSatellite() +
                ", velocity=" + getVelocity() +
                '}';
    }

}