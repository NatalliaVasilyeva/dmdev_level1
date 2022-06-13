package org.dmdev.natalliavasilyeva.multithreading.thread;

import org.dmdev.natalliavasilyeva.multithreading.model.Color;
import org.dmdev.natalliavasilyeva.multithreading.model.Crystal;
import org.dmdev.natalliavasilyeva.multithreading.model.Planet;
import org.dmdev.natalliavasilyeva.multithreading.util.RandomUtil;
import org.dmdev.natalliavasilyeva.multithreading.util.ThreadUtil;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

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
        getPlanetLock().lock();
        try {
            for (int j = 0; j < numberOfCrystalsForThrowingToPlanet; j++) {
                Color color = Color.COLOR_VALUES.get(RandomUtil.getNext(Color.COLOR_VALUES.size()));
                planet.add(new Crystal(color));
            }
            System.out.println("Factory threw out crystals. Count: " + numberOfCrystalsForThrowingToPlanet);
        } finally {
            getPlanetLock().unlock();
        }
    }

    private void waitNextNight() throws InterruptedException {
        Lock lock = getNightLock();
        Condition condition  = getNightCondition();

        lock.lock();
        condition.await();
        lock.unlock();

    }

    public Planet getPlanet() {
        return planet;
    }

    private Lock getPlanetLock() {
        return planet.getLock();
    }

    private Lock getNightLock() {
        return night.getLock();
    }

    private Condition getNightCondition() {
        return night.getCondition();
    }
}