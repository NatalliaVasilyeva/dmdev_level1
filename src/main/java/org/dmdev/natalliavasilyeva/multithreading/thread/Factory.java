package org.dmdev.natalliavasilyeva.multithreading.thread;

import org.dmdev.natalliavasilyeva.multithreading.model.Color;
import org.dmdev.natalliavasilyeva.multithreading.model.Crystal;
import org.dmdev.natalliavasilyeva.multithreading.model.Planet;
import org.dmdev.natalliavasilyeva.multithreading.util.RandomUtil;
import org.dmdev.natalliavasilyeva.multithreading.util.ThreadUtil;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public class Factory extends Thread {

    private static final int MIN_CRYSTAL_COUNT = 2;
    private static final int MAX_CRYSTAL_COUNT = 5;
    private final Night night;
    private final Planet planet;

    public Factory(Night night) {
        this.planet = new Planet();
        this.night = night;
    }


    @Override
    public void run() {
        while (!ThreadUtil.isInterruptNecessary.get()) {
            try {
                throwCrystals();
                waitNextNight();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

        private void throwCrystals() {
            int numberOfCrystalsForThrowingToPlanet = RandomUtil.getRandomNumberUsingInts(MIN_CRYSTAL_COUNT, MAX_CRYSTAL_COUNT + 1);
            synchronized (planet.getLock()) {
                for (int j = 0; j < numberOfCrystalsForThrowingToPlanet; j++) {
                    Color color = Color.COLOR_VALUES.get(RandomUtil.getNext(Color.COLOR_VALUES.size()));
                    planet.add(new Crystal(color));
                }
                System.out.println("Factory threw out crystals. Count: " + numberOfCrystalsForThrowingToPlanet);
            }
        }

        private void waitNextNight () throws InterruptedException {
            synchronized (night.getLock()) {
                night.getLock().wait();
            }
        }

    public Planet getPlanet() {
        return planet;
    }
    }