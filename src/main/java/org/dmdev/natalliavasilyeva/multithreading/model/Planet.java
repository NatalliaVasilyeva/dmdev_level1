package org.dmdev.natalliavasilyeva.multithreading.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Planet {
    private final Lock lock = new ReentrantLock();

    private final Condition condition = lock.newCondition();
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

    public Lock getLock() {
        return lock;
    }

    public Condition getCondition() {
        return condition;
    }

}