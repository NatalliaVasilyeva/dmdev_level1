package org.dmdev.natalliavasilyeva.inheritance.model;

import org.dmdev.natalliavasilyeva.inheritance.interfaces.StatisticPrinter;

import java.util.Objects;

public class Asteroid extends SpaceObject implements StatisticPrinter {

    private final AsteroidType asteroidType;

    public Asteroid(String name, double weight, double radius, AsteroidType asteroidType) {
        super(name, weight, radius);
        this.asteroidType = asteroidType;
    }

    public AsteroidType getAsteroidType() {
        return asteroidType;
    }

    @Override
    public void printInfo() {
        System.out.printf("Space object class is %s, name is %s, weight is %s, radius is %s, asteroid type is %s%n",
                this.getClass().getName(), getName(), getWeight(), getRadius(), getAsteroidType());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Asteroid asteroid = (Asteroid) o;
        return getAsteroidType() == asteroid.asteroidType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAsteroidType());
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "asteroidType=" + getAsteroidType() +
                '}';
    }

}