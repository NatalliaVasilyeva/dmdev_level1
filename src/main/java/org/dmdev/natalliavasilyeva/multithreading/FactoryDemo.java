package org.dmdev.natalliavasilyeva.multithreading;

import org.dmdev.natalliavasilyeva.multithreading.model.Race;
import org.dmdev.natalliavasilyeva.multithreading.thread.CrystalsChecker;
import org.dmdev.natalliavasilyeva.multithreading.thread.Factory;
import org.dmdev.natalliavasilyeva.multithreading.thread.Night;
import org.dmdev.natalliavasilyeva.multithreading.thread.RaceRocket;
import org.dmdev.natalliavasilyeva.multithreading.util.ThreadUtil;

import java.util.List;

public class FactoryDemo {

    public static void main(String[] args) throws InterruptedException {
        Night night = new Night();
        Factory factory = new Factory(night);
        Race fireRace = new Race("Fire wizard");
        Race airRace = new Race("Air wizard");
        CrystalsChecker crystalsChecker = new CrystalsChecker(List.of(fireRace, airRace));

        RaceRocket fireRaceRocket = new RaceRocket(fireRace, factory.getPlanet(), night);
        RaceRocket airRaceRocket = new RaceRocket(airRace, factory.getPlanet(), night);

        ThreadUtil.startThreads(List.of(night, factory, fireRaceRocket, airRaceRocket, crystalsChecker));

        ThreadUtil.joinThreads(List.of(night, factory, fireRaceRocket, airRaceRocket, crystalsChecker));

        viewStatistic(airRaceRocket.getRace(), fireRaceRocket.getRace());
    }

    private static void viewStatistic(Race firstRace, Race secondRace) {
        System.out.println("----------------");
        System.out.println(firstRace.getName() + " is " + getRacePosition(firstRace.isFull()));
        System.out.println(secondRace.getName() + " is " + getRacePosition(secondRace.isFull()));
    }

    private static String getRacePosition(boolean result) {
        return result ? "winner" : "loser";
    }
}