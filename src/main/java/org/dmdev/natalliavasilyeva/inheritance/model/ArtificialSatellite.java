package org.dmdev.natalliavasilyeva.inheritance.model;

import java.util.Objects;

public class ArtificialSatellite extends Satellite {
    private final boolean earthSatellite;

    public ArtificialSatellite(String name, double weight, double radius, double distanceToPlanet, SpaceObject spaceObject, boolean earthSatellite) {
        super(name, weight, radius, distanceToPlanet, spaceObject);
        this.earthSatellite = earthSatellite;
    }

    public boolean isEarthSatellite() {
        return earthSatellite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ArtificialSatellite that = (ArtificialSatellite) o;
        return isEarthSatellite() == that.earthSatellite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isEarthSatellite());
    }

    @Override
    public String toString() {
        return "ArtificialSatellite{" +
                "earthSatellite=" + earthSatellite +
                '}';
    }
}