package org.dmdev.natalliavasilyeva.multithreading.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Planet {
    private final Object lock = new Object();
    private final List<Crystal> planet = new CopyOnWriteArrayList<>();

    public Planet() {
    }

    public void add(Crystal crystal) {
        planet.add(crystal);
    }

    public Crystal remove(int index) {
        return planet.remove(index);
    }

    public List<Crystal> removeAll() {
        List<Crystal> crystals = new ArrayList<>(planet);
        planet.clear();
        return crystals;
    }

    public int size() {
        return planet.size();
    }

    public boolean isNotEmpty() {
        return !planet.isEmpty();
    }

    public Object getLock() {
        return lock;
    }

}