package org.dmdev.natalliavasilyeva.inheritance;

import org.dmdev.natalliavasilyeva.inheritance.model.Asteroid;
import org.dmdev.natalliavasilyeva.inheritance.model.AsteroidType;
import org.dmdev.natalliavasilyeva.inheritance.model.Color;
import org.dmdev.natalliavasilyeva.inheritance.model.NaturalSatellite;
import org.dmdev.natalliavasilyeva.inheritance.model.Planet;
import org.dmdev.natalliavasilyeva.inheritance.model.PlanetSize;
import org.dmdev.natalliavasilyeva.inheritance.model.Satellite;
import org.dmdev.natalliavasilyeva.inheritance.model.SpaceObject;
import org.dmdev.natalliavasilyeva.inheritance.model.Star;

import java.util.List;

public class SpaceRunner {

    public static void main(String[] args) {

        //create all objects as SpaceObject

        SpaceObject star = new Star("Sun", 260.4, 1900, Color.BLACK, 78.9);
        SpaceObject satellite = new Satellite("Sat", 229.4, 1289, 2900.5, star);
        SpaceObject naturalSatellite = new NaturalSatellite("Natural", 8989.0, 265, 8743, satellite, true, 876543.8);
        SpaceObject planet = new Planet("Earth", 2600.4, 6789, PlanetSize.A, true, 689.8);
        SpaceObject artificialSatellite = new Satellite("Artificial", 8.9, 25, 78, planet);
        SpaceObject asteroid = new Asteroid("Blitz", 300, 678, AsteroidType.C);


        printDiameterOfSpaceObjects(star, satellite, naturalSatellite, planet, artificialSatellite, asteroid);
        printInfoAboutSatellites(star, satellite, naturalSatellite, planet, artificialSatellite, asteroid);
        printInfoAboutAsteroids(star, satellite, naturalSatellite, planet, artificialSatellite, asteroid);
    }


    public static void printDiameterOfSpaceObjects(SpaceObject... spaceObjects) {
        List<SpaceObject> objects = List.of(spaceObjects);

        for (SpaceObject object : objects) {
            System.out.println("Diameter is: " + object.getDiameter());
        }
    }

    public static void printInfoAboutSatellites(SpaceObject... spaceObjects) {
        List<SpaceObject> objects = List.of(spaceObjects);

        for (SpaceObject object : objects) {
            if (object instanceof Satellite) {
                System.out.println("Distance is: " + ((Satellite) object).getDistanceToPlanet());
            }
        }
    }

    public static void printInfoAboutAsteroids(SpaceObject... spaceObjects) {
        List<SpaceObject> objects = List.of(spaceObjects);

        for (SpaceObject object : objects) {
            if (object instanceof Asteroid) {
               ((Asteroid) object).printInfo();
            }
        }
    }
}