package org.dmdev.natalliavasilyeva.inheritance.utils;

import org.dmdev.natalliavasilyeva.inheritance.model.SpaceObject;
import org.dmdev.natalliavasilyeva.inheritance.model.Star;

public final class SpaceUtils {

    private final static double GRAVITY = 6.67 * Math.pow(10, -11);
    private final static double DISTANCE = 983287903.38;


    private SpaceUtils() {
    }

    public static double calculateGravitation(SpaceObject first, SpaceObject second) {
        return GRAVITY * (first.getWeight() * second.getWeight()) / Math.pow(DISTANCE, 2);
    }


    public static boolean isStar(SpaceObject spaceObject) {
        return spaceObject instanceof Star;
    }

}