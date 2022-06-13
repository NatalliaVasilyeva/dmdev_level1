package org.dmdev.natalliavasilyeva.multithreading.thread;

import org.dmdev.natalliavasilyeva.multithreading.model.Crystal;
import org.dmdev.natalliavasilyeva.multithreading.model.Planet;
import org.dmdev.natalliavasilyeva.multithreading.model.Race;
import org.dmdev.natalliavasilyeva.multithreading.util.RandomUtil;
import org.dmdev.natalliavasilyeva.multithreading.util.ThreadUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class RaceRocket extends Thread {

    private static final int MIN_CRYSTAL_COUNT = 2;
    private static final int MAX_CRYSTAL_COUNT = 5;
    private final Night night;
    private final Race race;
    private final Planet planet;

    public RaceRocket(Race race, Planet planet, Night night) {
        this.race = race;
        this.planet = planet;
        this.night = night;
    }

    @Override
    public void run() {
        while (!ThreadUtil.isInterruptNecessary.get()) {
            try {
                List<Crystal> crystals = gatherCrystalsFromFactory();
                race.addCrystals(crystals);
                waitNextNight();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Crystal> gatherCrystalsFromFactory() {
        int crystalNumber = RandomUtil.getRandomNumberUsingInts(MIN_CRYSTAL_COUNT, MAX_CRYSTAL_COUNT + 1);
        List<Crystal> gatheredCrystalsFromFactory = new ArrayList<>(MAX_CRYSTAL_COUNT);
        planet.getLock().lock();
        try {
            if (planet.size() <= crystalNumber) {
                gatheredCrystalsFromFactory.addAll(planet.removeAll());
            } else if (planet.isNotEmpty()) {
                for (int j = 0; j < crystalNumber; j++) {
                    Crystal removeCrystal = planet.remove(RandomUtil.getNext(planet.size()));
                    gatheredCrystalsFromFactory.add(removeCrystal);
                }
            }
            System.out.printf("%s race rocket gathered next crystal: %s\n", race.getName(), gatheredCrystalsFromFactory);
        } finally {
            planet.getLock().unlock();
        }

        return gatheredCrystalsFromFactory;
    }

    private void waitNextNight() throws InterruptedException {
        Lock lock = getNightLock();
        Condition condition = getNightCondition();

        lock.lock();
        condition.await();
        lock.unlock();

    }

    public Race getRace() {
        return race;
    }

    private Lock getNightLock() {
        return night.getLock();
    }

    private Condition getNightCondition() {
        return night.getCondition();
    }

}